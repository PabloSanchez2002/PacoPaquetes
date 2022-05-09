package pacopaquetes.GUI.Repartidor.Paneles;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

import pacopaquetes.envios.*;
import pacopaquetes.envios.productos.*;
import pacopaquetes.PacoPaquetes;
import pacopaquetes.GUI.Repartidor.Controladores.*;
import pacopaquetes.GUI.A_GENERALES.*;
import pacopaquetes.usuarios.*;
import enums.*;

public class pantRepartidor extends JFrame {
    private JTextField telf1;
    private PacoPaquetes pp;
    public Object set;

    public pantRepartidor(PacoPaquetes pp, Repartidor rep) {
        JPanel cardLay = new JPanel();
        cardLay.setLayout(new CardLayout());
        JPanel ventana = new JPanel();
        ventana.setLayout(new FlowLayout());
        this.pp = pp;
        // crear componentes
        JLabel welcome = new JLabel("Bienvenido " + rep.getUsuario() + "\n");

        JButton consultar = new JButton("Ver plan de reparto");
        JButton reparto = new JButton("Repartir");
        JButton camion = new JButton("Dar de baja camion");
        JButton datosRep = new JButton("Modificar datos");
        JButton logOut = new JButton("Cerrar Sesion");
        JButton atras1 = new JButton("Atras");

        camion.addActionListener(new contrCamion(cardLay));
        consultar.addActionListener(new contrConsultar(cardLay));
        reparto.addActionListener(new contrReparto(cardLay));
        datosRep.addActionListener(new contrDatos(cardLay));
        logOut.addActionListener(new logOut(pp,this));
        
        atras1.addActionListener(new contrAtrasC(cardLay));

        ventana.add(welcome);
        ventana.add(consultar);
        ventana.add(reparto);
        ventana.add(camion);
        ventana.add(datosRep);
        ventana.add(logOut);

        cardLay.add(ventana, "" + 0);

        ///////////CAMION AVERIADO///////////////
        JPanel camionpant = new JPanel();
        camionpant.setLayout(new FlowLayout());
        JLabel question = new JLabel(
                "Quiere marcar el Camion: Matricula" + rep.consultarPlanReparto().getCamion().getMatricula()
                        + " como averiado?");
        JButton averiado = new JButton("Si");

        averiado.addActionListener(new contrAveriado(this, rep));

        camionpant.add(question);
        camionpant.add(averiado);
        camionpant.add(atras1);

        cardLay.add(camionpant, "" + 1);
        //////////////CONSULTAR REPARTO////////////////
        JPanel consultarpant = new JPanel();
        camionpant.setLayout(new FlowLayout());
        JLabel planetiq = new JLabel("Plan de reparto asignado: ");
        PlanDeReparto plan = rep.consultarPlanReparto();
        String[] columnas = {"Id Paquete","Destino(CP)","Prioridad","Tipo"};
        int numPaq = plan.getPaquetes().size();
        Object[][] filas = new Object[numPaq][4];
        int i = 0;
        for(Paquete p : plan.getPaquetes()){
            String prio = "";
            String tipo = "";
            if(p.getPrioridad() == PRIORIDAD.NORMAL){
                prio = "NORMAL";
            }
            else if(p.getPrioridad() == PRIORIDAD.URGENTE){
                prio = "URGENTE";
            }

            if(p.getTipo() == TIPOPAQUETE.NORMAL){
                tipo = "NORMAL";
            }
            else if(p.getTipo() == TIPOPAQUETE.FRAGIL){
                tipo = "FRAGIL";
            }
            else if(p.getTipo() == TIPOPAQUETE.ESPECIAL){
                tipo = "ESPECIALES";
            }
            else if(p.getTipo() == TIPOPAQUETE.COMIDA){
                tipo = "COMIDA";

                if(p.getTipocomida() == TIPOCOMIDA.REFRIGERADA){
                    tipo += "(REFRIGERADA)";
                }
                else if(p.getTipocomida() == TIPOCOMIDA.CONGELADA){
                    tipo += "(CONGELADA)";
                }

            }
            
            Object[] row = {p.getId(),p.getCP(),prio,tipo};
            filas[i] = row;
            i++;
        }

        TableModel model = new DefaultTableModel(filas,columnas);
        JTable tabla = new JTable(model);
        tabla.setDefaultEditor(Object.class, null);
        JScrollPane panel = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel.setPreferredSize(new Dimension(700, 500));

        consultarpant.add(planetiq);
        consultarpant.add(panel);
        consultarpant.add(atras1);

        cardLay.add(consultarpant, "" + 2);
        ///////////////////REPARTO///////////////////////////
        JPanel repartirpant = new JPanel();
        repartirpant.setLayout(new GridLayout(plan.getPaquetes().size(),1));
        JLabel marcar = new JLabel("Marque los paquetes entregados: ");
        Map<JCheckBox,Paquete> botonRep = new LinkedHashMap<>();
        repartirpant.add(marcar);

        for(Paquete p : plan.getPaquetes()){
            if(p.getEntregado() != ESTADO.ENTREGADO){
                JCheckBox box = new JCheckBox("Paquete Id:"+p.getId()+" CP:"+p.getCP());
                botonRep.put(box,p);
                repartirpant.add(box);
            }
        }

        JButton confirReparto = new JButton("Confirmar reparto");

        
        repartirpant.add(confirReparto);
        repartirpant.add(atras1);

        cardLay.add(repartirpant, "" + 3);
        ///////////MODIFICAR NUMERO DE TELEFONO//////////////
        JPanel datos = new JPanel();
        datos.setLayout(new FlowLayout());
        JLabel telf = new JLabel("Inserte su nuevo numero de telefono: ");
        this.telf1 = new JTextField(10);
        JButton telefono = new JButton("Cambiar");

        telefono.addActionListener(new contrTelf(this,rep));

        datos.add(telf);
        datos.add(this.telf1);
        datos.add(telefono);
        datos.add(atras1);

        cardLay.add(datos, "" + 4);

        //////////////////////////////////////////////////////
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(cardLay, BorderLayout.CENTER);
        setSize(700, 500);
    }

    public String getNumTelf(){
        return this.telf1.getText();
    }

    public PacoPaquetes getPP(){
        return this.pp;
    }

    
}
