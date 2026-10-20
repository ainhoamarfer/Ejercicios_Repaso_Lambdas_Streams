package es.ad.ejercicios.alumno;

import es.ad.ejercicios.Ejercicio5;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Cuenta cuántas ciudades hay por cada letra inicial.
 */
public class Ejercicio5Impl implements Ejercicio5 {
    @Override public Map<Character, Long> contarPorInicial(List<String> ciudades) {
        return ciudades.stream()
                .collect(Collectors.groupingBy(c -> c.charAt(0), Collectors.counting()));
    }
}
