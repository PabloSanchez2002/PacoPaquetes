package pacopaquetes.GUI.Operario.Paneles;

import pacopaquetes.*;
import pacopaquetes.usuarios.*;
import pacopaquetes.GUI.Operario.Controladores.*;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class pantOper extends JFrame {
    private JTextField usuariorep1;
    private JTextField contrasenarep1;
    private JTextField telefonorep1;
    private JTextField matriculacam1;
    private JTextField pesoMax1;
    private JTextField usuariorepp1;
    private JTextField matriculacamm1;
    private JTextField n_reint1;
    private JTextField maxVolume1;
    private JTextField descuento1;
    private JTextField maxCodPos1;
    private JTextField maxPesoPNormal1;
    private JTextField maxPesoPFragil1;
    private JComboBox<String> tipoCam1;

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
        alta_r.addActionListener(new altaRep(cardLay));
        baja_r.addActionListener(new bajaRep(cardLay));
        alta_c.addActionListener(new altaCam(cardLay));
        baja_c.addActionListener(new bajaCam(cardLay));
        stats.addActionListener(new verEst(cardLay));
        fact.addActionListener(new verFact(cardLay));
        pedido.addActionListener(new crearPedido(cardLay));
        conf.addActionListener(new configuracion(cardLay));
        paquete.addActionListener(new verEmpaquetacion(cardLay));
        //cerrarSesion.addActionListener(new logOut(pp, this));

        ventana.add(wellcome);
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


        //////////////// vista de nuevo repartidor
        JPanel newRepp = new JPanel();
        newRepp.setLayout(new FlowLayout());
        JLabel nombrer = new JLabel("DATOS REPARTIDOR");
        JLabel usuariorep = new JLabel("Usuario: ");
        this.usuariorep1 = new JTextField(10);
        JLabel contrasenarep = new JLabel("  Contraseña: ");
        this.contrasenarep1 = new JPasswordField(10);
        JLabel telefonorep = new JLabel("   Telefono: ");
        this.telefonorep1 = new JTextField(10);
        JButton guardarRep = new JButton("Guardar");

        guardarRep.addActionListener(new newRep(op, cardLay, this));

        newRepp.add(nombrer);
        newRepp.add(usuariorep);
        newRepp.add(usuariorep1);
        newRepp.add(contrasenarep);
        newRepp.add(contrasenarep1);
        newRepp.add(telefonorep);
        newRepp.add(telefonorep1);
        newRepp.add(guardarRep);

        //////////////// vista de nuevo camion
        
        JPanel newCamm = new JPanel();
        newCamm.setLayout(new FlowLayout());
        JLabel nombrec = new JLabel("DATOS CAMION");
        JLabel matriculacam = new JLabel("Matrícula: ");
        this.matriculacam1 = new JTextField(10);
        JLabel pesoMax = new JLabel("  PesoMax: ");
        this.pesoMax1 = new JPasswordField(10);
        JLabel tipoCam = new JLabel("   Tipo: ");
        String[] tiposCam={"estandar","especial","refrigerado"};
        this.tipoCam1 = new JComboBox<String>(tiposCam);
        this.tipoCam1.setSelectedIndex(0);
        JButton guardarCam = new JButton("Guardar");

        guardarCam.addActionListener(new newCam(op, cardLay, this));

        newCamm.add(nombrec);
        newCamm.add(matriculacam);
        newCamm.add(matriculacam1);
        newCamm.add(pesoMax);
        newCamm.add(pesoMax1);
        newCamm.add(tipoCam);
        newCamm.add(tipoCam1);
        newCamm.add(guardarCam);

        //////////////// vista de baja repartidor
        
        JPanel delRepp = new JPanel();
        delRepp.setLayout(new FlowLayout());
        JLabel nombrerr = new JLabel("ELIMINAR REPARTIDOR");
        JLabel usuariorepp = new JLabel("Usuario: ");
        this.usuariorepp1 = new JTextField(10);
        JButton deleRep = new JButton("Eliminar");

        guardarCam.addActionListener(new delRep(op, cardLay, this));

        delRepp.add(nombrerr);
        delRepp.add(usuariorepp);
        delRepp.add(usuariorepp1);
        delRepp.add(deleRep);

        //////////////// vista de baja camion
        
        JPanel delCamm = new JPanel();
        delCamm.setLayout(new FlowLayout());
        JLabel nombrecc = new JLabel("ELIMINAR CAMION");
        JLabel matriculacamm = new JLabel("Matrícula: ");
        this.matriculacamm1 = new JTextField(10);
        JButton deleCam = new JButton("Eliminar");

        guardarCam.addActionListener(new delCam(op, cardLay, this));

        delCamm.add(nombrecc);
        delCamm.add(matriculacamm);
        delCamm.add(matriculacamm1);
        delCamm.add(deleCam);

        //////////////// vista de configuracion
        
        JPanel config = new JPanel();
        config.setLayout(new FlowLayout());
        JLabel nombrecon = new JLabel("CONFIGURACION");
        JLabel n_reint = new JLabel("Número de reintentos: ");
        this.n_reint1 = new JTextField(10);
        JLabel maxVolume = new JLabel("Volumen Máximo de camiones: ");
        this.maxVolume1 = new JTextField(10);
        JLabel descuento = new JLabel("Descuento aplicable(%): ");
        this.descuento1 = new JTextField(10);
        JLabel maxCodPos = new JLabel("Máximo número de códigos postales: ");
        this.maxCodPos1 = new JTextField(10);
        JLabel maxPesoPNormal = new JLabel("Máximo peso de paquetes normales: ");
        this.maxPesoPNormal1 = new JTextField(10);
        JLabel maxPesoPFragil = new JLabel("Máximo peso de paquetes frágiles: ");
        this.maxPesoPFragil1 = new JTextField(10);
        JButton configB = new JButton("Guardar");

        guardarCam.addActionListener(new delCam(op, cardLay, this));

        config.add(nombrecon);
        config.add(n_reint);
        config.add(n_reint1);
        config.add(maxVolume);
        config.add(maxVolume1);
        config.add(descuento);
        config.add(descuento1);
        config.add(maxCodPos);
        config.add(maxCodPos1);
        config.add(maxPesoPNormal);
        config.add(maxPesoPNormal1);
        config.add(maxPesoPFragil);
        config.add(maxPesoPFragil1);
        config.add(configB);

        cardLay.add(ventana, "" + 0);
        cardLay.add(newRepp, "" + 1);
        cardLay.add(newCamm, "" + 2);
        cardLay.add(delRepp, "" + 3);
        cardLay.add(delCamm, "" + 4);
        cardLay.add(config, "" + 5);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(cardLay, BorderLayout.CENTER);
        setSize(400, 300);
    }
    public ArrayList<String> getNewRep(){
        ArrayList<String> s = new ArrayList<>();
        s.add(usuariorep1.getText());
        s.add(contrasenarep1.getText());
        s.add(telefonorep1.getText());
        return s;
    }
    public ArrayList<String> getNewCam(){
        ArrayList<String> s = new ArrayList<>();
        s.add(matriculacam1.getText());
        s.add(pesoMax1.getText());
        s.add((String)(tipoCam1.getSelectedItem()));
        return s;
    }
    public String getDelRep(){
        return usuariorepp1.getText();
    }
    public String getDelCam(){
        return matriculacamm1.getText();
    }
    public ArrayList<String> getNewConf(){
        ArrayList<String> s = new ArrayList<>();
        s.add(n_reint1.getText());
        s.add(maxVolume1.getText());
        s.add(descuento1.getText());
        s.add(maxCodPos1.getText());
        s.add(maxPesoPNormal1.getText());
        s.add(maxPesoPFragil1.getText());
        return s;
    }
}
