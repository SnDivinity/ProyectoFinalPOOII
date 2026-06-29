package hotel.model;

public interface UsuarioFactory {
    Usuario crearUsuario(String id, String nombre, String correo, String password);
}

// Fábrica para Huéspedes
class HuespedFactory implements UsuarioFactory {
    private String nroPasaporte;

    public HuespedFactory(String nroPasaporte) {
        this.nroPasaporte = nroPasaporte;
    }

    @Override
    public Usuario crearUsuario(String id, String nombre, String correo, String password) {
        return new Huesped(id, nombre, correo, password, nroPasaporte);
    }
}

// Fábrica para Recepcionistas
class RecepcionistaFactory implements UsuarioFactory {
    private String turno;
    private int nroCajaAsignada;

    public RecepcionistaFactory(String turno, int nroCajaAsignada) {
        this.turno = turno;
        this.nroCajaAsignada = nroCajaAsignada;
    }

    @Override
    public Usuario crearUsuario(String id, String nombre, String correo, String password) {
        return new Recepcionista(id, nombre, correo, password, turno, nroCajaAsignada);
    }
}

// Fábrica para Administradores
class AdministradorFactory implements UsuarioFactory {
    private int nivelAcceso;

    public AdministradorFactory(int nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    @Override
    public Usuario crearUsuario(String id, String nombre, String correo, String password) {
        return new Administrador(id, nombre, correo, password, nivelAcceso);
    }
}