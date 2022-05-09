package pacopaquetes.GUI.Cliente.Paneles;

import javax.swing.JFrame;
import java.awt.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import pacopaquetes.ModifiableDate;
import pacopaquetes.envios.Pedido;
import pacopaquetes.envios.productos.Producto;
/**
 *  Clase para mostrar los detalles de un pedido de un cliente
 */
public class detalles extends JFrame{

    public detalles(Pedido p) {
        JPanel cardLay = new JPanel();
        cardLay.setLayout(new CardLayout());
        this.setResizable(false);
        setSize(1200, 700);
        setVisible(true);

         //Creamos la tabla
        JPanel ventana = new JPanel();
        ventana.setLayout(new FlowLayout());
        JLabel infp = new JLabel("Pedido Nº" + p.getId() + ", al codigo postal: " + p.getCodPost() + "            Precio total: " + p.getPrecio(0.1) + "                                                      ");
        String[] titulos = {"Nombre producto", "Descripcion", "Id ", "Prioridad", "Fecha", "Nº intentos", "Empaquetado", "Estado", "Dim. especial", "Nº unidades", "Peso total", "Precio (€)",  "Dimensiones"};
        List<Producto> prod = p.getProductos();
        int num = prod.size();
        int i = 0;
        Object[][] filas = new Object[num][13];
        
        while(i<num){
            Producto pr = prod.get(i);
            String id = String.valueOf(pr.getId());
            pr.getFecha();
            pr.getFecha();
	
			String fecha = String.valueOf(ModifiableDate.getModifiableDate().getDayOfMonth())+"/"+ String.valueOf(ModifiableDate.getModifiableDate().getMonthValue())+"/"+String.valueOf(ModifiableDate.getModifiableDate().getYear());
            String intentos = String.valueOf(pr.getNIntentos());
            String empaq;
            if(pr.getEmpaquetado()){
                empaq = "Si";
            }else{
                empaq = "No";
            }
            String dim;
            if(pr.getDimEspecial()){
                dim = "Si";
            }else{
                dim = "No";
            }
            String numero = String.valueOf(pr.getNumUnidades());
            String peso = String.valueOf(pr.getPesoTotal());
            String precio = String.valueOf(pr.getPrecio());
            String tamano = String.valueOf(pr.getAlto()) +"/"+ String.valueOf(pr.getAncho()) +"/"+  String.valueOf(pr.getProfundo());


            String fila[] = {pr.getNombre(),pr.getDescription(), id , pr.getPrioridad().toString(), fecha, intentos, empaq, pr.getEstado().toString(), dim, numero, peso, precio, tamano};
            filas[i] = fila;
            i++;
        }
        TableModel tm = new DefaultTableModel(filas, titulos);
        JTable tabla = new JTable(tm);
        tabla.setDefaultEditor(Object.class, null);
        
        JScrollPane jsp = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp.setPreferredSize(new Dimension(1160, 400));


        ventana.add(infp);
        infp.setFont(new Font("Tahoma", Font.BOLD, 20));
        ventana.add(jsp);
        

        cardLay.add(ventana, "" + 0);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().add(cardLay, BorderLayout.CENTER);
    }
    
}
