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
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 11, 20);
        Date date = calendar.getTime();

        Pedido ped = op.CrearPedido(5674, date, pp.getConfig().getReintentos(), PRIORIDAD.URGENTE);

        op.anadirProductoPedido(ped, 20, 10, 123, 50, 34, ped.getId(), "Cristal", ped.getPrioridad(), true);
        op.anadirProductoPedido(ped, 90, 30, 123, 50, 34, ped.getId(), "Manzana", ped.getPrioridad(), TIPOCOMIDA.NORMAL,
                false);

        assertEquals(1344.6, ped.getPrecio(), 0);

    }
}