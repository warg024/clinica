-- ==========================================================
-- 1. PACIENTES DE PRUEBA
-- ==========================================================
INSERT IGNORE INTO pacientes (id, nombre, apellidos, dni, edad, telefono, email, sexo, tipo) VALUES (1, 'Carlos', 'Gómez Pérez', '12345678B', 34, '611223344', 'carlos.gomez@email.com', 'HOMBRE', 'ADULTO');
INSERT IGNORE INTO pacientes (id, nombre, apellidos, dni, edad, telefono, email, sexo, tipo) VALUES (2, 'Lucía', 'Martínez Cano', '22345678B', 28, '622334455', 'lucia.mtnez@email.com', 'MUJER', 'ADULTO');
INSERT IGNORE INTO pacientes (id, nombre, apellidos, dni, edad, telefono, email, sexo, tipo) VALUES (3, 'Marcos', 'Archilla Ruiz', '32345678B', 45, '633445566', 'marcos.archilla@email.com', 'HOMBRE', 'ADULTO');
INSERT IGNORE INTO pacientes (id, nombre, apellidos, dni, edad, telefono, email, sexo, tipo) VALUES (4, 'Pepe', 'Aguilera Fernández', '42345678B', 45, '633445566', 'pepe.aguilera@email.com', 'HOMBRE', 'INFANTIL');

-- ==========================================================
-- 2. TRATAMIENTOS DE PRUEBA
-- ==========================================================
INSERT IGNORE INTO tratamientos (id, nombre, descripcion, precio, duracion) VALUES (1, 'Limpieza Dental Avanzada', 'Profilaxis con ultrasonidos y pulido dental', 45.00, 30);
INSERT IGNORE INTO tratamientos (id, nombre, descripcion, precio, duracion) VALUES (2, 'Empaste de Composite', 'Obturación de cavidad dental con resina estética', 60.00, 45);
INSERT IGNORE INTO tratamientos (id, nombre, descripcion, precio, duracion) VALUES (3, 'Endodoncia Unirradicular', 'Tratamiento de conductos con sellado térmico', 150.00, 60);
INSERT IGNORE INTO tratamientos (id, nombre, descripcion, precio, duracion) VALUES (4, 'Muela del juicio', 'Extracción muela del juicio', 90.00, 60);

-- ==========================================================
-- 3. CITAS DE PRUEBA
-- ==========================================================
INSERT IGNORE INTO citas (id, estado, fecha, motivo, duracion, paciente_id, tratamiento_id) VALUES (1, 'PENDIENTE', DATE_ADD(CURDATE(), INTERVAL '1 10:00' DAY_MINUTE), 'Revisión anual rutinaria y limpieza', 30, 1, 1);
INSERT IGNORE INTO citas (id, estado, fecha, motivo, duracion, paciente_id, tratamiento_id) VALUES (2, 'CONFIRMADA', DATE_ADD(CURDATE(), INTERVAL '2 16:30' DAY_MINUTE), 'Dolor agudo en molar inferior izquierdo', 45, 2, 2);
INSERT IGNORE INTO citas (id, estado, fecha, motivo, duracion, paciente_id, tratamiento_id) VALUES (3, 'CONFIRMADA', DATE_ADD(CURDATE(), INTERVAL '4 11:15' DAY_MINUTE), 'Segunda sesión de endodoncia', 60, 3, 3);
INSERT IGNORE INTO citas (id, estado, fecha, motivo, duracion, paciente_id, tratamiento_id) VALUES (4, 'CANCELADA', DATE_ADD(CURDATE(), INTERVAL '6 09:25' DAY_MINUTE), 'Muela del juicio', 60, 4, 4);
