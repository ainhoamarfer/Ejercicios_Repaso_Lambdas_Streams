package es.ad.ejercicios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

import es.ad.ejercicios.alumno.Ejercicio3Impl;

class Ejercicio3Test {

    private final Ejercicio3 ej = new Ejercicio3Impl();

    @Test
    void filtraYTransforma() {
        List<String> entrada = List.of("Cádiz", "Barcelona", "Córdoba", "Sevilla", "Castellón", "Madrid", "Cuenca");
        assertEquals(List.of("BARCELONA", "CÓRDOBA", "SEVILLA", "CASTELLÓN"), ej.largasEnMayusculas(entrada));
    }

    @Test
    void ningunaCumple() {
        assertEquals(List.of(), ej.largasEnMayusculas(List.of("Cádiz", "Madrid")));
    }

    @Test
    void exactamenteSeisNoEntra() {
        assertEquals(List.of(), ej.largasEnMayusculas(List.of("Huesca", "Toledo")));
    }
}
