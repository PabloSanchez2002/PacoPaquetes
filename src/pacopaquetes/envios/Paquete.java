package pacopaquetes.envios;

import enums.*;
import pacopaquetes.Camion;
import pacopaquetes.PacoPaquetes;
import pacopaquetes.envios.productos.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Paquete implements Comparable<Paquete>, Serializable {
    private static final long serialVersionUID = 1L;
    private static int count = 0;
    private PRIORIDAD prioridad;
    private TIPOPAQUETE tipo;
    private TIPOCOMIDA comida;
    private int maxPeso;
    private int pesoTotal;
    private int id;
    private Date fecha;
    private int nintentos;
    private ESTADO entregado;
    private ArrayList<Producto> productos;

    public Paquete(PRIORIDAD prio, TIPOPAQUETE tipo, TIPOCOMIDA comida, int maxPeso, int nint,
            Date fecha) {
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
    public PRIORIDAD getPrioridad() {
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

    public Date getFecha() {
        return this.fecha;
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

            p.setEmpaquetado(true);
            return true;
        }
    }

    public void removeProduct(Producto p) {
        this.productos.remove(p);
    }

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

    public void empaquetadoMasivo(ArrayList<Producto> prods) {
        for (Producto p : prods) {
            if (p.empaquetar(this) == true) {
                prods.remove(p);
            }
        }
    }

    public PlanDeReparto nuevoPlanDeReparto(ArrayList<Camion> camionesSinCargar) {
        switch (this.tipo) {
            case NORMAL:
                // checkea que hay camion con el mismo tipo
                // si lo hay, crea plan reparto y lo asigna
                // retorna plan reparto
                // y se añade a este

            case FRAGIL:
                // checkea que hay camion con el mismo tipo
                // si lo hay, crea plan reparto y lo asigna
                // retorna plan reparto
                // y se añade a este

            case COMIDA:
                // checkea que hay camion con el mismo tipo
                // si lo hay, crea plan reparto y lo asigna
                // retorna plan reparto
                // y se añade a este

            default:
                break;
        }
        return null;
    }

}