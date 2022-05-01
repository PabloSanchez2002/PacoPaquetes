package pacopaquetes.GUI.Controladores;

import java.awt.*;

import java.awt.event.*;

import pacopaquetes.PacoPaquetes;
import pacopaquetes.GUI.Paneles.errorWindow;
import pacopaquetes.GUI.Paneles.logIn;

public class contrLogIn implements ActionListener {
    private logIn log;
    private PacoPaquetes pp;
    private String usuario;
    private String contrasena;

    public contrLogIn(logIn log, PacoPaquetes pp, String usuario, String contrasena) {
        this.log = log;
        this.pp = pp;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int x = pp.findUsuario(this.usuario, this.contrasena);
        if (x == 0) {
            // new pantOper(pp, pp.getOperario());
        } else if (x == 1) {
            // new pantCliente(pp, pp.findClienteByName(usuario));
        } else if (x == 2) {
            // new pantRepartidor(pp, pp.findRepByName(usuario));
        } else {
            new errorWindow("Contraseña o usuario no validos");
        }

    }

}
