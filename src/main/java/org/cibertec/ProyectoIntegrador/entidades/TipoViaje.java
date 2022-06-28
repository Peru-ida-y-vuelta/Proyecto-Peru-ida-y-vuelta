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
@Table(name="tb_tipo_viaje")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder  //mejor forma de hacer un método para devolver un tipo de viaje, etc
        // patrón Builder

public class TipoViaje implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigotv")
	private int codigotpv;
	
	@NotEmpty
	@Column(name = "origen")
	private String origen;
	
	@NotEmpty
	@Column(name = "destino")
	private String  destino;
	

}
