package com.archilla.clinicadental.controller;

import com.archilla.clinicadental.repository.CitaRepository;
import com.archilla.clinicadental.repository.PacienteRepository;
import com.archilla.clinicadental.repository.TratamientoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final PacienteRepository pacienteRepo;
    private final TratamientoRepository tratamientoRepo; // o TratamientoRepository
    private final CitaRepository citaRepo;

    public HomeController(PacienteRepository pacienteRepo,
                          TratamientoRepository tratamientoRepo,
                          CitaRepository citaRepo) {
        this.pacienteRepo = pacienteRepo;
        this.tratamientoRepo = tratamientoRepo;
        this.citaRepo = citaRepo;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("totalPacientes", pacienteRepo.count());
        model.addAttribute("totalTratamientos", tratamientoRepo.count());
        model.addAttribute("totalCitas", citaRepo.count());
        return "index";
    }

    @GetMapping("/calendario")
    public String verCalendario() {
        return "calendario"; // Retorna src/main/resources/templates/calendario.html
    }
}