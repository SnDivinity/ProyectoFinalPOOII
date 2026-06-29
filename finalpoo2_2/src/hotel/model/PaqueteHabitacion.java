package hotel.model;

import java.util.ArrayList;
import java.util.List;

public class PaqueteHabitacion implements ComponenteHabitacion {

    private int numeroPaquete;
    private List<ComponenteHabitacion> componentes;

    public PaqueteHabitacion(int numeroPaquete) {
        this.numeroPaquete = numeroPaquete;
        this.componentes = new ArrayList<>();
    }

    @Override
    public double getPrecioBase() {
        double total = 0;

        for (ComponenteHabitacion componente : componentes) {
            total += componente.getPrecioBase();
        }

        return total;
    }

    @Override
    public int getNumero() {
        return numeroPaquete;
    }

    public void agregarComponente(ComponenteHabitacion comp) {
        componentes.add(comp);
    }

    public List<ComponenteHabitacion> getComponentes() {
        return componentes;
    }
}