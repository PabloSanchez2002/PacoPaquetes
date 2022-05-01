package pacopaquetes.GUI.Controladores;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import pacopaquetes.PacoPaquetes;
import pacopaquetes.GUI.Paneles.logIn;
import pacopaquetes.GUI.Paneles.logIn.*;

public class contrRegistro implements ActionListener {
    private logIn log;
    private PacoPaquetes pp;
    private JFrame ventana;

    public contrRegistro(logIn log, PacoPaquetes pp, JFrame ventana) {
        this.log = log;
        this.pp = pp;
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ventana.setVisible(false);
        registrarse r = this.log.new registrarse();
    }
}