/*DROP DATABASE IF EXISTS proyecto_integrador_2022;

CREATE DATABASE proyecto_integrador_2022
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Peru.1252'
    LC_CTYPE = 'Spanish_Peru.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
*/
/*Una ves creado la bd seleccionenla y ejecuten las tablas*/

create table tb_tipousuario
(
	idTipo int primary key GENERATED ALWAYS AS IDENTITY,
	nombreTipo varchar(20)
);

create table tb_tipo_viaje
(
	codigotv int primary key GENERATED ALWAYS AS IDENTITY,
	salida varchar(50),
	destino varchar(50),
	duracion varchar(10),
	preciotv decimal
);

create table tb_viajes
(
	idViaje int primary key GENERATED ALWAYS AS IDENTITY,
	codigotv int,
	nplazas int,
	foreign key (codigotv)references tb_tipo_viaje(codigotv)
);

create table ofertas
(
	idOferta int primary key GENERATED ALWAYS AS IDENTITY,
	codigotv int,
	descripcion varchar(200),
	precioOferta decimal,
	foreign key (codigotv)references tb_tipo_viaje(codigotv)
);

create table tb_reservas
(
	idReserva int primary key GENERATED ALWAYS AS IDENTITY,
	fechaReserva varchar(50),
	codigotv int,
	foreign key (codigotv)references tb_tipo_viaje(codigotv)
);

create table tb_usuario
(
	idUsu int primary key GENERATED ALWAYS AS IDENTITY,
	nombreUsu varchar(50),
	apellidoUsu varchar(50),
	direccionUsu varchar(200),
	telefono varchar(20),
	email varchar(50) unique,
	idTipo int,
	clave varchar(10)
	foreign key (idTipo)references tb_tipousuario(idTipo)
);

create table tb_reclamos
(
	idReclamos int primary key GENERATED ALWAYS AS IDENTITY,
	idUsu int,
	detalle varchar(500),
	foreign key (idUsu)references tb_usuario(idUsu)
);


/*cambio de id de la unidad al chofer*/

create table tb_unidades
(
	idUnidades int primary key GENERATED ALWAYS AS IDENTITY,
	nombreUnidad varchar(50),
	placaUnidad varchar(50) unique,
	fechaCompra Date
);

create table tb_chofer
(
 idchofer int primary key GENERATED ALWAYS AS IDENTITY,
 nombrecho varchar(50),
 NumPermiso varchar(20),
 idUnidades int,
foreign key (idUnidades )references tb_unidades(idUnidades)
);



create table tb_bancos
(
	idBanco int primary key GENERATED ALWAYS AS IDENTITY,
	nombreBanco varchar(50)
);

create table tb_boleta
(
	idBoleta int primary key GENERATED ALWAYS AS IDENTITY,
	fechaEmision date,
	idUnidades int,
	idUsu int,
	foreign key (idUnidades)references tb_unidades(idUnidades),
	foreign key (idUsu)references tb_usuario(idUsu)
);

create table tb_detalle_boleta
(
	idDetalle int primary key GENERATED ALWAYS AS IDENTITY,
	idViaje int,
	idBoleta int,
	cantidad int,
	Precio decimal,
	foreign key (idViaje)references tb_viajes(idViaje),
	foreign key (idBoleta)references tb_boleta(idBoleta)
);
