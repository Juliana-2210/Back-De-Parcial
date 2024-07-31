package com.example.Back_Parcial.controllers;

import com.example.Back_Parcial.models.Curso;
import com.example.Back_Parcial.services.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Operation(summary = "Crea un nuevo curso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Curso creado"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PostMapping
    public Curso createCurso(@RequestBody Curso curso) {
        return cursoService.save(curso);
    }

    @Operation(summary = "Obtiene todos los cursos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cursos encontrados"),
            @ApiResponse(responseCode = "404", description = "No se encontraron cursos")
    })
    @GetMapping
    public List<Curso> getAllCursos() {
        return cursoService.findAll();
    }
}
