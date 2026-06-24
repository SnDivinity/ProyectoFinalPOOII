package Modelo.Builder;

public class Habitacion {
    private String numero;
    private String tipo;
    private boolean tieneJacuzzi;
    private boolean tieneMinibar;
    private boolean vistaAlMar;
    private int cantidadCamas;

    public Habitacion(String numero, String tipo, boolean tieneJacuzzi, boolean tieneMinibar, boolean vistaAlMar, int cantidadCamas) {
        this.numero = numero;
        this.tipo = tipo;
        this.tieneJacuzzi = tieneJacuzzi;
        this.tieneMinibar = tieneMinibar;
        this.vistaAlMar = vistaAlMar;
        this.cantidadCamas = cantidadCamas;
    }

    public String getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isTieneJacuzzi() {
        return tieneJacuzzi;
    }

    public boolean isTieneMinibar() {
        return tieneMinibar;
    }

    public boolean isVistaAlMar() {
        return vistaAlMar;
    }

    public int getCantidadCamas() {
        return cantidadCamas;
    }

    @Override
    public String toString() {
        return "Habitación N° " + numero + " [" + tipo + "] -> " +
                "Camas: " + cantidadCamas +
                " | Jacuzzi: " + (tieneJacuzzi ? "Sí" : "No") +
                " | Minibar: " + (tieneMinibar ? "Sí" : "No") +
                " | Vista al Mar: " + (vistaAlMar ? "Sí" : "No");
    }
}
