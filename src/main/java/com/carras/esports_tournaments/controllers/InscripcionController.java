package com.carras.esports_tournaments.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carras.esports_tournaments.dto.InscripcionRequestDto;
import com.carras.esports_tournaments.model.Inscripcion;
import com.carras.esports_tournaments.services.InscripcionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/inscripciones")
@RequiredArgsConstructor
public class InscripcionController {
    
    private final InscripcionService inscripcionService;

    @PostMapping
    public ResponseEntity<Inscripcion> crearInscripcion(@Valid @RequestBody InscripcionRequestDto requestDto) {

        Inscripcion inscripcion = inscripcionService.inscribirEquipo(requestDto.getTorneoId(), requestDto.getEquipoId());

        return ResponseEntity.status(HttpStatus.CREATED).body(inscripcion);
    }
    
}
