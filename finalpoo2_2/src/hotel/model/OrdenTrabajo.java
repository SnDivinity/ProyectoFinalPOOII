package hotel.model;

import hotel.model.Enum.Prioridad;
import hotel.model.Enum.TipoOrden;

public class OrdenTrabajo {

    private int idOrden;
    private int idHabitacion;
    private TipoOrden tipo;
    private Prioridad prioridad;
    private String descripcion;
    private boolean completada;
    private PersonalLimpieza encargado;

    public OrdenTrabajo(int idOrden, int idHabitacion, TipoOrden tipo,
                        Prioridad prioridad, String descripcion) {
        this.idOrden = idOrden;
        this.idHabitacion = idHabitacion;
        this.tipo = tipo;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
        this.completada = false;
        this.encargado = null;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public TipoOrden getTipo() {
        return tipo;
    }

    public void setTipo(TipoOrden tipo) {
        this.tipo = tipo;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public PersonalLimpieza getEncargado() {
        return encargado;
    }

    public void setEncargado(PersonalLimpieza encargado) {
        this.encargado = encargado;
    }

    public void asignarPersonal(PersonalLimpieza personal) {
        this.encargado = personal;
        if (personal != null) {
            personal.setDisponible(false);
        }
    }

    public void marcarComoCompletada() {
        this.completada = true;
        if (encargado != null) {
            encargado.setDisponible(true);
        }
    }

    @Override
    public String toString() {
        return "OrdenTrabajo{" +
                "idOrden=" + idOrden +
                ", idHabitacion=" + idHabitacion +
                ", tipo=" + tipo +
                ", prioridad=" + prioridad +
                ", descripcion='" + descripcion + '\'' +
                ", completada=" + completada +
                ", encargado=" + encargado +
                '}';
    }
}