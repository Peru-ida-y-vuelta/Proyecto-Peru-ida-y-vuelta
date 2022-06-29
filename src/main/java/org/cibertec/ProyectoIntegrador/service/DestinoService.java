package org.cibertec.ProyectoIntegrador.service;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.Destino;

public interface DestinoService {

	public List<Destino> listarDestino();
	public Destino grabarDes(Destino des);
	public Destino actualizarDes(Destino des);
	public void eliminarDes(int id);
	public Destino buscarDes(int id);
}
