package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RegistroHotel<T> {
    private List<T> listaElementos;

    public RegistroHotel() {
        this.listaElementos = new ArrayList<>();
    }

    public void registrar(T elemento) {
        listaElementos.add(elemento);
    }


    public List<T> obtenerTodos() {
        return listaElementos;
    }


    public List<T> filtrar(Predicate<T> condicion) {
        return listaElementos.stream()
                .filter(condicion)
                .collect(Collectors.toList());
    }


    public Optional<T> buscar(Predicate<T> condicion) {
        return listaElementos.stream()
                .filter(condicion)
                .findFirst();
    }
}
