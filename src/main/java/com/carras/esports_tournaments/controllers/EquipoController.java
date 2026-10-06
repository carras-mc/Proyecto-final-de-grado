package com.carras.esports_tournaments.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carras.esports_tournaments.dto.EquipoRequestDto;
import com.carras.esports_tournaments.dto.EquipoResponseDto;
import com.carras.esports_tournaments.model.Equipo;
import com.carras.esports_tournaments.services.EquipoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/equipos")
@RequiredArgsConstructor 
public class EquipoController {
    
    private final EquipoService equipoService;

    @PostMapping
    public ResponseEntity<EquipoResponseDto> crearEquipo(@Valid @RequestBody EquipoRequestDto requestDto) {
        
        Equipo equipo = equipoService.crearEquipo(requestDto.getEquipoNombre(), requestDto.getCreadorId());

        EquipoResponseDto equipoResponseDto = EquipoResponseDto.builder()
            .id(equipo.getId())
            .nombre(equipo.getNombre())
            .fechaCreacion(equipo.getFechaCreacion())
            .nombreCapitan(equipo.getCapitan().getNombre())
            .build();
        
        return ResponseEntity.status(HttpStatus.CREATED).body(equipoResponseDto);
    }
    
}   
