package PacoPaquetes.envios.productos;
import Enums.ESTADO;

public class Normal extends Producto{

    public Normal(int num,float pesoTot, float largo, float ancho, float profundo ,ESTADO estado ,int id, String nombre){
        super(num,pesoTot,largo,ancho,profundo,estado,id,nombre);
    }

    @Override public double getPrecio() {
        
        double p=0;
        if(getPesoTotal()/getNumUnidades()<1) p=0.4;
        else if(getPesoTotal()/getNumUnidades()<5) p=0.6;
        else if(getPesoTotal()/getNumUnidades()<30) p=1;

        return p*getNumUnidades();
    }
}