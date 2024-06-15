package com.grupo7.hospital.repository;

import com.grupo7.hospital.model.Consulta;
import com.grupo7.hospital.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
    List<Consulta> findByPaciente(User paciente);

    List<Consulta> findByMedico(User medico);
}
