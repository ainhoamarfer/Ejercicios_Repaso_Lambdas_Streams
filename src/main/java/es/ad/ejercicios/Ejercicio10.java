package es.ad.ejercicios;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

/**
 * Ejercicio 10. Procesar un CSV a mano (sin librerías de CSV).
 * El importe de una venta es {@code unidades * precio_unitario}.
 * Los importes se devuelven como {@link BigDecimal}.
 */
public interface Ejercicio10 {

    /** a) Número de ventas. */
    int numeroVentas(Path csv) throws IOException;

    /** a) Unidades vendidas en total. */
    int unidadesTotales(Path csv) throws IOException;

    /** b) Ingresos totales. */
    BigDecimal ingresosTotales(Path csv) throws IOException;

    /** c) Ingresos por tienda. */
    Map<String, BigDecimal> ingresosPorTienda(Path csv) throws IOException;

    /** d) Producto más vendido en unidades. */
    String productoMasVendido(Path csv) throws IOException;

    /** d) Unidades vendidas de ese producto. */
    int unidadesProductoMasVendido(Path csv) throws IOException;

    /** e) Id de la venta de mayor importe. */
    int idVentaMayorImporte(Path csv) throws IOException;

    /** f) Ingresos por mes; la clave es el mes con dos dígitos ("01", "02"...). */
    Map<String, BigDecimal> ingresosPorMes(Path csv) throws IOException;

    /** g) Categoría con más ingresos. */
    String categoriaMasIngresos(Path csv) throws IOException;

    /** h) Ids (en orden de fichero) de las ventas con importe superior a {@code limite}. */
    List<Integer> idsVentasMayoresDe(Path csv, BigDecimal limite) throws IOException;

    /**
     * Escribe los resultados (apartados a-h) en {@code salida}.
     * Si {@code salida} ya existe y {@code sobrescribir} es {@code false}, lanza
     * {@link java.nio.file.FileAlreadyExistsException} sin modificar el fichero.
     * Preguntar al usuario si quiere sobrescribir se hace en {@code Main}.
     */
    void escribirProcesamiento(Path csv, Path salida, boolean sobrescribir) throws IOException;
}
