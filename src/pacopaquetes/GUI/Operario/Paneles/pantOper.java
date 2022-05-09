package pacopaquetes.GUI.Operario.Paneles;

import pacopaquetes.*;
import pacopaquetes.usuarios.*;
import pacopaquetes.envios.*;
import pacopaquetes.GUI.A_GENERALES.*;
import pacopaquetes.GUI.Operario.Controladores.*;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
/**
 *  Clase para generar todas las pantallas referentes al repartidor
 */
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
    private JTextField nombreCli1;
    private JTextField cpPed1;
    private JTextField namePN1;
    private JTextField numPN1;
    private JTextField pesoPN1;
    private JTextField altoPN1;
    private JTextField anchoPN1;
    private JTextField profPN1;
    private JTextField namePF1;
    private JTextField numPF1;
    private JTextField pesoPF1;
    private JTextField altoPF1;
    private JTextField anchoPF1;
    private JTextField profPF1;
    private JTextField namePA1;
    private JTextField numPA1;
    private JTextField pesoPA1;
    private JTextField altoPA1;
    private JTextField anchoPA1;
    private JTextField profPA1;
    private JCheckBox urgn;
    private JCheckBox asegurado;
    private JCheckBox liquido;
    private JRadioButton prodN;
    private JRadioButton prodF;
    private JRadioButton prodA;
    private ButtonGroup grupo = new ButtonGroup();
    private JComboBox<String> tipoCam1;
    private JComboBox<String> tipoPrA1;

    private Pedido creandoPed;

    public pantOper(PacoPaquetes pp, Operario op) {
        JPanel cardLay = new JPanel();
        cardLay.setLayout(new CardLayout());

        JPanel ventana = new JPanel();
        ventana.setLayout(new FlowLayout());
        // crear componentes
        JLabel wellcome = new JLabel("Bienvenido " + op.getUsuario() + "\n  ");

        JButton alta_r = new JButton("Alta Repartidor");
        JButton baja_r = new JButton("Baja Repartidor");
        JButton alta_c = new JButton("Alta Camion");
        JButton baja_c = new JButton("Baja Camion");
        JButton fact = new JButton("Facturación");
        JButton pedido = new JButton("Crear pedido");
        JButton conf = new JButton("Configuración");
        JButton paquete = new JButton("Empaquetar");
        JButton cerrarSesion = new JButton("Cerrar sesión");

        // asociar acciones a componentes
        alta_r.addActionListener(new next(cardLay,1));
        baja_r.addActionListener(new next(cardLay,3));
        alta_c.addActionListener(new next(cardLay,2));
        baja_c.addActionListener(new next(cardLay,4));
        fact.addActionListener(new verFact(pp));
        pedido.addActionListener(new next(cardLay,6));
        conf.addActionListener(new next(cardLay,5));
        paquete.addActionListener(new verEmpaquetacion(this,op));
        cerrarSesion.addActionListener(new logOut(pp, this));

        ventana.add(wellcome);
        ventana.add(alta_r);
        ventana.add(baja_r);
        ventana.add(alta_c);
        ventana.add(baja_c);
        ventana.add(fact);
        ventana.add(pedido);
        ventana.add(paquete);
        ventana.add(conf);
       
        ventana.add(cerrarSesion);


        //////////////// vista de nuevo repartidor
        JPanel newRepp = new JPanel();
        newRepp.setLayout(new FlowLayout());
        JLabel nombrer = new JLabel("DATOS REPARTIDOR");
        JLabel usuariorep = new JLabel("Usuario: ");
        this.usuariorep1 = new JTextField(10);
        JLabel contrasenarep = new JLabel("  Contraseña: ");
        this.contrasenarep1 = new JTextField(10);
        JLabel telefonorep = new JLabel("   Telefono: ");
        this.telefonorep1 = new JTextField(10);
        JButton guardarRep = new JButton("Guardar");
        JButton atrasR = new JButton("Atras");
        
        guardarRep.addActionListener(new newRep(op, cardLay, this));
        atrasR.addActionListener(new contrAtrasC(cardLay));

        newRepp.add(nombrer);
        newRepp.add(usuariorep);
        newRepp.add(usuariorep1);
        newRepp.add(contrasenarep);
        newRepp.add(contrasenarep1);
        newRepp.add(telefonorep);
        newRepp.add(telefonorep1);
        newRepp.add(guardarRep);
        newRepp.add(atrasR);

        //////////////// vista de nuevo camion
        
        JPanel newCamm = new JPanel();
        newCamm.setLayout(new FlowLayout());
        JLabel nombrec = new JLabel("DATOS CAMION");
        JLabel matriculacam = new JLabel("Matrícula: ");
        this.matriculacam1 = new JTextField(10);
        JLabel pesoMax = new JLabel("  PesoMax: ");
        this.pesoMax1 = new JTextField(10);
        JLabel tipoCam = new JLabel("   Tipo: ");
        String[] tiposCam={"estandar","especial","refrigerado"};
        this.tipoCam1 = new JComboBox<String>(tiposCam);
        this.tipoCam1.setSelectedIndex(0);
        JButton guardarCam = new JButton("Guardar");
        JButton atrasC = new JButton("Atras");

        atrasC.addActionListener(new contrAtrasC(cardLay));
        guardarCam.addActionListener(new newCam(op, cardLay, this));

        newCamm.add(nombrec);
        newCamm.add(matriculacam);
        newCamm.add(matriculacam1);
        newCamm.add(pesoMax);
        newCamm.add(pesoMax1);
        newCamm.add(tipoCam);
        newCamm.add(tipoCam1);
        newCamm.add(guardarCam);
        newCamm.add(atrasC);

        //////////////// vista de baja repartidor
        
        JPanel delRepp = new JPanel();
        delRepp.setLayout(new FlowLayout());
        JLabel nombrerr = new JLabel("ELIMINAR REPARTIDOR");
        JLabel usuariorepp = new JLabel("Usuario: ");
        this.usuariorepp1 = new JTextField(10);
        JButton deleRep = new JButton("Eliminar");
        JButton atrasRR = new JButton("Atras");
        atrasRR.addActionListener(new contrAtrasC(cardLay));

        deleRep.addActionListener(new delRep(op, cardLay, this));

        delRepp.add(nombrerr);
        delRepp.add(usuariorepp);
        delRepp.add(usuariorepp1);
        delRepp.add(deleRep);
        delRepp.add(atrasRR);

        //////////////// vista de baja camion
        
        JPanel delCamm = new JPanel();
        delCamm.setLayout(new FlowLayout());
        JLabel nombrecc = new JLabel("ELIMINAR CAMION");
        JLabel matriculacamm = new JLabel("Matrícula: ");
        this.matriculacamm1 = new JTextField(10);
        JButton deleCam = new JButton("Eliminar");
        JButton atrasCC = new JButton("Atras");
        atrasCC.addActionListener(new contrAtrasC(cardLay));

        deleCam.addActionListener(new delCam(op, cardLay, this));

        delCamm.add(nombrecc);
        delCamm.add(matriculacamm);
        delCamm.add(matriculacamm1);
        delCamm.add(deleCam);
        delCamm.add(atrasCC);

        //////////////// vista de configuracion
        
        JPanel config = new JPanel();
        config.setLayout(new FlowLayout());
        JLabel nombrecon = new JLabel("                CONFIGURACION                           ");
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
        JButton atrasCo = new JButton("Atras");
        atrasCo.addActionListener(new contrAtrasC(cardLay));

        configB.addActionListener(new modificarConf(op, cardLay, this));

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
        config.add(atrasCo);

        //////////////// vista de crear pedido
        
        JPanel crearPed = new JPanel();
        crearPed.setLayout(new FlowLayout());
        JLabel nombrePed = new JLabel("Crear Pedido");
        JLabel nombreCli = new JLabel("Nombre del cliente: ");
        this.nombreCli1 = new JTextField(10);
        JLabel cpPed = new JLabel("Codigo postal: ");
        this.cpPed1 = new JTextField(10);
        this.urgn = new JCheckBox("Urgente");
        JButton guardarPed = new JButton("Crear");
        JButton atrasPe = new JButton("Atras");
        atrasPe.addActionListener(new contrAtrasC(cardLay));

        guardarPed.addActionListener(new newPed(op, cardLay, this));

        crearPed.add(nombrePed);
        crearPed.add(nombreCli);
        crearPed.add(nombreCli1);
        crearPed.add(cpPed);
        crearPed.add(cpPed1);
        crearPed.add(urgn);
        crearPed.add(guardarPed);
        crearPed.add(atrasPe);

        //////////////// vista de añadir producto
        
        JPanel addProd = new JPanel();
        addProd.setLayout(new FlowLayout());
        JLabel nombreProc = new JLabel("Añadir Producto");
        this.prodN = new JRadioButton("Normal");
        this.prodF = new JRadioButton("Fragil");
        this.prodA = new JRadioButton("Alimentario");
        this.grupo.add(prodN);
        this.grupo.add(prodF);
        this.grupo.add(prodA);
        JButton addProdd = new JButton("Datos Producto");
        JButton pedCre = new JButton("Hecho");
        pedCre.addActionListener(new contrAtrasC(cardLay));

        addProdd.addActionListener(new addPro(cardLay, this));

        addProd.add(nombreProc);
        addProd.add(prodN);
        addProd.add(prodF);
        addProd.add(prodA);
        addProd.add(addProdd);
        addProd.add(pedCre);

        //////////////// vista de añadir producto normal
        
        JPanel addProdN = new JPanel();
        addProdN.setLayout(new FlowLayout());
        JLabel nombreProdN = new JLabel("                    Producto normal                    ");
        JLabel namePN = new JLabel("Nombre del producto");
        this.namePN1 = new JTextField(10);
        JLabel numPN = new JLabel("Numero de productos");
        this.numPN1 = new JTextField(10);
        JLabel pesoPN = new JLabel("Peso del producto    ");
        this.pesoPN1 = new JTextField(10);
        JLabel altoPN = new JLabel("Alto del productos");
        this.altoPN1 = new JTextField(10);
        JLabel anchoPN = new JLabel("Ancho del productos");
        this.anchoPN1 = new JTextField(10);
        JLabel profPN = new JLabel("Profundidad del productos");
        this.profPN1 = new JTextField(10);
        JButton addProddN = new JButton("Añadir Producto");
        JButton atrasPN = new JButton("Atras");
        atrasPN.addActionListener(new contrVolver(cardLay,1));

        addProddN.addActionListener(new addProN(op, cardLay, this));

        addProdN.add(nombreProdN);
        addProdN.add(namePN);
        addProdN.add(namePN1);
        addProdN.add(numPN);
        addProdN.add(numPN1);
        addProdN.add(pesoPN);
        addProdN.add(pesoPN1);
        addProdN.add(altoPN);
        addProdN.add(altoPN1);
        addProdN.add(anchoPN);
        addProdN.add(anchoPN1);
        addProdN.add(profPN);
        addProdN.add(profPN1);
        addProdN.add(addProddN);
        addProdN.add(atrasPN);

        //////////////// vista de añadir producto fragil
        
        JPanel addProdF = new JPanel();
        addProdF.setLayout(new FlowLayout());
        JLabel nombreProdF = new JLabel("                    Producto fragil                    ");
        JLabel namePF = new JLabel("Nombre del producto");
        this.namePF1 = new JTextField(10);
        JLabel numPF = new JLabel("Numero de productos");
        this.numPF1 = new JTextField(10);
        JLabel pesoPF = new JLabel("Peso del producto    ");
        this.pesoPF1 = new JTextField(10);
        JLabel altoPF = new JLabel("Alto del productos");
        this.altoPF1 = new JTextField(10);
        JLabel anchoPF = new JLabel("Ancho del productos");
        this.anchoPF1 = new JTextField(10);
        JLabel profPF = new JLabel("Profundidad del productos");
        this.profPF1 = new JTextField(10);
        this.asegurado = new JCheckBox("Asegurado");
        JButton atrasPF = new JButton("Atras");
        atrasPF.addActionListener(new contrVolver(cardLay,2));

        JButton addProddF = new JButton("Añadir Producto");

        addProddF.addActionListener(new addProF(op, cardLay, this));

        addProdF.add(nombreProdF);
        addProdF.add(namePF);
        addProdF.add(namePF1);
        addProdF.add(numPF);
        addProdF.add(numPF1);
        addProdF.add(pesoPF);
        addProdF.add(pesoPF1);
        addProdF.add(altoPF);
        addProdF.add(altoPF1);
        addProdF.add(anchoPF);
        addProdF.add(anchoPF1);
        addProdF.add(profPF);
        addProdF.add(profPF1);
        addProdF.add(asegurado);
        addProdF.add(addProddF);
        addProdF.add(atrasPF);

        //////////////// vista de añadir producto fragil
        
        JPanel addProdA = new JPanel();
        addProdA.setLayout(new FlowLayout());
        JLabel nombreProdA = new JLabel("                   Producto alimentario                   ");
        JLabel namePA = new JLabel("Nombre del producto");
        this.namePA1 = new JTextField(10);
        JLabel numPA = new JLabel("Numero de productos");
        this.numPA1 = new JTextField(10);
        JLabel pesoPA = new JLabel("Peso del producto    ");
        this.pesoPA1 = new JTextField(10);
        JLabel altoPA = new JLabel("Alto del productos");
        this.altoPA1 = new JTextField(10);
        JLabel anchoPA = new JLabel("Ancho del productos");
        this.anchoPA1 = new JTextField(10);
        JLabel profPA = new JLabel("Profundidad del productos");
        this.profPA1 = new JTextField(10);
        this.liquido = new JCheckBox("Líquido");
        String[] tiposPrA={"normal","congelado","refrigerado"};
        this.tipoPrA1 = new JComboBox<String>(tiposPrA);
        this.tipoPrA1.setSelectedIndex(0);
        JButton atrasPA = new JButton("Atras");
        atrasPA.addActionListener(new contrVolver(cardLay,3));

        JButton addProddA = new JButton("Añadir Producto");

        addProddA.addActionListener(new addProA(op, cardLay, this));

        addProdA.add(nombreProdA);
        addProdA.add(namePA);
        addProdA.add(namePA1);
        addProdA.add(numPA);
        addProdA.add(numPA1);
        addProdA.add(pesoPA);
        addProdA.add(pesoPA1);
        addProdA.add(altoPA);
        addProdA.add(altoPA1);
        addProdA.add(anchoPA);
        addProdA.add(anchoPA1);
        addProdA.add(profPA);
        addProdA.add(profPA1);
        addProdA.add(liquido);
        addProdA.add(tipoPrA1);
        addProdA.add(addProddA);
        addProdA.add(atrasPA);

        cardLay.add(ventana, "" + 0);
        cardLay.add(newRepp, "" + 1);
        cardLay.add(newCamm, "" + 2);
        cardLay.add(delRepp, "" + 3);
        cardLay.add(delCamm, "" + 4);
        cardLay.add(config, "" + 5);
        cardLay.add(crearPed, "" + 6);
        cardLay.add(addProd, "" + 7);
        cardLay.add(addProdN, "" + 8);
        cardLay.add(addProdF, "" + 9);
        cardLay.add(addProdA, "" + 10);

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
    public ArrayList<String> getDatosPed(){
        ArrayList<String> s = new ArrayList<>();
        s.add(nombreCli1.getText());
        s.add(cpPed1.getText());
        if(this.urgn.isSelected()) s.add("s");
        else s.add("n");
        return s;
    }
    public String getTipoProd(){
        if(this.prodN.isSelected()) return "normal";
        else if(this.prodF.isSelected()) return "fragil";
        return "alimentario";
    }
    public ArrayList<String> getDatosProdN(){
        ArrayList<String> s = new ArrayList<>();
        s.add(namePN1.getText());
        s.add(numPN1.getText());
        s.add(pesoPN1.getText());
        s.add(altoPN1.getText());
        s.add(anchoPN1.getText());
        s.add(profPN1.getText());
        return s;
    }

    public ArrayList<String> getDatosProdF(){
        ArrayList<String> s = new ArrayList<>();
        s.add(namePF1.getText());
        s.add(numPF1.getText());
        s.add(pesoPF1.getText());
        s.add(altoPF1.getText());
        s.add(anchoPF1.getText());
        s.add(profPF1.getText());
        if(this.asegurado.isSelected()) s.add("s");
        else s.add("n");
        return s;
    }

    public ArrayList<String> getDatosProdA(){
        ArrayList<String> s = new ArrayList<>();
        s.add(namePA1.getText());
        s.add(numPA1.getText());
        s.add(pesoPA1.getText());
        s.add(altoPA1.getText());
        s.add(anchoPA1.getText());
        s.add(profPA1.getText());
        if(this.asegurado.isSelected()) s.add("s");
        else s.add("n");
        s.add((String)(tipoPrA1.getSelectedItem()));
        return s;
    }

    public Pedido getPed(){
        return this.creandoPed;
    }
    
    public void setPed(Pedido ped){
        this.creandoPed = ped;
    }
}
