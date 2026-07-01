package hotel.controlador;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProcesadorPagoRecurrente {

    private ExecutorService executorService;

    public ProcesadorPagoRecurrente() {
        executorService = Executors.newFixedThreadPool(4);
    }

    public void procesarTransaccionAsincrona(Runnable tarea) {
        executorService.execute(tarea);
    }

    public void cerrarProcesador() {
        executorService.shutdown();
    }
}