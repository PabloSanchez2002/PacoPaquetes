/**
 * 
 * Esta clase es de los productos alimenticios
 *
 * @author Pablo Sanchez, Mikel Riskez y Alberto Vicente
 *
 */
package pacopaquetes.envios.productos;

import enums.*;
import pacopaquetes.Configuracion;
import pacopaquetes.ModifiableDate;
import pacopaquetes.envios.Paquete;

public class Alimentario extends Producto {
    /**
     * Boolean si es liquido o no
     */
    private Boolean liquido;
    /**
     * Tipo de comida
     */
    private TIPOCOMIDA tipo;

    /**
     * Constructor de la clase alimentario
     *
     * @param num      numero de unidades en el producto
     * @param pesoTot  peso total de todas las unidades del producto
     * @param alto     tamano en altura del producto
     * @param ancho    tamano en anchura del producto
     * @param profundo profundidad del producto
     * @param nombre   nombre del producto
     * @param cp       codigo postal al que se va a entregar el producto
     * @param PR       prioridad del producto
     * @param ni       numero de intentos maximos
     * @param liquido  si es un alimento liquido o no
     * @param tipo2    tipo de alimento que es
     * @param date     fecha de creacion del pedido que contiene el producto
     */
    public Alimentario(int num, float pesoTot, float alto, float ancho, float profundo, String nombre,
            String cp, PRIORIDAD PR, int ni, Boolean liquido, TIPOCOMIDA tipo2, ModifiableDate date) {
        super(num, pesoTot, alto, ancho, profundo, nombre, cp, PR, ni, date);
        this.tipo = tipo2;
        this.liquido = liquido;
    }

    /**
     * Establece un tipo de comida
     *
     * @param t tipo de comida
     */
    public void setTipo(TIPOCOMIDA t) {
        this.tipo = t;
    }

    /**
     * Devuelve de que tipo es la comida
     *
     * @return el tipo de comida
     */
    public TIPOCOMIDA getTipo() {
        return this.tipo;
    }

    /**
     * Establece si es liquido o no
     *
     * @param l si es liquido o no
     */
    public void setLiquido(Boolean l) {
        this.liquido = l;
    }

    /**
     * Devuelve si es liquido o no
     *
     * @return true si es liquido, false en caso contrario
     */
    public boolean getLiquido() {
        return this.liquido;
    }

    /**
     * Calcula el precio de un producto alimentario en base a sus caracteristicas
     *
     * @return un double con el precio del producto
     */
    @Override
    public double getPrecio() {

        double p = 0.5 * getPesoTotal();
        if (getPesoTotal() / getNumUnidades() < 1)
            p += 0.4;
        else if (getPesoTotal() / getNumUnidades() < 5)
            p += 0.6;
        else if (getPesoTotal() / getNumUnidades() < 30)
            p += 1;

        return p * getNumUnidades();
    }

    /**
     * Crea un nuevo paquete en base a la configuracion y anade el producto,
     * si el producto que se crea es de dimensiones especiales, el paquete tambien
     *
     * @param conf la configuracion en la que se basa el paquete
     * @return el Paquete creado con el producto dentro
     */
    public Paquete nuevoPaquete(Configuracion conf) {
        Paquete p;
        if (this.getDimEspecial() == true) {
            p = new Paquete(this.getPrioridad(), TIPOPAQUETE.ESPECIAL, TIPOCOMIDA.NULL,
                    conf.getmaxPesoPaqNormal(), conf.getReintentos(), this.getFecha());
        } else {
            p = new Paquete(this.getPrioridad(), TIPOPAQUETE.COMIDA, this.getTipo(), conf.getmaxPesoPaqNormal(),
                    conf.getReintentos(), this.getFecha());
        }
        p.addProduct(this);
        return p;
    }

    /**
     * Empaqueta el producto alimentario en un paquete ya creado en base a sus
     * caracteristicas
     *
     * @param paq paquete al que se empaqueta
     * @return true si se ha empaquetado correctamente, false en caso contrario
     */
    public Boolean empaquetar(Paquete paq) {
        if (paq.getTipo().equals(TIPOPAQUETE.COMIDA) && (this.getDimEspecial() == false)) {
            if (paq.getTipocomida().equals(TIPOCOMIDA.CONGELADA)
                    && (this.getTipo().equals(TIPOCOMIDA.CONGELADA) != true)) {
                return false;
            } else {
                paq.addProduct(this);
                return true;
            }
        }
        return false;
    }
}