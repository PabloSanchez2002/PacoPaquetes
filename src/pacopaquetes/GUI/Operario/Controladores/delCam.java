package pacopaquetes.GUI.Operario.Controladores;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import pacopaquetes.GUI.A_GENERALES.*;
import pacopaquetes.GUI.Operario.Paneles.*;
import pacopaquetes.usuarios.*;
import pacopaquetes.Camion;

/**
 * Clase para dar de baja un camion
 */
public class delCam implements ActionListener{
    private JPanel cardLay;
    private pantOper panel;
    private Operario op;

    public delCam(Operario op, JPanel cardLay, pantOper panel) {
            this.panel = panel;
            this.cardLay = cardLay;
            this.op = op;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = this.panel.getDelCam();
        Camion c;
        if (s.equals("") ==true) {
            new errorWindow("Matrícula de camión obligatoria");
            return;
        }
        c=op.getEmpresa().findCamionByMatr(s);
        if (c==null){
            new errorWindow("El camión de matrícula "+ s+ " no está en la plantilla de camiones");
            return;
        }
        op.bajaCamion(op.getEmpresa().findCamionByMatr(s));

        CardLayout cardLayout = (CardLayout) this.cardLay.getLayout();
        cardLayout.previous(this.cardLay);
        cardLayout.previous(this.cardLay);
        cardLayout.previous(this.cardLay);
        cardLayout.previous(this.cardLay);
        new infoWindow("Se eleminó al camioón a la flota de la empresa");
    }
}