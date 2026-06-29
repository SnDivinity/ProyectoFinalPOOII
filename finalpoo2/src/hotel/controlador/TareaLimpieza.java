package hotel.controlador;

import hotel.model.OrdenTrabajo;

import java.util.List;

public class TareaLimpieza implements Runnable {

    private int idHabitacion;
    private MantenimientoRepositorio ordenRepo;

    public TareaLimpieza(int idHabitacion,
                         MantenimientoRepositorio ordenRepo) {

        this.idHabitacion = idHabitacion;
        this.ordenRepo = ordenRepo;
    }

    @Override
    public void run() {

        try {

            Thread.sleep(3000);

            List<OrdenTrabajo> lista =
                    ordenRepo.buscarPorHabitacion(idHabitacion);

            if (!lista.isEmpty()) {

                lista.get(0).marcarComoCompletada();

                System.out.println(
                        "Habitación "
                                + idHabitacion
                                + " finalizada."
                );

            }

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

    }
}