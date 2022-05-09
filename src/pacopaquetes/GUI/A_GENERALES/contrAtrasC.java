package pacopaquetes.GUI.A_GENERALES;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;
/**
 *  Clase para volver a la primera ventanan del cardLayout
 */
public class contrAtrasC implements ActionListener {
    private JPanel cardLay;

    public contrAtrasC(JPanel cardLay) {
        this.cardLay = cardLay;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) this.cardLay.getLayout();
        cardLayout.first(this.cardLay);
    }
}