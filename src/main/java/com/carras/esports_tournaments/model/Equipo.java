package com.carras.esports_tournaments.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "equipos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDate fechaCreacion;

    @ManyToMany(mappedBy = "equipo")
    @JoinTable(
        name = "equipos_usuarios",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "equipo_id")
    )
    @Builder.Default
    private List<Usuario> integrantes = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "capitan_id")
    private Usuario capitan;

    @Column(nullable = false)
    @Builder.Default
    private boolean activo = true;

    public void addIntegrante(Usuario usuario) {
        this.integrantes.add(usuario);
        usuario.getEquipos().add(this);
    }

}
