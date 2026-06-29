package hotel.model.repositorio;

import hotel.model.RegistroLog;
import java.util.List;

public class AuditoriaRepositorio extends RepositorioBase<RegistroLog> {

    public AuditoriaRepositorio() {
        super();
    }

    public List<RegistroLog> obtenerTodosLosLogs() {
        return buscarTodos();
    }
}