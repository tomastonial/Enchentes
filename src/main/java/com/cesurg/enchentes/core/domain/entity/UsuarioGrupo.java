package com.cesurg.enchentes.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "usuario_grupo")
public class UsuarioGrupo {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "id_usuario")
    private int idUsuario;

    @Column(name = "id_grupo")
    private int idGrupo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }
}
