package pacopaquetes.GUI.Controladores;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import pacopaquetes.PacoPaquetes;
import pacopaquetes.GUI.Paneles.logIn;
import pacopaquetes.GUI.Paneles.logIn.*;

public class contrRegistro implements ActionListener {
    private logIn log;
    private JPanel cardLay;

    public contrRegistro(logIn log,JPanel cardLay) {
        this.log = log;
        this.cardLay = cardLay;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) this.cardLay.getLayout();
        cardLayout.next(this.cardLay);
    }
}