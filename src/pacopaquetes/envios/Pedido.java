package pacopaquetes.envios;

import java.util.Date;

import pacopaquetes.envios.productos.Producto;
import enums.*;

import java.util.ArrayList;

public class Pedido {

    private int id;
    private PRIORIDAD prioridad;
    private Date fecha;
    private int nintentos;
    private ArrayList<Producto> productos;

    public Pedido(int id, Date date, int nint, PRIORIDAD pr){
        this.prioridad=pr;
        this.id = id;
        this.fecha = date;
        this.nintentos = nint;
        this.productos= new ArrayList<Producto>();
    }

    //===============SETS===============//

    public void setId(int i){
        this.id = i;
    }

    public void setFecha(Date d){
        this.fecha = d;
    }

    public void setNIntentos(int n){
        this.nintentos = n;
    }

    public void setPrioridad(PRIORIDAD p){
        this.prioridad = p;
    }
    
    //===============GETS===============//

    public int getId(){
        return this.id;
    }

    public Date getFecha(){
        return this.fecha;
    }

    public int getNIntentos(){
        return this.nintentos;
    }

    public PRIORIDAD getPrioridad(){
         return this.prioridad;
    }

    public void anadirProducto(Producto p){
        productos.add(p);
    }

    public void eliminarProducto(Producto p){
        productos.remove(p);
    }

    public double getPrecio(){
        double pr=0;
        int n=0;
        for(Producto p: this.productos){
            pr+=p.getPrecio();
            n+=p.getNumUnidades();
        }
        if(this.getPrioridad()==PRIORIDAD.URGENTE) pr+=5;
        if(n>=100) pr-=(pr*0.1);
        return pr;
    }
}