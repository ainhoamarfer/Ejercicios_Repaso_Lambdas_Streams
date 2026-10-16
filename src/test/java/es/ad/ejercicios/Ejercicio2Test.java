package es.ad.ejercicios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

import es.ad.ejercicios.alumno.Ejercicio2Impl;

class Ejercicio2Test {

    private final Ejercicio2 ej = new Ejercicio2Impl();
    private final List<String> ciudades = List.of("Cádiz", "Sevilla", "Cuenca");

    @Test
    void contarCiudades() {
        assertEquals(3, ej.contarCiudades(ciudades));
        assertEquals(0, ej.contarCiudades(List.of()));
    }

    @Test
    void contarMasLargasQue() {
        assertEquals(2, ej.contarMasLargasQue(ciudades, 5));
        assertEquals(3, ej.contarMasLargasQue(ciudades, 0));
        assertEquals(0, ej.contarMasLargasQue(ciudades, 7));
    }

    @Test
    void sumaLongitudes() {
        assertEquals(18, ej.sumaLongitudes(ciudades));
        assertEquals(0, ej.sumaLongitudes(List.of()));
    }
}
