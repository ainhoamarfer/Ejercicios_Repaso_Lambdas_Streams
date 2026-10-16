package es.ad.ejercicios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

import es.ad.ejercicios.alumno.Ejercicio5Impl;

class Ejercicio5Test {

    private final Ejercicio5 ej = new Ejercicio5Impl();

    @Test
    void cuentaPorInicial() {
        List<String> entrada = List.of("Cádiz", "Córdoba", "Sevilla", "Cuenca", "Segovia", "Madrid");
        assertEquals(Map.of('C', 3L, 'S', 2L, 'M', 1L), ej.contarPorInicial(entrada));
    }

    @Test
    void listaVacia() {
        assertTrue(ej.contarPorInicial(List.of()).isEmpty());
    }
}
