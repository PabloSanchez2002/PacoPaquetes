package pacopaquetes.GUI.Cliente.Controlador;

import java.awt.event.*;

import pacopaquetes.GUI.Cliente.Paneles.detalles;

import pacopaquetes.envios.Pedido;

/**
 *  Clase para llamar a mostrar detalles de un pedido
 */
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
