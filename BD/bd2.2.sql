CREATE DATABASE proyecto_integrador_2022
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Peru.1252'
    LC_CTYPE = 'Spanish_Peru.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

create table tb_tipo_usuario
(
	id_tipo int primary key GENERATED ALWAYS AS IDENTITY,
	nombre_tipo varchar(20) /*se cambio*/
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
	id_viaje int primary key GENERATED ALWAYS AS IDENTITY,
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
	fecha_Reserva varchar(50),
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
	foreign key (id_tipo)references tb_tipo_usuario(id_tipo)
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
	id_viaje int,
	idBoleta int,
	cantidad int,
	Precio decimal,
	foreign key (id_viaje)references tb_viajes(id_viaje),
	foreign key (idBoleta)references tb_boleta(idBoleta)
);

create table tab_servicio_soporte
(
	idSoporte int primary key GENERATED ALWAYS AS IDENTITY,
	id_usu int,
	Detalle varchar(100),
	foreign key (id_usu)references tb_usuario(id_usu)
);

INSERT INTO public.tab_servicio_soporte (id_usu,Detalle)
	VALUES ('1','CLIENTE SE QUEJA DE UNA AVERIA EN UN CARRO');
	



INSERT INTO public.tb_tipo_usuario (nombre_tipo)
	VALUES ('Cliente');
	
INSERT INTO public.tb_tipo_usuario (nombre_tipo)
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

INSERT INTO public.tb_tipo_viaje(
	 salida, destino, duracion, preciotv)
	VALUES ('Lunes', 'Lima','3 dias',150.50);
	
INSERT INTO public.tb_tipo_viaje(
	 salida, destino, duracion, preciotv)
	VALUES ('martes', 'Chincha','5 dias',200.50);
	
INSERT INTO public.tb_tipo_viaje(
	 salida, destino, duracion, preciotv)
	VALUES ('jueves', 'Arequipa','7 dias',500.50);

	

select * from tb_reservas;
select * from tb_tipo_usuario;
select * from tb_usuario;
select * from tb_unidades;