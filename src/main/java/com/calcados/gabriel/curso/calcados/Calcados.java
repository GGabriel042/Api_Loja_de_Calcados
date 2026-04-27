package com.calcados.gabriel.curso.calcados;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table (name = "Calcados")
@Entity (name = "calcados")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Calcados {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku; 
    private String nome; 
    private String marca; 
    private String descricao; 
    @Enumerated(EnumType.STRING)
    private Material material;
    private String tamanho; 
    @Enumerated(EnumType.STRING)
    private Genero genero; 
    @Enumerated(EnumType.STRING)
    private Categoria categoria; 
    private String cor;
    private BigDecimal peso_medio; 
    private BigDecimal preco;
    private int estoque;
    
}
