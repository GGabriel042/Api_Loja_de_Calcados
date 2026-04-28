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


    public Calcados(DadosCadastroCalcado dados) {
        this.sku =          dados.sku();
        this.nome =         dados.nome();
        this.marca =        dados.marca();
        this.descricao =    dados.descricao();
        this.material =     dados.material();
        this.tamanho =      dados.tamanho();
        this.genero =       dados.genero();
        this.categoria =    dados.categoria();
        this.cor =          dados.cor();
        this.peso_medio =   dados.peso_medio();
        this.preco =        dados.preco();
        this.estoque =      dados.estoque();
        this.ativo =        true;
    }


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
    private boolean ativo;



    public void atualizarInformacoes(DadosAtualizarCalcado dados) {
        
        this.nome = dados.nome() != null ? dados.nome() : this.nome;
        this.marca = dados.marca() != null ? dados.marca() : this.marca;
        this.descricao = dados.descricao() != null ? dados.descricao() : this.descricao;
        this.material = dados.material() != null ? dados.material() : this.material;
        this.tamanho = dados.tamanho() != null ? dados.tamanho() : this.tamanho;
        this.genero = dados.genero() != null ? dados.genero() : this.genero;
        this.categoria = dados.categoria() != null ? dados.categoria() : this.categoria;
        this.cor = dados.cor() != null ? dados.cor() : this.cor;
        this.peso_medio = dados.peso_medio() != null ? BigDecimal.valueOf(dados.peso_medio()) : this.peso_medio;
        this.preco = dados.preco() != null ? BigDecimal.valueOf(dados.preco()) : this.preco;
        this.estoque = dados.estoque() != null ? dados.estoque() : this.estoque;
    }



    public void inativar() {
        this.ativo = false;
    }

    public void reativar() {
        this.ativo = true;
    }



    public Boolean getAtivo() {
        return this.ativo;
    }
    
}
