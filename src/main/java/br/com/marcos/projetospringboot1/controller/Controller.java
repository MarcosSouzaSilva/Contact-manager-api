package br.com.marcos.projetospringboot1.controller;

import br.com.marcos.projetospringboot1.model.Person;
import br.com.marcos.projetospringboot1.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    private Service service;

    @PostMapping("/add")
    public ResponseEntity<?> addContact(@RequestBody Person person) {
        return service.addContact(person);

    }

    @PutMapping("/edit")
    public ResponseEntity<?> editContact(@RequestBody Person person) {
        return service.editContact(person);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable int id) {
        return service.deleteContact(id);

    }

    @GetMapping("/showContacts")
    public ResponseEntity<?> showContacts() {
        return service.showContacts();

    }
}