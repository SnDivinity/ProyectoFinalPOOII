package Modelo.Factory;

public class EventoVerano implements Evento {
    private String nombre;
    private String fecha;

    @Override
    public void asignarDatos() {
        this.nombre = "SunsetDay";
        this.fecha = "24 de junio";
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String detalles() {
        return nombre + " , fecha en :" + fecha;
    }


}
