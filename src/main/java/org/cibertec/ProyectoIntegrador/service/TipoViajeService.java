package org.cibertec.ProyectoIntegrador.service;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.TipoViaje;

public interface TipoViajeService {
	
	public List<TipoViaje> listarTipoViaje();
	public TipoViaje grabar(TipoViaje tipoviaje);
	public TipoViaje actualizar(TipoViaje tipoviaje);
	public void eliminar(int id);
	public TipoViaje buscarTipoViaje(int id);
	

}
