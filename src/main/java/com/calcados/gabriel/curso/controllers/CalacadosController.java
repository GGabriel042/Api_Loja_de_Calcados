package com.calcados.gabriel.curso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calcados.gabriel.curso.calcados.CalcadoRepository;
import com.calcados.gabriel.curso.calcados.Calcados;
import com.calcados.gabriel.curso.calcados.DadosCadastroCalcado;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/calcados")
public class CalacadosController {

    @Autowired
    private CalcadoRepository repository;
    
    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroCalcado dados) {
        
        repository.save(new Calcados(dados));
    }
}
