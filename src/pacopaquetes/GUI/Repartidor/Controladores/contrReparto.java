package pacopaquetes.GUI.Repartidor.Controladores;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import pacopaquetes.usuarios.Repartidor;
import pacopaquetes.GUI.A_GENERALES.errorWindow;

/**
 * Clase para acceder a la ventana de reparto
 */
public class contrReparto implements ActionListener {
    private JPanel cardLay;
    private Repartidor rep;
    
    public contrReparto(JPanel cardLay,Repartidor rep) {
        this.cardLay = cardLay;
        this.rep = rep;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.rep.consultarPlanReparto() == null){
            new errorWindow("Repartidor sin plan de reparto");
        }
        else{
        CardLayout cardLayout = (CardLayout) this.cardLay.getLayout();
        cardLayout.next(this.cardLay);
        cardLayout.next(this.cardLay);
        cardLayout.next(this.cardLay);
        }
    }
}