package com.cesurg.enchentes.infra.repository.database;

import com.cesurg.enchentes.core.domain.contract.usuario.UsuarioRepository;
import com.cesurg.enchentes.core.domain.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void create(Usuario usuario) {
        var query = """
                INSERT INTO usuario (nome, email, senha, ativo)
                VALUES (:nome, :email, :senha, :ativo)
                """;
        entityManager.createNativeQuery(query)
                .setParameter("nome", usuario.getNome())
                .setParameter("email", usuario.getEmail())
                .setParameter("senha", usuario.getSenha())
                .setParameter("ativo", usuario.getAtivo())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void update(int id, Usuario usuario) {
        var query = """
                UPDATE usuario
                SET nome = :nome, email = :email, senha = :senha, ativo = :ativo
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query)
                .setParameter("nome", usuario.getNome())
                .setParameter("email", usuario.getEmail())
                .setParameter("senha", usuario.getSenha())
                .setParameter("ativo", usuario.getAtivo())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void delete(int id) {
        var query = "DELETE FROM usuario WHERE id = :id";
        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public Usuario findById(int id) {
        var query = "SELECT * FROM usuario WHERE id = :id";
        return (Usuario) entityManager.createNativeQuery(query, Usuario.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Usuario> findAll() {
        var query = "SELECT * FROM usuario";
        return entityManager.createNativeQuery(query, Usuario.class)
                .getResultList();
    }
}
