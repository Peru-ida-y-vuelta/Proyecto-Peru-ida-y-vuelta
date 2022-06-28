package org.cibertec.ProyectoIntegrador.service;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.CategoriaReserva;


public interface CategoriaReservaService {
	
/*	 public List<CategoriaReserva> listarCategoriaReserva();
	public CategoriaReserva grabar (CategoriaReserva categoriareserva);
	public CategoriaReserva actualizar(CategoriaReserva categoriareserva);
	public void eliminar (int id);
	public CategoriaReserva buscarCategoriaReserva(int id); */
	
	
	
	 List<CategoriaReserva> listarCategoriaReservas(); 

	 CategoriaReserva registrar(CategoriaReserva categoriareserva);

	 CategoriaReserva actualizar(CategoriaReserva categoriareserva);

	 CategoriaReserva obtenerPorId(int id);

	 void eliminar(int id); 
}



