package pacopaquetes.GUI.Operario.Controladores;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Clase para avanzar un numero definido de pantallas
 */
public class next implements ActionListener {
    private JPanel cardLay;
    private int n;

    public next(JPanel cardLay, int n) {
        this.cardLay = cardLay;
        this.n=n;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cl = (CardLayout) this.cardLay.getLayout();
        for(int i=0;i<n;i++){
            cl.next(this.cardLay);
        }
    }
}
