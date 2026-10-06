package com.carras.esports_tournaments.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.carras.esports_tournaments.exceptions.BusinessException;
import com.carras.esports_tournaments.model.Equipo;
import com.carras.esports_tournaments.model.Usuario;
import com.carras.esports_tournaments.repositories.EquipoRepository;
import com.carras.esports_tournaments.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class EquipoService {
    private final UsuarioRepository usuarioRepository;
    private final EquipoRepository equipoRepository;

    @Transactional 
    public Equipo crearEquipo(String nombreEquipo, Long creadorId) {
        Usuario usuario = usuarioRepository.findById(creadorId).orElseThrow(() -> new BusinessException("El ID del usuario no existe"));

        if (equipoRepository.existsByNombre(nombreEquipo)) {
            throw new BusinessException("El nombre del equipo ya existe");
        }

        Equipo equipo = Equipo.builder()
            .nombre(nombreEquipo)
            .fechaCreacion(LocalDate.now())
            .capitan(usuario)
            .build();

        equipo.addIntegrante(usuario);


        return equipoRepository.save(equipo);
    }
}
