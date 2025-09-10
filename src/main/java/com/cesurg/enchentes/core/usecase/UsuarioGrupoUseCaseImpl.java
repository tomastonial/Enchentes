package com.cesurg.enchentes.core.usecase;

import com.cesurg.enchentes.core.domain.contract.usuarioGrupo.UsuarioGrupoRepository;
import com.cesurg.enchentes.core.domain.contract.usuarioGrupo.UsuarioGrupoUseCase;
import com.cesurg.enchentes.core.domain.entity.UsuarioGrupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioGrupoUseCaseImpl implements UsuarioGrupoUseCase {
    @Autowired
    private UsuarioGrupoRepository usuarioGrupoRepository;

    @Override
    public void create(UsuarioGrupo usuarioGrupo) {
        usuarioGrupoRepository.create(usuarioGrupo);
    }

    @Override
    public void update(int id, UsuarioGrupo usuarioGrupo) {
        usuarioGrupoRepository.update(id, usuarioGrupo);
    }

    @Override
    public void delete(int id) {
        usuarioGrupoRepository.delete(id);
    }

    @Override
    public UsuarioGrupo findById(int id) {
        return usuarioGrupoRepository.findById(id);
    }

    @Override
    public List<UsuarioGrupo> findAll() {
        return usuarioGrupoRepository.findAll();
    }
}
