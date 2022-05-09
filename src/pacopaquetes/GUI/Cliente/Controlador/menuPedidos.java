package pacopaquetes.GUI.Cliente.Controlador;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

/**
 *  Clase para llamar a la pantalla de mostrar los pedidos del cliente
 */
public class menuPedidos implements ActionListener {
    private JPanel cardLay;

    public menuPedidos(JPanel cardLay) {
        this.cardLay = cardLay;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        CardLayout cl = (CardLayout) this.cardLay.getLayout();
        cl.next(this.cardLay);
        cl.next(this.cardLay);

    }

}
