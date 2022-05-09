package pacopaquetes.GUI.Operario.Controladores;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

import pacopaquetes.GUI.A_GENERALES.errorWindow;
import pacopaquetes.GUI.Operario.Paneles.*;
import pacopaquetes.usuarios.*;

/**
 * Clase para anyadir un producto frágil
 */
public class addProF implements ActionListener {
    private JPanel cardLay;
    private pantOper panel;
    private Operario op;

    public addProF(Operario op, JPanel cardLay, pantOper panel) {
            this.panel = panel;
            this.cardLay = cardLay;
            this.op = op;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ArrayList<String> s = this.panel.getDatosProdF();

        for(int i=0;i<s.size();i++){
            if(s.get(i).equals("")) new errorWindow("Algun campo está vaio");
        }

        boolean t=false;
        if(s.get(6).equals("s")) t=true;

        op.anadirProductoPedido(this.panel.getPed(), Integer.parseInt(s.get(1)), Float.parseFloat(s.get(2)), 
                                Float.parseFloat(s.get(3)), Float.parseFloat(s.get(4)), Float.parseFloat(s.get(5)), 
                                s.get(0),op.getEmpresa().getConfig().getReintentos(), t);

        CardLayout cardLayout = (CardLayout) this.cardLay.getLayout();
        cardLayout.previous(this.cardLay);
        cardLayout.previous(this.cardLay);
    }
}
