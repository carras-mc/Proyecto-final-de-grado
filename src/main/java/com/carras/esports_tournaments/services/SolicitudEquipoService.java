package com.carras.esports_tournaments.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.carras.esports_tournaments.dto.SolicitudEquipoResponseDto;
import com.carras.esports_tournaments.exceptions.BusinessException;
import com.carras.esports_tournaments.model.Equipo;
import com.carras.esports_tournaments.model.SolicitudEquipo;
import com.carras.esports_tournaments.model.Usuario;
import com.carras.esports_tournaments.model.enums.EstadoSolicitudEquipo;
import com.carras.esports_tournaments.repositories.EquipoRepository;
import com.carras.esports_tournaments.repositories.MiembroEquipoRepository;
import com.carras.esports_tournaments.repositories.SolicitudEquipoRepository;
import com.carras.esports_tournaments.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class SolicitudEquipoService {

    private final EquipoRepository equipoRepository;
    private final UsuarioRepository usuarioRepository;
    private final MiembroEquipoRepository miembroEquipoRepository;
    private final SolicitudEquipoRepository solicitudEquipoRepository;
    
    @Transactional 
    public SolicitudEquipoResponseDto crearSolicitudUnirseAEquipo(Long equipoId, Long usuarioId, String mensaje) {
        Equipo equipo = equipoRepository.findById(equipoId).orElseThrow(() -> new BusinessException("El equipo no existe"));
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new BusinessException("El usuario no existe"));

        if (miembroEquipoRepository.existsByEquipoAndUsuario(equipo, usuario)) {
            throw new BusinessException("El usuario ya se encuentra en el equipo");
        }
        
        if (equipo.estaLleno()) {
            throw new BusinessException("El equipo ha alcanzado el límite de capacidad");
        }

        if (!equipo.isActivo()) {
            throw new BusinessException("El equipo no está activo");
        }

        if (solicitudEquipoRepository.existsByEquipoAndUsuarioAndEstado(equipo, usuario, EstadoSolicitudEquipo.PENDIENTE_CONFIRMACION)) {
            throw new BusinessException("Ya tienes una solicitud pendiente para este equipo");
        }

        SolicitudEquipo solicitudEquipo = SolicitudEquipo.builder()
            .equipo(equipo)
            .usuario(usuario)
            .fecha(LocalDateTime.now())
            .mensaje(mensaje)
            .build();

        solicitudEquipo = solicitudEquipoRepository.save(solicitudEquipo);

        SolicitudEquipoResponseDto solicitudEquipoResponseDto = SolicitudEquipoResponseDto.builder()
            .id(solicitudEquipo.getId())
            .nombreEquipo(equipo.getNombre())
            .nombreUsuario(usuario.getNombre())
            .fecha(solicitudEquipo.getFecha())
            .estadoSolicitudEquipo(solicitudEquipo.getEstado())
            .mensaje(mensaje)
            .build();

        return solicitudEquipoResponseDto;
        
    }
}
