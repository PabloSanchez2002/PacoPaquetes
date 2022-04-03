package pacopaquetes.envios.productos;

import enums.*;
import pacopaquetes.Configuracion;
import pacopaquetes.envios.Paquete;

public class Alimentario extends Producto {
    private Boolean liquido;
    private TIPOCOMIDA tipo;

    public Alimentario(int num, float pesoTot, float alto, float ancho, float profundo, String nombre,
            String cp, PRIORIDAD PR, int ni, Boolean liquido, TIPOCOMIDA tipo2, java.util.Date date) {
        super(num, pesoTot, alto, ancho, profundo, nombre, cp, PR, ni, date);
        this.tipo = tipo2;
        this.liquido = liquido;
    }

    public void setTipo(TIPOCOMIDA t) {
        this.tipo = t;
    }

    public TIPOCOMIDA getTipo() {
        return this.tipo;
    }

    public void setLiquido(Boolean l) {
        this.liquido = l;
    }

    public boolean getLiquido() {
        return this.liquido;
    }

    @Override
    public double getPrecio() {

        double p = 0.5 * getPesoTotal();
        if (getPesoTotal() / getNumUnidades() < 1)
            p += 0.4;
        else if (getPesoTotal() / getNumUnidades() < 5)
            p += 0.6;
        else if (getPesoTotal() / getNumUnidades() < 30)
            p += 1;

        return p * getNumUnidades();
    }

    public Paquete nuevoPaquete(Configuracion conf) {
        Paquete p = new Paquete(this.getPrioridad(), TIPOPAQUETE.COMIDA, this.getTipo(), conf.getmaxPesoPaqNormal(),
                conf.getReintentos(), this.getFecha());
        p.addProduct(this);
        return p;
    }

    public Boolean empaquetar(Paquete paq) {
        if (paq.getTipo().equals(TIPOPAQUETE.COMIDA)) {
            if (paq.getTipocomida().equals(TIPOCOMIDA.CONGELADA)
                    && (this.getTipo().equals(TIPOCOMIDA.CONGELADA) != true)) {
                return false;
            } else {
                paq.addProduct(this);
                return true;
            }
        }
        return false;
    }
}