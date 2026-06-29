package hotel.vista;

import hotel.model.Usuario;
import java.util.List;

public class GestionUsuariosVista {

    public void listarUsuarios(List<Usuario> usuarios) {
        System.out.println("=== LISTA DE USUARIOS EN EL SISTEMA ===");
        for (Usuario u : usuarios) {
            System.out.println("ID: " + u.getId() + " | Nombre: " + u.getNombre() +
                    " | Rol: " + u.getRol() + " | Correo: " + u.getCorreo());
        }
    }
}