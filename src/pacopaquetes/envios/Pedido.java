package pacopaquetes.envios;

import java.util.Date;

import pacopaquetes.envios.productos.Producto;

import java.util.ArrayList;

public class Pedido {

    private int id;
    private Date fecha;
    private int nintentos;
    private ArrayList<Producto> productos;

    public Pedido(int id, Date date, int nint){
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

    public void anadirProducto(Producto p){
        productos.add(p);
    }

    public void eliminarProducto(Producto p){
        productos.remove(p);
    }
}