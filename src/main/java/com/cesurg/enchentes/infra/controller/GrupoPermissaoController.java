package com.cesurg.enchentes.infra.controller;

import com.cesurg.enchentes.core.domain.contract.grupoPermissao.GrupoPermissaoUseCase;
import com.cesurg.enchentes.core.domain.entity.GrupoPermissao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GrupoPermissaoController {
    @Autowired
    private GrupoPermissaoUseCase grupoPermissaoUseCase;

    @PostMapping("/grupo-permissao")
    public void create(@RequestBody GrupoPermissao grupoPermissao) {
        grupoPermissaoUseCase.create(grupoPermissao);
    }

    @PutMapping("/grupo-permissao/{id}")
    public void update(@RequestBody GrupoPermissao grupoPermissao, @PathVariable int id) {
        grupoPermissaoUseCase.update(id, grupoPermissao);
    }

    @DeleteMapping("/grupo-permissao/{id}")
    public void delete(@PathVariable int id) {
        grupoPermissaoUseCase.delete(id);
    }

    @GetMapping("/grupo-permissao/{id}")
    public GrupoPermissao findById(@PathVariable int id) {
        return grupoPermissaoUseCase.findById(id);
    }

    @GetMapping("/grupo-permissao")
    public List<GrupoPermissao> findAll() {
        return grupoPermissaoUseCase.findAll();
    }
}
