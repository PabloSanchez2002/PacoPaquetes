package PacoPaquetes.envios.productos;
import Enums.ESTADO;

public class Normal extends Producto{

    public Normal(int num,float pesoTot, float largo, float ancho, float profundo ,ESTADO estado ,int id, String nombre){
        super(num,pesoTot,largo,ancho,profundo,estado,id,nombre);
    }
}