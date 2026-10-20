package es.ad.ejercicios.alumno;

import es.ad.ejercicios.Ejercicio10;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Ejercicio10Impl implements Ejercicio10 {

    public record Ventas (
            int id_venta,
            LocalDate fecha,
            String tienda,
            String producto,
            String categoria,
            int unidades,
            BigDecimal precio_unitario
    ){}

    private List<Ventas> leer(Path csv) throws IOException {
        try(Stream<String> lineas = Files.lines(csv)){
            lineas
                    .skip(1)
                    //1,2026-01-05,Madrid,Teclado,Perifericos,3,25.50
                    .map(l -> lineaAVenta(l));

        }catch (IOException e){

        }


    }



    @Override public int numeroVentas(Path csv) throws IOException {
    return leer(csv).size();
    }

    @Override public int unidadesTotales(Path csv) throws IOException {
        return leer(csv).stream().mapToInt(Ventas::unidades).sum();
    }

    @Override public BigDecimal ingresosTotales(Path csv) throws IOException {
        return leer(csv).stream
    }

    @Override public Map<String, BigDecimal> ingresosPorTienda(Path csv) throws IOException {
        throw new UnsupportedOperationException("TODO"); }

    @Override public String productoMasVendido(Path csv) throws IOException {
        throw new UnsupportedOperationException("TODO"); }

    @Override public int unidadesProductoMasVendido(Path csv) throws IOException {
        throw new UnsupportedOperationException("TODO"); }

    @Override public int idVentaMayorImporte(Path csv) throws IOException {
        throw new UnsupportedOperationException("TODO"); }

    @Override public Map<String, BigDecimal> ingresosPorMes(Path csv) throws IOException {
        throw new UnsupportedOperationException("TODO"); }

    @Override public String categoriaMasIngresos(Path csv) throws IOException {
        throw new UnsupportedOperationException("TODO"); }

    @Override public List<Integer> idsVentasMayoresDe(Path csv, BigDecimal limite) throws IOException {
        throw new UnsupportedOperationException("TODO"); }

    @Override public void escribirProcesamiento(Path csv, Path salida, boolean sobrescribir) throws IOException {
        throw new UnsupportedOperationException("TODO"); }
}
