package com.calcados;

public record DadosListagemCalcado(
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

    public DadosListagemCalcado(Calcados calcados) {
        this(calcados.getId(),
            calcados.getNome(), 
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
