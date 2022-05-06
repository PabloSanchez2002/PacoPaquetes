package pacopaquetes.GUI.Repartidor.Controladores;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import pacopaquetes.usuarios.*;

public class contrAveriado implements ActionListener {
    private JPanel cardLay;
    private Repartidor rep;

    public contrAveriado(JPanel cardLay, Repartidor rep) {
        this.cardLay = cardLay;
        this.rep = rep;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        rep.setCamionAveriado();
        CardLayout cardLayout = (CardLayout) this.cardLay.getLayout();
        cardLayout.previous(this.cardLay);
    }
}