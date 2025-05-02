package com.example.demojpa.infraestructure.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demojpa.domain.Rol;


public interface RolRepository extends JpaRepository< Rol,Long>{
    
    Optional<Rol>findByName(String Name);

    
}
