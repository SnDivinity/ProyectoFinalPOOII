package Modelo;

import Modelo.Factory.CreadorEventoAbstracto;
import Modelo.Factory.Evento;
import Modelo.Factory.EventoVerano;

public class CreadorEvento implements CreadorEventoAbstracto {

    @Override
    public Evento crearEvento() {
        return new EventoVerano();
    }
}
