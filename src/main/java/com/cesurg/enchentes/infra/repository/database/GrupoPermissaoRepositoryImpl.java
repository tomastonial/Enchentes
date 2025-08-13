package com.cesurg.enchentes.infra.repository.database;

import com.cesurg.enchentes.core.domain.contract.grupoPermissao.GrupoPermissaoRepository;
import com.cesurg.enchentes.core.domain.entity.GrupoPermissao;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GrupoPermissaoRepositoryImpl implements GrupoPermissaoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void create(GrupoPermissao grupoPermissao) {
        var query = """
                INSERT INTO grupo_permissao (id_grupo, id_permissao)
                VALUES (:grupoId, :permissaoId)
                """;
        entityManager.createNativeQuery(query)
                .setParameter("grupoId", grupoPermissao.getIdGrupo())
                .setParameter("permissaoId", grupoPermissao.getIdPermissao())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void update(int id, GrupoPermissao grupoPermissao) {
        var query = """
                UPDATE grupo_permissao
                SET id_grupo = :grupoId, id_permissao = :permissaoId
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query)
                .setParameter("grupoId", grupoPermissao.getIdGrupo())
                .setParameter("permissaoId", grupoPermissao.getIdPermissao())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void delete(int id) {
        var query = "DELETE FROM grupo_permissao WHERE id = :id";
        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public GrupoPermissao findById(int id) {
        var query = "SELECT * FROM grupo_permissao WHERE id = :id";
        return (GrupoPermissao) entityManager.createNativeQuery(query, GrupoPermissao.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<GrupoPermissao> findAll() {
        var query = "SELECT * FROM grupo_permissao";
        return entityManager.createNativeQuery(query, GrupoPermissao.class)
                .getResultList();
    }
}
