/**
 * 
 * Esta clase 
 *
 * @author Pablo Sanchez, Mikel Risquez y Alberto Vicente
 *
 */
package pacopaquetes.envios.productos;

import java.io.Serializable;

import enums.ESTADO;
import enums.PRIORIDAD;
import es.uam.eps.padsof.invoices.IProductInfo;
import pacopaquetes.Configuracion;
import pacopaquetes.ModifiableDate;
import pacopaquetes.envios.Paquete;

public abstract class Producto implements Comparable<Producto>, Serializable,IProductInfo {
    private static final long serialVersionUID = 1L;

    /**
     * Contador para los ids
     */
    private static int count = 0;
    /**
     * Prioridad del producto
     */
    private PRIORIDAD pr;
    /**
     * Numero de unidades
     */
    private int numUnidades;
    /**
     * Peso total del producto
     */
    private float pesoTotal;
    /**
     * Array de dimensiones del producto (alto, largo, ancho)
     */
    private float[] dimensiones;
    /**
     * Estado del producto, cuando se crea se pone en almacén
     */
    private ESTADO estado = ESTADO.EN_ALMACEN;
    /**
     * Id del producto
     */
    private int id;
    /**
     * Nombre del producto
     */
    private String nombre;
    /**
     * Codigo postal de reparto
     */
    private String codPostal;
    /**
     * Numero de intentos de entrega
     */
    private int nintentos;
    /**
     * Boolean de empaquetado, por defectro es false
     */
    private Boolean empaquetado;
    /**
     * Fecha de creación
     */
    private ModifiableDate fecha;
    /**
     * Boolean si es dimension especial
     */
    private Boolean dimEspecial;

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
     * @param fecha2   fecha de creacion del pedido que contiene el producto
     */
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
        this.dimEspecial = false;
    }

    // ===============SETS===============//

    /**
     * Establece elpero total
     * 
     * @param f peso total
     */
    public void setPesoTotal(float f) {
        this.pesoTotal = f;
    }

    /**
     * Establece el estado del producto
     * 
     * @param e estado
     */
    public void setEstado(ESTADO e) {
        this.estado = e;
    }

    /**
     * Establece el parametro de empaquetado
     * 
     * @param e empaquetado
     */
    public void setEmpaquetado(Boolean e) {
        this.empaquetado = e;
    }

    /**
     * Establece si es dimension especial
     * 
     * @param d dim especial
     */
    public void setDimEspecial(Boolean d) {
        this.dimEspecial = d;
    }

    /**
     * Establece el numero de intentos
     * 
     * @param i numero de intentos
     */
    public void setNintentos(int i) {
        this.nintentos = i;
    }

    // ===============GETS===============//

    /**
     * Devuelve la altura
     * 
     * @return altura
     */
    public float getAlto() {
        return this.dimensiones[0];
    }

    /**
     * Devuelve el ancho
     * 
     * @return ancho
     */
    public float getAncho() {
        return this.dimensiones[1];
    }

    /**
     * Devuelve el profundo
     * 
     * @return profundo
     */
    public float getProfundo() {
        return this.dimensiones[2];
    }

    /**
     * Devuelve las unidades
     * 
     * @return unidades
     */
    public int getNumUnidades() {
        return this.numUnidades;
    }

    /**
     * Devuelve el peso total
     * 
     * @return peso total
     */
    public float getPesoTotal() {
        return this.pesoTotal;
    }

    /**
     * Devuelve el estado
     * 
     * @return estado
     */
    public ESTADO getEstado() {
        return this.estado;
    }

    /**
     * Devuelve el Id
     * 
     * @return Id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Devuelve el nombre
     * 
     * @return nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Devuelve la prioridad
     * 
     * @return prioridad
     */
    public PRIORIDAD getPrioridad() {
        return this.pr;
    }

    /**
     * Devuelve el codigo postal
     * 
     * @return cofigo postal
     */
    public String getCodPost() {
        return this.codPostal;
    }

    /**
     * Devuelve numero de intentos
     * 
     * @return numero de intentos
     */
    public int getNIntentos() {
        return this.nintentos;
    }

    /**
     * Devuelve si esta empaquetado
     * 
     * @return empaquetdao
     */
    public boolean getEmpaquetado() {
        return this.empaquetado;
    }

    /**
     * Devuelve la fecha
     * 
     * @return fecha
     */
    public ModifiableDate getFecha() {
        return this.fecha;
    }

    /**
     * Devuelve si es de dimensiones epsaciales o no
     * 
     * @return dimensiones especiales
     */
    public Boolean getDimEspecial() {
        return this.dimEspecial;
    }

    // =================METODOS=================//

    /**
     * Calcula el precio del producto
     * 
     * @return precio
     */
    public abstract double getPrecio();

    /**
     * Genera nuevo paquete segun el producto y la configuración
     * 
     * @param conf configuración de la empresa
     * @return Paquete creado
     */
    public abstract Paquete nuevoPaquete(Configuracion conf);

    /**
     * Empaqueta el producto en un pedido
     * 
     * @param paq Paquete donde empaquetar
     * @return true si lo ha metido, false si no
     */
    public abstract Boolean empaquetar(Paquete paq);

    public String getPriceDetails(){
        double p = 0;
        if (this.getPesoTotal() / this.getNumUnidades() < 1)
            p = 0.4;
        else if (this.getPesoTotal() / this.getNumUnidades() < 5)
            p = 0.6;
        else if (this.getPesoTotal() / this.getNumUnidades() < 30)
            p = 1;

        if(p==0.4){
            return ""+this.getNumUnidades()+"unidades,40 cts/unidad";
        }
        if(p==0.6){
            return ""+this.getNumUnidades()+"unidades,60 cts/unidad";
        }
        if(p==1){
            return ""+this.getNumUnidades()+"unidades,1 euro/unidad";
        }
        else{
            return null;
        }
    }

    /**
     * Funcion para comparar dos productos para poder ordenarlos por prioridad o
     * fecha
     *
     * @param p producto con el que se va a comparar
     * @return un entero para saber quien tiene prioridad, en el caso de que sea la
     *         misma la fecha anterior
     */
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