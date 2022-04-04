package tests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import enums.*;
import pacopaquetes.*;
import pacopaquetes.envios.*;
import pacopaquetes.envios.productos.*;
import pacopaquetes.usuarios.*;

public class PacoPaquetesTest {
    // Test PacoPaquetes.java
    @Test
    public void test() throws IOException {

        Operario op = new Operario("usuario", "contrasena");
        PacoPaquetes pp = new PacoPaquetes(op);
        ModifiableDate dat = new ModifiableDate();

        Cliente cliente = new Cliente("pepe", "123pepe", "211223883D", "Fontanerias Pepe", "Av. Arriba 13",
                "pepefont@gmail.com", "6727738277");

        pp.addCliente(cliente);
        assertEquals(cliente, pp.findClienteByName("pepe"));
        assertEquals(null, pp.findClienteByName("juan"));

        Repartidor repartidor = new Repartidor("pedro", "1234pedro", "678237271");
        pp.addRepartidor(repartidor);
        assertEquals(repartidor, pp.findRepByName("pedro"));
        assertEquals(null, pp.findRepByName("juan"));

        Camion cam = new Camion("2322BBC", 3500, TIPOCAMION.ESTANDAR);
        pp.addCamion(cam);
        assertEquals(cam, pp.findCamionByMatr("2322BBC"));
        assertEquals(null, pp.findCamionByMatr("9999DSE"));

        Paquete paq = new Paquete(PRIORIDAD.URGENTE, TIPOPAQUETE.NORMAL, TIPOCOMIDA.NULL, 70,
                pp.getConfig().getReintentos(), dat);
        pp.addPaquete(paq);

        assertEquals(paq, pp.findPaqueteById(paq.getId()));
        assertEquals(null, pp.findPaqueteById(9999999));

        Pedido ped = new Pedido(dat, "12345", PRIORIDAD.URGENTE);
        pp.addPedido(ped);

        assertEquals(paq, pp.findPedidoById(ped.getId()));
        assertEquals(null, pp.findPedidoById(9999999));

        Producto nor = new Normal(30, 40, 12, 8, 4, "Silla", "12345", PRIORIDAD.NORMAL,
                pp.getConfig().getReintentos(), dat);
        pp.addProducto(nor);

        assertEquals(nor, pp.findProductoById(ped.getId()));
    }
}