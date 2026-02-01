package entidad;

import java.util.Date;
//Imports necesarios para poder usar las etiquetas de Entity para generar tablas en la BD.
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity

public class Clases{
	 
	/*La anotación @Id se usa para generar la clave primaria de la tabla que parte de esta 
	 * clase que con @Entity se convierte en la bd en una tabla*/
	@Id
	//El generated Value para hacerlo autoincremental.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private int capacidad;
	private int num_pista;
	
	
	public Clases(String nombre, int capacidad, int num_pista) {
		this.nombre= nombre;
		this.capacidad= capacidad;
		this.num_pista= num_pista;
	}
	//Necesario para que Thymeleaf cree otros objetos Clases
	public Clases() { }
	

	public int getId() {
		return id;
	}

	public int getNum_pista() {
		return num_pista;
	}


	public void setNum_pista(int num_pista) {
		this.num_pista = num_pista;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
}