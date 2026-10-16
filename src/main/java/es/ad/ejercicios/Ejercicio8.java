package es.ad.ejercicios;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/** Ejercicio 8. Operaciones con {@link java.nio.file.Files}. */
public interface Ejercicio8 {

    /** Crea el directorio (y los padres que falten). Devuelve si el resultado es un directorio. */
    boolean crearDirectorio(Path directorio) throws IOException;

    /** Crea el fichero con las líneas indicadas. */
    void crearFichero(Path fichero, List<String> lineas) throws IOException;

    /** Lee todas las líneas del fichero. */
    List<String> leerLineas(Path fichero) throws IOException;

    /** Copia SIN sobrescribir: si el destino existe lanza {@link java.nio.file.FileAlreadyExistsException}. */
    void copiar(Path origen, Path destino) throws IOException;

    /** Mueve el fichero. */
    void mover(Path origen, Path destino) throws IOException;

    /** Indica si existe. */
    boolean existe(Path ruta);

    /** Borra el fichero si existe. Devuelve {@code true} si lo borró, {@code false} si no existía. */
    boolean borrar(Path fichero) throws IOException;
}
