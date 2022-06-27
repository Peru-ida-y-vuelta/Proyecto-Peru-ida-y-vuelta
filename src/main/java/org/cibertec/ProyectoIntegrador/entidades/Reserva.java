package org.cibertec.ProyectoIntegrador.entidades;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_reservas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Reserva implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reserva")
	private int idRsv;	

	@NotNull(message="Campo requerido")
	@OneToOne
	@JoinColumn(name = "codigotv")
	private TipoViaje tipoviaje;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	@Column(name = "fecha_salida ")
    private LocalDate salida 	;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	@Column(name = "fecha_retorno")
    private LocalDate 	retorno;
	
	@Column(name = "adultos_reserva ")
	@NotNull
	@Min(value= 1)
	@Max(value= 10)
	private int adultos;
	
	@Column(name = "niños_reserva")
	@NotNull
	@Min(value= 0)
	@Max(value= 10)
	private int ninos;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "codigo_ct_reserva ")
	private CategoriaReserva categoriareserva;
	
	
}
