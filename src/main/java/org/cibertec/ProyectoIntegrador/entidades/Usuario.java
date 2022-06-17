package org.cibertec.ProyectoIntegrador.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	@Column(name = "id_usu")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idUsu;
	
	@Column(name = "nombre_usu")
	@Pattern(regexp = "[A-Za-z ]{2,}",message = "El nombre debe tener almenos 2 caracteres y no tener numeros")
	@NotEmpty
	public String nombreUsu;
	
	@Column(name = "apellido_usu")
	@Pattern(regexp = "[A-Za-z ]{2,}",message = "El apellido debe tener almenos 2 caracteres y no tener numeros")
	@NotEmpty
	public String apellidoUsu;
	
	@Column(name = "direccion_usu")
	@Pattern(regexp = "[A-Za-z ]{2,}" ,message = "La dirección debe tener almenos 2 caracteres y no tener numeros")
	@NotEmpty
	public String direccionUsu;
	
	@Column(name = "telefono")
	@NotEmpty
	@Pattern(regexp = "(\\+51)?[ -]*(9)[ -]*([0-9][ -]*){8}",message = "El telefono debe empezar con 9 y tener 9 digitos")
	public String telefono;
	
	@Column(name = "email")
	@Email(message = "El correo debe tener un @ y un .com")
	@NotEmpty
	public String email;
	
	@Column(name = "id_tipo")
	public int idTipo;
	
	@NotEmpty
	@Column(name = "clave_usu")
	private String clave;
}