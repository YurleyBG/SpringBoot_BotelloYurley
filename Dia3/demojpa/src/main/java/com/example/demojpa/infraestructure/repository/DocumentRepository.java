package com.example.demojpa.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demojpa.domain.Passport;

public interface DocumentRepository  extends JpaRepository<Passport,Long>{


}
