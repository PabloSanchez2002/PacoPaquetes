package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import enums.*;
import pacopaquetes.*;
import pacopaquetes.envios.*;
import pacopaquetes.usuarios.*;

public class pruebaped {
    @Test
    public void test() {
        Operario op = new Operario("oper1", "oper123");
        PacoPaquetes pp = new PacoPaquetes(op);
        Cliente pepe = op.nuevoCliente("jose", "123pepe", "231238" , "MANZANAS SA", "Calle joakin 14", "josepepe@mail", "425685222556");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 11, 20);
        Date date = calendar.getTime();

        Pedido ped = op.CrearPedido(pepe,5674, date, "22222", PRIORIDAD.URGENTE);

        op.anadirProductoPedido(ped, 20, 10, 123, 50, 34, ped.getId(), "Cristal", ped.getCodPost(), ped.getPrioridad(), pp.getConfig().getReintentos(), true);
        op.anadirProductoPedido(ped, 90, 30, 123, 50, 34, ped.getId(), "Manzana", ped.getCodPost(), ped.getPrioridad(), pp.getConfig().getReintentos(), TIPOCOMIDA.NORMAL,false);


        assertEquals(1349.1, ped.getPrecio(), 0);
        assertEquals(5674, pepe.getPedidos().get(0).getId());

    }
}