package Controlador;
import Modelo.Strategy.MenuMarino;
import Modelo.Strategy.MenuStrategy;
import Vista.MostrarMenu;
import Modelo.AsignarMenuModelo;
import Core.Controlador;

public class AsignarMenu extends Controlador {
   AsignarMenuModelo asignarMenuModelo;
   MostrarMenu mostrarMenu;

    public AsignarMenu(AsignarMenuModelo asignarMenuModelo,MostrarMenu mostrarMenu){
        this.mostrarMenu = mostrarMenu;
        this.asignarMenuModelo = asignarMenuModelo;
    }


    @Override
    public void run() {
        int opcion = mostrarMenu.mostrar();
        MenuStrategy estrategia;
        switch (opcion){
            case 1:
                System.out.println("No hay el menu disponible");break;
            case 2:
                estrategia = new MenuMarino();
                System.out.println(estrategia.cocinar());break;
            default:


        }
    }
}
