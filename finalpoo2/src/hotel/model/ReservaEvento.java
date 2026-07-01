package hotel.model;

import java.util.ArrayList;
import java.util.List;

public class ReservaEvento {

    private int idReservaEvento;
    private int idHuesped;
    private Salon salon;
    private TipoEvento tipo;
    private int cantidadAsistentes;
    private ServicioCatering catering;
    private List<EquipoAudioVisual> equipos;
    private double totalCotizado;

    public ReservaEvento() {
        equipos = new ArrayList<>();
    }

    public ReservaEvento(int idReservaEvento,
                         int idHuesped,
                         Salon salon,
                         TipoEvento tipo,
                         int cantidadAsistentes,
                         ServicioCatering catering) {

        this.idReservaEvento = idReservaEvento;
        this.idHuesped = idHuesped;
        this.salon = salon;
        this.tipo = tipo;
        this.cantidadAsistentes = cantidadAsistentes;
        this.catering = catering;
        this.equipos = new ArrayList<>();
    }

    public int getIdReservaEvento() {
        return idReservaEvento;
    }

    public void setIdReservaEvento(int idReservaEvento) {
        this.idReservaEvento = idReservaEvento;
    }

    public int getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public TipoEvento getTipo() {
        return tipo;
    }

    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }

    public int getCantidadAsistentes() {
        return cantidadAsistentes;
    }

    public void setCantidadAsistentes(int cantidadAsistentes) {
        this.cantidadAsistentes = cantidadAsistentes;
    }

    public ServicioCatering getCatering() {
        return catering;
    }

    public void setCatering(ServicioCatering catering) {
        this.catering = catering;
    }

    public List<EquipoAudioVisual> getEquipos() {
        return equipos;
    }

    public double getTotalCotizado() {
        return totalCotizado;
    }

    public void setTotalCotizado(double totalCotizado) {
        this.totalCotizado = totalCotizado;
    }

    public void agregarEquipoAudiovisual(EquipoAudioVisual eq) {
        equipos.add(eq);
    }

    public void removerEquipoAudiovisual(EquipoAudioVisual eq) {
        equipos.remove(eq);
    }

    public void confirmarReserva() {
        salon.setEstado(EstadoSalon.OCUPADO);
    }

    public void cancelarReserva() {
        salon.setEstado(EstadoSalon.DISPONIBLE);
    }

    public double calcularMontoNeto() {

        double total = salon.getPrecioBase();

        if (catering != null) {
            total += catering.calcularCostoTotalCatering(cantidadAsistentes);
        }

        for (EquipoAudioVisual equipo : equipos) {
            total += equipo.getCostoAlquiler();
        }

        totalCotizado = total;

        return total;
    }

}