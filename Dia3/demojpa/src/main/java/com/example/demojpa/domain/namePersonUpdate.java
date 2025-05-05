package com.example.demojpa.domain;

public class namePersonUpdate {

    private String newName;

    public namePersonUpdate() {
    }
    

    public namePersonUpdate(String newName) {
        this.newName = newName;
    }


    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }
}
