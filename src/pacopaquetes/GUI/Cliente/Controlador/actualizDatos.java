package pacopaquetes.GUI.Cliente.Controlador;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import pacopaquetes.usuarios.Cliente;

public class actualizDatos implements ActionListener {
    private String usuario;
    private String empresa;
    private String contrasena;
    private String direccion;
    private String correo;
    private String targ;
    private Cliente cli;

    public actualizDatos(String usuario, String empresa, String contrasena, String direccion, String correo,
            String targ, Cliente cli) {
        this.usuario = usuario;
        this.empresa = empresa;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.correo = correo;
        this.targ = targ;
        this.cli = cli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (usuario != "") {
            cli.setUsuario(usuario);
        }
        if (empresa != "") {
            cli.setNombreEmpresa(empresa);
        }
        if (contrasena != "") {
            cli.setContrasena(contrasena);
        }
        if (direccion != "") {
            cli.setDirecconFacturacion(direccion);
        }
        if (correo != "") {
            cli.setCorreoElectronico(correo);
        }
        if (targ != "") {
            cli.setTargetaBancaria(targ);
        }

    }

}
