package com.calcados.gabriel.curso.calcados;

public record DadosListagemCalcado(
    String nome, 
    String marca, 
    String descricao, 
    Material material, 
    String tamanho, 
    Genero genero, 
    Categoria categoria, 
    String cor, 
    Double preco) {

    public DadosListagemCalcado(Calcados calcados) {
        this(calcados.getNome(), 
            calcados.getMarca(), 
            calcados.getDescricao(), 
            calcados.getMaterial(), 
            calcados.getTamanho(), 
            calcados.getGenero(), 
            calcados.getCategoria(), 
            calcados.getCor(), 
            calcados.getPreco().doubleValue());
    }
    
}
