package tests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import pacopaquetes.*;
import pacopaquetes.usuarios.*;

public class ConfiguracionTest {
    // Test Configuracion.java
    @Test
    public void test() throws IOException {
        Operario op = new Operario("usuario", "contrasena");
        PacoPaquetes pp = new PacoPaquetes(op);

        // Se establece la configuracion predeterminada

        assertEquals(3, pp.getConfig().getReintentos());
        assertEquals(12000, pp.getConfig().getMaxVolume());
        assertEquals(0.1, pp.getConfig().getDescuento(), 0);
        assertEquals(10, pp.getConfig().getMaxCodPostales());
        assertEquals(30, pp.getConfig().getmaxPesoPaqNormal());
        assertEquals(20, pp.getConfig().getmaxPesoPaqFragil());

    }
}