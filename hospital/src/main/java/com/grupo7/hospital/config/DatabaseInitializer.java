package com.grupo7.hospital.config;

import com.grupo7.hospital.model.Perfil;
import com.grupo7.hospital.repository.PerfilRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseInitializer {

    @Bean
    CommandLineRunner initDatabase(PerfilRepository perfilRepository) {
        return args -> {
            if (perfilRepository.count() == 0) {
                Perfil admin = new Perfil();
                admin.setId(1);
                admin.setPerfil("ADMIN");

                Perfil paciente = new Perfil();
                paciente.setId(2);
                paciente.setPerfil("PACIENTE");

                Perfil medico = new Perfil();
                medico.setId(3);
                medico.setPerfil("MÉDICO");

                perfilRepository.save(admin);
                perfilRepository.save(paciente);
                perfilRepository.save(medico);
            }
        };
    }
}
