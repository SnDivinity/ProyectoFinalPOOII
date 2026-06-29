package hotel.model;

import hotel.model.Enum.RolUsuario;

import java.util.ArrayList;
import java.util.List;

public class Huesped extends Usuario {
    private List<Integer> historialReservas;
    private String nroPasaporte;

    public Huesped(String id, String nombre, String correo, String contrasena, String nroPasaporte) {
        super(id, nombre, correo, contrasena, RolUsuario.HUESPED);
        this.nroPasaporte = nroPasaporte;
        this.historialReservas = new ArrayList<>();
    }

    public List<Integer> getHistorialReservas() { return historialReservas; }
    public String getNroPasaporte() { return nroPasaporte; }
}