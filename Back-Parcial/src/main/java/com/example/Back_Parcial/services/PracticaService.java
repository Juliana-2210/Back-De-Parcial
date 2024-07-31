package com.example.Back_Parcial.services;

import com.example.Back_Parcial.models.Estudiante;
import com.example.Back_Parcial.models.Practica;
import com.example.Back_Parcial.repositories.PracticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PracticaService {

    @Autowired
    private PracticaRepository practicaRepository;

    public Practica save(Practica practica) {
        return practicaRepository.save(practica);
    }

    public List<Practica> findAll() {
        return practicaRepository.findAll();
    }

    public Optional<Practica> findById(Long id) {
        return practicaRepository.findById(id);
    }

    public List<Estudiante> findEstudiantesByPracticaId(Long id) {
        Optional<Practica> practica = practicaRepository.findById(id);
        return practica.map(Practica::getEstudiantes).orElseThrow(() -> new RuntimeException("Práctica no encontrada"));
    }

    public List<Practica> findPracticasByPeriodoAcademico(String periodoAcademico) {
        return practicaRepository.findPracticasByPeriodoAcademico(periodoAcademico);
    }

    public Practica updatePractica(Long id, Practica practicaDetails) {
        Practica practica = practicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Práctica no encontrada"));


        practica.setFechaSalida(practicaDetails.getFechaSalida());
        practica.setFechaRegreso(practicaDetails.getFechaRegreso());
        practica.setDestino(practicaDetails.getDestino());
        practica.setPeriodoAcademico(practicaDetails.getPeriodoAcademico());

        practica.setEstudiantes(practicaDetails.getEstudiantes());

        return practicaRepository.save(practica);
    }
}
