package pacopaquetes.GUI.Operario.Controladores;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import pacopaquetes.GUI.Operario.Paneles.*;
import pacopaquetes.usuarios.*;

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
        if (s.equals("") ==true) {
            //control de errores
        }

        op.bajaCamion(op.getEmpresa().findCamionByMatr(s));

        CardLayout cardLayout = (CardLayout) this.cardLay.getLayout();
        cardLayout.previous(this.cardLay);
        cardLayout.previous(this.cardLay);
        cardLayout.previous(this.cardLay);
        cardLayout.previous(this.cardLay);
    }
}