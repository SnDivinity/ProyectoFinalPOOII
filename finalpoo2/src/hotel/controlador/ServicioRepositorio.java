package hotel.controlador;

import hotel.model.ServicioExtra;
import java.util.List;

public class ServicioRepositorio extends RepositorioBase<ServicioExtra> {

    public ServicioExtra buscarPorIdServicio(int id) {
        return elementos.stream()
                .filter(s -> s.getIdServicio() == id)
                .findFirst()
                .orElse(null);
    }

    public ServicioExtra buscarPorNombre(String nombre) {
        return elementos.stream()
                .filter(s -> s.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }
}