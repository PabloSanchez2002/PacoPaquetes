package pacopaquetes.GUI.Operario.Controladores;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

import pacopaquetes.GUI.Operario.Paneles.*;
import pacopaquetes.usuarios.*;
import enums.*;

public class newCam implements ActionListener {
    private JPanel cardLay;
    private pantOper panel;
    private Operario op;

    public newCam(Operario op, JPanel cardLay, pantOper panel) {
            this.panel = panel;
            this.cardLay = cardLay;
            this.op = op;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<String> s = this.panel.getNewRep();
        if (s.get(1).equals("") ==true) {
            //control de errores
        }
        String mat=s.get(0);
        int peso=Integer.parseInt(s.get(1));
        String tipo=s.get(2);
        TIPOCAMION tipoC;
        if (mat.equals("") ==true) {
            //control de errores
        }
        if(tipo.equals("estandar")) tipoC=TIPOCAMION.ESTANDAR;
        if(tipo.equals("especial")) tipoC=TIPOCAMION.ESPECIALES;
        else tipoC=TIPOCAMION.REFRIGERADO;

        op.altaCamion(mat, peso, tipoC);

        CardLayout cardLayout = (CardLayout) this.cardLay.getLayout();
        cardLayout.previous(this.cardLay);
        cardLayout.previous(this.cardLay);
    }
}