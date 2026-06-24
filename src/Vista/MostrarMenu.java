package Vista;

import Controlador.AsignarMenu;

import java.util.Scanner;


public class MostrarMenu {
    AsignarMenu menu ;
    Scanner lector = new Scanner(System.in);
    public int mostrar(){
        System.out.println("Bienvenido , escoja su menu");
        System.out.println("1.Menu Clasico(Lomo)");
        System.out.println("2.Menu Marino(Ceviche)");
        System.out.println("3.");

        return lector.nextInt();
    }
}
