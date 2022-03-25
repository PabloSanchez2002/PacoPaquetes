package pacopaquetes;

import enums.TIPOCAMION;

public class Camion{
    private String matricula;
    private int pesoMax;
    private TIPOCAMION tipo;
    private boolean averiado;

    public Camion(String mat,int pesoM,TIPOCAMION tipo){
        this.matricula = mat;
        this.pesoMax = pesoM;
        this.tipo = tipo;
        this.averiado=false;
    }

    //===============SETS===============//

    public void setmatricula(String s){
        this.matricula = s;
    }

    public void setPesoMax(int i){
        this.pesoMax = i;
    }

    public void setTipo(TIPOCAMION t){
        this.tipo = t;
    }

    public void setAveriado(boolean av){
        this.averiado = av;
    }

    //===============GETS===============//

    public String getMatricula(){
        return this.matricula;
    }

    public int getPesoMax(){
        return this.pesoMax;
    }

    public TIPOCAMION getTipo(){
        return this.tipo;
    }

     public boolean getAveriado(){
        return this.averiado;
    }
}