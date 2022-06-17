package org.cibertec.ProyectoIntegrador.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;


@Entity
@Table(name = "tb_unidades")
public class Unidad implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_unidades")
	private int idUni;
	
	
	
	@OneToOne
	@JoinColumn(name = "idchofer")
	private Chofer chofer;
	
	
	@Column(name = "nombre_unidad")
	@NotEmpty(message = "Ingrese El detalle de la unidad")
	private String nomUni;
	
	@Column(name = "placa_unidad")
	@NotEmpty (message = "Ingrese una de placa")
	@Pattern(regexp = "[A-Za-z0-9]{3}-[A-Za-z0-9]{3}",message = "La placa debe tener el siguiente formato : A12-kjh")
	private String placa;

	public int getIdUni() {
		return idUni;
	}

	public void setIdUni(int idUni) {
		this.idUni = idUni;
	}

	public Chofer getChofer() {
		return chofer;
	}

	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}

	public String getNomUni() {
		return nomUni;
	}

	public void setNomUni(String nomUni) {
		this.nomUni = nomUni;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Unidad [idUni=" + idUni + ", chofer=" + chofer + ", nomUni=" + nomUni + ", placa=" + placa + "]";
	}
	
	
}
