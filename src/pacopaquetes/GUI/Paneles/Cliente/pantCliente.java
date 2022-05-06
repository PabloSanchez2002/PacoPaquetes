package pacopaquetes.GUI.Paneles.Cliente;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import pacopaquetes.PacoPaquetes;
import pacopaquetes.GUI.Controladores.*;
import pacopaquetes.GUI.Paneles.logIn;
import pacopaquetes.usuarios.Cliente;
public class pantCliente extends JFrame{
   
        public pantCliente(PacoPaquetes pp, Cliente cli) {
            JPanel cardLay = new JPanel();
            cardLay.setLayout(new CardLayout());
            JPanel ventana = new JPanel();
            ventana.setLayout(new FlowLayout());
            // crear componentes
            JLabel wellcome = new JLabel("Bienvenido" + cli.getUsuario() + "\n  " +cli.getNombreEmpresa());
        

            JButton pedidos = new JButton("Ver estado pedidos");
            JButton datos = new JButton("Modificar datos");
            JButton cerrarSesion = new JButton("Cerrar sesión");
            // asociar acciones a componentes
            //pedidos.addActionListener(new menuPedidos(pp, cli));
            //datos.addActionListener(new datosCliente(cli));
            //cerrarSesion.addActionListener(new logOut(pp));

            // añadir componentes al contenedor
            ventana.add(pedidos);
            ventana.add(datos);
            ventana.add(cerrarSesion);
    
            cardLay.add(ventana, "" + 0);
        
    
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            getContentPane().add(cardLay,BorderLayout.CENTER);
            setSize(180,240);
        }
    
    }
    
}
