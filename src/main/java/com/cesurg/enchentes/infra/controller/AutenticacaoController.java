package com.cesurg.enchentes.infra.controller;

import com.cesurg.enchentes.core.domain.contract.autenticacao.AutenticacaoUseCase;
import com.cesurg.enchentes.core.domain.entity.Autenticacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutenticacaoController {
    @Autowired
    private AutenticacaoUseCase autenticacaoUseCase;

    @PostMapping("/autenticacao")
    public void create(@RequestBody Autenticacao autenticacao) {
        autenticacaoUseCase.create(autenticacao);
    }

    @PutMapping("/autenticacao/{id}")
    public void update(@RequestBody Autenticacao autenticacao, @PathVariable int id) {
        autenticacaoUseCase.update(id, autenticacao);
    }

    @DeleteMapping("/autenticacao/{id}")
    public void delete(@PathVariable int id) {
        autenticacaoUseCase.delete(id);
    }

    @GetMapping("/autenticacao/{id}")
    public Autenticacao findById(@PathVariable int id) {
        return autenticacaoUseCase.findById(id);
    }

    @GetMapping("/autenticacao")
    public List<Autenticacao> findAll() {
        return autenticacaoUseCase.findAll();
    }
}
