package PacoPaquetes.envios.productos;
import Enums.ESTADO;

public abstract class Producto{
    private int numUnidades;
    private float pesoTotal;
    private float[] dimensiones;
    private ESTADO estado;
    private int id;
    private String nombre;

    public Producto(int num,float pesoTot, float largo, float alto, float profundo ,ESTADO estado ,int id, String nombre){
        this.dimensiones = new float[3];
        this.dimensiones[0] = largo;
        this.dimensiones[1] = alto;
        this.dimensiones[2] = profundo;
        this.numUnidades = num;
        this.pesoTotal = pesoTot;
        this.estado = estado;
        this.id = id;
        this.nombre = nombre;
    }

    //===============SETS===============//
    public void setAlto(float f){
        this.dimensiones[0] = f;
    }

    public void setAncho(float f){
        this.dimensiones[1] = f;
    }

    public void setLargo(float f){
        this.dimensiones[2] = f;
    }

    public void setNumUnidades(int n){
        this.numUnidades = n;
    }

    public void setPesoTotal(float f){
        this.pesoTotal = f;
    }

    public void setEstado(ESTADO e){
        this.estado = e;
    }

    public void setId(int i){
        this.id = i;
    }

    public void setNombre(String n){
        this.nombre = n;
    }
    
    //===============GETS===============//
    public float getAlto(){
        return this.dimensiones[0];
    }

    public float getAncho(){
        return this.dimensiones[1];
    }

    public float getLargo(){
        return this.dimensiones[2];
    }

    public int getNumUnidades(){
        return this.numUnidades;
    }

    public float getPesoTotal(){
        return this.pesoTotal;
    }

    public ESTADO getEstado(){
        return this.estado;
    }

    public int getId(){
        return this.id;
    }

    public String getNombre(){
        return this.nombre;
    }

    //==================================//
    public double getPrecio(){
        double p=0;
        if(pesoTotal/numUnidades<1) p=0.4;
        else if(pesoTotal/numUnidades<5) p=0.6;
        else if(pesoTotal/numUnidades<30) p=1;

        return p*numUnidades;
    }
}