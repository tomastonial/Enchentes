package com.cesurg.enchentes.infra.controller;

import com.cesurg.enchentes.core.domain.contract.permissao.PermissaoUseCase;
import com.cesurg.enchentes.core.domain.entity.Permissao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PermissaoController {
    @Autowired
    private PermissaoUseCase permissaoUseCase;

    @PostMapping("/permissao")
    public void create(@RequestBody Permissao permissao) {
        permissaoUseCase.create(permissao);
    }

    @PutMapping("/permissao/{id}")
    public void update(@RequestBody Permissao permissao, @PathVariable int id) {
        permissaoUseCase.update(id, permissao);
    }

    @DeleteMapping("/permissao/{id}")
    public void delete(@PathVariable int id) {
        permissaoUseCase.delete(id);
    }

    @GetMapping("/permissao/{id}")
    public Permissao findById(@PathVariable int id) {
        return permissaoUseCase.findById(id);
    }

    @GetMapping("/permissao")
    public List<Permissao> findAll() {
        return permissaoUseCase.findAll();
    }
}
