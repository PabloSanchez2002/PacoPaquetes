package pacopaquetes.GUI.LogIn.Controladores;

import java.awt.*;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import pacopaquetes.PacoPaquetes;
import pacopaquetes.GUI.A_GENERALES.errorWindow;
import pacopaquetes.GUI.LogIn.Paneles.logIn;

public class contrNewUser implements ActionListener {
    private JPanel cardLay;
    private logIn panel;
    private PacoPaquetes pp;


    public contrNewUser(PacoPaquetes pp, JPanel cardLay, logIn panel) {
        this.panel = panel;
        this.cardLay = cardLay;
        this.pp = pp;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<String> s = this.panel.getRegistros();
        int x = pp.findUsuario(s.get(0), s.get(1));
        if (x == -1) {
            pp.getOperario().nuevoCliente(s.get(0), s.get(1), s.get(2), s.get(3), s.get(4), s.get(5), s.get(6));
        } else {
            new errorWindow("Perfil con el mismo nombre y contraseña");
        }

        CardLayout cardLayout = (CardLayout) this.cardLay.getLayout();
        cardLayout.previous(this.cardLay);
    }
}