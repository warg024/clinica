package com.archilla.clinicadental.controller;

import com.archilla.clinicadental.entity.Cita;
import com.archilla.clinicadental.entity.Paciente;
import com.archilla.clinicadental.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService servicio;

    public PacienteController(PacienteService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pacientes", servicio.listar());
        return "pacientes";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "formulario-paciente";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Paciente paciente, RedirectAttributes flash) {
        servicio.guardar(paciente);
        flash.addFlashAttribute("mensajeExito", "✅ Paciente guardado correctamente.");
        return "redirect:/pacientes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        // 1. Obtener el paciente existente de la base de datos
        Paciente paciente = servicio.obtenerPorId(id);

        // 2. Pasarlo al modelo con la misma clave "paciente" que usa th:object
        model.addAttribute("paciente", paciente);

        // 3. Devolver la vista del formulario de pacientes
        return "formulario-paciente";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes flash) {
        servicio.eliminar(id);
        flash.addFlashAttribute("mensajeExito", "🗑️ Paciente eliminado correctamente.");
        return "redirect:/pacientes";
    }

    // Mostrar formulario de búsqueda
    @GetMapping("/buscar")
    public String mostrarFormulario() {
        return "buscar_paciente";
    }

    // Procesar búsqueda
    @GetMapping("/resultados")
    public String buscarPacientes(
            @RequestParam("dni") String dni,
            Model model) {

        List<Paciente> pacientes = servicio.buscarPorDni(dni);

        model.addAttribute("pacientes", pacientes);
        model.addAttribute("dniBuscado", dni);

        return "resultado_pacientes";
    }
}