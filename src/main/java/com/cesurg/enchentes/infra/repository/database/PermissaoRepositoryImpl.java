package com.cesurg.enchentes.infra.repository.database;

import com.cesurg.enchentes.core.domain.contract.permissao.PermissaoRepository;
import com.cesurg.enchentes.core.domain.entity.Permissao;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissaoRepositoryImpl implements PermissaoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void create(Permissao permissao) {
        var query = """
                INSERT INTO permissao (nome, descricao)
                VALUES (:nome, :descricao)
                """;
        entityManager.createNativeQuery(query)
                .setParameter("nome", permissao.getNome())
                .setParameter("descricao", permissao.getDescricao())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void update(int id, Permissao permissao) {
        var query = """
                UPDATE permissao
                SET nome = :nome, descricao = :descricao
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query)
                .setParameter("nome", permissao.getNome())
                .setParameter("descricao", permissao.getDescricao())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void delete(int id) {
        var query = "DELETE FROM permissao WHERE id = :id";
        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public Permissao findById(int id) {
        var query = "SELECT * FROM permissao WHERE id = :id";
        return (Permissao) entityManager.createNativeQuery(query, Permissao.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Permissao> findAll() {
        var query = "SELECT * FROM permissao";
        return entityManager.createNativeQuery(query, Permissao.class)
                .getResultList();
    }
}
