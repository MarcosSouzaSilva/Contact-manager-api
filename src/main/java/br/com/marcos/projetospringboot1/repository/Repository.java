package br.com.marcos.projetospringboot1.repository;

import br.com.marcos.projetospringboot1.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

public interface Repository extends CrudRepository <Person, Integer> {

    int countById(int id);

    ResponseEntity<?> deleteById(Person person);



}