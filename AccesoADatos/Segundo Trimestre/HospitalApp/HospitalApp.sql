DROP DATABASE IF EXISTS hospitalapp;
CREATE DATABASE hospitalapp;
Use hospitalapp;
-- Tabla de pacientes
CREATE TABLE pacientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    apellidos VARCHAR(255),
    ciudad VARCHAR(255),
    direccion VARCHAR(255),
    telefono VARCHAR(20),
    edad INT,
    historial TEXT
);

-- Tabla de medicos
CREATE TABLE medicos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    apellidos VARCHAR(255),
    especialidad VARCHAR(100)
);

-- Tabla de citas
CREATE TABLE citas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_paciente INT,
    id_medico INT,
    fecha VARCHAR(20),
    hora VARCHAR(20),
    FOREIGN KEY (id_paciente) REFERENCES pacientes(id),
    FOREIGN KEY (id_medico) REFERENCES medicos(id)
);