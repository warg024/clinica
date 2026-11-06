package com.archilla.clinicadental.service;

import com.archilla.clinicadental.entity.Cita;
import com.archilla.clinicadental.repository.CitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {

    private final CitaRepository citaRepository;

    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public List<Cita> listar() {
        return citaRepository.findAllConRelaciones(); // <-- Usamos la consulta con JOIN FETCH
    }

    public Cita guardar(Cita cita) {
        return citaRepository.save(cita);
    }

    public void eliminar(Long id) {
        citaRepository.deleteById(id);
    }

    public Cita obtenerPorId(Long id) {
        return citaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cita no encontrada con ID: " + id));
    }
}