package hotel.vista;

import hotel.controlador.ReporteController;
import hotel.model.RegistroLog;

import java.util.List;

public class PanelAuditoriaVista {

    private ReporteController controlador;

    public PanelAuditoriaVista(ReporteController controlador){

        this.controlador=controlador;

    }

    public void mostrarLogsEnPantalla(List<RegistroLog> logs){

        for(RegistroLog log:logs){

            System.out.println(log);

        }

    }

    public void advertirFalloCritico(){

        System.out.println("ALERTA: Existe un fallo crítico.");

    }

}