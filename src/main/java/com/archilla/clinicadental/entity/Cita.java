package com.archilla.clinicadental.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "citas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EstadoCita estado;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime fecha;

    @NotBlank
    @Size(max = 180)
    @Column(length = 180)
    private String motivo;

    @Column(length = 60)
    private Integer duracion;

    // Relación Muchos a Uno con Paciente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "paciente_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_citas_pacientes")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Paciente paciente;

    // Relación Muchos a Uno con Tratamiento
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "tratamiento_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_citas_tratamientos")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Tratamiento tratamiento;
}