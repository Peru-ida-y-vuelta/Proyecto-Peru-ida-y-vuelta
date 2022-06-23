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
	@Column(name = "idreserva")
	private int idRsv;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fechaReserva")
    private LocalDate 	fechaRsv;
	
	@OneToOne
	@JoinColumn(name = "codigotv")
	private TipoViaje tipoviaje;
	
   //@OneToOne
    //private TipoViaje tipoviaje;
	
}
