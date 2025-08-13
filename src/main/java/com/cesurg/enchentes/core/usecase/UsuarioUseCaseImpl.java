package com.cesurg.enchentes.core.usecase;

import com.cesurg.enchentes.core.domain.contract.usuario.UsuarioRepository;
import com.cesurg.enchentes.core.domain.contract.usuario.UsuarioUseCase;
import com.cesurg.enchentes.core.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioUseCaseImpl implements UsuarioUseCase {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void create(Usuario usuario) {
        usuarioRepository.create(usuario);
    }

    @Override
    public void update(int id, Usuario usuario) {
        usuarioRepository.update(id, usuario);
    }

    @Override
    public void delete(int id) {
        usuarioRepository.delete(id);
    }

    @Override
    public Usuario findById(int id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
}
