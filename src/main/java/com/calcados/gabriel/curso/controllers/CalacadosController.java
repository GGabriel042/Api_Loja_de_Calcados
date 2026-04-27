package com.calcados.gabriel.curso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calcados.gabriel.curso.calcados.CalcadoRepository;
import com.calcados.gabriel.curso.calcados.Calcados;
import com.calcados.gabriel.curso.calcados.DadosAtualizarCalcado;
import com.calcados.gabriel.curso.calcados.DadosCadastroCalcado;
import com.calcados.gabriel.curso.calcados.DadosListagemCalcado;

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
    public void cadastrar(@RequestBody @Valid DadosCadastroCalcado dados) {
        
        repository.save(new Calcados(dados));
    }

    @GetMapping()
    public List<DadosListagemCalcado> listar() {
        return repository.findAllByAtivoTrue().stream().map(DadosListagemCalcado::new).toList();
    }
    
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarCalcado dados) {
        var calcado = repository.getReferenceById(dados.id());
        calcado.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public void inativar(@PathVariable Long id) {
        var calcado = repository.getReferenceById(id);
        calcado.inativar();
    }
}
