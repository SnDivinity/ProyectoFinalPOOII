package hotel.vista;

import hotel.controlador.EventoController;

public class CotizadorEventosVista {

    private EventoController controlador;

    public CotizadorEventosVista(EventoController controlador) {
        this.controlador = controlador;
    }

    public void capturarDatosFormulario() {

        System.out.println("Capturando datos del formulario...");

    }

    public void mostrarCotizacionEnPantalla(double total) {

        System.out.println("Total cotizado: S/. " + total);

    }

    public void limpiarCampos() {

        System.out.println("Formulario limpiado.");

    }
}