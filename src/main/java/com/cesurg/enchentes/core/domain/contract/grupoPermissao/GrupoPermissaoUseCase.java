package com.cesurg.enchentes.core.domain.contract.grupoPermissao;

import com.cesurg.enchentes.core.domain.entity.GrupoPermissao;

import java.util.List;

public interface GrupoPermissaoUseCase {
    public void create(GrupoPermissao grupoPermissao);
    public void update(int id,GrupoPermissao grupoPermissao);
    public void delete(int id);
    public GrupoPermissao findById(int id);
    public List<GrupoPermissao> findAll();
}
