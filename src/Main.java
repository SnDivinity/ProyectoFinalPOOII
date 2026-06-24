//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import Controlador.*;
import Modelo.*;
import Modelo.Factory.CreadorEventoAbstracto;
import Modelo.Factory.EventoVerano;
import Vista.*;
void main() {
    AsignarMenuModelo asignar = new AsignarMenuModelo();
    MostrarMenu mostrarMenu = new MostrarMenu();

    AsignarMenu controlador = new AsignarMenu(asignar,mostrarMenu);

    eventoControlador evento = new eventoControlador();



    //controlador.run();

}
