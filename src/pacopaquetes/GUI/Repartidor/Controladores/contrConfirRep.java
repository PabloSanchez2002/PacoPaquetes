package pacopaquetes.GUI.Repartidor.Controladores;
import pacopaquetes.PacoPaquetes;
import pacopaquetes.GUI.A_GENERALES.*;

import java.awt.event.*;
import java.util.Map;

import javax.swing.JCheckBox;

import pacopaquetes.GUI.Repartidor.Paneles.pantRepartidor;
import pacopaquetes.envios.Paquete;
import pacopaquetes.usuarios.*;

public class contrConfirRep implements ActionListener {
    private pantRepartidor repar;
    private Repartidor rep;
    private Map<JCheckBox,Paquete> box;

    public contrConfirRep(pantRepartidor pantrep, Repartidor rep,Map<JCheckBox,Paquete> box) {
        this.repar = pantrep;
        this.rep = rep;
        this.box = box;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PacoPaquetes pp = repar.getPP();
        for(Map.Entry<JCheckBox, Paquete> entry : box.entrySet()){
            JCheckBox b = entry.getKey();
            Paquete paq = entry.getValue();

            for(Paquete paquet : pp.getPaquetes()){
                if(paquet.equals(paq)){
                    if(b.isSelected() == true){
                        
                    }
                }
            }



        }
    }
}