package es.ad.ejercicios.alumno;

import es.ad.ejercicios.Ejercicio1;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Ejercicio1Impl implements Ejercicio1 {
    @Override
    public void ejecutar() {

        Predicate<Integer> esPar4 = (x) -> x % 2 == 0;
        Function<String, Integer> longitud6 = (s) -> s.length();
        BiFunction<Integer, Integer, Integer> elMayorNumero = (n1, n2) -> n1 > n2 ? n1 : n2;
        Comparator<String> ordenaLongitud = Comparator.comparingInt(String::length);

        System.out.println(esPar4.test(4));
        System.out.println(esPar4.test(7));
        System.out.println(longitud6.apply("lambda"));
        System.out.println(elMayorNumero.apply(3,9));
        System.out.println(ordenaLongitud.compare("Cadiz", "Sevilla"));


    }
}
