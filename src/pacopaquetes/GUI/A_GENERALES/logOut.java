package pacopaquetes.GUI.A_GENERALES;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;
import pacopaquetes.PacoPaquetes;
import pacopaquetes.GUI.Cliente.Paneles.pantCliente;
import pacopaquetes.GUI.LogIn.Paneles.logIn;

public class logOut implements ActionListener {
    private PacoPaquetes pp;
    private pantCliente panel;

    public logOut(PacoPaquetes pp, pantCliente pantCliente) {
        this.pp = pp;
        this.panel = pantCliente;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new logIn(pp).setVisible(true);
        panel.setVisible(false);

    }

}
