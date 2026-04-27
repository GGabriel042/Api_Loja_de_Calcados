package com.calcados.gabriel.curso.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calcados.gabriel.curso.calcados.DadosCadastroCalcado;

@RestController
@RequestMapping("/calcados")
public class CalacadosController {
    
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroCalcado dados) {
        System.out.println(dados);
    }
}
