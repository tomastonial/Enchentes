package com.cesurg.enchentes.core.domain.contract.autenticacao;

import com.cesurg.enchentes.core.domain.entity.Autenticacao;

import java.util.List;

public interface AutenticacaoUseCase {
    public void create(Autenticacao autenticacao);
    public void update(int id,Autenticacao autenticacao);
    public void delete(int id);
    public Autenticacao findById(int id);
    public List<Autenticacao> findAll();
}
