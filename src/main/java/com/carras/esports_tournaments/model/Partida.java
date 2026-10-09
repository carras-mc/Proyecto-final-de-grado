package com.carras.esports_tournaments.model;

import java.time.LocalDateTime;

import com.carras.esports_tournaments.model.enums.EstadoPartida;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoPartida estado = EstadoPartida.PROGRAMADA;

    // --- Reporte enviado por el Equipo Local ---
    @Column(name = "propuesta_local_puntos_local")
    private Integer propuestaLocalPuntosLocal;

    @Column(name = "propuesta_local_puntos_visitante")
    private Integer propuestaLocalPuntosVisitante;

    @Column(name = "captura_local_url")
    private String capturaLocalUrl;

    // --- Reporte enviado por el Equipo Visitante ---
    @Column(name = "propuesta_visitante_puntos_local")
    private Integer propuestaVisitantePuntosLocal;

    @Column(name = "propuesta_visitante_puntos_visitante")
    private Integer propuestaVisitantePuntosVisitante;

    @Column(name = "captura_visitante_url")
    private String capturaVisitanteUrl;

}
