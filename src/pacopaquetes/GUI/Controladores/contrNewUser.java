package pacopaquetes.GUI.Controladores;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import pacopaquetes.PacoPaquetes;
import pacopaquetes.GUI.Paneles.errorWindow;

public class contrNewUser implements ActionListener {
    private String usuario;
    private String empresa;
    private String contrasena;
    private String cif;
    private String direccion;
    private String correo;
    private String tarjeta;
    private JPanel cardLay;
    private PacoPaquetes pp;

    public contrNewUser(PacoPaquetes pp,String usuario, String empresa, String contrasena, String cif, String direccion, String correo, String tarjeta, JPanel cardLay) {
        this.pp = pp;
        this.usuario = usuario;
        this.empresa = empresa;
        this.contrasena = contrasena;
        this.cif = cif;
        this.direccion = direccion;
        this.correo = correo;
        this.tarjeta = tarjeta;
        this.cardLay = cardLay;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int x = pp.findUsuario(usuario, contrasena);
        if(x == -1){
            pp.getOperario().nuevoCliente(usuario, contrasena, cif, empresa, direccion, correo, tarjeta);
        }else{
            new errorWindow("Perfil con el mismo nombre y contraseña");
        }
        
        CardLayout cardLayout = (CardLayout) this.cardLay.getLayout();
        cardLayout.previous(this.cardLay);
    }
}