package es.ad.ejercicios.alumno;

import es.ad.ejercicios.Ejercicio10;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Ejercicio10Impl implements Ejercicio10 {
    @Override public int numeroVentas(Path csv) throws IOException { throw new UnsupportedOperationException("TODO"); }
    @Override public int unidadesTotales(Path csv) throws IOException { throw new UnsupportedOperationException("TODO"); }
    @Override public BigDecimal ingresosTotales(Path csv) throws IOException { throw new UnsupportedOperationException("TODO"); }
    @Override public Map<String, BigDecimal> ingresosPorTienda(Path csv) throws IOException { throw new UnsupportedOperationException("TODO"); }
    @Override public String productoMasVendido(Path csv) throws IOException { throw new UnsupportedOperationException("TODO"); }
    @Override public int unidadesProductoMasVendido(Path csv) throws IOException { throw new UnsupportedOperationException("TODO"); }
    @Override public int idVentaMayorImporte(Path csv) throws IOException { throw new UnsupportedOperationException("TODO"); }
    @Override public Map<String, BigDecimal> ingresosPorMes(Path csv) throws IOException { throw new UnsupportedOperationException("TODO"); }
    @Override public String categoriaMasIngresos(Path csv) throws IOException { throw new UnsupportedOperationException("TODO"); }
    @Override public List<Integer> idsVentasMayoresDe(Path csv, BigDecimal limite) throws IOException { throw new UnsupportedOperationException("TODO"); }
    @Override public void escribirProcesamiento(Path csv, Path salida, boolean sobrescribir) throws IOException { throw new UnsupportedOperationException("TODO"); }
}
