package com.carras.esports_tournaments.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InscripcionRequestDto {
    
    @NotNull(message = "El ID del torneo es obligatorio")    
    private Long torneoId;

    @NotNull(message = "El ID del equipo es obligatorio")
    private Long equipoId;

}