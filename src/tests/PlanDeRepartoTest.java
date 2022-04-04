package tests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import enums.*;
import pacopaquetes.*;
import pacopaquetes.envios.*;
import pacopaquetes.envios.productos.*;
import pacopaquetes.usuarios.*;

public class PlanDeRepartoTest {
    // Test PlanDeReparto.java
    @Test
    public void test() throws IOException {
        Operario op = new Operario("oper1", "oper123");
        PacoPaquetes pp = new PacoPaquetes(op);
        ModifiableDate dat = new ModifiableDate();
        Camion cam = op.altaCamion("matricula", 2010, TIPOCAMION.ESTANDAR);
        PlanDeReparto pr = new PlanDeReparto();

        Paquete p1 = new Paquete(PRIORIDAD.URGENTE, TIPOPAQUETE.NORMAL, TIPOCOMIDA.NULL, 20, 10, dat);
        Paquete p2 = new Paquete(PRIORIDAD.NORMAL, TIPOPAQUETE.NORMAL, TIPOCOMIDA.NULL, 35, 10, dat);

        Producto pp1 = new Normal(5, 10, 2, 2, 2, "algo", "12345", PRIORIDAD.NORMAL, p1.getNIntentos(), dat);
        Producto pp2 = new Normal(10, 20, 2, 2, 2, "algo2", "12345", PRIORIDAD.NORMAL, p2.getNIntentos(), dat);

        p1.addProduct(pp1);
        p2.addProduct(pp2);

        pr.setCamion(cam);
        pr.addPaquete(p1);
        pr.addPaquete(p2);

        assertEquals(1, pr.getId());
        assertEquals(cam, pr.getCamion());
        assertEquals(30, pr.getPesoCamion());
        for (Paquete p : pr.getPaquetes())
            assertEquals(p.getTipo(), TIPOPAQUETE.NORMAL);
        // repartoMasivo se prueba en el test de Operario
    }
}