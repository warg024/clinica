package com.archilla.clinicadental;

import com.archilla.clinicadental.entity.*;
import com.archilla.clinicadental.repository.CitaRepository;
import com.archilla.clinicadental.repository.PacienteRepository;
import com.archilla.clinicadental.repository.TratamientoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

// Desactivado porque ahora usamos src/main/resources/data.sql
// @Configuration
public class DataInitializer {

    // @Bean
    public CommandLineRunner initData(
            PacienteRepository pacienteRepo,
            TratamientoRepository tratamientoRepo,
            CitaRepository citaRepo) {

        return args -> {

            // 1. Inicializar Pacientes si la tabla está vacía
            if (pacienteRepo.count() == 0) {
                Paciente p1 = new Paciente();
                p1.setNombre("Carlos");
                p1.setApellidos("Gómez Pérez");
                p1.setDni("12345678B");
                p1.setEdad(34);
                p1.setTelefono("611223344");
                p1.setEmail("carlos.gomez@email.com");
                p1.setSexo(SexoPaciente.HOMBRE);
                p1.setTipo(TipoPaciente.ADULTO);

                Paciente p2 = new Paciente();
                p2.setNombre("Lucía");
                p2.setApellidos("Martínez Cano");
                p2.setDni("22345678B");
                p2.setEdad(28);
                p2.setTelefono("622334455");
                p2.setEmail("lucia.mtnez@email.com");
                p2.setSexo(SexoPaciente.MUJER);
                p2.setTipo(TipoPaciente.ADULTO);

                Paciente p3 = new Paciente();
                p3.setNombre("Marcos");
                p3.setApellidos("Archilla Ruiz");
                p3.setDni("32345678B");
                p3.setEdad(45);
                p3.setTelefono("633445566");
                p3.setEmail("marcos.archilla@email.com");
                p3.setSexo(SexoPaciente.HOMBRE);
                p3.setTipo(TipoPaciente.ADULTO);

                Paciente p4 = new Paciente();
                p4.setNombre("Pepe");
                p4.setApellidos("Aguilera Fernández");
                p4.setDni("42345678B");
                p4.setEdad(45);
                p4.setTelefono("633445566");
                p4.setEmail("pepe.aguilera@email.com");
                p4.setSexo(SexoPaciente.HOMBRE);
                p4.setTipo(TipoPaciente.INFANTIL);

                pacienteRepo.saveAll(List.of(p1, p2, p3, p4));
                System.out.println(">>> Pacientes de prueba inicializados.");
            }

            // 2. Inicializar Tratamientos si la tabla está vacía
            if (tratamientoRepo.count() == 0) {
                Tratamiento t1 = new Tratamiento(
                        null,
                        "Limpieza Dental Avanzada",
                        "Profilaxis con ultrasonidos y pulido dental",
                        new BigDecimal("45.00"),
                        30,
                        null
                );
                Tratamiento t2 = new Tratamiento(
                        null,
                        "Empaste de Composite",
                        "Obturación de cavidad dental con resina estética",
                        new BigDecimal("60.00"),
                        45,
                        null
                );
                Tratamiento t3 = new Tratamiento(
                        null,
                        "Endodoncia Unirradicular",
                        "Tratamiento de conductos con sellado térmico",
                        new BigDecimal("150.00"),
                        60,
                        null
                );
                Tratamiento t4 = new Tratamiento(
                        null,
                        "Muela del juicio",
                        "Extracción muela del juicio",
                        new BigDecimal("90.00"),
                        60,
                        null
                );

                tratamientoRepo.saveAll(List.of(t1, t2, t3, t4));
                System.out.println(">>> Tratamientos de prueba inicializados.");
            }

            // 3. Inicializar Citas si la tabla está vacía y existen registros vinculables
            if (citaRepo.count() == 0 && pacienteRepo.count() > 0 && tratamientoRepo.count() > 0) {
                List<Paciente> pacientes = pacienteRepo.findAll();
                List<Tratamiento> tratamientos = tratamientoRepo.findAll();

                Cita c1 = new Cita(
                        null,
                        EstadoCita.PENDIENTE,
                        LocalDateTime.now().plusDays(1).withHour(10).withMinute(0),
                        "Revisión anual rutinaria y limpieza",
                        30,
                        pacientes.get(0),
                        tratamientos.get(0)
                );

                Cita c2 = new Cita(
                        null,
                        EstadoCita.CONFIRMADA,
                        LocalDateTime.now().plusDays(2).withHour(16).withMinute(30),
                        "Dolor agudo en molar inferior izquierdo",
                        45,
                        pacientes.get(1),
                        tratamientos.get(1)
                );

                Cita c3 = new Cita(
                        null,
                        EstadoCita.CONFIRMADA,
                        LocalDateTime.now().plusDays(4).withHour(11).withMinute(15),
                        "Segunda sesión de endodoncia",
                        60,
                        pacientes.get(2),
                        tratamientos.get(2)
                );

                Cita c4 = new Cita(
                        null,
                        EstadoCita.CANCELADA,
                        LocalDateTime.now().plusDays(6).withHour(9).withMinute(25),
                        "Muela del juicio",
                        60,
                        pacientes.get(3),
                        tratamientos.get(3)
                );

                citaRepo.saveAll(List.of(c1, c2, c3, c4));
                System.out.println(">>> Citas de prueba inicializadas.");
            }
        };
    }
}