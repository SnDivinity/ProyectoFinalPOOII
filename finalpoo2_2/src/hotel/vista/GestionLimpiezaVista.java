package hotel.vista;

import hotel.controlador.MantenimientoController;
import hotel.model.OrdenTrabajo;

import java.util.List;

public class GestionLimpiezaVista {

    private MantenimientoController controlador;

    public GestionLimpiezaVista(MantenimientoController controlador) {
        this.controlador = controlador;
    }

    public void renderizarGrillaTareas(List<OrdenTrabajo> tareas) {

        System.out.println("             TAREAS                ");

        for (OrdenTrabajo tarea : tareas) {

            System.out.println("----------------------------");
            System.out.println("Orden: " + tarea.getIdOrden());
            System.out.println("Habitación: " + tarea.getIdHabitacion());
            System.out.println("Tipo: " + tarea.getTipo());
            System.out.println("Prioridad: " + tarea.getPrioridad());
            System.out.println("Descripción: " + tarea.getDescripcion());
            System.out.println("Completada: " + tarea.isCompletada());

            if (tarea.getEncargado() != null) {
                System.out.println("Encargado: " +
                        tarea.getEncargado().getNombre());
            }

        }

    }

    public void mostrarNotificacionTareaTerminada(int idHabitacion) {

        System.out.println();
        System.out.println("La habitación " + idHabitacion +
                " terminó su proceso de limpieza.");
        System.out.println();
    }

}