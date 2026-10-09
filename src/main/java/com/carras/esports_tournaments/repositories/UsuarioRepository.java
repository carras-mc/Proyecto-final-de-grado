package com.carras.esports_tournaments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carras.esports_tournaments.model.Usuario;
import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);

    
}

