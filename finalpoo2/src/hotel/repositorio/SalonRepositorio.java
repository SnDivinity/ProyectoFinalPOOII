package hotel.repositorio;

import hotel.model.Salon;

public class SalonRepositorio extends RepositorioBase<Salon> {

    public Salon buscarPorId(int id) {

        for (Salon s : elementos) {
            if (s.getIdSalon() == id) {
                return s;
            }
        }

        return null;
    }

}