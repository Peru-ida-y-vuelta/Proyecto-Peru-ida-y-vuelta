package org.cibertec.ProyectoIntegrador.service;


import java.util.List;
import java.util.Optional;

import org.cibertec.ProyectoIntegrador.entidades.Viaje;




public interface ViajeService {
	public Viaje save( Viaje producto);
	public Optional<Viaje> get(Integer id);
	public void update(Viaje producto);
	public void delete(Integer id);
	public List<Viaje> findAll();

}
