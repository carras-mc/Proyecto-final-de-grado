package com.carras.esports_tournaments.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carras.esports_tournaments.model.Equipo;
import com.carras.esports_tournaments.model.MiembroEquipo;
import com.carras.esports_tournaments.model.Usuario;

public interface MiembroEquipoRepository extends JpaRepository<MiembroEquipo, Long> {

    public boolean existsByEquipoAndUsuario(Equipo equipo, Usuario usuario);

    public MiembroEquipo findByUsuario(Usuario usuario);

    public Optional<MiembroEquipo> findByUsuarioAndEquipo(Usuario usuario, Equipo equipo);
    
} 
