package com.cesurg.enchentes.core.domain.contract.permissao;

import com.cesurg.enchentes.core.domain.entity.Permissao;

import java.util.List;

public interface PermissaoRepository {
    public void create(Permissao permissao);
    public void update(int id,Permissao permissao);
    public void delete(int id);
    public Permissao findById(int id);
    public List<Permissao> findAll();
}
