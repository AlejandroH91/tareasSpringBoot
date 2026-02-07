package com.CRUD.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CRUD.entidad.Clases;
import com.CRUD.servicio.ClasesServicio;




@Controller
@RequestMapping("/clases")
public class ClasesControlador{
	
	@Autowired //Lo ponemos para usar el servicio dentro del controlador
	private ClasesServicio servicio;
	
	public ClasesControlador(ClasesServicio servicio) {
	    this.servicio = servicio;
	}
	
	@GetMapping
	public String listarClases(Model modelo,
	                           @RequestParam(defaultValue = "0") int page) {
	    int tamañoPagina = 10; // cuántas clases mostrar por página
	    Pageable pageable = PageRequest.of(page, tamañoPagina);//crea un objeto pageable indicando qué página y cuántos elementos por página.
	    Page<Clases> clasesPage = servicio.obtenerClases(pageable);

	    modelo.addAttribute("clases", clasesPage);
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