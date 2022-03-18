package pacopaquetes.envios;

import enums.PRIORIDAD;

public class Paquete{
    private PRIORIDAD tipo;
    private int pesoTotal;
    private int id;
    private int nintentos;

    public Paquete(PRIORIDAD tipo, int pesoT, int id, int nint){
        this.nintentos = nint;
        this.pesoTotal = pesoT;
        this.tipo = tipo;
        this.id = id;
    }

    //===============SETS===============//

    public void setTipo(PRIORIDAD t){
        this.tipo = t;
    }

    public void setPesoTotal(int p){
        this.pesoTotal = p;
    }

    public void setid(int i){
        this.id = i;
    }

    public void setNIntentos(int n){
        this.nintentos = n;
    }

    //===============GETS===============//

    public PRIORIDAD getTipo(){
        return this.tipo;
    }

    public int getPesoTotal(){
        return this.pesoTotal;
    }

    public int getId(){
        return this.id;
    }

    public int getNIntentos(){
        return this.nintentos;
    }


}