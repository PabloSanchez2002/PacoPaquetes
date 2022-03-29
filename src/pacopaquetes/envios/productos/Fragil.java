package pacopaquetes.envios.productos;

import enums.*;

public class Fragil extends Producto {
    Boolean asegurado; // faltan metodos

    public Fragil(int num, float pesoTot, float largo, float ancho, float profundo, int id, String nombre, PRIORIDAD PR,
            Boolean asegurado) {
        super(num, pesoTot, largo, ancho, profundo, id, nombre, PR);
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
}