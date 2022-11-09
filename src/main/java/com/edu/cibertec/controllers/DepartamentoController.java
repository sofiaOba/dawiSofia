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

import com.edu.cibertec.modelo.Departamento;
import com.edu.cibertec.repository.DepartamentoRepository;


@RestController
@RequestMapping(path="/api")
public class DepartamentoController {

	
	//1.-Instanciar por unica vez nuestro Repositorio
	//lo instancia por unica vez IMPORTANTE Autowired ojooo
	@Autowired
	private DepartamentoRepository repository;
	
	
	
	//2.-LISTAR Crear mis metodos para el CRUD
	@GetMapping(path="/departamentos")
	public List<Departamento> obtenerTodos(){	
		return repository.findAll();
	}
	
	
	
	//3.-CREAR DEPARTAMENTOS
	//recibo un json
	@PostMapping("/departamento")
	public Departamento crearDepartamento(@RequestBody Departamento departamento) {
		return repository.save(departamento);
	}
	
	
	
	//4.-ACTUALIZAR Departamento
	@PutMapping("/departamento/{id}")
	public Departamento actualizarDepartamento(@PathVariable int id, @RequestBody Departamento departamento) {
		//Si existe actualiza el id
		return repository.save(departamento);
	}
	
	
	//5.-ELIMINAR, el metodo que ponga aqui "DeleteMapping debo poner en postman
	@DeleteMapping("/departamento/{id}")
	public void eliminarDepartamento(@PathVariable("id") int id) {
		repository.deleteById(id);
	}
	
	
	
	//6.-OBTENER DEPARTAMENTO POR NOMBRE EXACATO
	@GetMapping("/departamento/{nombre}")
	public List<Departamento>obtenerDepartamentosxNombre(@PathVariable("nombre") String nombre){
		return repository.findByNombre(nombre);
	}
	
}//fin
