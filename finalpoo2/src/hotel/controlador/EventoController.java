package hotel.controlador;

import hotel.model.EstadoSalon;
import hotel.model.EvaluadorDescuento;
import hotel.model.ReservaEvento;
import hotel.model.Salon;
import hotel.repositorio.ReservaEventoRepositorio;
import hotel.repositorio.SalonRepositorio;

public class EventoController {

    private SalonRepositorio salonRepo;
    private ReservaEventoRepositorio reservaRepo;
    private int contadorReservas;

    public EventoController() {
        salonRepo = new SalonRepositorio();
        reservaRepo = new ReservaEventoRepositorio();
        contadorReservas = 1;
    }

    public ReservaEvento cotizarEvento(int idSalon, int asis, EvaluadorDescuento desc) {

        Salon salon = salonRepo.buscarPorId(idSalon);

        if (salon == null) {
            return null;
        }

        /*
         * AQUÍ debes usar el constructor que tenga tu clase ReservaEvento.
         * Si tu constructor es diferente, cambia solamente esta línea.
         */
        ReservaEvento reserva = new ReservaEvento();

        reserva.setIdReservaEvento(contadorReservas++);
        reserva.setSalon(salon);
        reserva.setCantidadAsistentes(asis);

        double subtotal = reserva.calcularMontoNeto();

        if (desc != null) {
            subtotal = desc.aplicarDescuento(subtotal);
        }

        reserva.setTotalCotizado(subtotal);

        return reserva;
    }

    public boolean confirmarYGuardarReserva(ReservaEvento reserva) {

        if (reserva == null) {
            return false;
        }

        reserva.confirmarReserva();
        reservaRepo.guardar(reserva);

        return true;
    }

    public boolean consultarDisponibilidadFechas(int idSalon) {

        Salon salon = salonRepo.buscarPorId(idSalon);

        if (salon == null) {
            return false;
        }

        return salon.getEstado() == EstadoSalon.DISPONIBLE;
    }
}