package com.archilla.clinicadental.controller;

import com.archilla.clinicadental.entity.Cita;
import com.archilla.clinicadental.service.CitaService;
import com.archilla.clinicadental.service.PacienteService;
import com.archilla.clinicadental.service.TratamientoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/citas")
public class CitaController {

    // 1. Declarar los tres servicios como dependencias
    private final CitaService citaService;
    private final PacienteService pacienteService;
    private final TratamientoService tratamientoService;

    // 2. Inyectar los tres servicios en el constructor
    public CitaController(CitaService citaService,
                          PacienteService pacienteService,
                          TratamientoService tratamientoService) {
        this.citaService = citaService;
        this.pacienteService = pacienteService;
        this.tratamientoService = tratamientoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("citas", citaService.listar());
        return "citas";
    }

    @GetMapping("/nuevo")
    public String nuevaCita(Model model) {
        model.addAttribute("cita", new Cita());
        // 3. Usar las instancias inyectadas (en minúscula)
        model.addAttribute("pacientes", pacienteService.listar());
        model.addAttribute("tratamientos", tratamientoService.listar());
        return "formulario-cita";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Cita cita) {
        citaService.guardar(cita);
        return "redirect:/citas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Cita cita = citaService.obtenerPorId(id);
        model.addAttribute("cita", cita);
        model.addAttribute("pacientes", pacienteService.listar());
        model.addAttribute("tratamientos", tratamientoService.listar());
        return "formulario-cita";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        citaService.eliminar(id);
        return "redirect:/citas";
    }
}