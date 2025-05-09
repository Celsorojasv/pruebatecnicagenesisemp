CREATE DATABASE sistema_prestamos;
USE sistema_prestamos;

CREATE TABLE clientes (
	dpi varchar(20) PRIMARY KEY,
    nombre varchar(100) NOT NULL
);


CREATE TABLE prestamos (
	codigo_prestamo BIGINT AUTO_INCREMENT PRIMARY KEY,
    monto INT NOT NULL,
    numero_cuotas INT NOT NULL,
    fecha_registro DATE NOT NULL,
    dpi_cliente VARCHAR(20) NOT NULL,
    FOREIGN KEY (dpi_cliente) REFERENCES clientes(dpi) ON DELETE CASCADE
);