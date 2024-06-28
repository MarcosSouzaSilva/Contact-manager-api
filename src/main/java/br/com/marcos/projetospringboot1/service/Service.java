package br.com.marcos.projetospringboot1.service;

import br.com.marcos.projetospringboot1.model.Mensage;
import br.com.marcos.projetospringboot1.model.Person;
import br.com.marcos.projetospringboot1.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@org.springframework.stereotype.Service
public class Service {

    private final Repository action;

    private final Mensage mensage;

    public Service(Repository action, Mensage mensage) {
        this.action = action;
        this.mensage = mensage;
    }


    // Method for adding a Contact
    public ResponseEntity<?> addContact(Person person) {

        if (person.getName().equals("")) {

            mensage.setMensage("Enter a character in the Name field");
            return new ResponseEntity<>(mensage, HttpStatus.BAD_REQUEST);

        } else {

            return new ResponseEntity<>(action.save(person), HttpStatus.CREATED);

        }
    }

    // Method for editing a contact
    public ResponseEntity<?> editContact(Person person) {

        if (action.countById(person.getId()) == 0) {
            mensage.setMensage("Provide a valid Id !!");
            return new ResponseEntity<>(mensage, HttpStatus.NOT_FOUND);

        } else if (person.getName().equals("")) {

            mensage.setMensage("Enter a character in the Name field");
            return new ResponseEntity<>(mensage, HttpStatus.BAD_REQUEST);

        } else {

            return new ResponseEntity<>(action.save(person), HttpStatus.OK);

        }
    }


    // Method for deleting a contact
    public ResponseEntity<?> deleteContact(int id) {

        Person person = action.findById(id).orElse(null);

        if (action.countById(person.getId()) == 0) {

            mensage.setMensage("Provide a valid Id !!");
            return new ResponseEntity<>(mensage, HttpStatus.NOT_FOUND);

        } else {

            action.delete(person);
            mensage.setMensage("Successfully deleted !!");
            return new ResponseEntity<>(mensage, HttpStatus.OK);

        }
    }

    // Show Contacts
    public ResponseEntity<?> showContacts() {
        return new ResponseEntity<>(action.findAll(), HttpStatus.OK);
    }
}