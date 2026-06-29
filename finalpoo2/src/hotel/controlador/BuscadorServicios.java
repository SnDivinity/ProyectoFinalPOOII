package hotel.controlador;

import hotel.model.ServicioExtra;
import hotel.model.TipoServicio;
import java.util.List;
import java.util.stream.Collectors;

public class BuscadorServicios {

    public List<ServicioExtra> filtrarServiciosPorTipo(List<ServicioExtra> lista, TipoServicio tipo) {
        return lista.stream()
                .filter(s -> s.getTipo() == tipo)
                .collect(Collectors.toList());
    }

    public List<ServicioExtra> obtenerServiciosPrecioMayorA(List<ServicioExtra> lista, double limite) {
        return lista.stream()
                .filter(s -> s.getPrecioBase() > limite)
                .collect(Collectors.toList());
    }
}