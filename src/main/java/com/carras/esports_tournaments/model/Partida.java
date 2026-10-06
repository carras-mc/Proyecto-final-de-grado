package com.carras.esports_tournaments.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "partidas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Partida {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "torneo_id", nullable = false)
    private Torneo torneo;

    @Column(name = "fecha_partida", nullable = false)
    private LocalDateTime fechaPartida;

    @ManyToOne
    @JoinColumn(name = "equipo_local_id", nullable = false)
    private Equipo equipoLocal;
    
    @ManyToOne
    @JoinColumn(name = "equipo_visitante_id", nullable = false)
    private Equipo equipoVisitante;

    @Column(name = "resultado_local", nullable = true)
    private Integer resultadoLocal = null;

    @Column(name = "resultado_visitante", nullable = true)
    private Integer resultadoVisitante = null;

}
