package es.ad.ejercicios;

import java.util.List;

/** Ejercicio 4. Números con streams. */
public interface Ejercicio4 {

    /** a) Los tres mayores valores distintos, de mayor a menor. */
    List<Integer> tresMayoresDistintos(List<Integer> numeros);

    /** b) Suma de la lista. */
    int suma(List<Integer> numeros);

    /** b) Media de la lista. */
    double media(List<Integer> numeros);

    /** b) Máximo de la lista. */
    int maximo(List<Integer> numeros);
}
