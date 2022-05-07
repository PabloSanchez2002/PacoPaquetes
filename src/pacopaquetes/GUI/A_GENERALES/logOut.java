package pacopaquetes.GUI.A_GENERALES;

import java.awt.event.*;

import javax.swing.*;
import pacopaquetes.PacoPaquetes;
import pacopaquetes.GUI.LogIn.Paneles.logIn;

public class logOut implements ActionListener {
    private PacoPaquetes pp;
    private JFrame panel;

    public logOut(PacoPaquetes pp, JFrame panel) {
        this.pp = pp;
        this.panel = panel;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new logIn(pp).setVisible(true);
        panel.setVisible(false);

    }

}
