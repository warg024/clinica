package com.archilla.clinicadental.service;

import com.archilla.clinicadental.entity.Paciente;
import com.archilla.clinicadental.entity.Tratamiento;
import com.archilla.clinicadental.repository.PacienteRepository;
import com.archilla.clinicadental.repository.TratamientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TratamientoService {

    private final TratamientoRepository repositorio;

    public TratamientoService(TratamientoRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Tratamiento> listar() {
        return repositorio.findAll();
    }

    public Tratamiento guardar(Tratamiento tratamiento) {
        return repositorio.save(tratamiento);
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }

    public Tratamiento obtenerPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tratamiento no encontrado con ID: " + id));
    }
}
