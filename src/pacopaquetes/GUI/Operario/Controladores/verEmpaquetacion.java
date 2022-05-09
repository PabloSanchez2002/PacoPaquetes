package pacopaquetes.GUI.Operario.Controladores;

import java.awt.event.*;


import pacopaquetes.GUI.A_GENERALES.infoWindow;
import pacopaquetes.GUI.Operario.Paneles.pantOper;
import pacopaquetes.usuarios.*;

/**
 * Clase para realizar el empaquetado de la empresa
 */
public class verEmpaquetacion implements ActionListener {
    private Operario op;
    private pantOper pant;

    public verEmpaquetacion(pantOper pant,Operario op) {
        this.op = op;
        this.pant = pant;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        op.empaquetar();
        new pantOper(op.getEmpresa(), op).setVisible(true);
        pant.setVisible(false);
        new infoWindow("Empaquetado correctamente");
    }
}
