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
	origen varchar(50),
	destino varchar(50)
);

INSERT INTO public.tb_tipo_viaje (origen,destino)
	VALUES ('Lima','Trujillo'),
	       ('Trujillo','Lima'),
	       ('Arequipa','Lambayeque'),
	       ('Lambayeque','Piura'),
	       ('Piura','Tacna'),
	       ('Tacna','Arequipa');

create table tb_categoria_reserva
(
	codigo_ct_reserva int primary key GENERATED ALWAYS AS IDENTITY,
	clase_ct_reserva varchar(100)
);

INSERT INTO public.tb_categoria_reserva (clase_ct_reserva)
	VALUES ('Economica'),
	       ('Premium'),
		   ('Ejecutivo'),
		   ('Turista'),
		   ('Primera Clase');
	   

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
	id_reserva int primary key GENERATED ALWAYS AS IDENTITY,	
	codigotv int,
	foreign key (codigotv)references tb_tipo_viaje(codigotv),
	fecha_salida date not null,
	fecha_retorno date not null,	
	adultos_reserva int default 1,
	niños_reserva int default 0,
	codigo_ct_reserva int,
	foreign key (codigo_ct_reserva)references  tb_categoria_reserva (codigo_ct_reserva)
);

INSERT INTO public.tb_reservas (codigotv,fecha_salida,fecha_retorno,adultos_reserva,niños_reserva
								,codigo_ct_reserva )
	VALUES (1,'2022-06-23','2022-06-30',1,0,1),
	       (2,'2022-07-23','2022-07-30',2,1,2),
		   (3,'2022-08-23','2022-08-28',2,1,3),
		   (4,'2022-09-10','2022-09-20',3,2,4),
		   (5,'2022-06-28','2022-07-10',2,2,5),
		   (6,'2022-10-10','2022-10-30',3,1,5);

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

create table tab_oferta
(
	idoferta int primary key GENERATED ALWAYS AS IDENTITY,
	id_usu int,
	descuento decimal(6,2),
	foreign key (id_usu)references tb_usuario(id_usu)
);

INSERT INTO public.tab_oferta(id_usu,descuento)
	VALUES ('1','100.50');

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

	
create table tb_establecimiento
(	
	id_estab int primary key GENERATED ALWAYS AS IDENTITY,
    ciudad varchar(50)
);
	
	INSERT INTO public.tb_establecimiento (ciudad)
	VALUES ('Lima'),
	       ('Trujillo'),
	       ('Arequipa'),
	       ('Lambayeque'),
	       ('Piura'),
	       ('Tacna');
	
select*from tb_establecimiento;
	
create table tb_libroreclamo
(
	id_libro int primary key GENERATED ALWAYS AS IDENTITY,
	id_estab int,
	foreign key (id_estab)references tb_establecimiento(id_estab),
	nombre_usu varchar(50),
	apellidopa_usu varchar(50),
	apellidoma_usu varchar(50),
	direccion_usu varchar(50),
	dni_usu varchar(50),
	telefono_usu varchar(50),
	email_usu varchar(50),
	edad_usu int,
	observaciones_usu varchar(255)	
);


INSERT INTO public.tb_libroreclamo (id_estab,nombre_usu,apellidopa_usu,apellidoma_usu,
									direccion_usu,dni_usu,telefono_usu,
									email_usu,edad_usu,observaciones_usu)
	VALUES (1, 'Jose','Diaz','Prado','calle lima 122','12345678', '989012768','jose123@gmail.com',18,'Mal servicio'),
	       (2, 'Luis','Gomez','Lopez','calle oro 891','80345678', '919012768','luis123@gmail.com',28,'Inconforme'),
		   (3, 'Marcos','Torres','Diaz','calle libia 333','77345678', '949012768','marcos123@gmail.com',30,'Pésimo vuelo');
		 
		   
select*from tb_libroreclamo;

select * from tb_reservas;
select * from tb_tipo_usuario;
select * from tb_usuario;
select * from tb_unidades;