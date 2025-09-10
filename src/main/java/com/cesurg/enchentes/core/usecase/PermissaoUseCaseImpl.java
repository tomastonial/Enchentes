package com.cesurg.enchentes.core.usecase;

import com.cesurg.enchentes.core.domain.contract.permissao.PermissaoRepository;
import com.cesurg.enchentes.core.domain.contract.permissao.PermissaoUseCase;
import com.cesurg.enchentes.core.domain.entity.Permissao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissaoUseCaseImpl implements PermissaoUseCase {
    @Autowired
    private PermissaoRepository permissaoRepository;


    @Override
    public void create(Permissao permissao) {
        permissaoRepository.create(permissao);
    }

    @Override
    public void update(int id, Permissao permissao) {
        permissaoRepository.update(id, permissao);
    }

    @Override
    public void delete(int id) {
        permissaoRepository.delete(id);
    }

    @Override
    public Permissao findById(int id) {
        return permissaoRepository.findById(id);
    }

    @Override
    public List<Permissao> findAll() {
        return permissaoRepository.findAll();
    }
}
