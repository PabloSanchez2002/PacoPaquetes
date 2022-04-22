package tests;

import org.junit.Test;

import java.io.IOException;

import enums.*;
import pacopaquetes.*;
import pacopaquetes.envios.*;

public class LoteTest {
    // Test Lote.java
    @Test
    public void test() throws IOException {

        ModifiableDate dat = new ModifiableDate();

        Lote lot = new Lote(PRIORIDAD.NORMAL, TIPOPAQUETE.COMIDA, TIPOCOMIDA.CONGELADA, 50, 10, dat, "28030");

        /*
         * Esta clase hereda de paquete todo asi que las pruebas corespondientes
         * se hacen en el test de Paquete
         */

    }
}