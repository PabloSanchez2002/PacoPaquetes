package tests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import enums.TIPOCAMION;
import pacopaquetes.*;
import pacopaquetes.usuarios.*;

public class CamionTest {
    // Test Camion.java
    @Test
    public void test() throws IOException {

        Operario op = new Operario("usuario", "contrasena");
        PacoPaquetes pp = new PacoPaquetes(op);
        Camion cam = op.altaCamion("matricula", 2010, TIPOCAMION.ESTANDAR);

        cam.setmatricula("0000 bbb");
        cam.setPesoMax(1000);
        cam.setCargado(true);
        cam.setAveriado(true);
        cam.setTipo(TIPOCAMION.ESPECIALES);

        assertEquals("0000 bbb", cam.getMatricula());
        assertEquals(1000, cam.getPesoMax());
        assertEquals(TIPOCAMION.ESPECIALES, cam.getTipo());
        assertEquals(true, cam.getCargado());
        assertEquals(true, cam.getAveriado());

    }
}