package org.cibertec.ProyectoIntegrador.service.impl;

import org.cibertec.ProyectoIntegrador.entidades.DetalleOrden;
import org.cibertec.ProyectoIntegrador.repository.IDetalleOrdenRepository;
import org.cibertec.ProyectoIntegrador.service.IDetalleOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class DetalleOrdenServiceImpl implements IDetalleOrdenService{
	
	@Autowired
	private IDetalleOrdenRepository detalleOrdenRepository;

	@Override
	public DetalleOrden save(DetalleOrden detalleOrden) {
		return detalleOrdenRepository.save(detalleOrden);
	}

}
