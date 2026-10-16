package es.ad.ejercicios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

import es.ad.ejercicios.alumno.Ejercicio4Impl;

class Ejercicio4Test {

    private final Ejercicio4 ej = new Ejercicio4Impl();
    private final List<Integer> numeros = List.of(4, 8, 15, 16, 23, 42, 8, 15);

    @Test
    void tresMayoresDistintos() {
        assertEquals(List.of(42, 23, 16), ej.tresMayoresDistintos(numeros));
    }

    @Test
    void tresMayoresConPocosValores() {
        assertEquals(List.of(9, 2), ej.tresMayoresDistintos(List.of(2, 9, 9, 2)));
    }

    @Test
    void suma() { assertEquals(131, ej.suma(numeros)); }

    @Test
    void media() { assertEquals(16.375, ej.media(numeros), 1e-9); }

    @Test
    void maximo() { assertEquals(42, ej.maximo(numeros)); }
}
