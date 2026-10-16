package es.ad.ejercicios;

import java.sql.SQLOutput;
import java.util.function.Predicate;

/**
 * Ejercicio 1. Lambdas básicas.
 *
 * <p>{@link #ejecutar()} declara las lambdas (el {@code Predicate} de las tres formas: con tipo, sin tipo y
 * sin paréntesis) y las prueba, mostrando por pantalla, una por línea y en este orden:
 * <pre>
 * true      (esPar con 4)
 * false     (esPar con 7)
 * 6         (longitud de "lambda")
 * 9         (mayor de 3 y 9)
 * -2        (comparación "Cádiz" / "Sevilla": cualquier valor negativo)
 * </pre>
 */
public interface Ejercicio1 {

    void ejecutar();
}
