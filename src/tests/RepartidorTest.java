package tests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import enums.TIPOCAMION;
import pacopaquetes.*;
import pacopaquetes.envios.*;
import pacopaquetes.usuarios.*;

public class RepartidorTest {
    // Test Repartidor.java
    @Test
    public void test() throws IOException {

        Operario op = new Operario("usuario", "contrasena");
        PacoPaquetes pp = new PacoPaquetes(op);
        PlanDeReparto pr = new PlanDeReparto();
        Camion cam = op.altaCamion("matricula", 2010, TIPOCAMION.ESTANDAR);
        Repartidor rep = op.altaRepartidor("rep", "rep123", "123456789");

        op.asignarRepartidor(pr, rep);
        pr.setCamion(cam);
        rep.setTelefono("987654321");
        rep.setCamionAveriado();

        assertEquals("987654321", rep.getTelefono());
        assertEquals(0, rep.consultarPlanReparto().getPesoCamion());
        assertEquals(true, rep.consultarPlanReparto().getCamion().getAveriado());

    }
}