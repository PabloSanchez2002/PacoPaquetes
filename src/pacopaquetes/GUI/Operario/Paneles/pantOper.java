package pacopaquetes.GUI.Operario.Paneles;

import pacopaquetes.*;
import pacopaquetes.usuarios.*;
import pacopaquetes.GUI.Operario.Controladores.*;
import pacopaquetes.GUI.Cliente.Controlador.*;
import pacopaquetes.GUI.A_GENERALES.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class pantOper extends JFrame {

    public pantOper(PacoPaquetes pp, Operario op) {
        JPanel cardLay = new JPanel();
        cardLay.setLayout(new CardLayout());
        JPanel ventana = new JPanel();
        ventana.setLayout(new FlowLayout());
        // crear componentes
        JLabel wellcome = new JLabel("Bienvenido" + op.getUsuario() + "\n  ");

        JButton alta_r = new JButton("Alta Repartidor");
        JButton baja_r = new JButton("Baja Repartidor");
        JButton alta_c = new JButton("Alta Camion");
        JButton baja_c = new JButton("Baja Camion");
        JButton stats = new JButton("Estadísticas");
        JButton fact = new JButton("Facturación");
        JButton pedido = new JButton("Crear pedido");
        JButton conf = new JButton("Configuración");
        JButton paquete = new JButton("Visualizar empaquetación");
        JButton cerrarSesion = new JButton("Cerrar sesión");

        // asociar acciones a componentes
        alta_r.addActionListener(new altaRep(op, cardLay));
        baja_r.addActionListener(new bajaRep(op, cardLay));
        alta_c.addActionListener(new altaCam(op, cardLay));
        baja_c.addActionListener(new bajaCam(op, cardLay));
        stats.addActionListener(new verEst(op, cardLay));
        fact.addActionListener(new verFact(op, cardLay));
        pedido.addActionListener(new crearPedido(op, cardLay));
        conf.addActionListener(new configuracion(op, cardLay));
        paquete.addActionListener(new verEmpaquetacion(op, cardLay));
        cerrarSesion.addActionListener(new logOut(pp));

        ventana.add(alta_r);
        ventana.add(baja_r);
        ventana.add(alta_c);
        ventana.add(baja_c);
        ventana.add(stats);
        ventana.add(fact);
        ventana.add(pedido);
        ventana.add(conf);
        ventana.add(paquete);
        ventana.add(cerrarSesion);

        cardLay.add(ventana, "" + 0);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(cardLay, BorderLayout.CENTER);
        setSize(400, 300);
    }

}
