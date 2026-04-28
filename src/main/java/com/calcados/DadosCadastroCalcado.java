package com.calcados;

import java.math.BigDecimal;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCalcado( 
    
    @NotBlank
    String sku,

    @NotBlank
    String nome,
    
    @NotBlank
    String marca,
    
    String descricao, 
    
    @Enumerated
    Material material,

    @NotBlank
    String tamanho,
    
    @Enumerated
    Genero genero,
    
    @Enumerated
    Categoria categoria, 
    
    @NotBlank
    String cor,

    @NotNull
    BigDecimal peso_medio, 
    
    @NotNull
    BigDecimal preco, 
    
    @NotNull
    int estoque) {
    
}
