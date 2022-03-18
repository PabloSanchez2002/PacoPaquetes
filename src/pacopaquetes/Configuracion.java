package pacopaquetes;

public class Configuracion {
    private int reintentos = 3;
    private int maxVolume = 200;
    private int maxNumPaquetes = 20;
    private int descuento = 10;
    private int maxCodPostales = 10;

    public Configuracion(){}

    //================SETS===============//
    public void setReintentos(int i){
        this.reintentos = i;
    }
    public void setMaxVolume(int i){
        this.maxVolume = i;
    }
    public void setMaxNumPaquetes(int i){
        this.maxNumPaquetes = i;
    }
    public void setDescuento(int i){
        this.descuento = i;
    }
    public void setMaxCodPostales(int i){
        this.maxCodPostales = i;
    }

    //================SETS===============//
    public int getReintentos(){
        return this.reintentos;
    }
    public int getMaxVolume(){
        return this.maxVolume;
    }
    public int getMaxNumPaquetes(){
        return this.maxNumPaquetes;
    }
    public int getDescuento(){
        return this.descuento;
    }
    public int getMaxCodPostales(){
        return this.maxCodPostales;
    }

}
