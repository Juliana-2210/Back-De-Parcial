package com.example.Back_Parcial.repositories;

import com.example.Back_Parcial.models.Practica;
import com.example.Back_Parcial.models.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PracticaRepository extends JpaRepository<Practica, Long> {

    @Query("SELECT p FROM Practica p WHERE p.periodoAcademico = :periodoAcademico")
    List<Practica> findPracticasByPeriodoAcademico(@Param("periodoAcademico") String periodoAcademico);

    @Query("SELECT e FROM Practica p JOIN p.estudiantes e WHERE p.id = :practicaId")
    List<Estudiante> findEstudiantesByPracticaId(@Param("practicaId") Long practicaId);

}
