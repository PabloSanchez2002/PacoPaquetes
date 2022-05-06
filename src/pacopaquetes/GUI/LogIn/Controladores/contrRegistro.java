package pacopaquetes.GUI.LogIn.Controladores;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class contrRegistro implements ActionListener {
    private JPanel cardLay;

    public contrRegistro(JPanel cardLay) {
        this.cardLay = cardLay;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) this.cardLay.getLayout();
        cardLayout.next(this.cardLay);
    }
}