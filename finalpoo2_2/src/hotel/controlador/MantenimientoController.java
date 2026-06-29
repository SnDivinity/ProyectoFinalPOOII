package hotel.controlador;

import hotel.model.OrdenTrabajo;
import hotel.model.PersonalLimpieza;
import hotel.model.Enum.Prioridad;
import hotel.model.Enum.TipoOrden;

import java.util.List;

public class MantenimientoController {

    private MantenimientoRepositorio mainRepo;
    private PersonalRepositorio personalRepo;
    private BuscadorOrdenes buscar;

    private int contadorOrdenes = 1;

    public MantenimientoController() {

        mainRepo = new MantenimientoRepositorio();
        personalRepo = new PersonalRepositorio();
        buscar = new BuscadorOrdenes();

    }

    public void crearOrdenTrabajo(int idHabitacion,
                                  TipoOrden tipo,
                                  Prioridad prioridad,
                                  String descripcion) {

        OrdenTrabajo orden = new OrdenTrabajo(
                contadorOrdenes++,
                idHabitacion,
                tipo,
                prioridad,
                descripcion
        );

        mainRepo.guardar(orden);
    }

    public boolean asignarYEjecutarAseo(int idHabitacion) {

        List<OrdenTrabajo> ordenes =
                mainRepo.buscarPorHabitacion(idHabitacion);

        if (ordenes.isEmpty()) {
            return false;
        }

        List<PersonalLimpieza> disponibles =
                personalRepo.obtenerPersonalDisponible();

        if (disponibles.isEmpty()) {
            return false;
        }

        OrdenTrabajo orden = ordenes.get(0);

        PersonalLimpieza empleado = disponibles.get(0);

        orden.asignarPersonal(empleado);

        Thread hilo = new Thread(
                new TareaLimpieza(idHabitacion, mainRepo));

        hilo.start();

        return true;
    }

    public MantenimientoRepositorio getMainRepo() {
        return mainRepo;
    }

    public PersonalRepositorio getPersonalRepo() {
        return personalRepo;
    }

    public BuscadorOrdenes getBuscar() {
        return buscar;
    }
}