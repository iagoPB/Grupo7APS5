package com.grupo7.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo7.hospital.model.Consulta;
import com.grupo7.hospital.model.Paciente;
import com.grupo7.hospital.repository.ConsultaRepository;
import com.grupo7.hospital.repository.PacienteRepository;

@Service
public class PacienteService {
    
    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    public Paciente findById(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        pacienteRepository.deleteById(id);
    }

    public List<Consulta> findConsultasByPaciente(Paciente paciente) {
        return consultaRepository.findByPaciente(paciente);
    }
}
