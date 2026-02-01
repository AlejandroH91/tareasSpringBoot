package com.CRUD.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import entidad.Clases;
@Service
public class clasesServicioImpl implements clasesServicio{

	private final List<Clases> listaClases = new ArrayList<>();
	
	public clasesServicioImpl() {
        agregarClases(new Clases("Tenis",10,1));//Nombre, capacidad, numero_pista
        agregarClases(new Clases("Volleyball",16,2));
        agregarClases(new Clases("Fútbol",14,3));
        agregarClases(new Clases("Baloncesto",12,4));
    }

	@Override
	public List<Clases> obtenerClases() {
	    return listaClases;
	}

	@Override
	public Clases obtenerClasesPorId(int id) {
	    for (Clases clase : listaClases) {
	        if (clase.getId() == id) {
	            return clase;
	        }
	    }
	    return null;
	}

	/*
	 * Ahora con los datos creados y este método 
	 * agregamos las clases a la lista.*/
	@Override
	public void agregarClases(Clases clase) {
		listaClases.add(clase);
		
	}
	
	@Override
	public void actualizarClases(int id, Clases claseActualizada) {
	    for (Clases clase : listaClases) {
	        if (clase.getId() == id) {
	        	clase.setNombre(claseActualizada.getNombre());
	        	clase.setCapacidad(claseActualizada.getCapacidad());
	        	clase.setNum_pista(claseActualizada.getNum_pista());
	            return;
	        }
	    }
	}
	
	@Override
	public void eliminarClases(int id) {
	    listaClases.removeIf(clase -> clase.getId() == id);
	}

}
