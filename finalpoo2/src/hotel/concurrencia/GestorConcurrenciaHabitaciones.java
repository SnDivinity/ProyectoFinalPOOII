package hotel.concurrencia;

import java.util.concurrent.locks.ReentrantLock;

public class GestorConcurrenciaHabitaciones {

    private final ReentrantLock cerrojo = new ReentrantLock();

    public void ejecutarAsignacionSegura(int numeroHabitacion,
                                         Runnable tarea) {

        cerrojo.lock();

        try {
            tarea.run();
        } finally {
            cerrojo.unlock();
        }
    }
}