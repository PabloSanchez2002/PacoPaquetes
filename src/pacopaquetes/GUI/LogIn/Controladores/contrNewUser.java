package pacopaquetes.GUI.LogIn.Controladores;

import java.awt.*;

import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

import pacopaquetes.PacoPaquetes;
import pacopaquetes.GUI.A_GENERALES.errorWindow;

public class contrNewUser implements ActionListener {
    private ArrayList<JTextField> labels;
    private JPanel cardLay;
    private PacoPaquetes pp;

    @SafeVarargs
    public contrNewUser(PacoPaquetes pp, JPanel cardLay, JTextField... labels) {
        this.labels = (ArrayList<JTextField>) Arrays.asList(labels);
        this.cardLay = cardLay;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int x = pp.findUsuario(usuario1.getText(), contrasena1.getText());
        if (x == -1) {
            pp.getOperario().nuevoCliente(usuario, contrasena, cif, empresa, direccion, correo, tarjeta);
        } else {
            new errorWindow("Perfil con el mismo nombre y contraseña");
        }

        CardLayout cardLayout = (CardLayout) this.cardLay.getLayout();
        cardLayout.previous(this.cardLay);
    }
}