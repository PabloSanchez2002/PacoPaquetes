package pacopaquetes.GUI.Cliente.Controlador;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import pacopaquetes.PacoPaquetes;
import pacopaquetes.usuarios.Cliente;

public class menuPedidos implements ActionListener {
    private PacoPaquetes pp;
    private Cliente cli;

    public menuPedidos(PacoPaquetes pp, Cliente cli) {
        this.pp = pp;
        this.cli = cli;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // crear vista pedidos y tal

    }

}
