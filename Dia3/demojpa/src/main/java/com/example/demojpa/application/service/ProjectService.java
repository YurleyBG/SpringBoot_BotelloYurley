package com.example.demojpa.application.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demojpa.domain.Project;

@Service
public interface ProjectService {

    List<Project>findAllProject();
} 
