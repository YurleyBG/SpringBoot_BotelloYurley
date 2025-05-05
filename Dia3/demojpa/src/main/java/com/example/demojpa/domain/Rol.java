package com.example.demojpa.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "role",fetch= FetchType.EAGER, cascade= CascadeType.REMOVE,orphanRemoval = true)
    @JsonManagedReference // marca el lado que si se serializa
    private List<Person> persona= new ArrayList<>();
    public Rol() {}

    public Rol(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPersona() {
        return persona;
    }

    public void setPersona(List<Person> persona) {
        this.persona = persona;
    }
    
    
    
}
