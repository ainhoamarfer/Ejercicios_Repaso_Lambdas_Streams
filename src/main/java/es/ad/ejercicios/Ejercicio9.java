package es.ad.ejercicios;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/** Ejercicio 9. Anagramas en un fichero (usar {@code Files.lines}). */
public interface Ejercicio9 {

    /**
     * Grupos de anagramas formados por dos o más palabras.
     * El orden de los grupos y de las palabras dentro de cada grupo es indiferente.
     */
    List<List<String>> gruposDeAnagramas(Path fichero) throws IOException;
}
