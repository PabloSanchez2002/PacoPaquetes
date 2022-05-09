package pacopaquetes.GUI.A_GENERALES;

import java.awt.*;
import javax.swing.*;

/**
 *  Clase para mostrar un error por pantalla con un mensaje pasado por argumento
 */
public class errorWindow {
    public errorWindow(String error) {
        JFrame ventana = new JFrame("Error");
        // obtener contenedor, asignar layout
        Container contenedor = ventana.getContentPane();
        contenedor.setLayout(new FlowLayout());
        // crear componentes
        JLabel etiqueta = new JLabel("¡¡¡ERROR!!!");
        JLabel err = new JLabel("   " + error + "    ");

        contenedor.add(etiqueta);
        contenedor.add(err);

        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setSize(300, 200);
        ventana.setVisible(true);
    }
}
