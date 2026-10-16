package es.ad.ejercicios;

import java.util.List;

/** Ejercicio 2. El contexto de una lambda. */
public interface Ejercicio2 {

    /** a) Cuenta cuántas ciudades hay, sin bucle for ni cambiar la lista. */
    int contarCiudades(List<String> ciudades);

    /** b) Cuenta las ciudades con más letras que {@code minimo} (la lambda debe leer {@code minimo}). */
    int contarMasLargasQue(List<String> ciudades, int minimo);

    /** c) Suma de las longitudes, sin modificar variables desde dentro de una lambda. */
    int sumaLongitudes(List<String> ciudades);
}
