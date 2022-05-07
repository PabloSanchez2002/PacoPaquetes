package pacopaquetes.GUI.Repartidor.Paneles;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

import pacopaquetes.envios.*;
import pacopaquetes.envios.productos.Producto;
import pacopaquetes.PacoPaquetes;
import pacopaquetes.GUI.Repartidor.Controladores.*;
import pacopaquetes.GUI.A_GENERALES.*;
import pacopaquetes.usuarios.*;
import enums.*;

public class pantRepartidor extends JFrame {
    private JTextField telf1;

    public pantRepartidor(PacoPaquetes pp, Repartidor rep) {
        JPanel cardLay = new JPanel();
        cardLay.setLayout(new CardLayout());
        JPanel ventana = new JPanel();
        ventana.setLayout(new FlowLayout());
        // crear componentes
        JLabel welcome = new JLabel("Bienvenido" + rep.getUsuario() + "\n");

        JButton consultar = new JButton("Ver plan de reparto");
        JButton reparto = new JButton("Repartir");
        JButton camion = new JButton("Dar de baja camion");
        JButton datosRep = new JButton("Modificar datos");
        JButton logOut = new JButton("Cerrar Sesion");

        camion.addActionListener(new contrCamion(cardLay));
        consultar.addActionListener(new contrConsultar(cardLay));
        reparto.addActionListener(new contrReparto(cardLay));
        datosRep.addActionListener(new contrDatos(cardLay));
        logOut.addActionListener(new logOut(pp,this));

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
        JButton atrasCamion = new JButton("Atras");

        averiado.addActionListener(new contrAveriado(cardLay, rep));
        atrasCamion.addActionListener(new contrAtrasC(cardLay));

        camionpant.add(question);
        camionpant.add(averiado);
        camionpant.add(atrasCamion);

        cardLay.add(camionpant, "" + 1);
        //////////////CONSULTAR REPARTO////////////////
        JPanel consultarpant = new JPanel();
        camionpant.setLayout(new FlowLayout());
        PlanDeReparto plan = rep.consultarPlanReparto();
        DefaultTableModel model = new DefaultTableModel();
        JTable tabla = new JTable();
        tabla.setModel(model);
        model.addColumn("Id Paquete");
        model.addColumn("Destino(CP)");
        model.addColumn("Prioridad");
        model.addColumn("Tipo");
        model.setRowCount(0);
        
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
            model.addRow(row);
        }

        consultarpant.add(tabla);
        consultarpant.add(atrasCamion);

        cardLay.add(consultarpant, "" + 2);
        ///////////////////REPARTO///////////////////////////
        JPanel repartirpant = new JPanel();
        repartirpant.setLayout(new FlowLayout());
        DefaultTableModel model1 = new DefaultTableModel();
        JTable tabla1 = new JTable();
        tabla1.setModel(model1);
        
        model.addColumn("Id Paquete");
        model.addColumn("Tipo");
        model.addColumn("Estado");

        for(Paquete p : plan.getPaquetes()){
            String prio = "";

            if(p.getPrioridad() == PRIORIDAD.NORMAL){
                prio = "NORMAL";
            }
            else if(p.getPrioridad() == PRIORIDAD.URGENTE){
                prio = "URGENTE";
            }

            JRadioButton repSi = new JRadioButton();
            JRadioButton repNo = new JRadioButton();
            ButtonGroup botonRep = new ButtonGroup();

            botonRep.add(repSi);
            botonRep.add(repNo);

            if(repSi.isSelected()){
                p.setEntregado(ESTADO.ENTREGADO);
                    for (Producto prods : p.getProductos()) {
                        prods.setEstado(ESTADO.ENTREGADO);
                    }
            }
            
            if(repNo.isSelected()){
                p.setNintentos(p.getNIntentos() - 1);
                    p.setEntregado(ESTADO.EN_ALMACEN);
                    for (Producto prods : p.getProductos()) {
                        prods.setNintentos(prods.getNIntentos() - 1);
                        prods.setEstado(ESTADO.EN_ALMACEN);
                    }
            }
            
            Object[] row = {p.getId(),prio,botonRep};
            model1.addRow(row);
        }

        repartirpant.add(tabla1);
        repartirpant.add(atrasCamion);

        cardLay.add(repartirpant, "" + 3);
        ///////////MODIFICAR NUMERO DE TELEFONO//////////////
        JPanel datos = new JPanel();
        datos.setLayout(new FlowLayout());
        JLabel telf = new JLabel("Inserte su nuevo numero de telefono: ");
        this.telf1 = new JTextField(10);
        JButton telefono = new JButton("Cambiar");

        telefono.addActionListener(new contrTelf(cardLay,this,rep));

        datos.add(telf);
        datos.add(this.telf1);
        datos.add(telefono);
        datos.add(atrasCamion);

        cardLay.add(datos, "" + 4);

        //////////////////////////////////////////////////////
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(cardLay, BorderLayout.CENTER);
        setSize(400, 300);
    }

    public String getNumTelf(){
        return this.telf1.getText();
    }
}
