package hotel.controlador;

import hotel.model.Usuario;

public class UsuarioRepository extends RepositorioBase<Usuario> {

    public Usuario buscarPorCorreo(String correo) {
        return elementos.stream()
                .filter(u -> u.getCorreo().equalsIgnoreCase(correo))
                .findFirst()
                .orElse(null);
    }
}