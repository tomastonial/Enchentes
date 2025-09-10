package com.cesurg.enchentes.core.domain.contract.grupo;

import com.cesurg.enchentes.core.domain.entity.Grupo;

import java.util.List;

public interface GrupoRepository {
    public void create(Grupo grupo);
    public void update(int id,Grupo grupo);
    public void delete(int id);
    public Grupo findById(int id);
    public List<Grupo> findAll();
}
