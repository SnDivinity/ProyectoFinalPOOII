package hotel.controlador;

import java.util.ArrayList;
import java.util.List;

public class RepositorioBase<T> {

    protected List<T> elementos;

    public RepositorioBase() {
        elementos = new ArrayList<>();
    }

    public void guardar(T item) {
        elementos.add(item);
    }

    public void eliminar(T item) {
        elementos.remove(item);
    }

    public List<T> obtenerTodos() {
        return elementos;
    }
}