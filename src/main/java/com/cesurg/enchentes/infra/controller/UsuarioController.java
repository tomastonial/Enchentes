package com.cesurg.enchentes.infra.controller;

import com.cesurg.enchentes.core.domain.contract.usuario.UsuarioUseCase;
import com.cesurg.enchentes.core.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioUseCase usuarioUseCase;

    @PostMapping("/usuario")
    public void create(@RequestBody Usuario usuario) {
        usuarioUseCase.create(usuario);
    }

    @PutMapping("/usuario/{id}")
    public void update(@RequestBody Usuario usuario, @PathVariable int id) {
        usuarioUseCase.update(id, usuario);
    }

    @DeleteMapping
    public void delete(@PathVariable int id) {
        usuarioUseCase.delete(id);
    }

    @GetMapping("/usuario/{id}")
    public Usuario findById(@PathVariable int id) {
        return usuarioUseCase.findById(id);
    }

    @GetMapping("/usuario")
    public List<Usuario> findAll() {
        return usuarioUseCase.findAll();
    }
}
