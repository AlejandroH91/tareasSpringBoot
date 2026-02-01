# CRUD MVC con Thymeleaf — RA3

## 1) Datos del alumno/a
- Entidad elegida (ej. Producto, Libro...):Clases

## 2) Repositorio (fork) y gestión de versiones
- Repositorio base: https://github.com/profeInformatica101/tareasSpringBoot
- Enlace a MI fork: https://github.com/AlejandroH91/tareasSpringBoot
- Nº de commits realizados: (mínimo 5) -> Hasta ahora 4.

## 3) Arquitectura
Explica brevemente cómo has organizado:
- Controller:Lo uso como intermediario entre el paquete de servicio y la vista.
- Service:Lógica del negocio dividida en interfaz (clasesServicio) y clasesServicioImpl. No importa en     este punto donde van o de donde vienen los datos.
- Repository:Encargada de guardar los datos usando la persistencia mediante JpaRepository.
- Entity:La clase/objeto que con la etiqueta @Entity quedará como una tabla en la BD.

## 4) Base de datos elegida (marca una)
- [ ] H2
- [x] MySQL
- [ ] PostgreSQL

## 5) Configuración de la base de datos
    Primero crear la BD en mi caso se llama igual que el repositorio tareasSpringBoot
### 5.1 Dependencias añadidas
	<dependency>
		<groupId>com.mysql</groupId>
		<artifactId>mysql-connector-j</artifactId>
		<scope>runtime</scope>
	</dependency>

### 5.2 application.properties / application.yml
(Pega aquí tu configuración SIN contraseñas reales si es necesario)

### 5.3 Pasos para crear la BD (si aplica)
- CREATE DATABASE tareasSpringBoot;


## 6) Cómo ejecutar el proyecto
1. Java JDK: Versión 17 o superior instalada.
    Gestor de dependencias: Maven.
    SGBD: MySQL (mediante xampp en mi caso).
2. Comando de arranque:
   - ./mvnw spring-boot:run
3. URL de acceso:
   - http://localhost:8080/...

## 7) Pantallas / Rutas MVC
- GET /listar clases
- POST /entidad Agregar una clase
- GET /entidad/{id}/editar (editar)
- POST /entidad/Actualizar clase por {id} 
- POST /entidad/borrar clases por {id}


## 8) Mejoras extra (opcional)
- Validaciones mediante etiquetas (@Notnull, @blank)
- Estilos Bootstrap
- Obtener clases por id
- Pruebas
- Paginación
