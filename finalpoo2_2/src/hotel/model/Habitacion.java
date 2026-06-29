package hotel.model;

import hotel.model.Enum.EstadoHabitacion;
import hotel.model.Enum.TipoHabitacion;
import hotel.model.observer.HabitacionesObserver;

import java.util.ArrayList;
import java.util.List;

public class Habitacion implements ComponenteHabitacion {

    private int numero;
    private double precioBase;
    private EstadoHabitacion estado;
    private TipoHabitacion tipo;
    private List<HabitacionesObserver> observadores;

    public Habitacion(int numero, double precioBase, TipoHabitacion tipo) {
        this.numero = numero;
        this.precioBase = precioBase;
        this.tipo = tipo;
        this.estado = EstadoHabitacion.DISPONIBLE;
        this.observadores = new ArrayList<>();
    }

    @Override
    public double getPrecioBase() {
        return precioBase;
    }

    @Override
    public int getNumero() {
        return numero;
    }

    public EstadoHabitacion getEstado() {
        return estado;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }

    public void setEstado(EstadoHabitacion nuevoEstado) {
        this.estado = nuevoEstado;
        notificarObservadores();
    }

    public void reservar() {
        setEstado(EstadoHabitacion.OCUPADA);
    }

    public void liberar() {
        setEstado(EstadoHabitacion.DISPONIBLE);
    }

    public void registrarObservador(HabitacionesObserver observer) {
        observadores.add(observer);
    }

    private void notificarObservadores() {
        for (HabitacionesObserver observer : observadores) {
            observer.actualizarEstado(numero, estado);
        }
    }
}