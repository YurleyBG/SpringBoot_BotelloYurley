package com.example.demojpa.infraestructure.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demojpa.domain.Project;

public interface ProjectRepository extends JpaRepository<Project,Long>{

   
}
