package com.edu.cibertec.controllers;

import java.util.List; //siempre util

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 
import com.edu.cibertec.modelo.Provincia;
import com.edu.cibertec.repository.ProvinciaRepository;


@RestController
@RequestMapping(path="/api")
public class ProvinciaController {

	
	//1.-Instanciar por unica vez nuestro Repositorio
	//lo instancia por unica vez IMPORTANTE Autowired ojooo
	@Autowired
	private ProvinciaRepository repository;
	
	 
	
	//2.-LISTAR Crear mis metodos para el CRUD
	@GetMapping(path="/provincias")
	public List<Provincia> obtenerTodos(){	
		return repository.findAll();
	}
	
	
	
	//3.-CREAR provincias
	//recibo un json
	@PostMapping("/Provincia")
	public Provincia crearProvincia(@RequestBody Provincia Provincia) {
		return repository.save(Provincia);
	}
	
	
	
	//4.-ACTUALIZAR Provincia
	@PutMapping("/Provincia/{id}")
	public Provincia actualizarProvincia(@PathVariable int id, @RequestBody Provincia Provincia) {
		//Si existe actualiza el id
		return repository.save(Provincia);
	}
	
	
	//5.-ELIMINAR, el metodo que ponga aqui "DeleteMapping debo poner en postman
	@DeleteMapping("/Provincia/{id}")
	public void eliminarProvincia(@PathVariable("id") int id) {
		repository.deleteById(id);
	}
	
	

	//6.-OBTENER DEPARTAMENTO POR NOMBRE EXACATO, ojo primero debes llamarlo en repository
	@GetMapping("/Provincia/{nombre}")
	public List<Provincia>obtenerProvinciaxNombre(@PathVariable("nombre") String nombre){
		return repository.findByNombre(nombre);
	}
	
	
	
}//fin
