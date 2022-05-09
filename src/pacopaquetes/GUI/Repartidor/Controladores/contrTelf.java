package pacopaquetes.GUI.Repartidor.Controladores;

import java.awt.event.*;
import pacopaquetes.GUI.A_GENERALES.*;


import pacopaquetes.GUI.A_GENERALES.errorWindow;
import pacopaquetes.GUI.Repartidor.Paneles.*;
import pacopaquetes.usuarios.*;
/**
 * Clase para modificar el numero de telefono del repartidor
 */
public class contrTelf implements ActionListener {
    private pantRepartidor rep;
    private Repartidor repar;

    public contrTelf(pantRepartidor rep, Repartidor repartidor) {
        this.rep = rep;
        this.repar = repartidor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = rep.getNumTelf();
        if(!(s.equals(""))){
            if(repar.getTelefono().equals(s)){
                new errorWindow("Numero de telefono identico, pruebe uno nuevo");
            }
            else{
                repar.setTelefono(s);
                pantRepartidor pant = new pantRepartidor(rep.getPP(),repar);
                pant.setVisible(true);
                rep.setVisible(false);
                new infoWindow("Numero de telefono correcto");
            }
        }
        else{
            new errorWindow("Numero de telefono vacio, vuelva a intentarlo");
        }
    }
}