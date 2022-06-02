package org.cibertec.ProyectoIntegrador.services;

import java.util.List;

import org.cibertec.ProyectoIntegrador.model.Unidades;
import org.cibertec.ProyectoIntegrador.repository.UnidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadService {

	@Autowired
	private UnidadRepository uniRepo;
	
	public List<Unidades>ListarTodo(){
		return uniRepo.findAll();
	}
	public Unidades listarXId(int id) {
		return uniRepo.findById(id).get();
	}
	public Unidades Crear(Unidades obj) {
		return uniRepo.save(obj);
	}
	public int Eliminar(Unidades obj) {
		int dato;
		try {
			uniRepo.delete(obj);
			dato=1;
		}
		catch (Exception e) {
			dato=-1;
		}
		 return dato;
	}
	public String Actualizar(int id) {
		String mensaje = "";
		try 
		{
			Unidades uni =  uniRepo.findById(id).get();
				if(uni == null) {
						mensaje = "No exite Registro";
					}
				else {
						uniRepo.save(uni);
						mensaje = "Unidad Registrada";
					}
		}
		catch (Exception e) 
		{
			mensaje = "Ingrese una id";
		}
		return mensaje;
	}
}
