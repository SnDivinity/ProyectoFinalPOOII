package hotel.model;

import java.util.List;

public class ReporteServiciosMasPedidos implements ReporteGenerador {

    @Override
    public double generarMetricas(List<Object> datos) {

        return datos.size();

    }

}