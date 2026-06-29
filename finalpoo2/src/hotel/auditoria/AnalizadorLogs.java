package hotel.auditoria;

import hotel.model.NivelSeguridad;
import hotel.model.RegistroLog;

import java.util.ArrayList;
import java.util.List;

public class AnalizadorLogs {

    public List<RegistroLog> filtrarLogsCriticos(List<RegistroLog> lista){

        List<RegistroLog> resultado = new ArrayList<>();

        for(RegistroLog log : lista){

            if(log.getNivel() == NivelSeguridad.CRITICO){
                resultado.add(log);
            }

        }

        return resultado;

    }

    public List<RegistroLog> buscarLogsPorUsuario(List<RegistroLog> lista,String usuario){

        List<RegistroLog> resultado = new ArrayList<>();

        for(RegistroLog log : lista){

            if(log.getUsuario().equalsIgnoreCase(usuario)){
                resultado.add(log);
            }

        }

        return resultado;

    }

}