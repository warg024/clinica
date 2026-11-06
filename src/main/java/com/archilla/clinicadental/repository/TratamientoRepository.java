package com.archilla.clinicadental.repository;

import com.archilla.clinicadental.entity.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TratamientoRepository
        extends JpaRepository<Tratamiento, Long> {
}