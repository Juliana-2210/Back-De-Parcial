package com.example.Back_Parcial.repositories;


import com.example.Back_Parcial.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}

