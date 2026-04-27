package com.calcados.gabriel.curso.calcados;

import java.math.BigDecimal;

public record DadosCadastroCalcado( String sku, 
                                    String nome, 
                                    String marca, 
                                    String descricao, 
                                    Material material,
                                    String tamanho, 
                                    Genero genero, 
                                    Categoria categoria, 
                                    String cor, 
                                    BigDecimal peso_medio, 
                                    BigDecimal preco, 
                                    int estoque) {
    
}
