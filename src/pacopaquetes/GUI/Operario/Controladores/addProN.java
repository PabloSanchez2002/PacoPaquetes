package pacopaquetes.GUI.Operario.Controladores;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

import pacopaquetes.ModifiableDate;
import pacopaquetes.GUI.Operario.Paneles.*;
import pacopaquetes.usuarios.*;
import enums.*;

public class addProN implements ActionListener {
    private JPanel cardLay;
    private pantOper panel;
    private Operario op;

    public addProN(Operario op, JPanel cardLay, pantOper panel) {
            this.panel = panel;
            this.cardLay = cardLay;
            this.op = op;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}