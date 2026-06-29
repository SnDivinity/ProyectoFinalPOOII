package hotel.model;

import java.util.ArrayList;
import java.util.List;

public class InventarioBase<T> {

    private List<T> items;

    public InventarioBase() {
        items = new ArrayList<>();
    }

    public void agregar(T item) {
        items.add(item);
    }

    public void eliminar(T item) {
        items.remove(item);
    }

    public List<T> obtenerTodos() {
        return new ArrayList<>(items);
    }

    public List<T> buscar() {
        return new ArrayList<>(items);
    }
}