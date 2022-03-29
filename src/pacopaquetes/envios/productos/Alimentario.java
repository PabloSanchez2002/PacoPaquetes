package pacopaquetes.envios.productos;

import enums.*;

public class Alimentario extends Producto {
    private Boolean liquido; // faltan metodos
    private TIPOCOMIDA tipo;

    public Alimentario(int num, float pesoTot, float largo, float ancho, float profundo, int id, String nombre,
            PRIORIDAD PR, Boolean liquido, TIPOCOMIDA tipo) {
        super(num, pesoTot, largo, ancho, profundo, id, nombre, PR);
        this.tipo = tipo;
        this.liquido = liquido;
    }

    public void setTipo(TIPOCOMIDA t) {
        this.tipo = t;
    }

    public TIPOCOMIDA getTipo() {
        return this.tipo;
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
}