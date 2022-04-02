package pacopaquetes.envios.productos;

import enums.*;
import pacopaquetes.Configuracion;
import pacopaquetes.envios.Paquete;

public class Fragil extends Producto {
    Boolean asegurado; // faltan metodos

    public Fragil(int num, float pesoTot, float largo, float ancho, float profundo, String nombre, String cp,
            PRIORIDAD PR, int ni, Boolean asegurado, java.util.Date fecha) {
        super(num, pesoTot, largo, ancho, profundo, nombre, cp, PR, ni, fecha);
        this.asegurado = asegurado;
    }

    @Override
    public double getPrecio() {
        double p = 2;
        if (this.asegurado == true) {
            p = 5;
        }
        if (getPesoTotal() / getNumUnidades() < 1)
            p += 0.4;
        else if (getPesoTotal() / getNumUnidades() < 5)
            p += 0.6;
        else if (getPesoTotal() / getNumUnidades() < 30)
            p += 1;

        return p * getNumUnidades();
    }

    public Paquete nuevoPaquete(Configuracion conf) {
        return new Paquete(this.getPrioridad(), TIPOPAQUETE.FRAGIL, TIPOCOMIDA.NULL, conf.getmaxPesoPaqFragil(),
                conf.getReintentos());
    }
}