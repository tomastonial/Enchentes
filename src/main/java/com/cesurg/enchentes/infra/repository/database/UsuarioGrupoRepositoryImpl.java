package com.cesurg.enchentes.infra.repository.database;

import com.cesurg.enchentes.core.domain.contract.usuarioGrupo.UsuarioGrupoRepository;
import com.cesurg.enchentes.core.domain.entity.UsuarioGrupo;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioGrupoRepositoryImpl implements UsuarioGrupoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void create(UsuarioGrupo usuarioGrupo) {
        var query = """
                INSERT INTO usuario_grupo (id_usuario, id_grupo)
                VALUES (:usuarioId, :grupoId)
                """;
        entityManager.createNativeQuery(query)
                .setParameter("usuarioId", usuarioGrupo.getIdUsuario())
                .setParameter("grupoId", usuarioGrupo.getIdGrupo())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void update(int id, UsuarioGrupo usuarioGrupo) {
        var query = """
                UPDATE usuario_grupo
                SET id_usuario = :usuarioId, id_grupo = :grupoId
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query)
                .setParameter("usuarioId", usuarioGrupo.getIdUsuario())
                .setParameter("grupoId", usuarioGrupo.getIdGrupo())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void delete(int id) {
        var query = "DELETE FROM usuario_grupo WHERE id = :id";
        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public UsuarioGrupo findById(int id) {
        var query = "SELECT * FROM usuario_grupo WHERE id = :id";
        return (UsuarioGrupo) entityManager.createNativeQuery(query, UsuarioGrupo.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<UsuarioGrupo> findAll() {
        var query = "SELECT * FROM usuario_grupo";
        return entityManager.createNativeQuery(query, UsuarioGrupo.class)
                .getResultList();
    }
}
