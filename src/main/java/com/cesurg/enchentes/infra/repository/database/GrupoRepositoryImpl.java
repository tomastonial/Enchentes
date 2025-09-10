package com.cesurg.enchentes.infra.repository.database;

import com.cesurg.enchentes.core.domain.contract.grupo.GrupoRepository;
import com.cesurg.enchentes.core.domain.entity.Grupo;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GrupoRepositoryImpl implements GrupoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void create(Grupo grupo) {
        var query = """
                INSERT INTO grupo (nome_grupo, descricao)
                VALUES (:nome, :descricao)
                """;
        entityManager.createNativeQuery(query)
                .setParameter("nome", grupo.getNomeGrupo())
                .setParameter("descricao", grupo.getDescricao())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void update(int id, Grupo grupo) {
        var query = """
                UPDATE grupo
                SET nome_grupo = :nome, descricao = :descricao
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query)
                .setParameter("nome", grupo.getNomeGrupo())
                .setParameter("descricao", grupo.getDescricao())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void delete(int id) {
        var query = "DELETE FROM grupo WHERE id = :id";
        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public Grupo findById(int id) {
        var query = "SELECT * FROM grupo WHERE id = :id";
        return (Grupo) entityManager.createNativeQuery(query, Grupo.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Grupo> findAll() {
        var query = "SELECT * FROM grupo";
        return entityManager.createNativeQuery(query, Grupo.class)
                .getResultList();
    }
}
