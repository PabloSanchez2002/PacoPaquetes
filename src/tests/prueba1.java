
package tests;
import static org.junit.Assert.*;
import org.junit.Test;

import pacopaquetes.*;
import pacopaquetes.usuarios.*;

public class prueba1 {
    @Test
    public void test() {
        Operario op = new Operario("oper1", "oper123");
        PacoPaquetes pp = new PacoPaquetes(op);
        Repartidor rp = op.altaRepartidor("Juan", "juan123", "123123123");

        assertEquals("Juan", rp.getUsuario());
    }

}
