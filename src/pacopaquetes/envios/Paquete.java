/**
 * 
 * Esta clase es de los paquetes
 *
 * @author Pablo Sanchez, Mikel Riskez y Alberto Vicente
 *
 */
package pacopaquetes.envios;

import enums.*;
import pacopaquetes.*;
import pacopaquetes.envios.productos.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Paquete implements Comparable<Paquete>, Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Contador de indices
     */
    private static int count = 0;
    /**
     * Prioridad del paquete
     */
    private PRIORIDAD prioridad;
    /**
     * Tipo de paquete
     */
    private TIPOPAQUETE tipo;
    /**
     * tipo de comida
     */
    private TIPOCOMIDA comida;
    /**
     * Maximo peso permitido
     */
    private int maxPeso;
    /**
     * Peso total del paquete
     */
    private int pesoTotal;
    /**
     * Id
     */
    private int id;
    /**
     * Fecha
     */
    private ModifiableDate fecha;
    /**
     * Numeor de intentos
     */
    private int nintentos;
    /**
     * Estado del paquete
     */
    private ESTADO entregado;
    /**
     * Lista de productos contenidos
     */
    private ArrayList<Producto> productos;

    /**
     * Genera un objeto Paquete
     * 
     * @param prio    prioridad
     * @param tipo    tipo de paquete
     * @param comida  tipo de comida
     * @param maxPeso peso maximo del paquete
     * @param nint    nuemero de intentos
     * @param fecha   fecha
     */
    public Paquete(PRIORIDAD prio, TIPOPAQUETE tipo, TIPOCOMIDA comida, int maxPeso, int nint,
            ModifiableDate fecha) {
        count++;
        this.id = count;
        this.prioridad = prio;
        this.nintentos = nint;
        this.pesoTotal = 0;
        this.fecha = fecha;
        this.maxPeso = maxPeso;
        this.tipo = tipo;
        this.comida = comida;
        this.entregado = ESTADO.EN_ALMACEN;
        this.productos = new ArrayList<Producto>();
    }

    // ===============SETS===============//

    /**
     * Establece el estado de entrega
     * 
     * @param e
     */
    public void setEntregado(ESTADO e) {
        for (Producto p : this.productos)
            p.setEstado(e);
        this.entregado = e;
    }

    /**
     * Establece numero de intentos de reparto
     * 
     * @param ni numero de intentos
     */
    public void setNintentos(int ni) {
        this.nintentos = ni;
    }

    // ===============GETS===============//

    /**
     * Devuelve la prioridad
     * 
     * @return PRIORIDAD
     */
    public PRIORIDAD getPrioridad() {
        return this.prioridad;
    }

    /**
     * Devuelve el tipo de paquete
     * 
     * @return TIPOPAQUETE
     */
    public TIPOPAQUETE getTipo() {
        return this.tipo;
    }

    /**
     * Devuelve el tipo de comida
     * 
     * @return TIPOCOMIDA
     */
    public TIPOCOMIDA getTipocomida() {
        return this.comida;
    }

    /**
     * Devuelve el peso total
     * 
     * @return int
     */
    public int getPesoTotal() {
        return this.pesoTotal;
    }

    /**
     * Devuelve el peso maximo
     * 
     * @return int
     */
    public int getMaxPeso() {
        return this.maxPeso;
    }

    /**
     * Devuelve el Id
     * 
     * @return int
     */
    public int getId() {
        return this.id;
    }

    /**
     * Devuelve la fecha
     * 
     * @return ModifiableDate
     */
    public ModifiableDate getFecha() {
        return this.fecha;
    }

    /**
     * Devuelve el numero de intentos
     * 
     * @return int
     */
    public int getNIntentos() {
        return this.nintentos;
    }

    /**
     * Devuelve el array de productos
     * 
     * @return ArrayList<Producto>
     */
    public ArrayList<Producto> getProductos() {
        return this.productos;
    }

    /**
     * Devuelve el estado del paquete
     * 
     * @return ESTADO
     */
    public ESTADO getEntregado() {
        return this.entregado;
    }

    // ===============ADDS===============//

    /**
     * Añade un producto al paquete
     * 
     * @param p producto
     * @return boolean si lo añadio bien
     */
    public boolean addProduct(Producto p) {
        if (this.pesoTotal + p.getPesoTotal() > this.maxPeso) {
            return false;
        } else {
            this.pesoTotal += p.getPesoTotal();
            this.productos.add(p);

            p.setEmpaquetado(true);
            return true;
        }
    }

    /**
     * Quita el producto del paquete
     * 
     * @param p producto
     */
    public void removeProduct(Producto p) {
        this.productos.remove(p);
    }

    /**
     * Funcion para comparar y ordenar paquetes
     * 
     * @param p Paquete conparacion
     * @return int
     */
    @Override
    public int compareTo(Paquete p) {
        if (this.getPrioridad().equals(PRIORIDAD.URGENTE) && p.getPrioridad().equals(PRIORIDAD.NORMAL)) {
            return 1;
        } else if (this.getPrioridad().equals(p.getPrioridad())) {
            return p.getFecha().compareTo(this.getFecha());
        } else if (this.getNIntentos() < p.getNIntentos()) {
            return 1;
        } else if (this.getTipocomida().equals(TIPOCOMIDA.REFRIGERADA) && (p.getTipocomida()
                .equals(TIPOCOMIDA.REFRIGERADA) != true)) {
            return 1;
        } else if (this.getTipocomida().equals(TIPOCOMIDA.REFRIGERADA) && (p.getTipocomida()
                .equals(TIPOCOMIDA.REFRIGERADA) != true)) {
            return 1;
        } else
            return -1;
    }

    /**
     * Empaqueta un array de productos
     * 
     * @param prods productos a intentar empaquetar
     */
    public void empaquetadoMasivo(ArrayList<Producto> prods) {
        for (Producto p : prods) {
            if (p.empaquetar(this) == true) {
                // prods.remove(p);
            }
        }
    }

    /**
     * Genera un plan de reparto en función del paquete
     * 
     * @param camionesSinCargar camiones disponibles
     * @return PlanDeReparto generado
     */
    public PlanDeReparto nuevoPlanDeReparto(ArrayList<Camion> camionesSinCargar) {
        switch (this.tipo) {
            case NORMAL:
                for (Camion c : camionesSinCargar) {
                    if (c.getTipo() == TIPOCAMION.ESTANDAR) {
                        PlanDeReparto rep = new PlanDeReparto();
                        rep.setCamion(c);
                        rep.addPaquete(this);
                        return rep;
                    }
                }
                break;
            case FRAGIL:
                for (Camion c : camionesSinCargar) {
                    if (c.getTipo() == TIPOCAMION.ESTANDAR) {
                        PlanDeReparto rep = new PlanDeReparto();
                        rep.setCamion(c);
                        rep.addPaquete(this);
                        return rep;
                    }
                }
                break;
            case COMIDA:
                for (Camion c : camionesSinCargar) {
                    if (this.getTipocomida() == TIPOCOMIDA.CONGELADA) {
                        if (c.getTipo() == TIPOCAMION.REFRIGERADO) {
                            PlanDeReparto rep = new PlanDeReparto();
                            rep.setCamion(c);
                            rep.addPaquete(this);
                            return rep;
                        }

                    }

                    else if (c.getTipo() == TIPOCAMION.ESTANDAR) {
                        PlanDeReparto rep = new PlanDeReparto();
                        rep.setCamion(c);
                        rep.addPaquete(this);
                        return rep;
                    }
                }
                break;

            case ESPECIAL:
                for (Camion c : camionesSinCargar) {
                    if (c.getTipo() == TIPOCAMION.ESPECIALES) {
                        PlanDeReparto rep = new PlanDeReparto();
                        rep.setCamion(c);
                        rep.addPaquete(this);
                        return rep;
                    }
                }
                break;
            default:
                break;
        }
        return null;
    }

}