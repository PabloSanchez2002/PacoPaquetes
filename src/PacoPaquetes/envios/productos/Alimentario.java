package PacoPaquetes.envios.productos;
import Enums.TIPOCOMIDA;
import Enums.ESTADO;

public class Alimentario extends Producto{
    private TIPOCOMIDA tipo;

    public Alimentario(int num,float pesoTot, float largo, float ancho, float profundo ,ESTADO estado ,int id, String nombre,TIPOCOMIDA tipo){
        super(num, pesoTot, largo, ancho, profundo, estado, id, nombre);
        this.tipo = tipo;
    }

    public void setTipo(TIPOCOMIDA t){
        this.tipo = t;
    }

    public TIPOCOMIDA getTipo(){
        return this.tipo;
    }
}