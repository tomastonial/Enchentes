package com.cesurg.enchentes.core.domain.contract.usuario;

import com.cesurg.enchentes.core.domain.entity.Usuario;

import java.util.List;

public interface UsuarioUseCase {
    public void create(Usuario usuario);
    public void update(int id,Usuario usuario);
    public void delete(int id);
    public Usuario findById(int id);
    public List<Usuario> findAll();
}
