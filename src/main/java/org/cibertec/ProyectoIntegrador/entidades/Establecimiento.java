package org.cibertec.ProyectoIntegrador.entidades;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tb_establecimiento")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Establecimiento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_estab")
	    private int idEstab;
	    
	    @Column(name = "ciudad ")
	    private String ciudad;

}
