package tests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import enums.*;
import pacopaquetes.*;
import pacopaquetes.envios.productos.*;
import pacopaquetes.envios.*;
import pacopaquetes.usuarios.*;

public class PaqueteTest {
    // Test Paquete.java
    @Test
    public void test() throws IOException {
        Operario op = new Operario("oper1", "oper123");
        PacoPaquetes pp = new PacoPaquetes(op);
        ModifiableDate dat = new ModifiableDate();

        Paquete paq = new Paquete(PRIORIDAD.URGENTE, TIPOPAQUETE.NORMAL, TIPOCOMIDA.NULL, 20, 10, dat, "12345");

        assertEquals(PRIORIDAD.URGENTE, paq.getPrioridad());
        assertEquals(TIPOPAQUETE.NORMAL, paq.getTipo());
        assertEquals(TIPOCOMIDA.NULL, paq.getTipocomida());
        assertEquals(20, paq.getMaxPeso());
        assertEquals(10, paq.getNIntentos());
        assertEquals(dat, paq.getFecha());
        assertEquals(ESTADO.EN_ALMACEN, paq.getEntregado());

        paq.setEntregado(ESTADO.EN_REPARTO);

        assertEquals(ESTADO.EN_REPARTO, paq.getEntregado());

        Producto p = new Normal(30, 40, 12, 8, 4, "Silla", "12345", PRIORIDAD.NORMAL,
                pp.getConfig().getReintentos(), dat);

        paq.addProduct(p);

        // En pruebaMain funciona -> assertEquals(40, paq.getPesoTotal());

        // En pruebaMain funciona -> assertEquals(1, paq.getProductos().size());

        // Resto de funciones se prueban en OperarioTest.java

    }
}