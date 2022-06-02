package org.cibertec.ProyectoIntegrador.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_chofer")
public class Chofer {
	
	@Id
	@Column(name = "idchofer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idChofer;
	
	@Column(name = "nombrecho")
	//@NotBlank
	@Pattern(regexp = "[A-Za-z ]{2,}")
	@NotEmpty
	//@Size(min = 2, message = "Nombre tiene que tener como mínimo 2 caracteres")
	
	private String nombreChofer;
	
	@Column(name = "apellidocho")
	//@NotBlank
	@Pattern(regexp = "[A-Za-z ]{2,}")
	@NotEmpty
	private String apellidoChofer;
    
	@Column(name = "num_permiso")
	@NotBlank
	@Pattern(regexp= "[A-Za-z][ -]*([0-9][ -]*){8}")
	private String numeroPermiso;
	
	@Column(name = "telefono")
	@NotEmpty
	@Pattern(regexp = "(\\+51)?[ -]*(9)[ -]*([0-9][ -]*){8}")
	private String telefono;

	@Column(name = "email")
	@Email
	@NotEmpty
	private String email;
}
