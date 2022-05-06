package pacopaquetes.GUI.Repartidor.Paneles;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import pacopaquetes.PacoPaquetes;
import pacopaquetes.GUI.Repartidor.Controladores.*;
import pacopaquetes.usuarios.*;

public class pantRepartidor extends JFrame {

    public pantRepartidor(PacoPaquetes pp, Repartidor rep) {
        JPanel cardLay = new JPanel();
        cardLay.setLayout(new CardLayout());
        JPanel ventana = new JPanel();
        ventana.setLayout(new FlowLayout());
        // crear componentes
        JLabel welcome = new JLabel("Bienvenido" + rep.getUsuario() + "\n");

        JButton consultar = new JButton("Ver plan de reparto");
        JButton reparto = new JButton("Repartir");
        JButton camion = new JButton("Dar de baja camion");

        camion.addActionListener(new contrCamion(cardLay));

        ventana.add(welcome);
        ventana.add(consultar);
        ventana.add(reparto);
        ventana.add(camion);

        cardLay.add(ventana, "" + 0);

        JPanel camionpant = new JPanel();
        ventana.setLayout(new FlowLayout());
        JLabel question = new JLabel(
                "Quiere marcar el Camion: Matrícula" + rep.consultarPlanReparto().getCamion().getMatricula()
                        + " como averiado?");
        JButton averiado = new JButton("Si");
        JButton atrasCamion = new JButton("Atras");

        averiado.addActionListener(new contrAveriado(cardLay, rep));
        atrasCamion.addActionListener(new contrAtrasC(cardLay));

        camionpant.add(question);
        camionpant.add(averiado);
        camionpant.add(atrasCamion);

        cardLay.add(camionpant, "" + 1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(cardLay, BorderLayout.CENTER);
        setSize(400, 300);
    }
}
