package com.CRUD.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CRUD.entidad.*;

public interface clasesServicio {
	List<Clases> obtenerClases();
	Clases obtenerClasesPorId(int id);
	void agregarClases(Clases clase);
	void actualizarClases(int id, Clases clasesActualizadas);
	void eliminarClases(int id);
	
}