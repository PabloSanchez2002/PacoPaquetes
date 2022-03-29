package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

import pacopaquetes.*;
import pacopaquetes.usuarios.*;

public class leer {
    @Test
    public void test() throws IOException {
        Operario op = new Operario("oper1", "oper123");
        PacoPaquetes pp = new PacoPaquetes(op);
        op.altaCamionesDesdeArchivo("/src/camiones.txt");

        ArrayList<Camion> cam = pp.getCamiones();
        assertEquals(7, cam.size());
    }

}
