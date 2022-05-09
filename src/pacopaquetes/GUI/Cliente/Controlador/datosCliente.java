package pacopaquetes.GUI.Cliente.Controlador;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;
/**
 *  Clase para ir a modificar los datos del cliente
 */
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
