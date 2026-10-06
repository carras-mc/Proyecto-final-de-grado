package com.carras.esports_tournaments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carras.esports_tournaments.model.Partida;

public interface PartidaRepository extends JpaRepository<Partida, Long> {
    
}
