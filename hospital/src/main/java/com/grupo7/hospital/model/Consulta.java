package com.grupo7.hospital.model;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;
    
    private String descricao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paciente_user_id", referencedColumnName = "id")
    private User paciente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medico_user_id", referencedColumnName = "id")
    private User medico;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public User getPaciente() {
        return paciente;
    }

    public void setPaciente(User paciente) {
        this.paciente = paciente;
    }

    public User getMedico() {
        return medico;
    }

    public void setMedico(User medico) {
        this.medico = medico;
    }
}
