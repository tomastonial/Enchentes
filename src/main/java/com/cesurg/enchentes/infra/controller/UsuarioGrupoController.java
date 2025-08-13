package com.cesurg.enchentes.infra.controller;

import com.cesurg.enchentes.core.domain.contract.usuarioGrupo.UsuarioGrupoUseCase;
import com.cesurg.enchentes.core.domain.entity.UsuarioGrupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioGrupoController {
    @Autowired
    private UsuarioGrupoUseCase usuarioGrupoUseCase;

    @PostMapping("/usuario-grupo")
    public void create(@RequestBody UsuarioGrupo usuarioGrupo) {
        usuarioGrupoUseCase.create(usuarioGrupo);
    }

    @PutMapping("/usuario-grupo/{id}")
    public void update(@RequestBody UsuarioGrupo usuarioGrupo, @PathVariable int id) {
        usuarioGrupoUseCase.update(id, usuarioGrupo);
    }

    @DeleteMapping("/usuario-grupo/{id}")
    public void delete(@PathVariable int id) {
        usuarioGrupoUseCase.delete(id);
    }

    @GetMapping("/usuario-grupo/{id}")
    public UsuarioGrupo findById(@PathVariable int id) {
        return usuarioGrupoUseCase.findById(id);
    }

    @GetMapping("/usuario-grupo")
    public List<UsuarioGrupo> findAll() {
        return usuarioGrupoUseCase.findAll();
    }

}
