package org.cibertec.ProyectoIntegrador.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
@Table(name="tab_servicio_soporte")
public class Soporte {
	@Id
	@Column(name="idsoporte")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSoporte;
	
	@ManyToOne
	@JoinColumn(name = "id_usu")
	private Usuario usuario;
	
	@Column(name="detalle")
	@Pattern(regexp = "[A-Za-z ]{2,}")
	@NotEmpty
	private String Detalle;
}
