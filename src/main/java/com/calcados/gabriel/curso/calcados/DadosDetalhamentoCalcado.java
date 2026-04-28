package com.calcados.gabriel.curso.calcados;

import java.math.BigDecimal;

public record DadosDetalhamentoCalcado(
    Long id,
    String sku,
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
    Integer estoque,
    Boolean ativo
) {

    public DadosDetalhamentoCalcado(Calcados calcado) {
        this(
            calcado.getId(),
            calcado.getSku(),
            calcado.getNome(),
            calcado.getMarca(),
            calcado.getDescricao(),
            calcado.getMaterial(),
            calcado.getTamanho(),
            calcado.getGenero(),
            calcado.getCategoria(),
            calcado.getCor(),
            calcado.getPeso_medio(),
            calcado.getPreco(),
            calcado.getEstoque(),
            calcado.getAtivo()
        );
    }
    
}
