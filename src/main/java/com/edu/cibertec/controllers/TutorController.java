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

 
import com.edu.cibertec.modelo.Tutor;
import com.edu.cibertec.repository.TutorRepository;


@RestController
@RequestMapping(path="/api")
public class TutorController {

	
	//1.-Instanciar por unica vez nuestro Repositorio
	//lo instancia por unica vez IMPORTANTE Autowired ojooo
	@Autowired
	private TutorRepository repository;
	
	
	
	//2.-LISTAR Crear mis metodos para el CRUD
	@GetMapping(path="/tutores")
	public List<Tutor> obtenerTodos(){	
		return repository.findAll();
	}
	
	
	
	//3.-CREAR Tutors
	//recibo un json
	@PostMapping("/Tutor")
	public Tutor crearTutor(@RequestBody Tutor Tutor) {
		return repository.save(Tutor);
	}
	
	
	
	//4.-ACTUALIZAR Tutor
	@PutMapping("/Tutor/{id}")
	public Tutor actualizarTutor(@PathVariable int id, @RequestBody Tutor Tutor) {
		//Si existe actualiza el id
		return repository.save(Tutor);
	}
	
	
	//5.-ELIMINAR, el metodo que ponga aqui "DeleteMapping debo poner en postman
	@DeleteMapping("/Tutor/{id}")
	public void eliminarTutor(@PathVariable("id") int id) {
		repository.deleteById(id);
	}
	
	
	/*
	//6.-OBTENER DEPARTAMENTO POR NOMBRE EXACATO
	@GetMapping("/Tutor/{nombre}")
	public List<Tutor>obtenerTutorxNombre(@PathVariable("nombre") String nombre){
		return repository.findByNombre(nombre);
	}
	
	*/
	
}//fin
