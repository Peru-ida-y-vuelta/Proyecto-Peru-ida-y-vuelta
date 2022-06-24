
CREATE DATABASE proyecto_integrador_2022
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Peru.1252'
    LC_CTYPE = 'Spanish_Peru.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

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
	id_usu int  primary key GENERATED ALWAYS AS IDENTITY ,
	nombre_usu varchar(50),
	apellido_usu varchar(50),
	direccion_usu varchar(200),
	telefono varchar(20),
	email varchar(50) unique,
	id_tipo int,
	clave_usu varchar(10),/*se agrego la columna clave*/
	foreign key (id_tipo)references tb_tipousuario(idTipo)
);

create table tb_reclamos
(
	idReclamos int primary key GENERATED ALWAYS AS IDENTITY,
	id_usu int,
	detalle varchar(500),
	foreign key (id_usu)references tb_usuario(id_usu)
);

create table tb_chofer
(
 idchofer int primary key GENERATED ALWAYS AS IDENTITY,
 nombrecho varchar(50),
 NumPermiso varchar(20)
);




create table tb_unidades
(
	id_unidades int primary key GENERATED ALWAYS AS IDENTITY,
	idchofer int,
	nombre_unidad varchar(50),
	placa_unidad varchar(50) unique,
	foreign key (idchofer)references tb_chofer(idchofer)
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
	id_unidades int,
	id_usu int,
	foreign key (id_unidades)references tb_unidades(id_unidades),
	foreign key (id_usu)references tb_usuario(id_usu)
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

INSERT INTO public.tb_tipousuario (nombretipo)
	VALUES ('Cliente');
	
INSERT INTO public.tb_tipousuario (nombretipo)
	VALUES ('Administrador');
	
INSERT INTO public.tb_usuario (nombre_usu,apellido_usu,direccion_usu,telefono,email,id_tipo,clave_usu)
	VALUES ('Admin','Aminister','av.Leyendas','987654321','a@gmail.com',1,'123');

alter table tb_chofer
drop column NumPermiso; 


alter table tb_chofer
add apellidocho varchar(100),
add telefono varchar(20),
add num_permiso varchar(20),
add email varchar(100);	



select * from tb_usuario;
select * from tb_unidades;