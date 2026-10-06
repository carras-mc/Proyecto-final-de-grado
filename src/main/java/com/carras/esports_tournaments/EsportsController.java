package com.carras.esports_tournaments;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EsportsController {

    @GetMapping("/hola")
    public String decirHola(@RequestParam("nombre") String nombre) {
        return "Hola " + nombre + " desde Spring boot!";

    }
}