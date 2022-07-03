package org.cibertec.ProyectoIntegrador.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	@Column(name = "id_usu")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsu;
	
	@Column(name = "nombre_usu")
	@Pattern(regexp = "[A-Za-z ]{2,}",message = "El nombre debe tener almenos 2 caracteres y no tener numeros")
	@NotEmpty
	private String nombreUsu;
	
	@Column(name = "apellido_usu")
	@Pattern(regexp = "[A-Za-z ]{2,}",message = "El apellido debe tener almenos 2 caracteres y no tener numeros")
	@NotEmpty
	private String apellidoUsu;
	
	@Column(name = "direccion_usu")
	@Pattern(regexp = "[A-Za-z ]{2,}" ,message = "La dirección debe tener almenos 2 caracteres y no tener numeros")
	@NotEmpty
	private String direccionUsu;
	
	@Column(name = "telefono")
	@NotEmpty
	@Pattern(regexp = "(\\+51)?[ -]*(9)[ -]*([0-9][ -]*){8}",message = "El telefono debe empezar con 9 y tener 9 digitos")
	private String telefono;
	
	@Column(name = "email")
	@Email(message = "El correo debe tener un @ y un .com")
	@NotEmpty
	private String email;
	
	@OneToOne
	@JoinColumn(name = "id_tipo")
	private TipoUsuario tipo;
	
	@NotEmpty
	@Column(name = "clave_usu")
	private String clave;

	public int getIdUsu() {
		return idUsu;
	}

	public void setIdUsu(int idUsu) {
		this.idUsu = idUsu;
	}

	public String getNombreUsu() {
		return nombreUsu;
	}

	public void setNombreUsu(String nombreUsu) {
		this.nombreUsu = nombreUsu;
	}

	public String getApellidoUsu() {
		return apellidoUsu;
	}

	public void setApellidoUsu(String apellidoUsu) {
		this.apellidoUsu = apellidoUsu;
	}

	public String getDireccionUsu() {
		return direccionUsu;
	}

	public void setDireccionUsu(String direccionUsu) {
		this.direccionUsu = direccionUsu;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "Usuario [idUsu=" + idUsu + ", nombreUsu=" + nombreUsu + ", apellidoUsu=" + apellidoUsu
				+ ", direccionUsu=" + direccionUsu + ", telefono=" + telefono + ", email=" + email + ", tipo=" + tipo
				+ ", clave=" + clave + "]";
	}

	public Usuario get() {
		// TODO Auto-generated method stub
		return null;
	}
}