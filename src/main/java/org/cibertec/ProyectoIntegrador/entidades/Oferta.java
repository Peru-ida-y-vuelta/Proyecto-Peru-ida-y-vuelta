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

import lombok.Data;

@Data
@Entity
@Table(name="tab_oferta")
public class Oferta {
	@Id
	@Column(name="idoferta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOferta;
	@ManyToOne
	@JoinColumn(name = "id_usu")
	private Usuario usuario;
	@Column(name="descuento")

	private double descuento;
	
}
