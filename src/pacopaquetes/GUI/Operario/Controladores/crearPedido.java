package pacopaquetes.GUI.Operario.Controladores;

import pacopaquetes.usuarios.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class crearPedido implements ActionListener {
    private JPanel cardLay;
    private Operario op;

    public crearPedido(Operario op, JPanel cardLay) {
        this.cardLay = cardLay;
        this.op = op;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cl = (CardLayout) this.cardLay.getLayout();
        cl.next(this.cardLay);
    }
}
