package pacopaquetes.GUI.Operario.Controladores;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import pacopaquetes.GUI.Operario.Paneles.*;
import pacopaquetes.usuarios.*;

public class configuracion implements ActionListener {
    private JPanel cardLay;

    public configuracion(JPanel cardLay) {
        this.cardLay = cardLay;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cl = (CardLayout) this.cardLay.getLayout();
        cl.next(this.cardLay);
        cl.next(this.cardLay);
        cl.next(this.cardLay);
        cl.next(this.cardLay);
        cl.next(this.cardLay);
    }
}
