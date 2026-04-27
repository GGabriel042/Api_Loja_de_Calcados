package com.calcados.gabriel.curso.calcados;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarCalcado(

    @NotNull
    Long id, 
    String nome, 
    String marca, 
    String descricao, 
    Material material, 
    String tamanho, 
    Genero genero, 
    Categoria categoria, 
    String cor, 
    Double preco) {


} 