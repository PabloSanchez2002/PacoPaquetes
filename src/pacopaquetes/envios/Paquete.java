package pacopaquetes.envios;

import enums.*;
import pacopaquetes.envios.productos.*;
import java.util.ArrayList;

public class Paquete {
    private static int count = 0;
    private PRIORIDAD prioridad;
    private TIPOPAQUETE tipo;
    private TIPOCOMIDA comida;
    private int maxPeso;
    private int pesoTotal;
    private int id;
    private int nintentos;
    private ESTADO entregado;
    private ArrayList<Producto> productos;

    public Paquete(PRIORIDAD prio, TIPOPAQUETE tipo, TIPOCOMIDA comida, int maxPeso, int nint) {
        count++;
        this.id = count;
        this.prioridad = prio;
        this.nintentos = nint;
        this.pesoTotal = 0;
        this.maxPeso = maxPeso;
        this.tipo = tipo;
        this.comida = comida;
        this.entregado = ESTADO.EN_ALMACEN;
        this.productos = new ArrayList<Producto>();
    }

    // ===============SETS===============//
    public void setPrior(PRIORIDAD p) {
        this.prioridad = p;
    }

    public void setTipo(TIPOPAQUETE t) {
        this.tipo = t;
    }

    public void setPesoTotal(int p) {
        this.pesoTotal = p;
    }

    public void setid(int i) {
        this.id = i;
    }

    public void setNIntentos(int n) {
        this.nintentos = n;
    }

    public void setEntregado(ESTADO e) {
        for (Producto p : this.productos)
            p.setEstado(e);
        this.entregado = e;
    }

    // ===============GETS===============//
    public PRIORIDAD getpPrioridad() {
        return this.prioridad;
    }

    public TIPOPAQUETE getTipo() {
        return this.tipo;
    }

    public TIPOCOMIDA getTipocomida() {
        return this.comida;
    }

    public int getPesoTotal() {
        return this.pesoTotal;
    }

    public int getMaxPeso() {
        return this.maxPeso;
    }

    public int getId() {
        return this.id;
    }

    public int getNIntentos() {
        return this.nintentos;
    }

    public ArrayList<Producto> getProductos() {
        return this.productos;
    }

    public ESTADO getEntregado() {
        return this.entregado;
    }

    // ===============ADDS===============//

    public boolean addProduct(Producto p) {
        if (this.pesoTotal + p.getPesoTotal() > this.maxPeso) {
            return false;
        } else {
            this.pesoTotal += p.getPesoTotal();
            this.productos.add(p);
            return true;
        }

    }

    public void removeProduct(Producto p) {
        this.productos.remove(p);
    }
}