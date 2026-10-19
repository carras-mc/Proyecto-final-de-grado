package com.carras.esports_tournaments.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class SolicitudEquipoRequestDto {
    
    @NotNull(message = "El ID del equipo es obligatorio")    
    private Long equipoId;

    @NotNull(message = "El ID del usuario es obligatorio")
    private Long usuarioId;

    private String mensaje;
}
