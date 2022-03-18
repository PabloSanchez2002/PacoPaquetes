
package tests;

import pacopaquetes.*;
import pacopaquetes.usuarios.*;

public class prueba1 {
    public static void main(String[] args) {
        Operario op = new Operario("oper1", "oper123");
        PacoPaquetes pp = new PacoPaquetes(op);
        Repartidor rp = op.altaRepartidor("Juan", "juan123", "123123123");

        System.out.println(rp.getUsuario());
    }

}
