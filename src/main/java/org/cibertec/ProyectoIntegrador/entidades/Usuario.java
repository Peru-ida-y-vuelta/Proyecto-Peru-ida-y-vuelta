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

@Data
@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@Column(name = "idUsu")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idUsu;
	
	@Column(name = "nombreUsu")
	@Pattern(regexp = "[A-Za-z ]{2,}")
	@NotEmpty
	public String nombreUsu;
	
	@Column(name = "apellidoUsu")
	@Pattern(regexp = "[A-Za-z ]{2,}")
	@NotEmpty
	public String apellidoUsu;
	
	@Column(name = "DireccionUsu")
	@Pattern(regexp = "[A-Za-z ]{2,}")
	@NotEmpty
	public String direccionUsu;
	
	@Column(name = "telefono")
	@NotEmpty
	@Pattern(regexp = "(\\+51)?[ -]*(9)[ -]*([0-9][ -]*){8}")
	public String telefono;
	
	@Column(name = "email")
	@Email
	@NotEmpty
	public String email;
	
	@Column(name = "idUsu")
	public int idTipo;

}
