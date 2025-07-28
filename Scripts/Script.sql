CREATE DATABASE IF NOT EXISTS inventario;

use inventario;


/*Tabla Rol*/
create table Rol (
	id_rol INT auto_increment primary key,
	rol VARCHAR(50) not null
);

/*Tabla usuarios*/
create table Usuarios (
    id_usuario INT auto_increment primary key,
    nombre VARCHAR(100) not null,
    correo VARCHAR(100) not null unique,
    contrasena VARCHAR(255) not null,
    status INT(1) not null default 1,
    id_rol INT not null,
    foreign key (id_rol) references Rol(id_rol)
);

/*Tabla Productos*/
create table Productos (
	id_producto INT auto_increment primary key,
	nombre VARCHAR(100) not null,
	stock INT not null default 0,
	status INT not null default 1
);

insert into productos (nombre) values ('silla');
select * from productos p ;


/*Tabla historial*/
create table Historial (
	id_historial INT auto_increment primary key,
	id_usuario INT not null,
	id_producto INT not null,
	movimiento VARCHAR(20) not null,
	cantidad INT not null,
	fecha DATETIME not null,
	foreign key (id_usuario) references Usuarios(id_usuario),
	foreign key (id_producto) references Productos(id_producto)
);

insert into historial (id_usuario, id_producto, movimiento, cantidad, fecha) values 
(1, 1, 'Entrada', 5, '2025-07-27 00:00:00')

select * from historial h;
select * from usuarios u ;


/*Insertamos los roles*/
insert into Rol (rol) values ('Administrador');
insert into Rol (rol) values ('Almacenista');

/*Verificamos*/
select * from Rol


select * from usuarios u 