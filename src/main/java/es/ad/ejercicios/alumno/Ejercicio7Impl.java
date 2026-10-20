package es.ad.ejercicios.alumno;

import es.ad.ejercicios.Ejercicio7;
import java.nio.file.Path;

public class Ejercicio7Impl implements Ejercicio7 {
    @Override public Path normalizada(Path ruta) {
        return ruta.normalize();
    }

    @Override public Path nombreFichero(Path ruta) {
        return ruta.getFileName();
    }

    @Override public Path directorioPadre(Path ruta) {
        return ruta.getParent().normalize();
    }

    @Override public boolean esAbsoluta(Path ruta) {
        return ruta.isAbsolute();
    }

    @Override public Path conExtension(Path ruta, String extension) {
        Path normalizada = ruta.normalize();
        String nombre = normalizada.getFileName().toString();
        String base = nombre.substring(0, nombre.lastIndexOf('.'));
        return normalizada.resolveSibling(base + '.' + extension);
    }
}
