package pacopaquetes.GUI.Operario.Controladores;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class bajaRep implements ActionListener {
    private JPanel cardLay;

    public bajaRep(JPanel cardLay) {
        this.cardLay = cardLay;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cl = (CardLayout) this.cardLay.getLayout();
        cl.next(this.cardLay);
        cl.next(this.cardLay);
        cl.next(this.cardLay);
    }
}
