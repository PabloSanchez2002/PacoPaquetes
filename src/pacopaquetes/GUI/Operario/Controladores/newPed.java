package pacopaquetes.GUI.Operario.Controladores;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

import pacopaquetes.ModifiableDate;
import pacopaquetes.GUI.A_GENERALES.errorWindow;
import pacopaquetes.GUI.Operario.Paneles.*;
import pacopaquetes.usuarios.*;
import enums.*;

/**
 * Clase para crear un nuevo pedido
 */
public class newPed implements ActionListener {
    private JPanel cardLay;
    private pantOper panel;
    private Operario op;

    public newPed(Operario op, JPanel cardLay, pantOper panel) {
            this.panel = panel;
            this.cardLay = cardLay;
            this.op = op;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        ArrayList<String> s = this.panel.getDatosPed();
        if (s.get(0).equals("") ==true || s.get(1).equals("") ==true) {
            new errorWindow("Campos vacíos, intentalo de nuevo");
        }else{
            //Asegurar si cliente es null
            Cliente cli = op.getEmpresa().findClienteByName(s.get(0));
            if(cli==null) new errorWindow("No existe un cliente llamado "+s.get(0));
            else{
                if(op.getEmpresa().getCPs().contains(s.get(1)) == false) new errorWindow("No existe el código postal "+s.get(1));
                else{
                    String cp=s.get(1);
                    PRIORIDAD pr;
                    if(s.get(2).equals("s")) pr=PRIORIDAD.URGENTE;
                    else pr=PRIORIDAD.NORMAL;



                    this.panel.setPed(op.CrearPedido(cli, new ModifiableDate(), cp, pr));

                    CardLayout cardLayout = (CardLayout) this.cardLay.getLayout();
                    cardLayout.next(this.cardLay);
                }
            }
        }
        
    }
}