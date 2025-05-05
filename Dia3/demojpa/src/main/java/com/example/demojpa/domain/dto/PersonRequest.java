package com.example.demojpa.domain.dto;

public class PersonRequest {

    private String name, surname, skill;

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
    

}
