package pacopaquetes.GUI.Cliente.Controlador;

import java.awt.event.*;

import pacopaquetes.GUI.A_GENERALES.infoWindow;

import pacopaquetes.envios.Pedido;
import pacopaquetes.usuarios.Cliente;
import pacopaquetes.usuarios.Operario;
/**
 *  Clase para generar factura de un pedido
 */
public class contrGenerarFactura implements ActionListener {
    private Cliente cli;
    private Pedido ped;
    private Operario op;

    public contrGenerarFactura(Cliente cli, Pedido ped, Operario op) {
        this.cli = cli;
        this.ped = ped;
        this.op = op;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        op.generarFactura(ped, cli);
        new infoWindow("Se generó la factura para el pedido Nº" + ped.getId());
    }


}
