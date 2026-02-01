package com.CRUD.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.CRUD.repository.ClasesRepository;
import com.CRUD.entidad.*;
@Service
public class clasesServicioImpl implements clasesServicio{

	private final List<Clases> listaClases = new ArrayList<>();
	
	@Autowired
	 private ClasesRepository repository;

	@Override
	public List<Clases> obtenerClases() {
	    return repository.findAll();
	}

	@Override
	public Clases obtenerClasesPorId(int id) {
		 return repository.findById(id).orElse(null);
	}

	/*
	 * Ahora con los datos creados y este método 
	 * agregamos las clases a la lista.*/
	@Override
	public void agregarClases(Clases clase) {
		repository.save(clase);
		
	}
	
	@Override
	public void actualizarClases(int id, Clases clase) {
		Clases existente = repository.findById(id).orElse(null);
	    if (existente != null) {
	        existente.setNombre(clase.getNombre());
	        existente.setCapacidad(clase.getCapacidad());
	        existente.setNum_pista(clase.getNum_pista());
	        repository.save(existente);
	    }
	}
	
	@Override
	public void eliminarClases(int id) {
		repository.deleteById(id);
	}

}
