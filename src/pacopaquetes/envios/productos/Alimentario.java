package pacopaquetes.envios.productos;
import enums.ESTADO;
import enums.TIPOCOMIDA;

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

    @Override public double getPrecio() {
        
        double p=0.5*getPesoTotal();
        if(getPesoTotal()/getNumUnidades()<1) p+=0.4;
        else if(getPesoTotal()/getNumUnidades()<5) p+=0.6;
        else if(getPesoTotal()/getNumUnidades()<30) p+=1;

        return p*getNumUnidades();
    }
}