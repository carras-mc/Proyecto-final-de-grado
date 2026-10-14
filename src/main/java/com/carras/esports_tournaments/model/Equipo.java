package com.carras.esports_tournaments.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.carras.esports_tournaments.model.enums.RolMiembro;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<MiembroEquipo> miembros = new ArrayList<>();

    @Column(nullable = false)
    @Builder.Default
    private boolean activo = true;

    @Column
    @Builder.Default
    private Integer capacidadMaxima = 20;

    public void addMiembro(Usuario usuario, RolMiembro rol) {
        MiembroEquipo nuevoMiembro = MiembroEquipo.builder()
            .equipo(this)
            .usuario(usuario)
            .rol(rol)
            .fechaIngreso(LocalDateTime.now())
            .build();

        this.miembros.add(nuevoMiembro);

    }

}
