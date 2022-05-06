package pacopaquetes.GUI.Controladores;

import java.awt.event.*;

import pacopaquetes.PacoPaquetes;
import pacopaquetes.GUI.Paneles.errorWindow;
import pacopaquetes.GUI.Paneles.Cliente.pantCliente;

public class contrLogIn implements ActionListener {
    private PacoPaquetes pp;
    private String usuario;
    private String contrasena;

    public contrLogIn( PacoPaquetes pp, String usuario, String contrasena) {
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
            new pantCliente(pp, pp.findClienteByName(usuario));
        } else if (x == 2) {
            // new pantRepartidor(pp, pp.findRepByName(usuario));
        } else {
            new errorWindow("Contraseña o usuario no validos");
        }

    }

}
