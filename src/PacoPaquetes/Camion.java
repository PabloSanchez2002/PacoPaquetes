package PacoPaquetes;

import Enums.TIPOCAMION;

public class Camion{
    private String matricula;
    private int pesoMax;
    private TIPOCAMION tipo;

    public Camion(String mat,int pesoM,TIPOCAMION tipo){
        this.matricula = mat;
        this.pesoMax = pesoM;
        this.tipo = tipo;
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


}