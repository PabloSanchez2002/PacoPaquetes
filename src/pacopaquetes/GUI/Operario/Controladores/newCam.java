package pacopaquetes.GUI.Operario.Controladores;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

import pacopaquetes.GUI.A_GENERALES.*;
import pacopaquetes.GUI.Operario.Paneles.*;
import pacopaquetes.usuarios.*;
import enums.*;

/**
 * Clase para dar de alta a un camion
 */
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
        ArrayList<String> s = this.panel.getNewCam();
        if (s.get(0).equals("") ==true) {
            new errorWindow("La matricula es obligatoria");
            return;
        }
        String mat=s.get(0);
        int peso=Integer.parseInt(s.get(1));
        if (peso <=0) {
            new errorWindow("El peso tiene que ser mayor a 0");
            return;
        }
        String tipo=s.get(2);
        TIPOCAMION tipoC;
        if(tipo.equals("estandar")) tipoC=TIPOCAMION.ESTANDAR;
        if(tipo.equals("especial")) tipoC=TIPOCAMION.ESPECIALES;
        else tipoC=TIPOCAMION.REFRIGERADO;

        op.altaCamion(mat, peso, tipoC);

        CardLayout cardLayout = (CardLayout) this.cardLay.getLayout();
        cardLayout.previous(this.cardLay);
        cardLayout.previous(this.cardLay);
        new infoWindow("Se añadió al camión a la flota de la empresa");
    }
}