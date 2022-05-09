package pacopaquetes.GUI.Repartidor.Controladores;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

/**
 * Clase para acceder a la modificacion de los datos del repartidor(telefono)
 */
public class contrDatos implements ActionListener {
    private JPanel cardLay;

    public contrDatos(JPanel cardLay) {
        this.cardLay = cardLay;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) this.cardLay.getLayout();
        cardLayout.next(this.cardLay);
        cardLayout.next(this.cardLay);
        cardLayout.next(this.cardLay);
        cardLayout.next(this.cardLay);
    }
}