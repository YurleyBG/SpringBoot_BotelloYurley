package com.example.demojpa.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
public class passport {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    private  String number;
    private Date expiretion;

    @OneToOne
    @JoinColumn(name="person_id")
    @JsonBackReference
    private Person person;
    public passport(){

    }

    public passport(long id, String number, Date expiretion) {
        this.id = id;
        this.number = number;
        this.expiretion = expiretion;
    }
    
    
}
