package es.ad.ejercicios;

import java.nio.file.Path;

/** Ejercicio 7. Rutas con {@link Path}. Todo salvo {@link #esAbsoluta} se calcula sobre la ruta normalizada. */
public interface Ejercicio7 {

    /** Ruta normalizada. */
    Path normalizada(Path ruta);

    /** Nombre del fichero. */
    Path nombreFichero(Path ruta);

    /** Directorio que contiene al fichero. */
    Path directorioPadre(Path ruta);

    /** Indica si la ruta (tal como se recibe) es absoluta. */
    boolean esAbsoluta(Path ruta);

    /** Misma ruta normalizada, pero con otra extensión (p. ej. {@code "txt"}, sin punto). */
    Path conExtension(Path ruta, String extension);
}
