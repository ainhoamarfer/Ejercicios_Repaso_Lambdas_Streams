package es.ad.ejercicios.alumno;

import es.ad.ejercicios.Ejercicio10;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class Ejercicio10Impl implements Ejercicio10 {

    public record Venta(
            int id_venta,
            LocalDate fecha,
            String tienda,
            String producto,
            String categoria,
            int unidades,
            BigDecimal precio_unitario
    ){}

    private List<Venta> leer(Path csv) throws IOException {
        try(Stream<String> lineas = Files.lines(csv)){
            return lineas
                    .skip(1)
                    .map(l -> lineaAVenta(l))
                    .toList();

        }catch (IOException e){
            throw new RuntimeException();
        }
    }

    private Venta lineaAVenta(String l) {
        String[] campos = l.split(",", -1);

        return new Venta(
                parseInt(campos[0].trim()),
                LocalDate.parse(campos[1].trim()),
                campos[2].trim(),
                campos[3].trim(),
                campos[4].trim(),
                parseInt(campos[5].trim()),
                new BigDecimal(campos[6].trim())
        );
    }


    @Override public int numeroVentas(Path csv) throws IOException {
    return leer(csv).size();
    }

    @Override public int unidadesTotales(Path csv) throws IOException {
        return leer(csv).stream().mapToInt(Venta::unidades).sum();
    }

    @Override public BigDecimal ingresosTotales(Path csv) throws IOException {
        return leer(csv).stream()
                .map(this::importeUnaVenta)
                .reduce(BigDecimal.valueOf(0), BigDecimal::add);
    }

    private BigDecimal importeUnaVenta(Venta venta) {
        return venta.precio_unitario().multiply(BigDecimal.valueOf(venta.unidades()));
    }

    //id_venta,fecha,tienda,producto,categoria,unidades,precio_unitario
    //1,2026-01-05,Madrid,Teclado,Perifericos,3,25.50
    @Override public Map<String, BigDecimal> ingresosPorTienda(Path csv) throws IOException {
        return leer(csv).stream()
                .collect(Collectors.groupingBy(Venta::tienda, Collectors.reducing(BigDecimal.ZERO, this::importeUnaVenta, BigDecimal::add)
                ));
    }

    public Map<String, Integer> unidadesVendidasPorProducto(Path csv) throws IOException {

        return leer(csv).stream()
                .collect(Collectors.groupingBy(Venta::producto, Collectors.summingInt(Venta::unidades)
                ));
    }

    @Override public String productoMasVendido(Path csv) throws IOException {
        Map<String, Integer> unidades = unidadesVendidasPorProducto(csv);

        String productoMasVendido = "";
        int maxUnidades = 0;

        for (String producto : unidades.keySet()) {
            int cantidad = unidades.get(producto);

            if (cantidad > maxUnidades) {
                maxUnidades = cantidad;
                productoMasVendido = producto;
            }
        }

        return productoMasVendido;
    }


    @Override public int unidadesProductoMasVendido(Path csv) throws IOException {
        Map<String, Integer> unidades = unidadesVendidasPorProducto(csv);

        int maxUnidades = 0;

        for (String producto : unidades.keySet()){
            int unidadesItem = unidades.get(unidades);

            if (unidadesItem > maxUnidades){
                maxUnidades = unidadesItem;
            }
        }
        return maxUnidades;
    }

    @Override public int idVentaMayorImporte(Path csv) throws IOException {
        Map<Integer, BigDecimal> importes = leer(csv).stream()
                .collect(Collectors.toMap(
                        Venta::id_venta,
                        this::importeUnaVenta
                ));

        return importes.entrySet().stream()
                .max((a, b) -> a.getValue().compareTo(b.getValue()))
                .map(Map.Entry::getKey)
                .orElse(-1);
    }

    @Override public Map<String, BigDecimal> ingresosPorMes(Path csv) throws IOException {
        throw new UnsupportedOperationException("TODO"); }

    @Override public String categoriaMasIngresos(Path csv) throws IOException {
        throw new UnsupportedOperationException("TODO"); }

    @Override public List<Integer> idsVentasMayoresDe(Path csv, BigDecimal limite) throws IOException {
        throw new UnsupportedOperationException("TODO"); }

    @Override public void escribirProcesamiento(Path csv, Path salida, boolean sobrescribir) throws IOException {
        throw new UnsupportedOperationException("TODO"); }
}
