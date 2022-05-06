package pacopaquetes.GUI.Cliente.Controlador;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class datosCliente implements ActionListener {
    private JPanel cardLay;

    public datosCliente(JPanel cardLay) {
        this.cardLay = cardLay;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cl = (CardLayout) this.cardLay.getLayout();
        cl.next(this.cardLay);
    }

}
