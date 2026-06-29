package hotel.model.concurrencia;

import hotel.model.ComponenteHabitacion;
import hotel.model.Habitacion;
import hotel.model.Enum.TipoHabitacion;

import java.util.ArrayList;
import java.util.List;

public class BuscadorHabitaciones {

    public List<Habitacion> buscarDisponibles(
            List<ComponenteHabitacion> lista,
            TipoHabitacion tipo) {

        List<Habitacion> resultado = new ArrayList<>();

        for (ComponenteHabitacion componente : lista) {

            if (componente instanceof Habitacion) {

                Habitacion habitacion = (Habitacion) componente;

                if (habitacion.getTipo() == tipo) {
                    resultado.add(habitacion);
                }
            }
        }

        return resultado;
    }
}