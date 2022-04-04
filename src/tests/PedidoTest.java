package tests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import enums.*;
import pacopaquetes.*;
import pacopaquetes.envios.productos.*;
import pacopaquetes.envios.*;
import pacopaquetes.usuarios.*;

public class PedidoTest {
    // Test Pedido.java
    @Test
    public void test() throws IOException {
        Operario op = new Operario("oper1", "oper123");
        PacoPaquetes pp = new PacoPaquetes(op);
        ModifiableDate dat = new ModifiableDate();

        Pedido ped = new Pedido(dat, "12345", PRIORIDAD.NORMAL);

        assertEquals(dat, ped.getFecha());
        assertEquals("12345", ped.getCodPost());
        assertEquals(PRIORIDAD.NORMAL, ped.getPrioridad());
        assertEquals(1, ped.getId());

        // Creamos producto para probar demás funciones
        Producto p = new Normal(30, 40, 12, 8, 4, "Silla", ped.getCodPost(), ped.getPrioridad(),
                pp.getConfig().getReintentos(), dat);

        assertEquals(0, ped.getPrecio(pp.getConfig().getDescuento()), 0);
        ped.anadirProducto(p);
        assertEquals(18, ped.getPrecio(pp.getConfig().getDescuento()), 0);
        ped.eliminarProducto(p);
        assertEquals(0, ped.getPrecio(pp.getConfig().getDescuento()), 0);

    }
}