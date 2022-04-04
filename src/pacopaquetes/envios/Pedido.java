package pacopaquetes.envios;

import pacopaquetes.ModifiableDate;
import pacopaquetes.envios.productos.Producto;
import enums.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int count = 0;
    private int id;
    private PRIORIDAD prioridad;
    private ModifiableDate fecha;
    private String codPostal;
    private ArrayList<Producto> productos;

    public Pedido(ModifiableDate date, String codPost, PRIORIDAD pr) {
        count++;
        this.id = count;
        this.prioridad = pr;
        this.fecha = date;
        this.codPostal = codPost;
        this.productos = new ArrayList<Producto>();
    }

    // ===============SETS===============//

    public void setId(int i) {
        this.id = i;
    }

    public void setFecha(ModifiableDate d) {
        this.fecha = d;
    }

    public void setPrioridad(PRIORIDAD p) {
        this.prioridad = p;
    }

    public void setCodPost(String cp) {
        this.codPostal = cp;
    }

    // ===============GETS===============//

    public int getId() {
        return this.id;
    }

    public ModifiableDate getFecha() {
        return this.fecha;
    }

    public PRIORIDAD getPrioridad() {
        return this.prioridad;
    }

    public String getCodPost() {
        return this.codPostal;
    }

    public void anadirProducto(Producto p) {
        productos.add(p);
    }

    public void eliminarProducto(Producto p) {
        productos.remove(p);
    }

    public double getPrecio() {
        double pr = 0;
        int n = 0;
        for (Producto p : this.productos) {
            pr += p.getPrecio();
            n += p.getNumUnidades();
        }
        if (this.getPrioridad() == PRIORIDAD.URGENTE)
            pr += 5;
        if (n >= 100)
            pr -= (pr * 0.1);
        return pr;
    }
}