package org.cibertec.ProyectoIntegrador.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "tb_viajes")
public class Destino {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idViaje")
	private int idDestino;
	
	@OneToOne
	@JoinColumn(name = "codigotv")
	private TipoViaje tipoviaje;
	
	@NotNull
	@Column(name = "nplazas ")
	private int plazas;
}
