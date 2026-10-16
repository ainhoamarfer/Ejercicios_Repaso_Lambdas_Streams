package es.ad.ejercicios;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;
import org.junit.jupiter.api.Test;

import es.ad.ejercicios.alumno.Ejercicio7Impl;

class Ejercicio7Test {

    private final Ejercicio7 ej = new Ejercicio7Impl();
    private final Path ruta = Path.of("proyecto/datos/../recursos/./informe.pdf");

    @Test
    void normalizada() {
        assertEquals(Path.of("proyecto", "recursos", "informe.pdf"), ej.normalizada(ruta));
    }

    @Test
    void nombreFichero() {
        assertEquals(Path.of("informe.pdf"), ej.nombreFichero(ruta));
    }

    @Test
    void directorioPadre() {
        assertEquals(Path.of("proyecto", "recursos"), ej.directorioPadre(ruta));
    }

    @Test
    void esAbsoluta() {
        assertFalse(ej.esAbsoluta(ruta));
        assertTrue(ej.esAbsoluta(ruta.toAbsolutePath()));
    }

    @Test
    void conExtension() {
        assertEquals(Path.of("proyecto", "recursos", "informe.txt"), ej.conExtension(ruta, "txt"));
    }
}
