package com.example.demojpa.domain.dto;

public class PersonRequest {

    private String name, surname, skill , passport;

    public PersonRequest(String name, String surname, String skill, String passport) {
        this.name = name;
        this.surname = surname;
        this.skill = skill;
        this.passport=passport;
    }
    public PersonRequest(String name, String surname, String skill) {
        this.name = name;
        this.surname = surname;
        this.skill = skill;
    }

    public PersonRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
    
    

}
