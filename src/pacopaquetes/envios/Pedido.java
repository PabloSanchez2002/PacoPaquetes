/**
 * 
 * Esta clase es de los pedidos
 *
 * @author Pablo Sanchez, Mikel Risquez y Alberto Vicente
 *
 */
package pacopaquetes.envios;

import pacopaquetes.ModifiableDate;
import pacopaquetes.envios.productos.Producto;
import enums.*;
import es.uam.eps.padsof.invoices.IInvoiceInfo;
import es.uam.eps.padsof.invoices.IProductInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Contador de indices
     */
    private static int count = 0;
    /**
     * id del pedido
     */
    private int id;
    /**
     * Prioridad del pedido
     */
    private PRIORIDAD prioridad;
    /**
     * Fecha del pedido
     */
    private ModifiableDate fecha;
    /**
     * Codigo postal
     */
    private String codPostal;
    /**
     * Array de productos del pedido
     */
    private List<Producto> productos;

    /**
     * Genera objeto pedido
     * 
     * @param date    fecha
     * @param codPost codigo postal
     * @param pr      prioridad
     */
    public Pedido(ModifiableDate date, String codPost, PRIORIDAD pr) {
        count++;
        this.id = count;
        this.prioridad = pr;
        this.fecha = date;
        this.codPostal = codPost;
        this.productos = new ArrayList<Producto>();
    }

    // ===============GETS===============//
    /**
     * Devuelve la Id
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
     * Devuelve la prioridad
     * 
     * @return PRIORIDAD
     */
    public PRIORIDAD getPrioridad() {
        return this.prioridad;
    }

    /**
     * Devuelve el codigo postal
     * 
     * @return String
     */
    public String getCodPost() {
        return this.codPostal;
    }

    /**
     * Devuelve un array con los productos del pedido
     *
     * @return Array<Producto>
     */
    public List<Producto> getProductos() {
        return this.productos;
    }

    /**
     * Devuelve un array con los productos del pedido tipo
     *
     * @return Array<Producto>
     */
    public List<IProductInfo> getProductosIProductInfo() {
        List<IProductInfo> list = new ArrayList<IProductInfo>();
        for (Producto p : this.productos)
            list.add((IProductInfo) p);
        return list;

    }

    /**
     * Añade un producto a el pedido
     * 
     * @param p producto
     */
    public void anadirProducto(Producto p) {
        productos.add(p);
    }

    /**
     * Elimina un producto del pedido
     * 
     * @param p
     */
    public void eliminarProducto(Producto p) {
        productos.remove(p);
    }

    /**
     * Calcula el precio del pedido
     * 
     * @return double
     */
    public double getPrecio(double d) {
        double pr = 0;
        int n = 0;
        for (Producto p : this.productos) {
            pr += p.getPrecio();
            n += p.getNumUnidades();
        }
        if (this.getPrioridad() == PRIORIDAD.URGENTE)
            pr += 5;
        if (n >= 100)
            pr -= (pr * d);
        return pr;
    }
}