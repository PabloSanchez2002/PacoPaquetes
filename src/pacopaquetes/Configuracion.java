/**
 * 
 * Esta clase es del Configuración
 *
 * @author Pablo Sanchez, Mikel Risquez y Alberto Vicente
 *
 */
package pacopaquetes;

import java.io.Serializable;

public class Configuracion implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Numero de reintentos
     */
    private int reintentos = 3;
    /**
     * maximo volumen admitido
     */
    private int maxVolume = 12000;
    /**
     * maximo numero de paquetes por
     */

    private double descuento = 0.1;
    /**
     * maximo numero de codigos postales
     */
    private int maxCodPostales = 10;
    /**
     * maximo peso por paquete nomal
     */
    private int maxPesoPaqNormal = 30;
    /**
     * maximo peso por paquete fragil
     */
    private int maxPesoPaqFragil = 20;

    public Configuracion() {
    }

    // ================SETS===============//
    /**
     * Cambia el numero de intentos
     * 
     * @param i numero de intentos
     */
    public void setReintentos(int i) {
        this.reintentos = i;
    }

    /**
     * Cambia el maximo volumen por paquete
     * 
     * @param i maximo volumen
     */
    public void setMaxVolume(int i) {
        this.maxVolume = i;
    }

    /**
     * Cambia el porcentaje de descuento
     * 
     * @param i descuento
     */
    public void setDescuento(int i) {
        this.descuento = i;
    }

    /**
     * Establece el maximo de codigos postales
     *
     * @param i maximo de codigos postales
     */
    public void setMaxCodPostales(int i) {
        this.maxCodPostales = i;
    }

    /**
     * Establece el peso maximo de paquetes normales
     *
     * @param i peso maximo
     */
    public void setmaxPesoPaqNormal(int i) {
        this.maxPesoPaqNormal = i;
    }

    /**
     * Establece el peso maximo de paquetes fragiles
     *
     * @param i peso maximo
     */
    public void setmaxPesoPaqFragil(int i) {
        this.maxPesoPaqFragil = i;
    }

    /**
     * Devuelve el maximo de reintentos de la empresa
     * 
     * @return int numero max de reintentos
     */
    // ================SETS===============//
    public int getReintentos() {
        return this.reintentos;
    }

    /**
     * Devuelve el volumen maximo de los paquetes
     * 
     * @return int volumen maximo
     */
    public int getMaxVolume() {
        return this.maxVolume;
    }

    /**
     * Devuelve el descuento de la empresa
     * 
     * @return double descuento
     */
    public double getDescuento() {
        return this.descuento;
    }

    /**
     * Devuelve el maximo de codigos portales
     * 
     * @return int maximo de codigos postales
     */
    public int getMaxCodPostales() {
        return this.maxCodPostales;
    }

    /**
     * Devuelve el peso maximo de los paquetes normales
     * 
     * @return int peso maximo normal
     */
    public int getmaxPesoPaqNormal() {
        return this.maxPesoPaqNormal;
    }

    /**
     * Devuelve el peso maximo de los paquetes fragiles
     * 
     * @return int peso maximo fragil
     */
    public int getmaxPesoPaqFragil() {
        return this.maxPesoPaqFragil;
    }
}
