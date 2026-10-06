package com.carras.esports_tournaments.dto;

import java.time.LocalDate;

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
public class EquipoResponseDto {
    
    private Long id;
    private String nombre;
    private LocalDate fechaCreacion;
    private String nombreCapitan;
}
