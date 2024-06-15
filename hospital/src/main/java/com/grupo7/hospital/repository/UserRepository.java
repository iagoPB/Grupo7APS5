package com.grupo7.hospital.repository;

import com.grupo7.hospital.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {  
    @Query("SELECT u FROM User u JOIN u.perfis p WHERE p.perfil = :perfil")
    List<User> findUsersByPerfil(@Param("perfil") String perfil);

    User findByEmail(String email);
}

