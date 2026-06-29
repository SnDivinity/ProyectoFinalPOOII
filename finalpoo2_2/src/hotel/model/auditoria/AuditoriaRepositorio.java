package hotel.model.auditoria;

import hotel.model.RegistroLog;
import hotel.model.repositorio.RepositorioBase;

import java.util.List;

public class AuditoriaRepositorio extends RepositorioBase<RegistroLog> {

    public List<RegistroLog> obtenerTodosLosLogs() {
        return buscarTodos();
    }

}