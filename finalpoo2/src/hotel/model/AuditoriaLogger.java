package hotel.model;

public class AuditoriaLogger {

    public static final String RUTA_ARCHIVO = "auditoria.txt";

    public void escribirLogTexto(RegistroLog log) {

        System.out.println(log);

    }

}