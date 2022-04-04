package tests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import pacopaquetes.usuarios.*;

public class UsuarioRegistradoTest {
    // Test UsuarioRegistrado.java
    @Test
    public void test() throws IOException {

        UsuarioRegistrado ur = new Operario("Juan", "juan1234");

        ur.setUsuario("Pepe");
        ur.setContrasena("Pepe123");

        assertEquals("Pepe", ur.getUsuario());
        assertEquals("Pepe123", ur.getContrasena());
    }
}