package pacopaquetes.GUI.Cliente.Controlador;

import java.awt.event.*;
import java.util.ArrayList;

import pacopaquetes.GUI.Cliente.Paneles.pantCliente;
import pacopaquetes.GUI.A_GENERALES.*;
import pacopaquetes.usuarios.Cliente;
/**
 *  Clase para actualizar los datos del cliente
 */
public class actualizDatos implements ActionListener {
    private pantCliente panel;
    private Cliente cli;

    public actualizDatos(Cliente cli, pantCliente panel) {
            this.panel = panel;
            this.cli = cli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<String> s = this.panel.getNewRegistros();
        if (s.get(0).equals("") ==false) {
            cli.setNombreEmpresa(s.get(0));
        }
        if (s.get(1).equals("") ==false) {
            cli.setUsuario(s.get(1));
        }
        if (s.get(2).equals("") ==false) {
            cli.setContrasena(s.get(2));
        }
        if (s.get(3).equals("") ==false) {
            cli.setDirecconFacturacion(s.get(3));
        }
        if (s.get(4).equals("") ==false) {
            cli.setCorreoElectronico(s.get(4));
        }
        if (s.get(5).equals("") ==false) {
            cli.setTargetaBancaria(s.get(5));
        }

        new pantCliente(panel.getPP(), cli).setVisible(true);
        panel.setVisible(false);
        new infoWindow("Los datos personales se cambiaron con exito");
    }

}
