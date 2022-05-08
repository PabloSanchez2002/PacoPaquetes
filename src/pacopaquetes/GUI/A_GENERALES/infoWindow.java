package pacopaquetes.GUI.A_GENERALES;

import java.awt.*;
import javax.swing.*;

public class infoWindow {
    public infoWindow(String inf) {
        JFrame ventana = new JFrame("Info");
        // obtener contenedor, asignar layout
        Container contenedor = ventana.getContentPane();
        contenedor.setLayout(new FlowLayout());
        // crear componentes
        JLabel etiqueta = new JLabel("INFORMACION:");
        JLabel info = new JLabel("   " + inf + "    ");

        etiqueta.setFont(new Font("Tahoma", Font.BOLD, 30));
        contenedor.add(etiqueta);
        contenedor.add(info);

        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setSize(400, 200);
        ventana.setVisible(true);
    }
}
