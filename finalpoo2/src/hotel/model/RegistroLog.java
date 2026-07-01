package hotel.model;

import java.time.LocalDateTime;

public class RegistroLog {

    private int idLog;
    private LocalDateTime timestamp;
    private String usuario;
    private String accion;
    private NivelSeguridad nivel;

    public RegistroLog() {
    }

    public RegistroLog(int idLog, LocalDateTime timestamp, String usuario,
                       String accion, NivelSeguridad nivel) {

        this.idLog = idLog;
        this.timestamp = timestamp;
        this.usuario = usuario;
        this.accion = accion;
        this.nivel = nivel;

    }

    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public NivelSeguridad getNivel() {
        return nivel;
    }

    public void setNivel(NivelSeguridad nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {

        return "RegistroLog{" +
                "idLog=" + idLog +
                ", timestamp=" + timestamp +
                ", usuario='" + usuario + '\'' +
                ", accion='" + accion + '\'' +
                ", nivel=" + nivel +
                '}';

    }

}
