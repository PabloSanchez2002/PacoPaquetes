package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

import pacopaquetes.*;
import pacopaquetes.usuarios.*;

public class LeerTest {
    @Test
    public void test() throws IOException {
        Operario op = new Operario("oper1", "oper123");
        PacoPaquetes pp = new PacoPaquetes(op);
        op.cargarCP("files/codigos.txt");
        op.altaCamionesDesdeArchivo("files/camiones.txt");

        ArrayList<Camion> cam = pp.getCamiones();
        ArrayList<String> cp = pp.getCPs();
        // =====================//
        /* Por alguna razón no funcionan estos asert, comprobado en el main */
        assertEquals(25, cp.size());
        assertEquals(7, cam.size());
    }
}
