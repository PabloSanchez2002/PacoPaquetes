
package tests;

import static org.junit.Assert.*;

import java.util.Date;
import java.io.IOException;
import java.util.Calendar;

import org.junit.Test;

import enums.PRIORIDAD;
import enums.TIPOCOMIDA;
import pacopaquetes.*;
import pacopaquetes.envios.Pedido;
import pacopaquetes.usuarios.*;

public class OperarioTest {
    @Test
    public void test() throws IOException {
        // Inicialización de la empresa
        Operario op = new Operario("oper1", "oper123");
        PacoPaquetes pp = new PacoPaquetes(op);
        Repartidor rp = op.altaRepartidor("Juan", "juan123", "123123123");
        assertEquals("Juan", rp.getUsuario());

        // lee camiones y CPs
        op.cargarCP("files/codigos.txt");
        op.altaCamionesDesdeArchivo("files/camiones.txt");
        op.getEmpresa().addCP("12345");
        /* Aquí debe ir el test de LeerTest pero por alguna razon no funciona */

        // Crea cliente e inicia pedido
        Cliente pepe = op.nuevoCliente("jose", "123pepe", "231238", "MANZANAS SA", "Calle joakin 14", "josepepe@mail",
                "425685222556");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 11, 20);
        Date date = calendar.getTime();

        // Pedido no valido, cp no registrado en la empresa
        Pedido ped0 = op.CrearPedido(pepe, 5674, date, "1000", PRIORIDAD.URGENTE);
        assertEquals(null, ped0);

        // Pedido con CP valido
        Pedido ped = op.CrearPedido(pepe, 5674, date, "12345", PRIORIDAD.URGENTE);

        // producto normal
        op.anadirProductoPedido(ped, 2, 9, 123, 50, 30, "Altavoz",
                pp.getConfig().getReintentos());

        // producto fragil
        op.anadirProductoPedido(ped, 20, 10, 123, 50, 34, "Cristal",
                pp.getConfig().getReintentos(), true);

        // producto alimenticio normal
        op.anadirProductoPedido(ped, 90, 30, 123, 50, 34, "Manzana",
                pp.getConfig().getReintentos(), false, TIPOCOMIDA.NULL);

        // producto alimenticio congelado
        op.anadirProductoPedido(ped, 5, 20, 23, 10, 20, "Atun congelado",
                pp.getConfig().getReintentos(), false, TIPOCOMIDA.CONGELADA);

        assertEquals(1396.8, ped.getPrecio(), 0);
        assertEquals(5674, pepe.getPedidos().get(0).getId());
    }

}
