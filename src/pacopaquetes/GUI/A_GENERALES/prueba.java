package pacopaquetes.GUI.A_GENERALES;

import pacopaquetes.PacoPaquetes;
import pacopaquetes.GUI.LogIn.Paneles.logIn;
import pacopaquetes.usuarios.Operario;

public class prueba {
   public static void main(String[] args) {
      Operario op = new Operario("oper1", "oper123");
      PacoPaquetes pp = new PacoPaquetes(op);
      new logIn(pp).setVisible(true);
   }
}