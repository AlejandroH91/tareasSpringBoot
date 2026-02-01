package com.CRUD.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import entidad.Clases;

import org.springframework.ui.Model;
import servicio.clases.clasesServicio;



@Controller
@RequestMapping("/clases")
public class clasesControlador{
	
	@Autowired //Lo ponemos para usar el servicio dentro del controlador
	private clasesServicio servicio;
	
	public clasesControlador(clasesServicio servicio) {
	    this.servicio = servicio;
	}
	
	@GetMapping
	public String listarClases(Model modelo) {
	    modelo.addAttribute("clases", servicio.obtenerClases());
	    return "clases/listar";
	}
	
	@GetMapping("/nuevo")
	public String mostrarFormularioCrear(Model modelo) {
	    modelo.addAttribute("clase", new Clases("", 0, 0));
	    return "clases/nuevo";
	}
	
	@PostMapping
	public String guardarClase(@ModelAttribute("clase") Clases clase) {
	    servicio.agregarClases(clase);
	    return "redirect:/clases";
	}
	
	@GetMapping("/editar/{id}")// "/editar" apunta a la ruta del html y el {id} al id del elemento a editar.
	public String mostrarFormularioEditar(@PathVariable("id") int id, Model modelo) {
	    Clases clase = servicio.obtenerClasesPorId(id);
	    modelo.addAttribute("clase", clase);
	    return "clases/editar";
	}
	
	@PostMapping("/{id}")
	public String actualizarClase(@PathVariable("id") int id, @ModelAttribute("clase") Clases clase) {
	    servicio.actualizarClases(id, clase);
	    return "redirect:/clases";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarClase(@PathVariable("id") int id) {
	    servicio.eliminarClases(id);
	    return "redirect:/clases";
	}
}