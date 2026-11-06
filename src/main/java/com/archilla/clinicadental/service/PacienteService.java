package com.archilla.clinicadental.service;

import com.archilla.clinicadental.entity.Cita;
import com.archilla.clinicadental.entity.Paciente;
import com.archilla.clinicadental.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repositorio;

    public PacienteService(PacienteRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Paciente> listar() {
        return repositorio.findAll();
    }

    public Paciente guardar(Paciente paciente) {
        return repositorio.save(paciente);
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }

    public Paciente obtenerPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado con ID: " + id));
    }

    public List<Paciente> buscarPorDni(String dni) {
        return repositorio.buscarPorDni(dni);
    }
}
