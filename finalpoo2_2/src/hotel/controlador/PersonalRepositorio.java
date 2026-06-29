package hotel.controlador;

import hotel.model.PersonalLimpieza;
import hotel.model.PersonalLimpieza;

import java.util.ArrayList;
import java.util.List;

public class PersonalRepositorio extends RepositorioBase<PersonalLimpieza> {

    public List<PersonalLimpieza> obtenerPersonalDisponible() {

        List<PersonalLimpieza> disponibles = new ArrayList<>();

        for (PersonalLimpieza p : elementos) {
            if (p.isDisponible()) {
                disponibles.add(p);
            }
        }

        return disponibles;
    }
}