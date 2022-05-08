package pacopaquetes.GUI.Cliente.Controlador;

import java.awt.event.*;

import pacopaquetes.GUI.Cliente.Paneles.detalles;

import pacopaquetes.envios.Pedido;

public class contrVerDetalles implements ActionListener {
    private Pedido p;

    public contrVerDetalles(Pedido p) {
        this.p= p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       new detalles(p);
    }

    
}
