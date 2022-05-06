package pacopaquetes.GUI.Cliente.Paneles;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import pacopaquetes.PacoPaquetes;
import pacopaquetes.GUI.A_GENERALES.logOut;
import pacopaquetes.GUI.Cliente.Controlador.actualizDatos;
import pacopaquetes.GUI.Cliente.Controlador.datosCliente;
import pacopaquetes.GUI.Cliente.Controlador.menuPedidos;
import pacopaquetes.usuarios.Cliente;

public class pantCliente extends JFrame {

    public pantCliente(PacoPaquetes pp, Cliente cli) {
        JPanel cardLay = new JPanel();
        cardLay.setLayout(new CardLayout());

        JPanel ventana = new JPanel();
        ventana.setLayout(new FlowLayout());
        // crear componentes
        JLabel wellcome = new JLabel("Bienvenido" + cli.getUsuario() + "\n  " + cli.getNombreEmpresa());

        JButton pedidos = new JButton("Ver estado pedidos");
        JButton datos = new JButton("Modificar datos");
        JButton cerrarSesion = new JButton("Cerrar sesión");
        // asociar acciones a componentes
        pedidos.addActionListener(new menuPedidos(pp, cli));
        datos.addActionListener(new datosCliente(cardLay));
        cerrarSesion.addActionListener(new logOut(pp));

        // añadir componentes al contenedor
        ventana.add(wellcome);
        ventana.add(pedidos);
        ventana.add(datos);
        ventana.add(cerrarSesion);

        //////////////// vista de editar datos
        JPanel editDatos = new JPanel();
        editDatos.setLayout(new FlowLayout());
        JLabel nombre = new JLabel("EDITAR DATOS");
        JLabel empresa = new JLabel("   Nombre de empresa: " + cli.getNombreEmpresa());
        final JTextField empresa1 = new JTextField(10);
        JLabel usuarioreg = new JLabel("Usuario: " + cli.getUsuario());
        final JTextField usuario1 = new JTextField(10);
        JLabel contrasenareg = new JLabel("  Contraseña: " + cli.getContrasena());
        final JTextField contrasena1 = new JPasswordField(10);
        JLabel direccion = new JLabel("   Direccion de facturación: " + cli.getDirecconFacturacion());
        final JTextField direccion1 = new JTextField(10);
        JLabel correo = new JLabel("   Correo electronico: " + cli.getCorreoElectronico());
        final JTextField correo1 = new JTextField(10);
        JLabel targB = new JLabel("  Tarjeta bancaria: " + cli.getTargetaBancaria());
        final JTextField targB1 = new JTextField(10);
        JButton guardar = new JButton("Guardar");

        guardar.addActionListener(new actualizDatos(usuario1.getText(), empresa1.getText(), contrasena1.getText(),
                direccion1.getText(), correo1.getText(), targB1.getText(), cli));

        editDatos.add(nombre);
        editDatos.add(empresa);
        editDatos.add(empresa1);
        editDatos.add(usuarioreg);
        editDatos.add(usuario1);
        editDatos.add(contrasenareg);
        editDatos.add(contrasena1);
        editDatos.add(direccion);
        editDatos.add(direccion1);
        editDatos.add(correo);
        editDatos.add(correo1);
        editDatos.add(targB);
        editDatos.add(targB1);
        editDatos.add(guardar);

        cardLay.add(ventana, "" + 0);
        cardLay.add(editDatos, "" + 1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(cardLay, BorderLayout.CENTER);
        setSize(400, 300);
    }

}
