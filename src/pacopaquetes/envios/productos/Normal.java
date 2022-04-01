package pacopaquetes.envios.productos;

import java.sql.Date;

import enums.*;

public class Normal extends Producto {

    public Normal(int num, float pesoTot, float largo, float ancho, float profundo, int id, String nombre, String cp, PRIORIDAD PR, int ni, java.util.Date date) {
        super(num, pesoTot, largo, ancho, profundo, id, nombre, cp, PR, ni,date);
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
}