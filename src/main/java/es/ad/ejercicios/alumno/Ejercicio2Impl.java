package es.ad.ejercicios.alumno;

import es.ad.ejercicios.Ejercicio2;
import java.util.List;
import java.util.stream.Stream;

public class Ejercicio2Impl implements Ejercicio2 {
    @Override public int contarCiudades(List<String> ciudades) {

        return ((int) ciudades
                .stream()
                .count());
    }

    @Override public int contarMasLargasQue(List<String> ciudades, int minimo) {

        return ((int) ciudades.stream()
                .filter(s -> s.length() > minimo)
                .count());
    }
    @Override public int sumaLongitudes(List<String> ciudades) {

        return  ciudades.stream()
                .map(c ->c.length())
                .reduce(0, (vAcumulado, numero) -> vAcumulado + numero);
    }
}
