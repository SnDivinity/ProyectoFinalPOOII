package hotel.controlador;

import hotel.model.TicketConsumo;
import java.util.List;
import java.util.stream.Collectors;

public class ConsumoRepositorio extends RepositorioBase<TicketConsumo> {

    public List<TicketConsumo> obtenerConsumosPorReserva(int idReserva) {
        return elementos.stream()
                .filter(t -> t.getIdReserva() == idReserva)
                .collect(Collectors.toList());
    }
}