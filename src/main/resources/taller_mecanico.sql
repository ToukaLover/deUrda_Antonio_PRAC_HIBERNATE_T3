DROP DATABASE IF EXISTS taller_mecanico;

CREATE DATABASE taller_mecanico;

USE taller_mecanico;

-- Tabla Usuario
CREATE TABLE Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);

-- Tabla Empleado
CREATE TABLE Empleado (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    puesto VARCHAR(50),
    salario DECIMAL(10, 2),
    usuario_id INT UNIQUE,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
);

-- Tabla Cliente
CREATE TABLE Cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    telefono VARCHAR(15)
);

-- Tabla Coche
CREATE TABLE Coche (
    id INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    año INT,
    precio DECIMAL(10, 2)
);

-- Tabla Reparacion
CREATE TABLE Reparacion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion TEXT,
    fecha DATE NOT NULL,
    costo DECIMAL(10, 2),
    coche_id INT,
    empleado_id INT,
    FOREIGN KEY (coche_id) REFERENCES Coche(id),
    FOREIGN KEY (empleado_id) REFERENCES Empleado(id)
);

-- Tabla Venta
CREATE TABLE Venta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    monto DECIMAL(10, 2),
    empleado_id INT,
    cliente_id INT,
    FOREIGN KEY (empleado_id) REFERENCES Empleado(id),
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id)
);

-- Tabla intermedia para relacion Many-to-Many entre Cliente y Coche
CREATE TABLE Cliente_Coche (
    cliente_id INT,
    coche_id INT,
    PRIMARY KEY (cliente_id, coche_id),
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id),
    FOREIGN KEY (coche_id) REFERENCES Coche(id)
);

-- Tabla intermedia para relacion One-to-Many entre Venta y Coche
CREATE TABLE Venta_Coche (
    venta_id INT,
    coche_id INT,
    PRIMARY KEY (venta_id, coche_id),
    FOREIGN KEY (venta_id) REFERENCES Venta(id),
    FOREIGN KEY (coche_id) REFERENCES Coche(id)
);
