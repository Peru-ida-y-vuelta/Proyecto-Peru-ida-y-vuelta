package org.cibertec.ProyectoIntegrador.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="tb_categoria_reserva")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CategoriaReserva implements Serializable {
	
	
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_ct_reserva")
	private int codigo_ctersv;	
	
	@Column(name = "clase_ct_reserva")
	@NotEmpty(message="Clase requerida")
	public String clase;

}
