CREATE DATABASE escuela;
USE escuela;

create table alumno(
cod_alumno int auto_increment primary key,
nombre varchar(80) not null,
apellido varchar(80) not null,
edad int not null,
direccion varchar(100) not null);
create table materia(
cod_materia int auto_increment primary key,
nombre varchar(25) unique not null,
descripcion varchar(100) not null);
create table alumno_materia(
id_alumno_materia int auto_increment primary key,
fk_cod_alumno int not null,
fk_cod_materia int not null);