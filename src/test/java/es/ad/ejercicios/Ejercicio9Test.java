package es.ad.ejercicios;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import es.ad.ejercicios.alumno.Ejercicio9Impl;

class Ejercicio9Test {

    private final Ejercicio9 ej = new Ejercicio9Impl();

    @TempDir
    Path tmp;

    private static Set<Set<String>> comoConjuntos(List<List<String>> grupos) {
        return grupos.stream().map(g -> (Set<String>) new HashSet<>(g)).collect(Collectors.toSet());
    }

    @Test
    void ficheroDelEnunciado() throws IOException {
        List<List<String>> grupos = ej.gruposDeAnagramas(Path.of("datos", "palabras.txt"));
        assertEquals(3, grupos.size());
        assertEquals(Set.of(
                Set.of("amor", "roma", "ramo", "mora"),
                Set.of("sol", "los"),
                Set.of("caso", "saco")), comoConjuntos(grupos));
        assertTrue(grupos.stream().anyMatch(g -> g.size() == 4), "el grupo amor/roma/ramo/mora debe tener 4 palabras");
    }

    @Test
    void sinAnagramas() throws IOException {
        Path f = tmp.resolve("p.txt");
        Files.write(f, List.of("uno", "dos", "tres"));
        assertTrue(ej.gruposDeAnagramas(f).isEmpty());
    }

    @Test
    void ficheroPropio() throws IOException {
        Path f = tmp.resolve("p.txt");
        Files.write(f, List.of("ave", "eva", "vea", "pan", "nap", "sol"));
        assertEquals(Set.of(Set.of("ave", "eva", "vea"), Set.of("pan", "nap")), comoConjuntos(ej.gruposDeAnagramas(f)));
    }
}
