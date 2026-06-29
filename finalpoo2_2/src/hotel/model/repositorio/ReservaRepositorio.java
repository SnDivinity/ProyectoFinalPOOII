package hotel.model.repositorio;

import hotel.model.Reserva;

public class ReservaRepositorio extends RepositorioBase<Reserva> {

    public Reserva buscarId(int id) {

        for (Reserva reserva : elementos) {

            if (reserva.getIdReserva() == id) {
                return reserva;
            }

        }

        return null;
    }

}