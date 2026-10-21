package com.carras.esports_tournaments.dto;

import java.time.LocalDateTime;

import com.carras.esports_tournaments.model.enums.EstadoSolicitudEquipo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor 
@NoArgsConstructor 
@Builder
public class SolicitudEquipoResponseDto {
    
    private Long id;
    private String nombreEquipo;
    private String nombreUsuario;
    private LocalDateTime fecha;
    private EstadoSolicitudEquipo estadoSolicitudEquipo;
    private String mensaje;
}
