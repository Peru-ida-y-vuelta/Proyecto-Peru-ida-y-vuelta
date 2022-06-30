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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_libroreclamo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Libro implements Serializable {
		
private static final long serialVersionUID = 1L;
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_libro")
	    private int idlibro;
        
	    
		@OneToOne
		@JoinColumn(name = "id_estab")
		private  Establecimiento establecimiento;
	    
	    
	    @Column(name = "nombre_usu ")
	    private String nombre;

	    
	    @Column(name = "apellidopa_usu ")
	    private String apellidopa;

	    
	    @Column(name = "apellidoma_usu ")
	    private String apellidoma;

	    
	    @Column(name = "direccion_usu ")
	    private String direccion;
	    
	    
	    @Column(name = "dni_usu ")
        private String dni;
	    
	    
	    @Column(name = "telefono_usu ")
	    private String telefono;
	        
	    
	    @Column(name = "email_usu ")
	    private String email;
	    

	    @Column(name = "edad_usu ")
	    private int edad;
	    
	    @Column(name = "observaciones_usu ")
	    private String observaciones;

}

