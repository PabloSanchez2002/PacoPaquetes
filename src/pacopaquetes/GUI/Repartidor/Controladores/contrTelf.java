package pacopaquetes.GUI.Repartidor.Controladores;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import pacopaquetes.GUI.Repartidor.Paneles.*;
import pacopaquetes.usuarios.*;
public class contrTelf implements ActionListener {
    private JPanel cardLay;
    private pantRepartidor rep;
    private Repartidor repar;

    public contrTelf(JPanel cardLay, pantRepartidor rep, Repartidor repartidor) {
        this.cardLay = cardLay;
        this.rep = rep;
        this.repar = repartidor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = rep.getNumTelf();
        if(s != ""){
            repar.setTelefono(s);
        }
        CardLayout cardLayout = (CardLayout) this.cardLay.getLayout();
        cardLayout.first(this.cardLay);
    }
}