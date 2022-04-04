/**
 * 
 * Esta clase es del Camion
 *
 * @author Pablo Sanchez, Mikel Riskez y Alberto Vicente
 *
 */
package pacopaquetes;

import java.io.Serializable;

import enums.TIPOCAMION;

public class Camion implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Matricula
     */
    private String matricula;
    /**
     * Peso maximo que carga
     */
    private int pesoMax;
    /**
     * Tipo de camion
     */
    private TIPOCAMION tipo;
    /**
     * Boolean si esta cargado o no
     */
    private Boolean cargado;
    /**
     * Boolean para saber si esta averiado o no
     */
    private Boolean averiado;

    /**
     * Contructor de camion
     * 
     * @param mat   matricula
     * @param pesoM peso Maximo
     * @param tipo  tipo de camion
     */
    public Camion(String mat, int pesoM, TIPOCAMION tipo) {
        this.matricula = mat;
        this.pesoMax = pesoM;
        this.tipo = tipo;
        this.averiado = false;
        this.cargado = false;
    }

    // ===============SETS===============//
    /**
     * Establece una matricula
     *
     * @param s matricula
     */
    public void setmatricula(String s) {
        this.matricula = s;
    }

    /**
     * Establece un peso Maximo
     *
     * @param i peso maximo
     */
    public void setPesoMax(int i) {
        this.pesoMax = i;
    }

    /**
     * Establece el tipo de camion
     *
     * @param t tipo de camion
     */
    public void setTipo(TIPOCAMION t) {
        this.tipo = t;
    }

    /**
     * Establece si un camion esta averiado o no
     *
     * @param av si esta averiado o no
     */
    public void setAveriado(boolean av) {
        this.averiado = av;
    }

    /**
     * Establece si un camion esta cargado
     *
     * @param car si esta cargado o no
     */
    public void setCargado(boolean car) {
        this.cargado = car;
    }

    // ===============GETS===============//
    /**
     * Devuelve la matricula
     *
     * @return String matricula
     */
    public String getMatricula() {
        return this.matricula;
    }

    /**
     * Devuelve el peso maximo
     *
     * @return int peso maximo
     */
    public int getPesoMax() {
        return this.pesoMax;
    }

    /**
     * Devuelve el tipo de camion
     *
     * @return TIPOCAMION tipo de camion
     */
    public TIPOCAMION getTipo() {
        return this.tipo;
    }

    /**
     * Devuelve si esta averiado o no
     * 
     * @return boolean
     */
    public boolean getAveriado() {
        return this.averiado;
    }

    /**
     * Devuelve si esta cargado o no
     * 
     * @return boolean
     */
    public boolean getCargado() {
        return this.cargado;
    }
}