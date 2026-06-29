package hotel.controlador;

import hotel.model.*;
import java.time.LocalDate;
import java.util.List;

public class ServicioController {
    private ServicioRepositorio servicioRepo;
    private ConsumoRepositorio consumoRepo;
    private BuscadorServicios buscador;
    private int contadorTickets = 0;

    public ServicioController(ServicioRepositorio servicioRepo, ConsumoRepositorio consumoRepo, BuscadorServicios buscador) {
        this.servicioRepo = servicioRepo;
        this.consumoRepo = consumoRepo;
        this.buscador = buscador;
    }

    public void agregarServicioAlCatalogoFactory(IServicioFactory factory, int id, String nom, String desc, double precio) {
        ServicioExtra nuevoServicio = factory.crearServicio(id, nom, desc, precio);
        servicioRepo.guardar(nuevoServicio);
    }

    public boolean registrarConsumoHuesped(int idReserva, int idServicio, int cantidad) {
        ServicioExtra servicio = servicioRepo.buscarPorIdServicio(idServicio);
        if (servicio != null) {
            contadorTickets++;
            TicketConsumo nuevoTicket = new TicketConsumo(contadorTickets, idReserva, servicio, LocalDate.now(), cantidad);
            consumoRepo.guardar(nuevoTicket);
            return true;
        }
        return false;
    }

    public double calcularTotalCargosReserva(int idReserva) {
        List<TicketConsumo> consumos = consumoRepo.obtenerConsumosPorReserva(idReserva);
        return consumos.stream()
                .mapToDouble(TicketConsumo::getSubtotal)
                .sum();
    }

    // Getters auxiliares para las vistas
    public ServicioRepositorio getServicioRepo() { return servicioRepo; }
    public ConsumoRepositorio getConsumoRepo() { return consumoRepo; }
    public BuscadorServicios getBuscador() { return buscador; }
}