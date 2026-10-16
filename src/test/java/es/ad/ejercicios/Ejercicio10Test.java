package es.ad.ejercicios;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import es.ad.ejercicios.alumno.Ejercicio10Impl;

class Ejercicio10Test {

    private final Ejercicio10 ej = new Ejercicio10Impl();
    private final Path csv = Path.of("datos", "ventas.csv");

    @TempDir
    Path tmp;

    private static void assertImporte(String esperado, BigDecimal real) {
        assertNotNull(real);
        assertEquals(0, new BigDecimal(esperado).compareTo(real), "esperado " + esperado + " pero fue " + real);
    }

    private static void assertImportes(Map<String, String> esperado, Map<String, BigDecimal> real) {
        assertEquals(esperado.keySet(), real.keySet());
        esperado.forEach((k, v) -> assertImporte(v, real.get(k)));
    }

    @Test
    void a_ventasYUnidades() throws IOException {
        assertEquals(20, ej.numeroVentas(csv));
        assertEquals(90, ej.unidadesTotales(csv));
    }

    @Test
    void b_ingresosTotales() throws IOException {
        assertImporte("9039.30", ej.ingresosTotales(csv));
    }

    @Test
    void c_ingresosPorTienda() throws IOException {
        assertImportes(Map.of("Madrid", "3483.50", "Sevilla", "2428.15", "Valencia", "3127.65"),
                ej.ingresosPorTienda(csv));
    }

    @Test
    void d_productoMasVendido() throws IOException {
        assertEquals("Raton", ej.productoMasVendido(csv));
        assertEquals(37, ej.unidadesProductoMasVendido(csv));
    }

    @Test
    void e_ventaMayorImporte() throws IOException {
        assertEquals(8, ej.idVentaMayorImporte(csv));
    }

    @Test
    void f_ingresosPorMes() throws IOException {
        assertImportes(Map.of("01", "1426.30", "02", "2672.45", "03", "2488.00", "04", "2452.55"),
                ej.ingresosPorMes(csv));
    }

    @Test
    void g_categoriaMasIngresos() throws IOException {
        assertEquals("Ordenadores", ej.categoriaMasIngresos(csv));
    }

    @Test
    void h_ventasMayoresDe500() throws IOException {
        assertEquals(List.of(4, 6, 8, 12, 15, 19), ej.idsVentasMayoresDe(csv, new BigDecimal("500")));
    }

    @Test
    void h_limiteExactoNoCuenta() throws IOException {
        // la venta 8 vale exactamente 1700.00: no es "mayor de" 1700
        assertEquals(List.of(), ej.idsVentasMayoresDe(csv, new BigDecimal("1700.00")));
    }

    @Test
    void csvPropioPequeno() throws IOException {
        Path f = tmp.resolve("mini.csv");
        Files.write(f, List.of(
                "id_venta,fecha,tienda,producto,categoria,unidades,precio_unitario",
                "1,2026-05-01,Bilbao,Cable,Accesorios,2,3.10",
                "2,2026-05-02,Bilbao,Cable,Accesorios,1,3.10",
                "3,2026-06-01,Vigo,Funda,Accesorios,1,9.99"));
        assertEquals(3, ej.numeroVentas(f));
        assertEquals(4, ej.unidadesTotales(f));
        assertImporte("19.29", ej.ingresosTotales(f));
        assertImportes(Map.of("Bilbao", "9.30", "Vigo", "9.99"), ej.ingresosPorTienda(f));
        assertEquals("Cable", ej.productoMasVendido(f));
        assertEquals(3, ej.unidadesProductoMasVendido(f));
        assertEquals(3, ej.idVentaMayorImporte(f));
    }

    @Test
    void escribeElFicheroDeSalida() throws IOException {
        Path salida = tmp.resolve("procesamiento.csv");
        ej.escribirProcesamiento(csv, salida, false);
        assertTrue(Files.exists(salida));
        String contenido = Files.readString(salida);
        assertTrue(contenido.contains("9039.30"), "debe incluir los ingresos totales");
        assertTrue(contenido.contains("Raton"));
        assertTrue(contenido.contains("Ordenadores"));
    }

    @Test
    void noSobrescribeSiNoSePermite() throws IOException {
        Path salida = tmp.resolve("procesamiento.csv");
        Files.writeString(salida, "contenido previo");
        assertThrows(FileAlreadyExistsException.class, () -> ej.escribirProcesamiento(csv, salida, false));
        assertEquals("contenido previo", Files.readString(salida));
    }

    @Test
    void sobrescribeSiSePermite() throws IOException {
        Path salida = tmp.resolve("procesamiento.csv");
        Files.writeString(salida, "contenido previo");
        ej.escribirProcesamiento(csv, salida, true);
        assertTrue(Files.readString(salida).contains("9039.30"));
        assertFalse(Files.readString(salida).contains("contenido previo"));
    }
}
