package pacopaquetes.GUI.LogIn.Paneles;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import pacopaquetes.PacoPaquetes;
import pacopaquetes.GUI.LogIn.Controladores.*;

public class logIn extends JFrame {
    //Primera pantalla
    private JTextField campo;
    private JTextField campo2;
    //Segunda pantalla
    private JTextField empresa1;
    private JTextField usuario1;
    private JTextField contrasena1;
    private JTextField cif1;
    private JTextField direccion1;
    private JTextField correo1;
    private JTextField targB1;

    public logIn(PacoPaquetes pp) {
        JPanel cardLay = new JPanel();
        cardLay.setLayout(new CardLayout());
        this.setResizable(false);

        JPanel ventana = new JPanel();
        // obtener contenedor, asignar layout
        ventana.setLayout(new FlowLayout());
        // crear componentes
        JLabel etiqueta = new JLabel("Log in:");
        JLabel usuario = new JLabel("   Usuario:");
        this.campo = new JTextField(10);
        JLabel contrasena = new JLabel("  Contraseña:");
        this.campo2 = new JPasswordField(10);
        JButton boton = new JButton("Inicia sesión");
        JButton registro = new JButton("Registrarse cliente");
        // asociar acciones a componentes
        boton.addActionListener(new contrLogIn(pp, this));

        registro.addActionListener(new contrRegistro(cardLay));
        // añadir componentes al contenedor
        etiqueta.setFont(new Font("Tahoma", Font.BOLD, 70));
        ventana.add(etiqueta);
        ventana.add(usuario);
        ventana.add(campo);
        ventana.add(contrasena);
        ventana.add(campo2);
        ventana.add(boton);
        ventana.add(registro);

        //////////////// REGISTRO////////////////////////
        JPanel registrar = new JPanel();
        registrar.setLayout(new FlowLayout());
        JLabel nombre = new JLabel("Nuevo cliente");
        JLabel empresa = new JLabel("   Nombre de empresa:");
        this.empresa1 = new JTextField(10);
        JLabel usuarioreg = new JLabel("Usuario: ");
        this.usuario1 = new JTextField(10);
        JLabel contrasenareg = new JLabel("  Contraseña:");
        this.contrasena1 = new JPasswordField(10);
        JLabel cif = new JLabel("   CIF:");
        this.cif1 = new JTextField(10);
        JLabel direccion = new JLabel("   Direccion de facturación:");
        this.direccion1 = new JTextField(10);
        JLabel correo = new JLabel("   Correo electronico:");
        this.correo1 = new JTextField(10);
        JLabel targB = new JLabel("  Tarjeta bancaria:");
        this.targB1 = new JTextField(10);
        JButton registroreg = new JButton("Registrarse");

        nombre.setFont(new Font("Tahoma", Font.BOLD, 30));
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

        registroreg
                .addActionListener(
                        new contrNewUser(pp, cardLay, this));



        cardLay.add(ventana, "" + 0);
        cardLay.add(registrar, "" + 1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(cardLay, BorderLayout.CENTER);
        setSize(280, 400);
    }

    public ArrayList<String> getLogIns(){
        ArrayList<String> s = new ArrayList<>();
        s.add(campo.getText());
        s.add(campo2.getText());
        return s;
    }

    public ArrayList<String>  getRegistros(){
        ArrayList<String> s = new ArrayList<>();
        s.add(empresa1.getText());
        s.add(usuario1.getText());
        s.add(contrasena1.getText());
        s.add(cif1.getText());
        s.add(direccion1.getText());
        s.add(correo1.getText());
        s.add(targB1.getText());
        return s;
    }
}
