package pacopaquetes.GUI.Operario.Controladores;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import pacopaquetes.GUI.A_GENERALES.infoWindow;
import pacopaquetes.GUI.Operario.Paneles.*;
import pacopaquetes.usuarios.*;

/**
 * Clase para modificar la configuracion de la empresa
 */
public class modificarConf implements ActionListener{
    private JPanel cardLay;
    private pantOper panel;
    private Operario op;

    public modificarConf(Operario op, JPanel cardLay, pantOper panel) {
            this.panel = panel;
            this.cardLay = cardLay;
            this.op = op;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<String> s = this.panel.getNewConf();
        if (s.get(0).equals("") ==false) {
            op.getEmpresa().getConfig().setReintentos(Integer.parseInt(s.get(0)));
        }
        if (s.get(1).equals("") ==false) {
            op.getEmpresa().getConfig().setMaxVolume(Integer.parseInt(s.get(0)));
        }
        if (s.get(2).equals("") ==false) {
            op.getEmpresa().getConfig().setDescuento((double)Integer.parseInt(s.get(0))/100);
        }
        if (s.get(3).equals("") ==false) {
            op.getEmpresa().getConfig().setMaxCodPostales(Integer.parseInt(s.get(0)));
        }
        if (s.get(4).equals("") ==false) {
            op.getEmpresa().getConfig().setmaxPesoPaqNormal(Integer.parseInt(s.get(0)));
        }
        if (s.get(5).equals("") ==false) {
            op.getEmpresa().getConfig().setmaxPesoPaqFragil(Integer.parseInt(s.get(0)));
        }

        CardLayout cardLayout = (CardLayout) this.cardLay.getLayout();
        cardLayout.previous(this.cardLay);
        cardLayout.previous(this.cardLay);
        cardLayout.previous(this.cardLay);
        cardLayout.previous(this.cardLay);
        cardLayout.previous(this.cardLay);
        new infoWindow("Se actualizó la configuración de la empresa");
    }
}