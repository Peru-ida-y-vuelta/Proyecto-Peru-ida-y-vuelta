package org.cibertec.ProyectoIntegrador.service;
import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.Oferta;
public interface OfertaService {

	public List<Oferta> listarOferta();
	public Oferta agregar(Oferta oferta);
	public Oferta editar(Oferta oferta);
	public void eliminar(int id);
	public  Oferta buscarOferta(int id);
	
	
}
