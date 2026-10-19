package com.carras.esports_tournaments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carras.esports_tournaments.model.Equipo;
import com.carras.esports_tournaments.model.SolicitudEquipo;
import com.carras.esports_tournaments.model.Usuario;
import com.carras.esports_tournaments.model.enums.EstadoSolicitudEquipo;

public interface SolicitudEquipoRepository extends JpaRepository<SolicitudEquipo, Long>{
    
    boolean existsByEquipoAndUsuarioAndEstado(Equipo equipo, Usuario usuario, EstadoSolicitudEquipo estado);
}
