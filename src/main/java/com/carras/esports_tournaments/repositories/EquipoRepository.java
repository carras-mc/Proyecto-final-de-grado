package com.carras.esports_tournaments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carras.esports_tournaments.model.Equipo;
import java.util.Optional;


public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    
    Optional<Equipo> findByNombre(String nombre);

    boolean existsByNombre(String nombre);
    
}
