package com.archilla.clinicadental.controller;

import com.archilla.clinicadental.service.CitaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/citas")
public class CitaRestController {

    private final CitaService citaService;

    public CitaRestController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping("/eventos")
    public List<Map<String, Object>> obtenerEventosCalendario() {
        return citaService.listar().stream().map(c -> Map.<String, Object>of(
                "title", (c.getPaciente() != null ? c.getPaciente().getNombre() : "Sin paciente")
                        + " (" + (c.getTratamiento() != null ? c.getTratamiento().getNombre() : "Sin tto") + ")",
                "start", c.getFecha().toString(),
                "description", c.getMotivo() != null ? c.getMotivo() : ""
        )).collect(Collectors.toList());
    }
}