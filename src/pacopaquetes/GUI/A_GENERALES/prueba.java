package pacopaquetes.GUI.A_GENERALES;

import enums.*;
import pacopaquetes.Camion;
import pacopaquetes.ModifiableDate;
import pacopaquetes.PacoPaquetes;
import pacopaquetes.GUI.LogIn.Paneles.logIn;
import pacopaquetes.envios.*;
import pacopaquetes.envios.productos.Normal;
import pacopaquetes.envios.productos.Producto;
import pacopaquetes.usuarios.Cliente;
import pacopaquetes.usuarios.Operario;

/**
 *  Clase para inicializar una ejecucion normal de la aplición
 */
public class prueba {
   public static void main(String[] args) {
      Operario op = new Operario("oper1", "oper123");
      PacoPaquetes pp = new PacoPaquetes(op); 
      Cliente pepe = op.nuevoCliente("jose", "123", "231238", "MANZANAS SA", "Calle joakin 14",
                                "josepepe@mail",
                                "1234567890123456");
                                ModifiableDate date = new ModifiableDate();
      ModifiableDate dat = new ModifiableDate();
      Camion cam = op.altaCamion("4231JKD", 2010, TIPOCAMION.ESTANDAR);
      PlanDeReparto pr = new PlanDeReparto();
      // Pedido con CP valido
      op.getEmpresa().addCP("12345");
      Pedido ped = op.CrearPedido(pepe, date, "12345", PRIORIDAD.URGENTE);

      // producto normal
      op.anadirProductoPedido(ped, 2, 9, 3, 50, 30, "Altavoz",
      pp.getConfig().getReintentos());

      // producto fragil
      op.anadirProductoPedido(ped, 20, 10, 3, 50, 34, "Cristal",
      pp.getConfig().getReintentos(), true);

      Pedido ped2 = op.CrearPedido(pepe, date, "12345", PRIORIDAD.URGENTE);

      // producto normal
      op.anadirProductoPedido(ped2, 2, 9, 3, 50, 30, "Altavoz",
                     pp.getConfig().getReintentos());

      // producto fragil
      op.anadirProductoPedido(ped2, 20, 10, 3, 50, 34, "Cristal",
                     pp.getConfig().getReintentos(), true);

      // producto alimenticio normal
      op.anadirProductoPedido(ped2, 90, 30, 3, 50, 34, "Manzana",
                     pp.getConfig().getReintentos(), false, TIPOCOMIDA.NULL);

      // producto alimenticio congelado
      op.anadirProductoPedido(ped2, 5, 20, 23, 10, 20, "Atun congelado",
                     pp.getConfig().getReintentos(), false, TIPOCOMIDA.CONGELADA);

      // fragil
      op.anadirProductoPedido(ped2, 50, 1, 3, 5, 41, "Jarron", pp.getConfig().getReintentos(), false);

      op.altaRepartidor("jaime", "123", "1");

      Paquete p1 = new Paquete(PRIORIDAD.URGENTE, TIPOPAQUETE.NORMAL, TIPOCOMIDA.NULL, 20, 10, dat, "12345");
      Paquete p2 = new Paquete(PRIORIDAD.NORMAL, TIPOPAQUETE.NORMAL, TIPOCOMIDA.NULL, 35, 10, dat, "12345");

      Producto pp1 = new Normal(5, 10, 2, 2, 2, "algo", "12345", PRIORIDAD.NORMAL, p1.getNIntentos(), dat);
      Producto pp2 = new Normal(10, 20, 2, 2, 2, "algo2", "12345", PRIORIDAD.NORMAL, p2.getNIntentos(), dat);

      p1.addProduct(pp1);
      p2.addProduct(pp2);

      pr.setCamion(cam);
      pr.addPaquete(p1);
      pr.addPaquete(p2);

      pp.addPaquete(p1);
      pp.addPaquete(p2);

      op.asignarRepartidor(pr, pp.findRepByName("jaime"));
      new logIn(pp).setVisible(true);
   }
}