package hotel.controlador;

import hotel.auditoria.AnalizadorLogs;
import hotel.model.AuditoriaLogger;
import hotel.model.NivelSeguridad;
import hotel.model.RegistroLog;
import hotel.model.ReporteGenerador;
import hotel.repositorio.AuditoriaRepositorio;

import java.time.LocalDateTime;
import java.util.List;

public class ReporteController {

    private AuditoriaRepositorio logRepo;
    private AnalizadorLogs analizador;
    private AuditoriaLogger loggerText;
    private ReporteGenerador generadorActual;

    public ReporteController(){

        logRepo=new AuditoriaRepositorio();
        analizador=new AnalizadorLogs();
        loggerText=new AuditoriaLogger();

    }

    public void registrarAccionSistema(String usuario,
                                       String accion,
                                       NivelSeguridad nivel){

        RegistroLog log=new RegistroLog();

        log.setUsuario(usuario);
        log.setAccion(accion);
        log.setNivel(nivel);
        log.setTimestamp(LocalDateTime.now());

        logRepo.guardar(log);

        loggerText.escribirLogTexto(log);

    }

    public void configurarGeneradorReporte(ReporteGenerador generador){

        this.generadorActual=generador;

    }

    public double ejecutarReporte(List<Object> datos){

        if(generadorActual==null){
            return 0;
        }

        return generadorActual.generarMetricas(datos);

    }

}