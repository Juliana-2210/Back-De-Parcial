package com.example.Back_Parcial.controllers;

import com.example.Back_Parcial.models.Docente;
import com.example.Back_Parcial.services.DocenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/docentes")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @Operation(summary = "Crea un nuevo docente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Docente creado"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PostMapping
    public Docente createDocente(@RequestBody Docente docente) {
        return docenteService.save(docente);
    }

    @Operation(summary = "Obtiene un docente por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Docente encontrado"),
            @ApiResponse(responseCode = "404", description = "Docente no encontrado")
    })
    @GetMapping("/{id}")
    public Docente getDocenteById(@PathVariable Long id) {
        return docenteService.findById(id)
                .orElseThrow(() -> new RuntimeException("Docente no encontrado"));
    }

    @Operation(summary = "Obtiene todos los docentes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Docentes encontrados")
    })
    @GetMapping
    public List<Docente> getAllDocentes() {
        return docenteService.findAll();
    }
}
