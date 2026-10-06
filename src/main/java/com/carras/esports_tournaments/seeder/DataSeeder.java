package com.carras.esports_tournaments.seeder;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.carras.esports_tournaments.model.Equipo;
import com.carras.esports_tournaments.model.Torneo;
import com.carras.esports_tournaments.model.Usuario;
import com.carras.esports_tournaments.model.enums.Rol;
import com.carras.esports_tournaments.repositories.EquipoRepository;
import com.carras.esports_tournaments.repositories.TorneoRepository;
import com.carras.esports_tournaments.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final TorneoRepository torneoRepository;
    private final EquipoRepository equipoRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
        
        if (torneoRepository.count() == 0) {

            //Torneo torneo = new Torneo(null, "Torneo de verano", EstadoTorneo.INSCRIPCION_ABIERTA, 8, null, "Valorant", null, LocalDateTime.now(), LocalDateTime.of(2026, 9, 3, 19, 0)) ;
            Torneo torneo = Torneo.builder()
                .nombre("Torneo de Verano")
                .capacidadMaxima(8)
                .juego("Valorant")
                .fechaInicio(LocalDateTime.now())
                .fechaFinal(LocalDateTime.of(2026, 9, 3, 19, 0))
                .build();
            torneoRepository.save(torneo);

            //Equipo equipo = new Equipo(null, "Legionarios", LocalDate.now(), null, null, true);
            Equipo equipo = Equipo.builder()
                .nombre("Legionarios")
                .fechaCreacion(LocalDate.now())
                .activo(true)
                .build();
            equipoRepository.save(equipo);

            //Usuario usuario = new Usuario(null, "markiwis", "Marcos", "marcosmunozcarrasco06@gmail.com", equipoRepository.findByNombre("Legionarios").orElse(null), "marquitosElCapitan", Rol.CAPITAN);
            Usuario usuario = Usuario.builder()
                .username("markiwis")
                .nombre("Marcos")
                .email("marcosmunozcarrasco06@gmail.com")
                .password("marquitosElCapitan")
                .rol(Rol.USER)
                .build();
            usuarioRepository.save(usuario);

            equipo.addIntegrante(usuario);
            equipo.setCapitan(usuario);
            equipoRepository.save(equipo);

            System.out.println("¡Datos de prueba inicializados con éxito!");
        }
    }
}
