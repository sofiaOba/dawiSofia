package com.edu.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

 
import com.edu.cibertec.modelo.Tutor;

//Te es la clase y id tipo de llame
public interface TutorRepository extends JpaRepository<Tutor, Integer> {

	
}//fin
