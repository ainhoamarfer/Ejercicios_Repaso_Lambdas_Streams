package es.ad.ejercicios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

import es.ad.ejercicios.alumno.Ejercicio6Impl;

class Ejercicio6Test {

    private final Ejercicio6 ej = new Ejercicio6Impl();

    @Test
    void hasta30() {
        assertEquals(List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29), ej.primosHasta(30));
    }

    @Test
    void hasta10() { assertEquals(List.of(2, 3, 5, 7), ej.primosHasta(10)); }

    @Test
    void hasta1() { assertEquals(List.of(), ej.primosHasta(1)); }

    @Test
    void incluyeElLimite() { assertEquals(List.of(2, 3, 5, 7, 11), ej.primosHasta(11)); }

    @Test
    void hasta2() { assertEquals(List.of(2), ej.primosHasta(2)); }

    @Test
    void cantidadHasta100() { assertEquals(25, ej.primosHasta(100).size()); }
}
