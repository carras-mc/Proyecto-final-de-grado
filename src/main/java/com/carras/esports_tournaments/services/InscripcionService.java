package com.carras.esports_tournaments.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.carras.esports_tournaments.model.Inscripcion;
import com.carras.esports_tournaments.model.Torneo;
import com.carras.esports_tournaments.model.enums.EstadoInscripcion;
import com.carras.esports_tournaments.model.enums.EstadoTorneo;
import com.carras.esports_tournaments.repositories.EquipoRepository;
import com.carras.esports_tournaments.repositories.InscripcionRepository;
import com.carras.esports_tournaments.repositories.TorneoRepository;

import jakarta.transaction.Transactional;

import com.carras.esports_tournaments.exceptions.BusinessException;
import com.carras.esports_tournaments.model.Equipo;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class InscripcionService {
    
    private final InscripcionRepository inscripcionRepository;
    private final TorneoRepository torneoRepository;
    private final EquipoRepository equipoRepository;

    @Transactional
    public Inscripcion inscribirEquipo(Long torneoId, Long equipoId) {
        Torneo torneo = torneoRepository.findById(torneoId).orElseThrow(() -> new BusinessException("Torneo no encontrado"));
        Equipo equipo = equipoRepository.findById(equipoId).orElseThrow(() -> new BusinessException("Equipo no encontrado"));
        
        if (!torneo.getEstado().equals(EstadoTorneo.INSCRIPCION_ABIERTA)) {
            throw new BusinessException("El torneo no acepta inscripciones.");
        }
        if (inscripcionRepository.countByTorneo(torneo) >= torneo.getCapacidadMaxima()) {
            throw new BusinessException("Capacidad máxima de integrantes del torneo superada.");
        }
        if (inscripcionRepository.existsByTorneoAndEquipo(torneo, equipo)) {
            throw new BusinessException("Ya existe una inscripción para el torneo y el equipo.");
        }

        Inscripcion inscripcion = Inscripcion.builder()
            .fechaInscripcion(LocalDate.now())
            .estado(EstadoInscripcion.PENDIENTE)
            .pagado(false)
            .equipo(equipo)
            .torneo(torneo)
            .build();
            
        return inscripcionRepository.save(inscripcion);
    }
}