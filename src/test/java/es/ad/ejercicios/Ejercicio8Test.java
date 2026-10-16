package es.ad.ejercicios;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import es.ad.ejercicios.alumno.Ejercicio8Impl;

class Ejercicio8Test {

    private final Ejercicio8 ej = new Ejercicio8Impl();

    @TempDir
    Path tmp;

    @Test
    void secuenciaCompleta() throws IOException {
        Path dir = tmp.resolve("backup").resolve("2026");
        Path notas = dir.resolve("notas.txt");
        Path copia = dir.resolve("notas-copia.txt");
        Path fin = dir.resolve("notas-final.txt");

        assertTrue(ej.crearDirectorio(dir));
        assertTrue(Files.isDirectory(dir));

        ej.crearFichero(notas, List.of("uno", "dos"));
        assertEquals(List.of("uno", "dos"), ej.leerLineas(notas));

        ej.copiar(notas, copia);
        assertThrows(FileAlreadyExistsException.class, () -> ej.copiar(notas, copia));

        ej.mover(copia, fin);
        assertFalse(ej.existe(copia));
        assertTrue(ej.existe(fin));
        assertTrue(Files.exists(notas), "el original debe seguir existiendo");

        assertTrue(ej.borrar(fin));
        assertFalse(ej.borrar(fin));
        assertFalse(Files.exists(fin));
    }

    @Test
    void crearDirectorioCreaLosPadres() throws IOException {
        Path dir = tmp.resolve("a").resolve("b").resolve("c");
        assertTrue(ej.crearDirectorio(dir));
        assertTrue(Files.isDirectory(dir));
    }

    @Test
    void copiaMantieneContenido() throws IOException {
        Path o = tmp.resolve("o.txt");
        Path d = tmp.resolve("d.txt");
        Files.write(o, List.of("x", "y", "z"));
        ej.copiar(o, d);
        assertEquals(List.of("x", "y", "z"), Files.readAllLines(d));
    }

    @Test
    void existeDevuelveFalseSiNoExiste() {
        assertFalse(ej.existe(tmp.resolve("no-existe.txt")));
    }
}
