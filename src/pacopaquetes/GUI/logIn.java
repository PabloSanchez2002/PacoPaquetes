package pacopaquetes.GUI.Paneles;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class logIn extends JPanel {
    public logIn() {
        JFrame ventana = new JFrame("Mi GUI");
        // obtener contenedor, asignar layout
        Container contenedor = ventana.getContentPane();
        contenedor.setLayout(new FlowLayout());
        // crear componentes
        JLabel etiqueta = new JLabel("Log in:");
        JLabel usuario = new JLabel("   Usuario:");
        final JTextField campo = new JTextField(10);
        JLabel contrasena = new JLabel("  Contraseña:");
        final JTextField campo2 = new JPasswordField(10);
        JButton boton = new JButton("Inicia sesión");
        JButton registro = new JButton("Registrarse cliente");
        // asociar acciones a componentes
        boton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, campo.getText());
                    }
                });

        registro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventana.setVisible(false);
                registrarse r = new registrarse();
            }
        });
        // añadir componentes al contenedor
        contenedor.add(new JLabel(new ImageIcon("resources/logo.png")));
        contenedor.add(etiqueta);
        contenedor.add(usuario);
        contenedor.add(campo);
        contenedor.add(contrasena);
        contenedor.add(campo2);
        contenedor.add(boton);
        contenedor.add(registro);
        // mostrar ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(200, 240);
        ventana.setVisible(true);
    }

    public class registrarse {

        public registrarse() {
            JFrame registrar = new JFrame("Registro");
            Container contenedorReg = registrar.getContentPane();
            contenedorReg.setLayout(new FlowLayout());
            JLabel nombre = new JLabel("Nuevo cliente");
            JLabel empresa = new JLabel("   Nombre de empresa:");
            final JTextField empresa1 = new JTextField(10);
            JLabel contrasena = new JLabel("  Contraseña:");
            final JTextField contrasena1 = new JPasswordField(10);
            JLabel cif = new JLabel("   CIF:");
            final JTextField cif1 = new JTextField(10);
            JLabel direccion = new JLabel("   Direccion de facturación:");
            final JTextField direccion1 = new JTextField(10);
            JLabel targB = new JLabel("  Tarjeta bancaria:");
            final JTextField targB1 = new JTextField(10);
            JButton registro = new JButton("Registrarse");

            contenedorReg.add(nombre);
            contenedorReg.add(empresa);
            contenedorReg.add(empresa1);
            contenedorReg.add(contrasena);
            contenedorReg.add(contrasena1);
            contenedorReg.add(cif);
            contenedorReg.add(cif1);
            contenedorReg.add(direccion);
            contenedorReg.add(direccion1);
            contenedorReg.add(targB);
            contenedorReg.add(targB1);
            contenedorReg.add(registro);

            registrar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            registrar.setSize(200, 240);
            registrar.setVisible(true);
        }
    }
}
