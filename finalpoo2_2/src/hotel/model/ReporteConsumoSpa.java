package hotel.model;

import java.util.List;

public class ReporteConsumoSpa implements ReporteGenerador {

    @Override
    public double generarMetricas(List<Object> datos) {

        return datos.size();

    }

}