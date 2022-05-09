package pacopaquetes.GUI.Repartidor.Controladores;
import pacopaquetes.GUI.A_GENERALES.*;

import java.awt.event.*;


import pacopaquetes.GUI.Repartidor.Paneles.pantRepartidor;
import pacopaquetes.usuarios.*;

public class contrAveriado implements ActionListener {
    private pantRepartidor repar;
    private Repartidor rep;

    public contrAveriado(pantRepartidor cardLay, Repartidor rep) {
        this.repar = cardLay;
        this.rep = rep;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        rep.setCamionAveriado();
        pantRepartidor pant = new pantRepartidor(repar.getPP(),rep);
        pant.setVisible(true);
        repar.setVisible(false);
        new infoWindow("Camion dado de baja correctamente");
    }
}