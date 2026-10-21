package com.carras.esports_tournaments.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carras.esports_tournaments.dto.SolicitudEquipoRequestDto;
import com.carras.esports_tournaments.dto.SolicitudEquipoResponseDto;
import com.carras.esports_tournaments.services.SolicitudEquipoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/solicitudes-equipo")
@RequiredArgsConstructor 
public class SolicitudEquipoController {
    
    private final SolicitudEquipoService solicitudEquipoService;

    @PostMapping
    public ResponseEntity<SolicitudEquipoResponseDto> crearSolicitudAEquipo(@Valid @RequestBody SolicitudEquipoRequestDto requestDto) {
        
        SolicitudEquipoResponseDto solicitudEquipoResponseDto = solicitudEquipoService.crearSolicitudUnirseAEquipo(requestDto.getEquipoId(), requestDto.getUsuarioId(), requestDto.getMensaje());

        return ResponseEntity.status(HttpStatus.CREATED).body(solicitudEquipoResponseDto);
    }

    @PutMapping("/{id}/responder")
    public ResponseEntity<SolicitudEquipoResponseDto> responderSolicitud(
        @PathVariable("id") Long solicitudId, 
        @RequestParam Long usuarioRespondedorId, 
        @RequestParam boolean aceptar) {
        
            SolicitudEquipoResponseDto solicitudEquipoResponseDto = solicitudEquipoService.responderSolicitud(solicitudId, usuarioRespondedorId, aceptar);

            return ResponseEntity.status(HttpStatus.OK).body(solicitudEquipoResponseDto);
    }

}
