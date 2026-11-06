package com.archilla.clinicadental.repository;

import com.archilla.clinicadental.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface PacienteRepository
        extends JpaRepository<Paciente, Long> {
    @Query("SELECT p FROM Paciente p " +
            "WHERE LOWER(p.dni) LIKE LOWER(CONCAT('%', :dni, '%'))")
    List<Paciente> buscarPorDni(@Param("dni") String dni);
}