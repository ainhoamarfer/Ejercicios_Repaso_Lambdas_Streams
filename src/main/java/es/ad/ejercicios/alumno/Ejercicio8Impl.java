package es.ad.ejercicios.alumno;

import es.ad.ejercicios.Ejercicio8;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Ejercicio8Impl implements Ejercicio8 {
    @Override public boolean crearDirectorio(Path directorio) throws IOException { throw new UnsupportedOperationException("TODO"); }
    @Override public void crearFichero(Path fichero, List<String> lineas) throws IOException { throw new UnsupportedOperationException("TODO"); }
    @Override public List<String> leerLineas(Path fichero) throws IOException { throw new UnsupportedOperationException("TODO"); }
    @Override public void copiar(Path origen, Path destino) throws IOException { throw new UnsupportedOperationException("TODO"); }
    @Override public void mover(Path origen, Path destino) throws IOException { throw new UnsupportedOperationException("TODO"); }
    @Override public boolean existe(Path ruta) { throw new UnsupportedOperationException("TODO"); }
    @Override public boolean borrar(Path fichero) throws IOException { throw new UnsupportedOperationException("TODO"); }
}
