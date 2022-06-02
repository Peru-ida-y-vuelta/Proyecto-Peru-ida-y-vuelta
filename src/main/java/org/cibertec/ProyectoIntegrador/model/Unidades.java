package org.cibertec.ProyectoIntegrador.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "tb_unidades")
public class Unidades {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_unidades")
	private int id;
	
	@Column(name = "nombre_unidad")
	private String nom;
	
	
	@Column(name = "fecha_compra")
	private String fecha;
	
	@Column(name = "placa_unidad",unique = true)
	private String placa;
}
