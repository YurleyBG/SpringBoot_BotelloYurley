package com.example.demojpa.domain;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name="persona")
@EqualsAndHashCode(exclude = {"role"})
@ToString(exclude ={"role"})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="Full_Name",columnDefinition = "TEXT",length = 50,nullable=false)
    private String name;
    private String lastname;
    @Column(name="Programming_language")
    private String language;
    
    @ManyToOne(cascade = CascadeType.PERSIST)//nivel de JPA
    @JoinColumn(name="rol_id",nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)// nivel de base de datos
    @JsonBackReference
    private Rol role;

    @OneToOne(mappedBy = "person")
    private passport Passport;


    @ManyToMany
    @JoinTable(
        name="personas_projects",
        joinColumns = @JoinColumn(name="persona_id",foreignKey = @ForeignKey(name="fk_id_pesona_project")),
        inverseJoinColumns = @JoinColumn(name="project_id")

    )
    private List<Project> projects=new ArrayList<>();
  
    public Person() {
        
    }

    public Person(Long id, String name, String lastname, String language) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLanguage() {
        return language;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Rol getRole() {
        return role;
    }

    public void setRole(Rol role) {
        this.role = role;
    }

    public passport getPassport() {
        return Passport;
    }

    public void setPassport(passport passport) {
        Passport = passport;
    }




    
    

}
