package br.com.marcos.projetospringboot1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Person {

    @Id
    @GeneratedValue
    int id;

    @NotBlank(message = "Enter a character in the name field")
    String name;

    @NotBlank(message = "Enter a character in the email field")
    @Email(message = " Provide a valid email ")
    String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public @Email(message = "Provide a valid email !!") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Provide a valid email !!") String email) {
        this.email = email;
    }
}