package com.cesurg.enchentes.infra.controller;


import com.cesurg.enchentes.core.domain.contract.grupo.GrupoUseCase;
import com.cesurg.enchentes.core.domain.entity.Grupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GrupoController {
    @Autowired
    private GrupoUseCase grupoUseCase;

    @PostMapping("/grupo")
    public void create(@RequestBody Grupo grupo) {
        grupoUseCase.create(grupo);
    }

    @PutMapping("/grupo/{id}")
    public void update(@RequestBody Grupo grupo, @PathVariable int id) {
        grupoUseCase.update(id, grupo);
    }

    @DeleteMapping("/grupo/{id}")
    public void delete(@PathVariable int id) {
        grupoUseCase.delete(id);
    }

    @GetMapping("/grupo/{id}")
    public Grupo findById(@PathVariable int id) {
        return grupoUseCase.findById(id);
    }

    @GetMapping("/grupo")
    public List<Grupo> findAll() {
        return grupoUseCase.findAll();
    }
}
