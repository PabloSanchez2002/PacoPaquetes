package pacopaquetes.envios.productos;

import enums.*;
import pacopaquetes.Configuracion;
import pacopaquetes.envios.Paquete;

public class Normal extends Producto {

    public Normal(int num, float pesoTot, float largo, float ancho, float profundo, String nombre, String cp,
            PRIORIDAD PR, int ni, java.util.Date date) {
        super(num, pesoTot, largo, ancho, profundo, nombre, cp, PR, ni, date);
    }

    @Override
    public double getPrecio() {
        double p = 0;
        if (getPesoTotal() / getNumUnidades() < 1)
            p = 0.4;
        else if (getPesoTotal() / getNumUnidades() < 5)
            p = 0.6;
        else if (getPesoTotal() / getNumUnidades() < 30)
            p = 1;

        return p * getNumUnidades();
    }

    public Paquete nuevoPaquete(Configuracion conf) {
        return new Paquete(this.getPrioridad(), TIPOPAQUETE.NORMAL, TIPOCOMIDA.NULL, conf.getmaxPesoPaqNormal(),
                conf.getReintentos());
    }

}