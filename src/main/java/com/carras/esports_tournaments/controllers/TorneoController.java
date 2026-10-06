package com.carras.esports_tournaments.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carras.esports_tournaments.dto.TorneoResponseDto;
import com.carras.esports_tournaments.services.TorneoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/torneos")
@RequiredArgsConstructor
public class TorneoController {
    
    private final TorneoService torneoService;

    @GetMapping("/{id}") // Usamos GET y definimos el parámetro en la ruta
    public ResponseEntity<TorneoResponseDto> obtenerTorneoConDetalles(@PathVariable("id") Long id) {
        TorneoResponseDto torneo = torneoService.obtenerTorneoConDetalles(id);
        
        // Devolvemos 200 OK (HttpStatus.OK), que es el estándar para búsquedas exitosas
        return ResponseEntity.ok(torneo); 
    }
}
