package com.calcados;

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
    Double preco,
    Double peso_medio,
    Integer estoque) {


} 