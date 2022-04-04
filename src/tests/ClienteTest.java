package tests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import pacopaquetes.usuarios.*;

public class ClienteTest {
    // Test Cliente/ClienteSinRegistrar/.java
    @Test
    public void test() throws IOException {
        ClienteSinRegistrar cli = new ClienteSinRegistrar();

        Cliente client = cli.nuevoCliente("pepe", "123pepe", "211223883D", "Fontanerias Pepe", "Av. Arriba 13",
                "pepefont@gmail.com", "6727738277");

        assertEquals("pepe", client.getUsuario());
        assertEquals("123pepe", client.getContrasena());
        assertEquals("211223883D", client.getCIF());
        assertEquals("Fontanerias Pepe", client.getNombreEmpresa());
        assertEquals("Av. Arriba 13", client.getDirecconFacturacion());
        assertEquals("pepefont@gmail.com", client.getCorreoElectronico());
        assertEquals("6727738277", client.getTargetaBancaria());

        client.setUsuario("roberto");
        client.setContrasena("456roberto");
        client.setCorreoElectronico("robertoelect@gmail.com");
        client.setDirecconFacturacion("Calle Abajo 14");
        client.setNombreEmpresa("Roberto Electricas");
        client.setTargetaBancaria("23334222123");

        assertEquals("roberto", client.getUsuario());
        assertEquals("456roberto", client.getContrasena());
        assertEquals("211223883D", client.getCIF());
        assertEquals("Roberto Electricas", client.getNombreEmpresa());
        assertEquals("Calle Abajo 14", client.getDirecconFacturacion());
        assertEquals("robertoelect@gmail.com", client.getCorreoElectronico());
        assertEquals("23334222123", client.getTargetaBancaria());
        /*
         * En pruebaMain funciona ->
         * ModifiableDate date = new ModifiableDate();
         * Dentro se prueba client.addPedido(ped)
         * Pedido ped = op.CrearPedido(client, date, "12345", PRIORIDAD.URGENTE);
         * Dentro se prueba client.addLote(lot)
         * Lote lot = op.CrearLote(client, date, "12345", PRIORIDAD.URGENTE,
         * TIPOPAQUETE.FRAGIL, TIPOCOMIDA.NULL);
         * assertEquals(1, client.getPedidos().size());
         * En pruebaMain funciona assertEquals(1, client.getLotes().size());
         */
    }
}