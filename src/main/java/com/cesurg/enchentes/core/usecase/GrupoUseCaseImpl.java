package com.cesurg.enchentes.core.usecase;

import com.cesurg.enchentes.core.domain.contract.grupo.GrupoRepository;
import com.cesurg.enchentes.core.domain.contract.grupo.GrupoUseCase;
import com.cesurg.enchentes.core.domain.entity.Grupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoUseCaseImpl implements GrupoUseCase {
    @Autowired
    private GrupoRepository grupoRepository;


    @Override
    public void create(Grupo grupo) {
        grupoRepository.create(grupo);
    }

    @Override
    public void update(int id, Grupo grupo) {
        grupoRepository.update(id, grupo);
    }

    @Override
    public void delete(int id) {
        grupoRepository.delete(id);
    }

    @Override
    public Grupo findById(int id) {
        return grupoRepository.findById(id);
    }

    @Override
    public List<Grupo> findAll() {
        return grupoRepository.findAll();
    }
}
