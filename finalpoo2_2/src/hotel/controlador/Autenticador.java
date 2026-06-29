package hotel.controlador;

import hotel.model.Usuario;
import hotel.model.UsuarioFactory;

public class Autenticador {
    private UsuarioRepository usuarioRepo;

    public Autenticador(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    public void registrarNuevoUsuario(UsuarioFactory factory, String id, String nombre, String correo, String password) {
        Usuario nuevoUsuario = factory.crearUsuario(id, nombre, correo, password);
        usuarioRepo.guardar(nuevoUsuario);
    }
}