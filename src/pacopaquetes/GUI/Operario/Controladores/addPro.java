package pacopaquetes.GUI.Operario.Controladores;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import pacopaquetes.GUI.Operario.Paneles.*;

/**
 * Clase para anyadir un producto
 */
public class addPro implements ActionListener {
    private JPanel cardLay;
    private pantOper panel;

    public addPro(JPanel cardLay, pantOper panel) {
            this.panel = panel;
            this.cardLay = cardLay;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = this.panel.getTipoProd();

        CardLayout cardLayout = (CardLayout) this.cardLay.getLayout();
        if(s.equals("normal")) cardLayout.next(this.cardLay);
        else if(s.equals("fragil")){
            cardLayout.next(this.cardLay);
            cardLayout.next(this.cardLay);
        }
        else if (s.equals("alimentario")){
            cardLayout.next(this.cardLay);
            cardLayout.next(this.cardLay);
            cardLayout.next(this.cardLay);
        }
    }
}