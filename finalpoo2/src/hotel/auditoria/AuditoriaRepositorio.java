package hotel.auditoria;

import hotel.model.RegistroLog;
import hotel.repositorio.RepositorioBase;

import java.util.List;

public class AuditoriaRepositorio extends RepositorioBase<RegistroLog> {

    public List<RegistroLog> obtenerTodosLosLogs() {
        return buscarTodos();
    }

}