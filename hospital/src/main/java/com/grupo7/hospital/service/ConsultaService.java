package com.grupo7.hospital.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo7.hospital.model.Consulta;
import com.grupo7.hospital.repository.ConsultaRepository;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public Consulta save(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public void saveOrUpdate(Consulta consulta) {
        if (consulta.getMedico() == null || consulta.getPaciente() == null) {
            throw new IllegalArgumentException("Consulta deve ter um médico e um paciente.");
        }
        consultaRepository.save(consulta);
    }

    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    public void deleteById(Long id) {
        consultaRepository.deleteById(id);
    }

    public Consulta findById(Long id) {
        return consultaRepository.findById(id).orElse(null);
    }

    public List<Consulta> findByNomePaciente(String nomePaciente) {
        return consultaRepository.findByNomePaciente(nomePaciente);
    }
    
    public List<Consulta> findByPacienteId(Long pacienteId) {
        return consultaRepository.findByPacienteId(pacienteId);
    }
}
