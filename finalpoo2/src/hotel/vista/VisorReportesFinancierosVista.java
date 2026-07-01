package hotel.vista;

import hotel.controlador.ReporteController;

public class VisorReportesFinancierosVista {

    private ReporteController controlador;

    public VisorReportesFinancierosVista(ReporteController controlador){

        this.controlador=controlador;

    }

    public void imprimirMetricaCalculada(String titulo,double valor){

        System.out.println(titulo+" : "+valor);

    }

    public void solicitarParametrosReporte(){

        System.out.println("Ingrese los parámetros del reporte.");

    }

}