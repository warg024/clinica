package com.archilla.clinicadental.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tratamientos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tratamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String nombre;

    @Size(max = 250)
    @Column(length = 250)
    private String descripcion;

    // Precio con dos decimales, mínimo 1€
    @NotNull
    @DecimalMin(value = "1.00", inclusive = true, message = "El precio debe ser mínimo de 1€")
    @DecimalMax(value = "9999.99")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    // Duración en minutos
    @NotNull
    @Min(value = 1, message = "La duración mínima debe ser de al menos 1 minuto")
    @Column(nullable = false)
    private Integer duracion;

    // Relación inversa 1 a N hacia Cita
    @OneToMany(mappedBy = "tratamiento", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private List<Cita> citas = new ArrayList<>();
}