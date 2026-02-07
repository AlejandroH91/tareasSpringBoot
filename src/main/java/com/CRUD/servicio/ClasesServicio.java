package com.CRUD.servicio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.CRUD.entidad.*;

public interface ClasesServicio {
	List<Clases> obtenerClases();
	Page<Clases> obtenerClases(Pageable pageable);
	Clases obtenerClasesPorId(int id);
	void agregarClases(Clases clase);
	void actualizarClases(int id, Clases clasesActualizadas);
	void eliminarClases(int id);
	
}