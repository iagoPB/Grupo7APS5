package com.grupo7.hospital.service;

import com.grupo7.hospital.model.Consulta;
import com.grupo7.hospital.model.User;
import com.grupo7.hospital.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;

    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    public List<Consulta> findByPaciente(User paciente) {
        return consultaRepository.findByPaciente(paciente);
    }

    public List<Consulta> findByMedico(User medico) {
        return consultaRepository.findByMedico(medico);
    }

    public Consulta save(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public Consulta findById(int id) {
        return consultaRepository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        consultaRepository.deleteById(id);
    }
}
