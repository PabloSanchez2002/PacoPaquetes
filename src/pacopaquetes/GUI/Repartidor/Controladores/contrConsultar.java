package pacopaquetes.GUI.Repartidor.Controladores;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import pacopaquetes.GUI.A_GENERALES.errorWindow;
import pacopaquetes.usuarios.Repartidor;

/**
 * Clase para acceder a consultar el plan de reparto
 */
public class contrConsultar implements ActionListener {
    private JPanel cardLay;
    private Repartidor rep;
    
    public contrConsultar(JPanel cardLay,Repartidor rep) {
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
        }
    }
}