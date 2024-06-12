package com.grupo7.hospital.model;
import java.util.ArrayList;
import java.util.List;

import com.grupo7.hospital.model.enums.Permissao;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import com.grupo7.hospital.model.enums.Permissao;

@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    
    @ElementCollection(targetClass = Permissao.class)
    @Enumerated(EnumType.STRING)
    private List<Permissao> permissoes = new ArrayList<>();
    
    
    public Paciente() {
        this.permissoes.add(Permissao.VISUALIZAR_CONSULTAS);
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}