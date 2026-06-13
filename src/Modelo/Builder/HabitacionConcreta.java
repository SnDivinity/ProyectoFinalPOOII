package Modelo.Builder;

public class HabitacionConcreta implements BuilderHabitacion{
    private String numero;
    private String tipo;
    private boolean tieneJacuzzi = false;
    private boolean tieneMinibar = false;
    private boolean vistaAlMar = false;
    private int cantidadCamas = 1;

    public HabitacionConcreta(String numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }


    @Override
    public BuilderHabitacion conJacuzzi(boolean tieneJacuzzi) {
        this.tieneJacuzzi = tieneJacuzzi;
        return this; // Retornamos la interfaz para poder encadenar
    }

    @Override
    public BuilderHabitacion conMinibar(boolean tieneMinibar) {
        this.tieneMinibar = tieneMinibar;
        return this;
    }

    @Override
    public BuilderHabitacion conVistaAlMar(boolean vistaAlMar) {
        this.vistaAlMar = vistaAlMar;
        return this;
    }

    @Override
    public BuilderHabitacion modificarCamas(int cantidadCamas) {
        this.cantidadCamas = cantidadCamas;
        return this;
    }

    @Override
    public Habitacion build() {
        // Llama al constructor de tu clase Habitacion normal
        return new Habitacion(numero, tipo, tieneJacuzzi, tieneMinibar, vistaAlMar, cantidadCamas);
    }
}
