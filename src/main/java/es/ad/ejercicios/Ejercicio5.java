package es.ad.ejercicios;

import java.util.List;
import java.util.Map;

/** Ejercicio 5. Agrupar elementos. */
public interface Ejercicio5 {

    /** Número de ciudades por cada letra inicial. */
    Map<Character, Long> contarPorInicial(List<String> ciudades);
}
