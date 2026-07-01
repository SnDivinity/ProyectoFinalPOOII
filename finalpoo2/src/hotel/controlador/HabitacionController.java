package hotel.controlador;

import hotel.concurrencia.BuscadorHabitaciones;
import hotel.concurrencia.GestorConcurrenciaHabitaciones;
import hotel.factory.HabitacionDobleFactory;
import hotel.factory.HabitacionFactory;
import hotel.factory.HabitacionSimpleFactory;
import hotel.factory.HabitacionSuiteFactory;
import hotel.model.ComponenteHabitacion;
import hotel.model.Habitacion;
import hotel.model.InventarioBase;
import hotel.model.TipoHabitacion;
import hotel.observer.HabitacionesObserver;

import java.util.ArrayList;
import java.util.List;

public class HabitacionController {

    private InventarioBase<ComponenteHabitacion> inventario;
    private HabitacionFactory factory;
    private BuscadorHabitaciones buscador;
    private GestorConcurrenciaHabitaciones gestor;
    private List<HabitacionesObserver> observers;

    public HabitacionController(HabitacionFactory factory) {
        this.factory = factory;
        this.inventario = new InventarioBase<>();
        this.buscador = new BuscadorHabitaciones();
        this.gestor = new GestorConcurrenciaHabitaciones();
        this.observers = new ArrayList<>();
    }

    public HabitacionController() {
        this.inventario = new InventarioBase<>();
        this.buscador = new BuscadorHabitaciones();
        this.gestor = new GestorConcurrenciaHabitaciones();
        this.observers = new ArrayList<>();
    }

    public void registrarObserver(HabitacionesObserver observer) {
        observers.add(observer);
    }

    public void eliminarObserver(HabitacionesObserver observer) {
        observers.remove(observer);
    }

    private void notificar(Habitacion habitacion) {
        for (HabitacionesObserver observer : observers) {
            observer.actualizarEstado(
                    habitacion.getNumero(),
                    habitacion.getEstado());
        }
    }

    public void agregarHabitacion(int numero,
                                  double precio,
                                  TipoHabitacion tipo) {

        HabitacionFactory factoryDelTipo = obtenerFactory(tipo);

        ComponenteHabitacion habitacion =
                factoryDelTipo.crearHabitacion(numero, precio);

        inventario.agregar(habitacion);
    }

    private HabitacionFactory obtenerFactory(TipoHabitacion tipo) {
        switch (tipo) {
            case DOBLE:
                return new HabitacionDobleFactory();
            case SUITE:
                return new HabitacionSuiteFactory();
            case SIMPLE:
            default:
                return new HabitacionSimpleFactory();
        }
    }

    public List<ComponenteHabitacion> obtenerHabitaciones() {
        return inventario.obtenerTodos();
    }

    public List<Habitacion> buscarHabitaciones(TipoHabitacion tipo) {
        return buscador.buscarDisponibles(
                inventario.obtenerTodos(),
                tipo);
    }

    public void reservarHabitacion(Habitacion habitacion) {

        gestor.ejecutarAsignacionSegura(
                habitacion.getNumero(),
                () -> {
                    habitacion.reservar();
                    notificar(habitacion);
                });

    }

    public void liberarHabitacion(Habitacion habitacion) {

        gestor.ejecutarAsignacionSegura(
                habitacion.getNumero(),
                () -> {
                    habitacion.liberar();
                    notificar(habitacion);
                });

    }
}