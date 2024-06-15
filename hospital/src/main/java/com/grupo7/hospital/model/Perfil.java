package com.grupo7.hospital.model;

import com.grupo7.hospital.model.enums.Permissao;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String perfil;

    @ElementCollection(targetClass = Permissao.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Permissao> permissoes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
    }
}
