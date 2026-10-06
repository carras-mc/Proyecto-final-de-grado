package com.carras.esports_tournaments.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TorneoResponseDto {
    
    private Long id;
    private String nombre;
    private String juego;
    private String estado;
    private Integer capacidadMaxima;
    private LocalDateTime fechaInicio;
    private List<String> equipos;

}
