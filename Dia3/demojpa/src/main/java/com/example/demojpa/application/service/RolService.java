package com.example.demojpa.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demojpa.domain.Rol;

@Service
public interface RolService {
    public List<Rol> findAllRolesByFilter(String filter,String value);
    public Rol createNewRol(String name);
    public Rol RemoveRol(long id);
}
