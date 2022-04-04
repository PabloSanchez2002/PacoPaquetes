/**
 * 
 * Esta clase es para losproductos normales
 *
 * @author Pablo Sanchez, Mikel Riskez y Alberto Vicente
 *
 */
package pacopaquetes.envios.productos;

import enums.*;
import pacopaquetes.Configuracion;
import pacopaquetes.ModifiableDate;
import pacopaquetes.envios.Paquete;

public class Normal extends Producto {

    /**
     * Constructor de la clase normal
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
     * @param date     fecha de creacion del pedido que contiene el producto
     */
    public Normal(int num, float pesoTot, float alto, float ancho, float profundo, String nombre, String cp,
            PRIORIDAD PR, int ni, ModifiableDate date) {
        super(num, pesoTot, alto, ancho, profundo, nombre, cp, PR, ni, date);
    }

    /**
     * Calcula el precio de un producto normal en base a sus caracteristicas
     *
     * @return un double con el precio del producto
     */
    @Override
    public double getPrecio() {
        double p = 0;
        if (getPesoTotal() / getNumUnidades() < 1)
            p = 0.4;
        else if (getPesoTotal() / getNumUnidades() < 5)
            p = 0.6;
        else if (getPesoTotal() / getNumUnidades() < 30)
            p = 1;

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
            p = new Paquete(this.getPrioridad(), TIPOPAQUETE.NORMAL, TIPOCOMIDA.NULL,
                    conf.getmaxPesoPaqNormal(), conf.getReintentos(), this.getFecha());
        }
        p.addProduct(this);
        return p;
    }

    /**
     * Empaqueta el producto fragil en un paquete ya creado en base a sus
     * caracteristicas
     *
     * @param paq paquete al que se empaqueta
     * @return true si se ha empaquetado correctamente, false en caso contrario
     */
    public Boolean empaquetar(Paquete paq) {
        if (paq.getTipo().equals(TIPOPAQUETE.NORMAL) && (this.getDimEspecial() == false)) {
            paq.addProduct(this);
            return true;
        }
        return false;
    }

}