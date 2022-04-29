package pacopaquetes.GUI.Paneles;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import pacopaquetes.PacoPaquetes;
import pacopaquetes.usuarios.Operario;

public class prueba {
   public static void main(String[] args) {
      Operario op = new Operario("oper1", "oper123");
      PacoPaquetes pp = new PacoPaquetes(op);
      JPanel p = new logIn(pp);
   }
}