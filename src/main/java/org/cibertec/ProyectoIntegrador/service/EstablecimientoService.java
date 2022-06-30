package org.cibertec.ProyectoIntegrador.service;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.Establecimiento;



public interface EstablecimientoService {

   List<Establecimiento> listarEstablecimientos(); 	
   
   Establecimiento registrar(Establecimiento establecimiento);

   Establecimiento actualizar(Establecimiento establecimiento);

   Establecimiento obtenerPorId(int id);

	 void eliminar(int id);
	
}
