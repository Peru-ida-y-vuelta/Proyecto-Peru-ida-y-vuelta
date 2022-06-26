package org.cibertec.ProyectoIntegrador.service.impl;

import java.util.List;

import org.cibertec.ProyectoIntegrador.entidades.Soporte;
import org.cibertec.ProyectoIntegrador.repository.SoporteRepositorio;
import org.cibertec.ProyectoIntegrador.service.SoporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoporteServiceImpl implements SoporteService{
	@Autowired
	SoporteRepositorio sr;

@Override
public List<Soporte> listarSoporte() {
	// TODO Auto-generated method stub
	return sr.findAll();
}

@Override
public Soporte Insertar(Soporte spt) {
	// TODO Auto-generated method stub
	return sr.save(spt);
}

@Override
public Soporte Actualizar(Soporte spt) {
	// TODO Auto-generated method stub
	return sr.save(spt);
}

@Override
public void eliminar(int id) {
	// TODO Auto-generated method stub
	sr.deleteById(id);
}

@Override
public Soporte buscaSoporte(int id) {
	// TODO Auto-generated method stub
	return sr.findById(id).get();
}
}
