package es.ad.ejercicios;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import es.ad.ejercicios.alumno.Ejercicio1Impl;

class Ejercicio1Test {

    private final Ejercicio1 ej = new Ejercicio1Impl();

    @TempDir
    Path tmp;

    /** Ejecuta el ejercicio con System.out redirigido a un fichero temporal y devuelve las líneas escritas. */
    private List<String> capturarSalida() throws IOException {
        Path fichero = tmp.resolve("salida.txt");
        PrintStream original = System.out;
        try (PrintStream ps = new PrintStream(Files.newOutputStream(fichero), true, StandardCharsets.UTF_8)) {
            System.setOut(ps);
            ej.ejecutar();
        } finally {
            System.setOut(original);
        }
        return Files.readAllLines(fichero, StandardCharsets.UTF_8).stream().map(String::trim).toList();
    }

    @Test
    void muestraCincoLineas() throws IOException {
        assertEquals(5, capturarSalida().size(), "debe imprimir exactamente 5 líneas");
    }

    @Test
    void esParConCuatroYSiete() throws IOException {
        List<String> salida = capturarSalida();
        assertEquals("true", salida.get(0));
        assertEquals("false", salida.get(1));
    }

    @Test
    void longitudDeLambda() throws IOException {
        assertEquals("6", capturarSalida().get(2));
    }

    @Test
    void mayorDeTresYNueve() throws IOException {
        assertEquals("9", capturarSalida().get(3));
    }

    @Test
    void comparadorPorLongitudDaNegativo() throws IOException {
        int resultado = Integer.parseInt(capturarSalida().get(4));
        assertTrue(resultado < 0, "\"Cádiz\" va antes que \"Sevilla\", se esperaba un valor negativo");
    }
}
