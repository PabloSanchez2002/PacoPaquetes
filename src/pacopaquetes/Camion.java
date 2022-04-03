package pacopaquetes;

import java.io.Serializable;

import enums.TIPOCAMION;

public class Camion implements Serializable {
    private static final long serialVersionUID = 1L;
    private String matricula;
    private int pesoMax;
    private TIPOCAMION tipo;
    private Boolean cargado;
    private boolean averiado;

    public Camion(String mat, int pesoM, TIPOCAMION tipo) {
        this.matricula = mat;
        this.pesoMax = pesoM;
        this.tipo = tipo;
        this.averiado = false;
        this.cargado = false;
    }

    // ===============SETS===============//

    public void setmatricula(String s) {
        this.matricula = s;
    }

    public void setPesoMax(int i) {
        this.pesoMax = i;
    }

    public void setTipo(TIPOCAMION t) {
        this.tipo = t;
    }

    public void setAveriado(boolean av) {
        this.averiado = av;
    }

    public void setCargado(boolean car) {
        this.cargado = car;
    }

    // ===============GETS===============//

    public String getMatricula() {
        return this.matricula;
    }

    public int getPesoMax() {
        return this.pesoMax;
    }

    public TIPOCAMION getTipo() {
        return this.tipo;
    }

    public boolean getAveriado() {
        return this.averiado;
    }

    public boolean getCargado() {
        return this.cargado;
    }
}