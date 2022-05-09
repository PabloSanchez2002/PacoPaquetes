package pacopaquetes.GUI.A_GENERALES;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  Clase para volver un numero de veces atras en el cardLayout
 */
public class contrVolver implements ActionListener {
    private JPanel cardLay;
    int num;
    
    public contrVolver(JPanel cardLay, int num){
        this.cardLay = cardLay;
        this.num = num;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cl = (CardLayout) this.cardLay.getLayout();
        for(int i = 0; i< this.num; i++){
            cl.previous(this.cardLay);
        }
    }
}
