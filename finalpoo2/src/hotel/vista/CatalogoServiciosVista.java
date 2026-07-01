package hotel.vista;

import hotel.controlador.ServicioController;
import hotel.model.ServicioExtra;
import hotel.model.TipoServicio;
import java.util.List;

public class CatalogoServiciosVista {
    private ServicioController controlador;

    public CatalogoServiciosVista(ServicioController controlador) {
        this.controlador = controlador;
    }

    public void mostrarCatalogoCompleto(List<ServicioExtra> servicios) {
        System.out.println("--- CATÁLOGO DE SERVICIOS DEL HOTEL ---");
        for (ServicioExtra s : servicios) {
            System.out.println("[" + s.getIdServicio() + "] " + s.getNombre() + " (" + s.getTipo() + ") - $" + s.getPrecioBase());
        }
    }

    public void mostrarCatalogoPorTipo(List<ServicioExtra> servicios, TipoServicio tipo) {
        System.out.println("--- SERVICIOS DE TIPO: " + tipo + " ---");
        List<ServicioExtra> filtrados = controlador.getBuscador().filtrarServiciosPorTipo(servicios, tipo);
        for (ServicioExtra s : filtrados) {
            System.out.println("[" + s.getIdServicio() + "] " + s.getNombre() + " - $" + s.getPrecioBase());
        }
    }

    public void solicitarDatosConsumo() {
        System.out.println("Por favor, ingrese el ID de la reserva, ID del servicio y la cantidad consumida.");
    }
}