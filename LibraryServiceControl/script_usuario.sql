-- -
-- -  Script de creación de base de datos y tablas
-- -
CREATE DATABASE librarysc;
USE librarysc;

-- -
-- -  Roles de la aplicacion
-- -
CREATE TABLE rol(
id 					INT 		NOT NULL	AUTO_INCREMENT,
rol					VARCHAR(40) NOT NULL 	UNIQUE,
PRIMARY KEY(id)
);

INSERT INTO rol(rol) VALUES('Admin');
INSERT INTO rol(rol) VALUES('Asesor');
INSERT INTO rol(rol) VALUES('Estudiante');

-- -
-- -  Usuarios de la aplicacion
-- -
CREATE TABLE usuario(
id 					INT 		NOT NULL	AUTO_INCREMENT,
nombres				VARCHAR(40) NOT NULL,
apellidos			VARCHAR(40) NOT NULL,
usuario 			VARCHAR(20)	NULL,
clave				VARCHAR(32)	NULL,
fecha_creado		DATE		NOT NULL,
tipo_documento		VARCHAR(20) NOT NULL,
numero_documento	VARCHAR(15) NOT NULL	UNIQUE,
fecha_nacimiento	DATE 		NULL,
telefono			VARCHAR(15) NULL,
correo				VARCHAR(80) NULL,
direccion			VARCHAR(90)	NULL,
ciudad 				VARCHAR(50) NULL,
rol_id				INT 		NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY(rol_id) REFERENCES rol(id)
);

-- Administrador
INSERT INTO usuario(nombres, apellidos, usuario, clave, fecha_creado, tipo_documento, numero_documento, rol_id) VALUES('Administrador', 'Library S C', 'admin', 'admin123', CURRENT_DATE, 'CEDULA', '11111111', (SELECT id FROM rol WHERE rol = 'Admin') );
-- Asesor
INSERT INTO usuario(nombres, apellidos, usuario, clave, fecha_creado, tipo_documento, numero_documento, telefono, correo, direccion, ciudad, rol_id) VALUES('Asesor', 'Prueba', 'asesor', '123456', CURRENT_DATE, 'CEDULA', '22222222', '2072531', 'asesor@prueba.com', 'Centro Historico de Medellin', 'Medellin', (SELECT id FROM rol WHERE rol = 'Asesor') );
-- Estudiante
INSERT INTO usuario(nombres, apellidos, fecha_creado, tipo_documento, numero_documento, telefono, correo, direccion, ciudad, rol_id) VALUES('Estudiante', 'Prueba', CURRENT_DATE, 'CEDULA', '33333333', '3121234567', 'estudiante@prueba.com', 'Avenida Siempre Viva # 7 - 27', 'Bogota', (SELECT id FROM rol WHERE rol = 'Estudiante') );


-- -
-- -  Categorias
-- -
CREATE TABLE categoria(
id 					INT 		NOT NULL	AUTO_INCREMENT,
categoria			VARCHAR(40) NOT NULL	UNIQUE,
PRIMARY KEY(id)
);

INSERT INTO categoria(categoria) VALUES('Libros');
INSERT INTO categoria(categoria) VALUES('Revistas');

-- -
-- -  Areas
-- -
CREATE TABLE area(
id 					INT 		NOT NULL	AUTO_INCREMENT,
area 				VARCHAR(40) NOT NULL	UNIQUE,
PRIMARY KEY(id)
);

INSERT INTO area(area) VALUES('Matematicas');
INSERT INTO area(area) VALUES('Cultura');

-- -
-- -  Genero
-- -
CREATE TABLE genero(
id 					INT 		NOT NULL	AUTO_INCREMENT,
genero 				VARCHAR(40) NOT NULL	UNIQUE,
PRIMARY KEY(id)
);

INSERT INTO genero(genero) VALUES('Literatura');
INSERT INTO genero(genero) VALUES('Tecnologia');

-- -
-- -  Elementos
-- -
CREATE TABLE elemento(
id 					INT 		NOT NULL	AUTO_INCREMENT,
titulo				VARCHAR(80) NOT NULL,
autor				VARCHAR(50) NOT NULL,
editorial 			VARCHAR(50)	NOT NULL,
fecha_publicacion	DATE 		NOT NULL,
observaciones		VARCHAR(250)NULL,
categoria_id		INT 		NOT NULL,
area_id				INT 		NOT NULL,
genero_id			INT 		NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY(categoria_id) REFERENCES categoria(id),
FOREIGN KEY(area_id) REFERENCES area(id),
FOREIGN KEY(genero_id) REFERENCES genero(id)
);

-- -
-- -  Historico de prestamos
-- -
CREATE TABLE historico_prestamo(
id 					INT 		NOT NULL	AUTO_INCREMENT,
elemento_id			INT 		NOT NULL,
usuario_id			INT 		NOT NULL,
fecha_publicacion	DATE 		NOT NULL,
fecha_devolucion	DATE 		NOT NULL,
estado				VARCHAR(20)	NULL,
PRIMARY KEY(id),
FOREIGN KEY(elemento_id) REFERENCES elemento(id),
FOREIGN KEY(usuario_id) REFERENCES usuario(id)
);
