package pacopaquetes.GUI.Cliente.Paneles;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import pacopaquetes.PacoPaquetes;
import pacopaquetes.GUI.A_GENERALES.logOut;
import pacopaquetes.GUI.Cliente.Controlador.actualizDatos;
import pacopaquetes.GUI.Cliente.Controlador.datosCliente;
import pacopaquetes.GUI.Cliente.Controlador.menuPedidos;
import pacopaquetes.usuarios.Cliente;

public class pantCliente extends JFrame {
    private JTextField empresa1;
    private JTextField usuario1;
    private JTextField contrasena1;
    private JTextField direccion1;
    private JTextField correo1;
    private JTextField targB1;

    public pantCliente(PacoPaquetes pp, Cliente cli) {
        JPanel cardLay = new JPanel();
        cardLay.setLayout(new CardLayout());
        this.setResizable(false);

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
        cerrarSesion.addActionListener(new logOut(pp, this));

        // añadir componentes al contenedor
        wellcome.setFont(new Font("Tahoma", Font.BOLD, 30));
        ventana.add(wellcome);
        ventana.add(pedidos);
        ventana.add(datos);
        ventana.add(cerrarSesion);

        //////////////// vista de editar datos
        JPanel editDatos = new JPanel();
        editDatos.setLayout(new FlowLayout());
        JLabel nombre = new JLabel("EDITAR DATOS");
        JLabel empresa = new JLabel("   Nombre de empresa: " + cli.getNombreEmpresa());
        this.empresa1 = new JTextField(10);
        JLabel usuarioreg = new JLabel("Usuario: " + cli.getUsuario());
        this.usuario1 = new JTextField(10);
        JLabel contrasenareg = new JLabel("  Contraseña: " + cli.getContrasena());
        this.contrasena1 = new JPasswordField(10);
        JLabel direccion = new JLabel("   Direccion de facturación: " + cli.getDirecconFacturacion());
        this.direccion1 = new JTextField(10);
        JLabel correo = new JLabel("   Correo electronico: " + cli.getCorreoElectronico());
        this.correo1 = new JTextField(10);
        JLabel targB = new JLabel("  Tarjeta bancaria: " + cli.getTargetaBancaria());
        this.targB1 = new JTextField(10);
        JButton guardar = new JButton("Guardar");

        guardar.addActionListener(new actualizDatos(cli, cardLay, this));

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
        setSize(600, 400);
    }
    public ArrayList<String> getNewRegistros(){
        ArrayList<String> s = new ArrayList<>();
        s.add(empresa1.getText());
        s.add(usuario1.getText());
        s.add(contrasena1.getText());
        s.add(direccion1.getText());
        s.add(correo1.getText());
        s.add(targB1.getText());
        return s;
    }

}
