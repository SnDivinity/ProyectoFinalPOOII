package hotel.vista;

import hotel.model.Usuario;
import java.util.List;

public class GestionUsuariosVista {

    public void listarUsuarios(List<Usuario> usuarios) {
        System.out.println("Lista de Usuarios del Sistema:");
        for (Usuario u : usuarios) {
            System.out.println("ID: " + u.getId() + " | Nombre: " + u.getNombre() +
                    " | Rol: " + u.getRol() + " | Correo: " + u.getCorreo());
        }
    }
}