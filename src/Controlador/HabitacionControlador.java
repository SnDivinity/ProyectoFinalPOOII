package Controlador;
import Modelo.Builder.*;
import Modelo.Factory.Evento;
import Modelo.RegistroHotel;

import java.util.List;

public class HabitacionControlador {

    RegistroHotel<Habitacion> inventario = new RegistroHotel<>();

    void crearHabitacion(){
        BuilderHabitacion builder = new HabitacionConcreta("102","Una");

        Habitacion habitacion1 = builder.conMinibar(true)
                .conJacuzzi(false)
                .conVistaAlMar(true)
                .build();
        inventario.registrar(habitacion1);
    }

    void procesarHabitacion(){
        System.out.println("Reporte 1: Habitaciones con Vista al Mar");
        List<Habitacion> deLujo = inventario.filtrar(hab -> hab.isVistaAlMar() && hab.isTieneMinibar());


        deLujo.forEach(System.out::println);


        System.out.println("Reporte 2: Buscar si la habitación 505 tiene Jacuzzi ");
        inventario.buscar(hab -> hab.getNumero().equals("505"))
                .ifPresentOrElse(
                        hab -> System.out.println("La 505 existe. ¿Tiene Jacuzzi? " + (hab.isTieneJacuzzi() ? "Sí" : "No")),
                        () -> System.out.println("No se encontró la habitación 505.")
                );
    }
    }
}
