package pacopaquetes.GUI.Repartidor.Controladores;
import pacopaquetes.PacoPaquetes;

import java.awt.event.*;
import java.util.Map;

import javax.swing.JCheckBox;

import pacopaquetes.GUI.A_GENERALES.infoWindow;
import pacopaquetes.GUI.Repartidor.Paneles.pantRepartidor;
import pacopaquetes.envios.Paquete;
import pacopaquetes.envios.productos.Producto;
import pacopaquetes.usuarios.*;
import enums.*;

/**
 * Clase para que se marquen como repartidos los paquetes del plan de reparto del repartidor y se elimine su plan de reparto
 */
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
                         paquet.setEntregado(ESTADO.ENTREGADO);
                    for (Producto prods : paquet.getProductos()) {
                        prods.setEstado(ESTADO.ENTREGADO);
                    }
                    }
                    else{
                        paquet.setNintentos(paquet.getNIntentos() - 1);
                        paquet.setEntregado(ESTADO.EN_ALMACEN);
                        for (Producto prods : paquet.getProductos()) {
                            prods.setNintentos(prods.getNIntentos() - 1);
                            prods.setEstado(ESTADO.EN_ALMACEN);
                        }
                    }
                }
            }
        }

        this.rep.setPlanReparto(null);
        new pantRepartidor(pp,this.rep).setVisible(true);
        repar.setVisible(false);
        new infoWindow("Reparto realizado correctamente");
    }
}