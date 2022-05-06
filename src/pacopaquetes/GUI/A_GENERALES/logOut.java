package pacopaquetes.GUI.A_GENERALES;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;
import pacopaquetes.PacoPaquetes;
import pacopaquetes.GUI.LogIn.Paneles.logIn;

public class logOut implements ActionListener {
    private PacoPaquetes pp;

    public logOut(PacoPaquetes pp) {
        this.pp = pp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new logIn(pp).setVisible(true);

    }

}
