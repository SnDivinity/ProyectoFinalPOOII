package hotel.controlador;

import hotel.model.OrdenTrabajo;

import java.util.ArrayList;
import java.util.List;

public class MantenimientoRepositorio extends RepositorioBase<OrdenTrabajo> {

    public List<OrdenTrabajo> obtenerOrdenesPendientes() {

        List<OrdenTrabajo> pendientes = new ArrayList<>();

        for (OrdenTrabajo orden : elementos) {

            if (!orden.isCompletada()) {
                pendientes.add(orden);
            }

        }

        return pendientes;
    }

    public List<OrdenTrabajo> buscarPorHabitacion(int idHabitacion) {

        List<OrdenTrabajo> resultado = new ArrayList<>();

        for (OrdenTrabajo orden : elementos) {

            if (orden.getIdHabitacion() == idHabitacion) {
                resultado.add(orden);
            }

        }

        return resultado;
    }
}