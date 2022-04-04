package pacopaquetes.envios.productos;

import java.io.Serializable;

import enums.ESTADO;
import enums.PRIORIDAD;
import pacopaquetes.Configuracion;
import pacopaquetes.ModifiableDate;
import pacopaquetes.envios.Paquete;

public abstract class Producto implements Comparable<Producto>, Serializable {
    private static final long serialVersionUID = 1L;
    private static int count = 0;
    private PRIORIDAD pr;
    private int numUnidades;
    private float pesoTotal;
    private float[] dimensiones;
    private ESTADO estado = ESTADO.EN_ALMACEN;
    private int id;
    private String nombre;
    private String codPostal;
    private int nintentos;
    private boolean empaquetado;
    private ModifiableDate fecha;

    public Producto(int num, float pesoTot, float alto, float ancho, float profundo, String nombre, String cp,
            PRIORIDAD PR, int ni, ModifiableDate fecha2) {
        count++;
        this.id = count;
        this.dimensiones = new float[3];
        this.dimensiones[0] = alto;
        this.dimensiones[1] = ancho;
        this.dimensiones[2] = profundo;
        this.numUnidades = num;
        this.pesoTotal = pesoTot;
        this.nombre = nombre;
        this.pr = PR;
        this.codPostal = cp;
        this.nintentos = ni;
        this.empaquetado = false;
        this.fecha = fecha2;
    }

    // ===============SETS===============//
    public void setAlto(float f) {
        this.dimensiones[0] = f;
    }

    public void setAncho(float f) {
        this.dimensiones[1] = f;
    }

    public void setProfundo(float f) {
        this.dimensiones[2] = f;
    }

    public void setNumUnidades(int n) {
        this.numUnidades = n;
    }

    public void setPesoTotal(float f) {
        this.pesoTotal = f;
    }

    public void setEstado(ESTADO e) {
        this.estado = e;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }

    public void setPrioridad(PRIORIDAD p) {
        this.pr = p;
    }

    public void setCodPost(String cp) {
        this.codPostal = cp;
    }

    public void setNintentos(int n) {
        this.nintentos = n;
    }

    public void setEmpaquetado(Boolean e) {
        this.empaquetado = e;
    }

    public void setFecha(ModifiableDate d) {
        this.fecha = d;
    }

    // ===============GETS===============//
    public float getAlto() {
        return this.dimensiones[0];
    }

    public float getAncho() {
        return this.dimensiones[1];
    }

    public float getProfundo() {
        return this.dimensiones[2];
    }

    public int getNumUnidades() {
        return this.numUnidades;
    }

    public float getPesoTotal() {
        return this.pesoTotal;
    }

    public ESTADO getEstado() {
        return this.estado;
    }

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public PRIORIDAD getPrioridad() {
        return this.pr;
    }

    public String getCodPost() {
        return this.codPostal;
    }

    public int getNIntentos() {
        return this.nintentos;
    }

    public boolean getEmpaquetado() {
        return this.empaquetado;
    }

    public ModifiableDate getFecha() {
        return this.fecha;
    }

    // =================METODOS=================//
    public abstract double getPrecio();

    public abstract Paquete nuevoPaquete(Configuracion conf);

    public abstract Boolean empaquetar(Paquete paq);

    @Override
    public int compareTo(Producto p) {
        if (this.getPrioridad().equals(PRIORIDAD.URGENTE) && p.getPrioridad().equals(PRIORIDAD.NORMAL)) {
            return 1;
        } else if (this.getPrioridad().equals(p.getPrioridad())) {
            return p.getFecha().compareTo(this.getFecha());
        } else
            return -1;
    }

}