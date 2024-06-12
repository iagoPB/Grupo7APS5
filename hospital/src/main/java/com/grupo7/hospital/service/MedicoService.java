package com.grupo7.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo7.hospital.model.Consulta;
import com.grupo7.hospital.model.Medico;
import com.grupo7.hospital.repository.ConsultaRepository;
import com.grupo7.hospital.repository.MedicoRepository;

@Service
public class MedicoService {
    
    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico save(Medico medico) {
        return medicoRepository.save(medico);
    }

    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    public Medico findById(Long id) {
        return medicoRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        medicoRepository.deleteById(id);
    }


    public List<Consulta> findConsultasByMedico(Medico medico) {
        return consultaRepository.findByMedico(medico);
    }
}
