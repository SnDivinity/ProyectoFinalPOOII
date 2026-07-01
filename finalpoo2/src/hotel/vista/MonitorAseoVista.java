package hotel.vista;

import hotel.controlador.MantenimientoController;
import hotel.model.Prioridad;
import hotel.model.TipoOrden;

import java.util.Scanner;

public class MonitorAseoVista {

    private MantenimientoController controlador;

    public MonitorAseoVista(MantenimientoController controlador) {
        this.controlador = controlador;
    }

    public void mostrarFormularioAsignacion() {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== NUEVA ORDEN =====");

        System.out.print("Habitación: ");
        int idHabitacion = sc.nextInt();
        sc.nextLine();

        System.out.println("Tipo:");
        System.out.println("1. Limpieza diaria");
        System.out.println("2. Mantenimiento");
        System.out.println("3. Desinfección");

        int opcion = sc.nextInt();
        sc.nextLine();

        TipoOrden tipo;

        switch (opcion) {
            case 2:
                tipo = TipoOrden.MANTENIMIENTO;
                break;
            case 3:
                tipo = TipoOrden.DESINFECCION;
                break;
            default:
                tipo = TipoOrden.LIMPIEZA_DIARIA;
        }

        System.out.println("Prioridad:");
        System.out.println("1. Baja");
        System.out.println("2. Media");
        System.out.println("3. Alta");

        opcion = sc.nextInt();
        sc.nextLine();

        Prioridad prioridad;

        switch (opcion) {
            case 2:
                prioridad = Prioridad.MEDIA;
                break;
            case 3:
                prioridad = Prioridad.ALTA;
                break;
            default:
                prioridad = Prioridad.BAJA;
        }

        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();

        controlador.crearOrdenTrabajo(
                idHabitacion,
                tipo,
                prioridad,
                descripcion
        );

        System.out.println("Orden creada correctamente.");
    }

    public void solicitarDatosNuevaOrden() {
        mostrarFormularioAsignacion();
    }

    public void mostrarMensajeConfirmacion(boolean exito) {

        if (exito) {
            System.out.println("Personal asignado correctamente.");
        } else {
            System.out.println("No fue posible asignar personal.");
        }

    }
}