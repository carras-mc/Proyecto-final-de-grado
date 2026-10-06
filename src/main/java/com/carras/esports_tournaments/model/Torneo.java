package com.carras.esports_tournaments.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.carras.esports_tournaments.model.enums.EstadoTorneo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "torneos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Torneo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private EstadoTorneo estado = EstadoTorneo.INSCRIPCION_ABIERTA;

    @Column(name = "capacidad_maxima", nullable = false)
    private Integer capacidadMaxima;

    @OneToMany(mappedBy = "torneo")
    @Builder.Default
    private List<Inscripcion> inscripciones = new ArrayList<>();

    @Column(nullable = false)
    private String juego;

    @OneToMany(mappedBy = "torneo")
    @Builder.Default
    private List<Partida> partidas = new ArrayList<>();

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_final", nullable = false)
    private LocalDateTime fechaFinal;


    
}
