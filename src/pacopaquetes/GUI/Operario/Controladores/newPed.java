package pacopaquetes.GUI.Operario.Controladores;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

import pacopaquetes.ModifiableDate;
import pacopaquetes.GUI.Operario.Paneles.*;
import pacopaquetes.usuarios.*;
import enums.*;

public class newPed implements ActionListener {
    private JPanel cardLay;
    private pantOper panel;
    private Operario op;

    public newPed(Operario op, JPanel cardLay, pantOper panel) {
            this.panel = panel;
            this.cardLay = cardLay;
            this.op = op;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<String> s = this.panel.getDatosPed();
        if (s.get(0).equals("") ==true || s.get(1).equals("") ==true) {
            //control de errores
        }
        Cliente cli = op.getEmpresa().findClienteByName(s.get(0));
        String cp=s.get(1);
        PRIORIDAD pr;
        if(s.get(2).equals("s")) pr=PRIORIDAD.URGENTE;
        else pr=PRIORIDAD.NORMAL;

        op.CrearPedido(cli, new ModifiableDate(), cp, pr);

        CardLayout cardLayout = (CardLayout) this.cardLay.getLayout();
        cardLayout.next(this.cardLay);
    }
}