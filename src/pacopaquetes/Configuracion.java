package pacopaquetes;

import java.io.Serializable;

public class Configuracion implements Serializable {
    private static final long serialVersionUID = 1L;
    private int reintentos = 3;
    private int maxVolume = 12000;
    private int maxNumPaquetes = 20;
    private double descuento = 0.1;
    private int maxCodPostales = 10;
    private int maxPesoPaqNormal = 30;
    private int maxPesoPaqFragil = 20;

    public Configuracion() {
    }

    // ================SETS===============//
    public void setReintentos(int i) {
        this.reintentos = i;
    }

    public void setMaxVolume(int i) {
        this.maxVolume = i;
    }

    public void setMaxNumPaquetes(int i) {
        this.maxNumPaquetes = i;
    }

    public void setDescuento(int i) {
        this.descuento = i;
    }

    public void setMaxCodPostales(int i) {
        this.maxCodPostales = i;
    }

    public void setmaxPesoPaqNormal(int i) {
        this.maxPesoPaqNormal = i;
    }

    public void setmaxPesoPaqFragil(int i) {
        this.maxPesoPaqFragil = i;
    }

    // ================SETS===============//
    public int getReintentos() {
        return this.reintentos;
    }

    public int getMaxVolume() {
        return this.maxVolume;
    }

    public int getMaxNumPaquetes() {
        return this.maxNumPaquetes;
    }

    public double getDescuento() {
        return this.descuento;
    }

    public int getMaxCodPostales() {
        return this.maxCodPostales;
    }

    public int getmaxPesoPaqNormal() {
        return this.maxPesoPaqNormal;
    }

    public int getmaxPesoPaqFragil() {
        return this.maxPesoPaqFragil;
    }
}
