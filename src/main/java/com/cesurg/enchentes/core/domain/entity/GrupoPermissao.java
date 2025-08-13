package com.cesurg.enchentes.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "grupo_permissao")
public class GrupoPermissao {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "id_grupo")
    private int idGrupo;

    @Column(name = "id_permissao")
    private int idPermissao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public int getIdPermissao() {
        return idPermissao;
    }

    public void setIdPermissao(int idPermissao) {
        this.idPermissao = idPermissao;
    }
}
