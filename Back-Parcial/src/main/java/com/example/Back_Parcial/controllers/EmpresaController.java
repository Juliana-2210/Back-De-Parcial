package com.example.Back_Parcial.controllers;

import com.example.Back_Parcial.models.Empresa;
import com.example.Back_Parcial.services.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @Operation(summary = "Crea una nueva empresa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Empresa creada"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PostMapping
    public Empresa createEmpresa(@RequestBody Empresa empresa) {
        return empresaService.save(empresa);
    }

    @Operation(summary = "Obtiene todas las empresas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Empresas encontradas"),
            @ApiResponse(responseCode = "404", description = "No se encontraron empresas")
    })
    @GetMapping
    public List<Empresa> getAllEmpresas() {
        return empresaService.findAll();
    }
}
