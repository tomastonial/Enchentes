package com.cesurg.enchentes.core.usecase;

import com.cesurg.enchentes.core.domain.contract.autenticacao.AutenticacaoRepository;
import com.cesurg.enchentes.core.domain.contract.autenticacao.AutenticacaoUseCase;
import com.cesurg.enchentes.core.domain.entity.Autenticacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutenticacaoUseCaseImpl implements AutenticacaoUseCase {
    @Autowired
    private AutenticacaoRepository autenticacaoRepository;

    @Override
    public void create(Autenticacao autenticacao) {
        autenticacaoRepository.create(autenticacao);
    }

    @Override
    public void update(int id, Autenticacao autenticacao) {
        autenticacaoRepository.update(id, autenticacao);
    }

    @Override
    public void delete(int id) {
        autenticacaoRepository.delete(id);
    }

    @Override
    public Autenticacao findById(int id) {
        return autenticacaoRepository.findById(id);
    }

    @Override
    public List<Autenticacao> findAll() {
        return autenticacaoRepository.findAll();
    }
}
