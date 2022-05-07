package pacopaquetes.GUI.LogIn.Controladores;

import java.awt.event.*;
import java.util.ArrayList;

import pacopaquetes.PacoPaquetes;
import pacopaquetes.GUI.A_GENERALES.errorWindow;
import pacopaquetes.GUI.Cliente.Paneles.pantCliente;
import pacopaquetes.GUI.LogIn.Paneles.logIn;

public class contrLogIn implements ActionListener {
    private PacoPaquetes pp;
    private logIn login;

    public contrLogIn(PacoPaquetes pp, logIn login) {
        this.pp = pp;
        this.login = login;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<String> s = this.login.getLogIns();
        int x = pp.findUsuario(s.get(0), s.get(1));
        if (x == 0) {
            login.setVisible(false);
            // new pantOper(pp, pp.getOperario()).setVisible(true);
        } else if (x == 1) {
            login.setVisible(false);
            new pantCliente(pp, pp.findClienteByName(s.get(0))).setVisible(true);
        } else if (x == 2) {
            login.setVisible(false);
            // new pantRepartidor(pp, pp.findRepByName(usuario)).setVisible(true);
        } else {
            new errorWindow("Contraseña o usuario no validos");
        }

    }

}
