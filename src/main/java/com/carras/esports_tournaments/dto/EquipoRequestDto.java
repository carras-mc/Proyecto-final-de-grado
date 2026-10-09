package com.carras.esports_tournaments.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipoRequestDto {
    
    @NotBlank(message = "El nombre del equipo es obligatorio")
    private String equipoNombre;

    @NotNull(message = "El ID del creador es obligatorio")
    private Long creadorId;

    @NotNull(message = "El ID del equipo es obligatorio")
    private Long equipoId;

    @NotNull(message = "El ID del usuario es obligatorio")
    private Long usuarioId;

}
