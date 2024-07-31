package com.example.Back_Parcial.controllers;

import com.example.Back_Parcial.models.Estudiante;
import com.example.Back_Parcial.models.Practica;
import com.example.Back_Parcial.services.PracticaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/practicas")
public class PracticaController {

    @Autowired
    private PracticaService practicaService;

    @Operation(summary = "Crea una nueva práctica")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Práctica creada"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PostMapping
    public Practica createPractica(@RequestBody Practica practica) {
        return practicaService.save(practica);
    }

    @Operation(summary = "Obtiene todas las prácticas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prácticas encontradas"),
            @ApiResponse(responseCode = "404", description = "No se encontraron prácticas")
    })
    @GetMapping
    public List<Practica> getAllPracticas() {
        return practicaService.findAll();
    }

    @Operation(summary = "Obtiene una práctica por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Práctica encontrada"),
            @ApiResponse(responseCode = "404", description = "Práctica no encontrada")
    })
    @GetMapping("/{id}")
    public Practica getPracticaById(@PathVariable Long id) {
        return practicaService.findById(id)
                .orElseThrow(() -> new RuntimeException("Práctica no encontrada"));
    }

    @Operation(summary = "Obtiene los estudiantes por ID de práctica")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estudiantes encontrados"),
            @ApiResponse(responseCode = "404", description = "No se encontraron estudiantes")
    })
    @GetMapping("/{id}/estudiantes")
    public List<Estudiante> getEstudiantesByPracticaId(@PathVariable Long id) {
        return practicaService.findEstudiantesByPracticaId(id);
    }

    @Operation(summary = "Obtiene las prácticas por periodo académico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prácticas encontradas"),
            @ApiResponse(responseCode = "404", description = "No se encontraron prácticas")
    })
    @GetMapping("/periodo/{periodoAcademico}")
    public List<Practica> getPracticasByPeriodoAcademico(@PathVariable String periodoAcademico) {
        return practicaService.findPracticasByPeriodoAcademico(periodoAcademico);
    }

    @Operation(summary = "Actualiza una práctica existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Práctica actualizada"),
            @ApiResponse(responseCode = "404", description = "Práctica no encontrada"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PutMapping("/{id}")
    public Practica updatePractica(@PathVariable Long id, @RequestBody Practica practicaDetails) {
        return practicaService.updatePractica(id, practicaDetails);
    }
}
