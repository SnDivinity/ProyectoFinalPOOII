package hotel.model;

import java.time.LocalDate;

public class TicketConsumo {
    private int idTicket;
    private int idReserva;
    private ServicioExtra servicio;
    private LocalDate fechaConsumo;
    private int cantidad;
    private double subtotal;

    public TicketConsumo(int idTicket, int idReserva, ServicioExtra servicio, LocalDate fechaConsumo, int cantidad) {
        this.idTicket = idTicket;
        this.idReserva = idReserva;
        this.servicio = servicio;
        this.fechaConsumo = fechaConsumo;
        this.cantidad = cantidad;
        calcularSubtotal();
    }

    public void calcularSubtotal() {
        if (this.servicio != null) {
            this.subtotal = this.servicio.getPrecioBase() * this.cantidad;
        } else {
            this.subtotal = 0.0;
        }
    }

    // Getters y Setters
    public int getIdTicket() { return idTicket; }
    public int getIdReserva() { return idReserva; }
    public ServicioExtra getServicio() { return servicio; }
    public LocalDate getFechaConsumo() { return fechaConsumo; }
    public int getCantidad() { return cantidad; }
    public double getSubtotal() { return subtotal; }
}