package com.example.Back_Parcial.services;

import com.example.Back_Parcial.models.Docente;
import com.example.Back_Parcial.repositories.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    public Docente save(Docente docente) {
        return docenteRepository.save(docente);
    }

    public Optional<Docente> findById(Long id) {
        return docenteRepository.findById(id);
    }

    public List<Docente> findAll() {
        return docenteRepository.findAll();
    }
}
