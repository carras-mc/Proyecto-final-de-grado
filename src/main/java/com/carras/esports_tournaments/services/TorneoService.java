package com.carras.esports_tournaments.services;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carras.esports_tournaments.dto.TorneoResponseDto;
import com.carras.esports_tournaments.exceptions.BusinessException;
import com.carras.esports_tournaments.model.Torneo;
import com.carras.esports_tournaments.repositories.TorneoRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TorneoService {
    
    private final TorneoRepository torneoRepository;

    @Transactional(readOnly = true)
    public TorneoResponseDto obtenerTorneoConDetalles(Long id) {
        //return torneoRepository.findTorneoConDetalles(id).orElseThrow(() -> new BusinessException("Torneo no encontrado"));
        Torneo torneo = torneoRepository.findTorneoConDetalles(id).orElseThrow(() -> new BusinessException("Torneo no encontrado"));

        List<String> nombresEquipos = torneo.getInscripciones().stream()
            .map(inscripcion -> inscripcion.getEquipo().getNombre())
            .toList();

        TorneoResponseDto torneoDto = TorneoResponseDto.builder()
            .id(id)
            .nombre(torneo.getNombre())
            .juego(torneo.getJuego())
            .estado(torneo.getEstado().name())
            .fechaInicio(torneo.getFechaInicio())
            .capacidadMaxima(torneo.getCapacidadMaxima())
            .equipos(nombresEquipos)
            .build();

        return torneoDto;
        
    }
}
