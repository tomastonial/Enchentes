package com.cesurg.enchentes.infra.repository.database;


import com.cesurg.enchentes.core.domain.contract.autenticacao.AutenticacaoRepository;
import com.cesurg.enchentes.core.domain.entity.Autenticacao;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AutenticacaoRepositoryImpl implements AutenticacaoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void create(Autenticacao autenticacao) {
        var query = """
                INSERT INTO autenticacao (usuario_id, data_hora, ip_origem, sucesso, tipo)
                VALUES (:usuarioId, :dataHora, :ipOrigem, :sucesso, :tipo)
                """;
        entityManager.createNativeQuery(query)
                .setParameter("usuarioId", autenticacao.getIdUsuario())
                .setParameter("dataHora", autenticacao.getDataHora())
                .setParameter("ipOrigem", autenticacao.getIpOrigem())
                .setParameter("sucesso", autenticacao.getSucesso())
                .setParameter("tipo", autenticacao.getTipo())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void update(int id, Autenticacao autenticacao) {
        var query = """
                UPDATE autenticacao
                SET usuario_id = :usuarioId, data_hora = :dataHora, ip_origem = :ipOrigem, sucesso = :sucesso, tipo = :tipo
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query)
                .setParameter("usuarioId", autenticacao.getIdUsuario())
                .setParameter("dataHora", autenticacao.getDataHora())
                .setParameter("ipOrigem", autenticacao.getIpOrigem())
                .setParameter("sucesso", autenticacao.getSucesso())
                .setParameter("tipo", autenticacao.getTipo())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void delete(int id) {
        var query = "DELETE FROM autenticacao WHERE id = :id";
        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public Autenticacao findById(int id) {
        var query = "SELECT * FROM autenticacao WHERE id = :id";
        return (Autenticacao) entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Autenticacao> findAll() {
        var query = "SELECT * FROM autenticacao";
        return entityManager.createNativeQuery(query, Autenticacao.class)
                .getResultList();
    }
}
