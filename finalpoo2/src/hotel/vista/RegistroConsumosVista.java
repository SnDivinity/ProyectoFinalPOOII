package hotel.vista;

import hotel.controlador.ServicioController;
import hotel.model.TicketConsumo;
import java.util.List;

public class RegistroConsumosVista {
    private ServicioController controlador;

    public RegistroConsumosVista(ServicioController controlador) {
        this.controlador = controlador;
    }

    public RegistroConsumosVista() {

    }

    public void mostrarConfirmacionRegistro(boolean exito) {
        if (exito) {
            System.out.println("Consumo registrado exitosamente.");
        } else {
            System.out.println("Error: No se pudo registrar el consumo (Servicio no encontrado).");
        }
    }

    public void renderizarEstadoCuentaServicios(int idReserva, List<TicketConsumo> tickets, double totalCargos) {
        System.out.println("=== ESTADO DE CUENTA DE SERVICIOS - RESERVA #" + idReserva + " ===");
        for (TicketConsumo t : tickets) {
            System.out.println("- Ticket #" + t.getIdTicket() + " | " + t.getServicio().getNombre() +
                    " x" + t.getCantidad() + " | Subtotal: $" + t.getSubtotal());
        }
        System.out.println("TOTAL CARGOS: $" + totalCargos);
        System.out.println("================================================");
    }
}