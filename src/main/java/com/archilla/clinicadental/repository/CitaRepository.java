package com.archilla.clinicadental.repository;

import com.archilla.clinicadental.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {

    @Query("SELECT c FROM Cita c LEFT JOIN FETCH c.paciente LEFT JOIN FETCH c.tratamiento")
    List<Cita> findAllConRelaciones();
}