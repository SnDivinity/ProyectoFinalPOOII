package hotel.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reserva {

    private int idReserva;
    private Huesped huesped;
    private List<ComponenteHabitacion> habitaciones;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private EstadoReserva estado;
    private double total;

    public Reserva() {
        habitaciones = new ArrayList<>();
    }

    public Reserva(int idReserva, Huesped huesped,
                   LocalDate fechaInicio,
                   LocalDate fechaFin) {

        this.idReserva = idReserva;
        this.huesped = huesped;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = EstadoReserva.PENDIENTE;
        this.habitaciones = new ArrayList<>();
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public List<ComponenteHabitacion> getHabitaciones() {
        return habitaciones;
    }

    public void agregarHabitacion(ComponenteHabitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}