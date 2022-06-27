package org.cibertec.ProyectoIntegrador.service.impl;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.Oferta;
import org.cibertec.ProyectoIntegrador.repository.OfertaRepository;
import org.cibertec.ProyectoIntegrador.service.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OferaServiceImpl implements OfertaService {
@Autowired
	OfertaRepository repository;
	
	
	@Override
	public List<Oferta> listarOferta() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Oferta agregar(Oferta oferta) {
		// TODO Auto-generated method stub
		return repository.save(oferta);
	}

	@Override
	public Oferta editar(Oferta oferta) {
		// TODO Auto-generated method stub
		return repository.save(oferta);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	@Override
	public Oferta buscarOferta(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}
	

}
