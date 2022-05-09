package pacopaquetes.GUI.Operario.Controladores;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

import pacopaquetes.GUI.A_GENERALES.errorWindow;
import pacopaquetes.GUI.A_GENERALES.infoWindow;
import pacopaquetes.GUI.Operario.Paneles.*;
import pacopaquetes.usuarios.*;

/**
 * Clase para dar de alta un nuevo repartidor
 */
public class newRep implements ActionListener {
    private JPanel cardLay;
    private pantOper panel;
    private Operario op;

    public newRep(Operario op, JPanel cardLay, pantOper panel) {
            this.panel = panel;
            this.cardLay = cardLay;
            this.op = op;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<String> s = this.panel.getNewRep();
        String usu=s.get(0);
        String cont=s.get(1);
        String tel=s.get(2);
        if (usu.equals("") ==true || cont.equals("") ==true || tel.equals("") ==true) {
            new errorWindow("Uno de los campos está vacío, intentalo de nuevo");
            return;
        }
        if(op.getEmpresa().findRepByName(usu)!=null){
            new errorWindow("Ya existe un repartidor con este nombre");
            return;
        }
        
        op.altaRepartidor(usu, cont, tel);

        CardLayout cardLayout = (CardLayout) this.cardLay.getLayout();
        cardLayout.previous(this.cardLay);
        new infoWindow("Se añadió el repartidor a la empresa");
    }
}