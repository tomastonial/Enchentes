package com.cesurg.enchentes.infra.repository.database;

import com.cesurg.enchentes.core.domain.contract.produto.ProdutoRepository;
import com.cesurg.enchentes.core.domain.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void create(Produto produto) {
        var query = """
                INSERT INTO produtos (codigo, capacidade_estatica, capacidade_trabalho, reducao, tipo_acionamento, bucha_fixacao_altura, curso_mm, tipo_bucha, bucha_avulsa, base)
                VALUES (:codigo, :capacidade_estatica, :capacidade_trabalho, :reducao, :tipo_acionamento, :bucha_fixacao_altura, :curso_mm, :tipo_bucha, :bucha_avulsa, :base)
                """;
        entityManager.createNativeQuery(query).setParameter("codigo", produto.getCodigo())
                .setParameter("capacidade_estatica", produto.getCapacidade_estatica())
                .setParameter("capacidade_trabalho", produto.getCapacidade_trabalho())
                .setParameter("reducao", produto.getReducao())
                .setParameter("tipo_acionamento", produto.getTipo_acionamento())
                .setParameter("bucha_fixacao_altura", produto.getBucha_fixacao_altura())
                .setParameter("curso_mm", produto.getCurso_mm())
                .setParameter("tipo_bucha", produto.getTipo_bucha())
                .setParameter("bucha_avulsa", produto.getBucha_avulsa())
                .setParameter("base", produto.getBase())
                .executeUpdate();
    }

    @Override
    public List<Produto> read() {
        var query = "SELECT * FROM produtos;";
        return entityManager.createNativeQuery(query, Produto.class)
                .getResultList();
    }

    @Transactional
    @Override
    public void update(int id, Produto produto) {
    var query = """
            UPDATE produtos
            SET codigo = :codigo, capacidade_estatica = :capacidade_estatica, capacidade_trabalho = :capacidade_trabalho, reducao = :reducao, tipo_acionamento = :tipo_acionamento, bucha_fixacao_altura = :bucha_fixacao_altura, curso_mm = :curso_mm, tipo_bucha = :tipo_bucha, bucha_avulsa = :bucha_avulsa, base = :base
            WHERE id = :id
            """;
    entityManager.createNativeQuery(query).setParameter("codigo", produto.getCodigo())
            .setParameter("capacidade_estatica", produto.getCapacidade_estatica())
            .setParameter("capacidade_trabalho", produto.getCapacidade_trabalho())
            .setParameter("reducao", produto.getReducao())
            .setParameter("tipo_acionamento", produto.getTipo_acionamento())
            .setParameter("bucha_fixacao_altura", produto.getBucha_fixacao_altura())
            .setParameter("curso_mm", produto.getCurso_mm())
            .setParameter("tipo_bucha", produto.getTipo_bucha())
            .setParameter("bucha_avulsa", produto.getBucha_avulsa())
            .setParameter("base", produto.getBase())
            .setParameter("id", id)
            .executeUpdate();
    }

    @Transactional
    @Override
    public void delete(int id) {
        var query = "DELETE FROM produtos WHERE id = :id";
        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }
}
