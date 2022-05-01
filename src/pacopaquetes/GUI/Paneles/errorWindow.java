package pacopaquetes.GUI.Paneles;

import java.awt.*;
import javax.swing.*;

public class errorWindow {
    public errorWindow(String error) {
        JFrame ventana = new JFrame("LogIn");
        // obtener contenedor, asignar layout
        Container contenedor = ventana.getContentPane();
        contenedor.setLayout(new FlowLayout());
        // crear componentes
        JLabel etiqueta = new JLabel("ERROR:");
        JLabel err = new JLabel(error);

        contenedor.add(etiqueta);
        contenedor.add(err);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(30, 20);
        ventana.setVisible(true);
    }
}
