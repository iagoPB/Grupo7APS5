package com.grupo7.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo7.hospital.model.Consulta;
import com.grupo7.hospital.model.Medico;
import com.grupo7.hospital.model.Paciente;

@Service
public class HospitalService {

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private ConsultaService consultaService;

    @Autowired
    private PacienteService pacienteService;

    public List<Consulta> findAllConsultas() {
        return consultaService.findAll();
    }

    public List<Paciente> findAllPacientes() {
        return pacienteService.findAll();
    }
    
    // Outros métodos que envolvem múltiplas entidades
}
