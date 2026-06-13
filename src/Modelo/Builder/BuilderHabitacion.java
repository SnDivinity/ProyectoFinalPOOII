package Modelo.Builder;

public interface BuilderHabitacion {
    BuilderHabitacion conJacuzzi(boolean tieneJacuzzi);
    BuilderHabitacion conMinibar(boolean tieneMinibar);
    BuilderHabitacion conVistaAlMar(boolean vistaAlMar);
    BuilderHabitacion modificarCamas(int cantidadCamas);

    Habitacion build();
}
