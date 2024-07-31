package com.example.Back_Parcial.services;

import com.example.Back_Parcial.models.Curso;
import com.example.Back_Parcial.repositories.CursoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Optional<Curso> findById(Long id) {
        return cursoRepository.findById(id);
    }

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }
}
