package org.cibertec.ProyectoIntegrador.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
@Table(name="tab_servicio_soporte")
public class Soporte {
	@Id
	@Column(name="idSoporte")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSoporte;
	@Column(name="id_usu")
	@Pattern(regexp="")
	@NotEmpty
	private int idUsuario;
	@Column(name="Detalle")
	@Pattern(regexp="")
	@NotEmpty
	private String Detalle;
}
