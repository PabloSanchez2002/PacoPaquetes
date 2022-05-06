package pacopaquetes.GUI.Paneles;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import pacopaquetes.PacoPaquetes;
import pacopaquetes.GUI.Controladores.*;

public class logIn extends JFrame {

    public logIn(PacoPaquetes pp) {
        JPanel cardLay = new JPanel();
        cardLay.setLayout(new CardLayout());
        JPanel ventana = new JPanel();
        // obtener contenedor, asignar layout
        ventana.setLayout(new FlowLayout());
        // crear componentes
        JLabel etiqueta = new JLabel("Log in:");
        JLabel usuario = new JLabel("   Usuario:");
        final JTextField campo = new JTextField(10);
        JLabel contrasena = new JLabel("  Contraseña:");
        final JTextField campo2 = new JPasswordField(10);
        JButton boton = new JButton("Inicia sesión");
        JButton registro = new JButton("Registrarse cliente");
        // asociar acciones a componentes
        boton.addActionListener(new contrLogIn(pp, campo.getText(), campo2.getText()));

        registro.addActionListener(new contrRegistro(cardLay));
        // añadir componentes al contenedor
        ventana.add(etiqueta);
        ventana.add(usuario);
        ventana.add(campo);
        ventana.add(contrasena);
        ventana.add(campo2);
        ventana.add(boton);
        ventana.add(registro);



        ////////////////REGISTRO////////////////////////
        JPanel registrar = new JPanel();
        registrar.setLayout(new FlowLayout());
        JLabel nombre = new JLabel("Nuevo cliente");
        JLabel empresa = new JLabel("   Nombre de empresa:");
        final JTextField empresa1 = new JTextField(10);
        JLabel usuarioreg = new JLabel("Usuario: ");     
        final JTextField usuario1 = new JTextField(10);
        JLabel contrasenareg = new JLabel("  Contraseña:");
        final JTextField contrasena1 = new JPasswordField(10);
        JLabel cif = new JLabel("   CIF:");
        final JTextField cif1 = new JTextField(10);
        JLabel direccion = new JLabel("   Direccion de facturación:");
        final JTextField direccion1 = new JTextField(10);
        JLabel correo = new JLabel("   Correo electronico:");
        final JTextField correo1 = new JTextField(10);
        JLabel targB = new JLabel("  Tarjeta bancaria:");
        final JTextField targB1 = new JTextField(10);
        JButton registroreg = new JButton("Registrarse");

        registrar.add(nombre);
        registrar.add(empresa);
        registrar.add(empresa1);
        registrar.add(usuarioreg);
        registrar.add(usuario1);
        registrar.add(contrasenareg);
        registrar.add(contrasena1);
        registrar.add(cif);
        registrar.add(cif1);
        registrar.add(direccion);
        registrar.add(direccion1);
        registrar.add(correo);
        registrar.add(correo1);
        registrar.add(targB);
        registrar.add(targB1);
        registrar.add(registroreg);

        cardLay.add(ventana, "" + 0);
        cardLay.add(registrar, "" + 1);
        registroreg.addActionListener(new contrNewUser(pp, usuario1.getText(), empresa1.getText(), contrasena1.getText(), cif1.getText(), direccion1.getText(),correo1.getText(), targB1.getText(), cardLay));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(cardLay,BorderLayout.CENTER);
        setSize(400,300);
    }

}
