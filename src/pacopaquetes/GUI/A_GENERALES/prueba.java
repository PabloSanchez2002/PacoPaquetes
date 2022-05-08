package pacopaquetes.GUI.A_GENERALES;

import enums.PRIORIDAD;
import pacopaquetes.ModifiableDate;
import pacopaquetes.PacoPaquetes;
import pacopaquetes.GUI.LogIn.Paneles.logIn;
import pacopaquetes.envios.Pedido;
import pacopaquetes.usuarios.Cliente;
import pacopaquetes.usuarios.Operario;

public class prueba {
   public static void main(String[] args) {
      Operario op = new Operario("oper1", "oper123");
      PacoPaquetes pp = new PacoPaquetes(op);
      Cliente pepe = op.nuevoCliente("jose", "123", "231238", "MANZANAS SA", "Calle joakin 14",
                                "josepepe@mail",
                                "1234567890123456");
                                ModifiableDate date = new ModifiableDate();
      // Pedido con CP valido
      op.getEmpresa().addCP("12345");
      Pedido ped = op.CrearPedido(pepe, date, "12345", PRIORIDAD.URGENTE);

      // producto normal
      op.anadirProductoPedido(ped, 2, 9, 3, 50, 30, "Altavoz",
      pp.getConfig().getReintentos());

      // producto fragil
      op.anadirProductoPedido(ped, 20, 10, 3, 50, 34, "Cristal",
      pp.getConfig().getReintentos(), true);
      new logIn(pp).setVisible(true);
   }
}