package hotel.repositorio;

import java.util.ArrayList;
import java.util.List;

import hotel.model.ReservaEvento;

public class ReservaEventoRepositorio extends RepositorioBase<ReservaEvento>{

    public List<ReservaEvento> buscarReservasPorHuesped(int idHuesped){

        List<ReservaEvento> lista = new ArrayList<>();

        for(ReservaEvento r : elementos){

            if(r.getIdHuesped()==idHuesped){
                lista.add(r);
            }

        }

        return lista;

    }

    public void cancelarReserva(int idReserva){

        for(ReservaEvento r : elementos){

            if(r.getIdReservaEvento()==idReserva){

                r.cancelarReserva();

                break;
            }

        }

    }

}