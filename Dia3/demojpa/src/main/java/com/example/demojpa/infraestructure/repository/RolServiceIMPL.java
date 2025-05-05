package com.example.demojpa.infraestructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demojpa.application.service.RolService;
import com.example.demojpa.domain.Rol;
import com.example.demojpa.infraestructure.error.RoldDuplicationException;

import jakarta.persistence.EntityNotFoundException;
@Service
public class RolServiceIMPL  implements RolService{
    private final  RolRepository rolRepository;

    public RolServiceIMPL(RolRepository rolRepository){
        this.rolRepository=rolRepository;
    }

    @Override
    public List<Rol> findAllRolesByFilter(String filter, String value) {
        
        return rolRepository.findAll();
    }

    @Override
    public Rol createNewRol(String name) {
        Rol newRol = new Rol();
        newRol.setName(name);
        if(GetRoleByName(name).isPresent()){
            throw new RoldDuplicationException("El Rol: "+ name +" ya esta registrado.",HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return rolRepository.save(newRol);
       
    }
    private Optional<Rol> GetRoleByName(String rolName){
        return rolRepository.findByName(rolName);
    }

    @Override
    public Rol RemoveRol(long id) {
        Optional<Rol> rol= rolRepository.findById(id);
        if(!rol.isPresent()){
            throw new EntityNotFoundException("El  rol no se encuentra regustrado.");
        }
        if(!rol.get().getPersona().isEmpty()){
            throw new EntityNotFoundException("El rol se encuentra asociado a un usuario");
        }
        rolRepository.deleteById(id);
        return rol.get();
        // roleRepository.delete(rol.get());
        
        


      
    }


}
