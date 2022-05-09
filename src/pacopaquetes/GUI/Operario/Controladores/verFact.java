package pacopaquetes.GUI.Operario.Controladores;


import java.awt.event.*;


import pacopaquetes.*;
import pacopaquetes.GUI.A_GENERALES.infoWindow;
import pacopaquetes.envios.Pedido;
import pacopaquetes.usuarios.Cliente;
import java.util.ArrayList;
/**
 *  Clase para generar facturas de todos los pedidos de la empresa
 */
public class verFact implements ActionListener {
    private PacoPaquetes pp;

    public verFact(PacoPaquetes pp) {
        this.pp = pp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Cliente> clis = this.pp.getClientes();

        for(Cliente c : clis){
            ArrayList<Pedido> peds = c.getPedidos();
            for (Pedido p : peds){
                this.pp.getOperario().generarFactura(p, c);
            }
        }
        new infoWindow("Se han generado las fcaturas de todos los pedidos");
    }
}
