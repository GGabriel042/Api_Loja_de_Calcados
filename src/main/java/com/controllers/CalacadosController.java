package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.calcados.CalcadoRepository;
import com.calcados.Calcados;
import com.calcados.DadosAtualizarCalcado;
import com.calcados.DadosCadastroCalcado;
import com.calcados.DadosDetalhamentoCalcado;
import com.calcados.DadosListagemCalcado;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.experimental.var;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/calcados")
public class CalacadosController {

    @Autowired
    private CalcadoRepository repository;
    
    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoCalcado> cadastrar(@RequestBody @Valid DadosCadastroCalcado dados, UriComponentsBuilder uriBuilder) {
        var calcado = new Calcados(dados);
        repository.save(calcado);

        var uri = uriBuilder.path("/calcados/{id}").buildAndExpand(calcado.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoCalcado(calcado));
    }


    @GetMapping()
    public ResponseEntity<List<DadosListagemCalcado>> listar() {
        var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemCalcado::new).toList();
        return ResponseEntity.ok(lista);
    }

    
    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoCalcado> atualizar(@RequestBody @Valid DadosAtualizarCalcado dados) {
        var calcado = repository.getReferenceById(dados.id());
        calcado.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoCalcado(calcado));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativar(@PathVariable Long id) {
        var calcado = repository.getReferenceById(id);
        calcado.inativar();

        return ResponseEntity.noContent().build();
    }


    @PutMapping("reativar/{id}")
    @Transactional
    public ResponseEntity<Void> reativar(@PathVariable Long id) {
        var calcado = repository.getReferenceById(id);
        calcado.reativar();
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoCalcado> buscarPorId(@PathVariable Long id) {
        var calcado = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoCalcado(calcado));
    }
    
}
