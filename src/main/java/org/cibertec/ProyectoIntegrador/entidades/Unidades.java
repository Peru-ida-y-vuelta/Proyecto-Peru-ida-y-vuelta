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
@Table(name = "tb_unidades")
public class Unidades {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_unidades")
	private int id;
	
	@Column(name = "idchofer")
	private int idchofer;
	
	
	/*@Pattern(regexp = "[A-Za-z ]{5,}")*/
	@NotEmpty
	@Column(name = "nombre_unidad")
	private String nom;
	
	/*@Pattern(regexp = "{6}")*/
	@Column(name = "placa_unidad",unique = true)
	private String placa;
}
