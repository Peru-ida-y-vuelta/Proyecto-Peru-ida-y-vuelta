package org.cibertec.ProyectoIntegrador.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usu")
	private int id;
	
	@Column(name = "nombre_usu")
	private String nom;
	
	@Column(name = "apellido_usu")
	private String ape;
	
	@Column(name = "direccion_usu")
	private String direc;
	
	@Column(name = "telefono")
	private String phone;
	
	@Column(name = "email")
	private String correo;
	
	@Column(name = "id_tipo")
	private int tipo;
	
	@Column(name = "clave_usu")
	private String clave;
}