package pacopaquetes.GUI.Operario.Controladores;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import pacopaquetes.GUI.A_GENERALES.*;
import pacopaquetes.GUI.Operario.Paneles.*;
import pacopaquetes.usuarios.*;

/**
 * Clase para dar de baja un repartidor
 */
public class delRep implements ActionListener{
    private JPanel cardLay;
    private pantOper panel;
    private Operario op;

    public delRep(Operario op, JPanel cardLay, pantOper panel) {
            this.panel = panel;
            this.cardLay = cardLay;
            this.op = op;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = this.panel.getDelRep();
        Repartidor rep;
        if (s.equals("") ==true) {
            new errorWindow("Nombre del repartidor obligatorio");
            return;
        }

        rep=op.getEmpresa().findRepByName(s);
        if(rep==null){
            new errorWindow(s+" no está en la plantilla de trabajadores");
            return;
        }

        op.bajaRepartidor(rep);

        CardLayout cardLayout = (CardLayout) this.cardLay.getLayout();
        cardLayout.previous(this.cardLay);
        cardLayout.previous(this.cardLay);
        cardLayout.previous(this.cardLay);
        new infoWindow("Se dio de baja al repartidor  de la empresa");
    }
}
