package hotel.controlador;

import hotel.model.OrdenTrabajo;
import hotel.model.Prioridad;

import java.util.ArrayList;
import java.util.List;

public class BuscadorOrdenes {

    public List<OrdenTrabajo> filtrarPendientesAltaPrioridad(
            List<OrdenTrabajo> lista) {

        List<OrdenTrabajo> resultado = new ArrayList<>();

        for (OrdenTrabajo orden : lista) {

            if (!orden.isCompletada()
                    && orden.getPrioridad() == Prioridad.ALTA) {

                resultado.add(orden);

            }

        }

        return resultado;
    }

}