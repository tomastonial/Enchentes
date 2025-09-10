package com.cesurg.enchentes.core.usecase;


import com.cesurg.enchentes.core.domain.contract.grupoPermissao.GrupoPermissaoRepository;
import com.cesurg.enchentes.core.domain.contract.grupoPermissao.GrupoPermissaoUseCase;
import com.cesurg.enchentes.core.domain.entity.GrupoPermissao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoPermissaoUseCaseImpl implements GrupoPermissaoUseCase {
    @Autowired
    private GrupoPermissaoRepository grupoPermissaoRepository;


    @Override
    public void create(GrupoPermissao grupoPermissao) {
        grupoPermissaoRepository.create(grupoPermissao);
    }

    @Override
    public void update(int id, GrupoPermissao grupoPermissao) {
        grupoPermissaoRepository.update(id, grupoPermissao);
    }

    @Override
    public void delete(int id) {
        grupoPermissaoRepository.delete(id);
    }

    @Override
    public GrupoPermissao findById(int id) {
        return grupoPermissaoRepository.findById(id);
    }

    @Override
    public List<GrupoPermissao> findAll() {
        return grupoPermissaoRepository.findAll();
    }
}
