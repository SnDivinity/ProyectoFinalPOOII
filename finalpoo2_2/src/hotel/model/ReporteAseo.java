package hotel.model;

import java.util.List;

public class ReporteAseo implements ReporteGenerador {

    @Override
    public double generarMetricas(List<Object> datos) {

        return datos.size();

    }

}