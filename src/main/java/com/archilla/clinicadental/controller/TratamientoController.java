package com.archilla.clinicadental.controller;

import com.archilla.clinicadental.entity.Cita;
import com.archilla.clinicadental.entity.Tratamiento;
import com.archilla.clinicadental.service.TratamientoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/tratamientos")
public class TratamientoController {

    private final TratamientoService servicio;

    public TratamientoController(TratamientoService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute(
                "tratamientos", servicio.listar()
        );
        return "tratamientos";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("tratamiento", new Tratamiento());
        return "formulario-tratamiento";
    }

    @PostMapping("/guardar")
    public String guardar(
            @ModelAttribute Tratamiento tratamiento) {
        servicio.guardar(tratamiento);
        return "redirect:/tratamientos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        // 1. Obtener el tratamiento existente de la base de datos
        Tratamiento tratamiento = servicio.obtenerPorId(id);

        // 2. Pasarlo al modelo con la clave "tratamiento" esperada por th:object
        model.addAttribute("tratamiento", tratamiento);

        // 3. Devolver la vista del formulario de tratamientos
        return "formulario-tratamiento";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
        return "redirect:/tratamientos";
    }
}
