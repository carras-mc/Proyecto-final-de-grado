package com.carras.esports_tournaments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carras.esports_tournaments.model.Equipo;
import com.carras.esports_tournaments.model.Inscripcion;
import com.carras.esports_tournaments.model.Torneo;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
    
    boolean existsByTorneoAndEquipo(Torneo torneo, Equipo equipo);

    long countByTorneo(Torneo torneo);
}
