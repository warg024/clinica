package com.archilla.clinicadental.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pacientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String nombre;

    @Size(max = 100)
    private String apellidos;

    @Min(0)
    @Max(120)
    private Integer edad;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SexoPaciente sexo;

    @Pattern(
            regexp = "^[6789]\\d{8}$",
            message = "El teléfono debe tener 9 dígitos y comenzar por 6, 7, 8 o 9"
    )
    @Column(length = 15)
    private String telefono;

    @Column(length = 10, nullable = false)
    private String dni;

    @Email
    private String email;

    @Size(max = 75)
    private String direccion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoPaciente tipo;

    // Relación inversa 1 a N hacia Cita
    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private List<Cita> citas = new ArrayList<>();
}