package pacopaquetes.usuarios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import enums.*;
import pacopaquetes.*;
import pacopaquetes.envios.*;
import pacopaquetes.envios.productos.*;

public class Operario extends UsuarioRegistrado {

    private PacoPaquetes Empresa;

    public Operario(String usuario, String contrasena) {
        super(usuario, contrasena);
    }

    // ===============SETS===============//
    public void setEmpresa(PacoPaquetes PPaquetes) {
        this.Empresa = PPaquetes;
    }

    // ===============GETS===============//
    public PacoPaquetes getEmpresa() {
        return this.Empresa;
    }

    public Repartidor altaRepartidor(String usuario, String contrasena, String telefono) {
        Repartidor rep = new Repartidor(usuario, contrasena, telefono);
        this.Empresa.addRepartidor(rep);
        return rep;
    }

    public void bajaRepartidor(Repartidor rep) {
        this.Empresa.rmRepartidor(rep);
    }

    public Camion altaCamion(String matricula, int pesoMax, TIPOCAMION tipo) {
        Camion cam = new Camion(matricula, pesoMax, tipo);
        this.Empresa.addCamion(cam);
        return cam;
    }

    public void altaCamionesDesdeArchivo(String filename) throws IOException {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File(filename);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            int matricula;
            String strCamion = br.readLine();
            while (strCamion != null) {
                String[] camion = strCamion.split(":");
                matricula = Integer.parseInt(camion[1]);

                this.altaCamion(camion[0], matricula, TIPOCAMION.ESTANDAR.getTipo(camion[2]));
                strCamion = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void cargarCP(String filename) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File(filename);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                this.Empresa.addCP(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void bajaCamion(Camion cam) {
        this.Empresa.rmCamion(cam);
    }

    public Cliente nuevoCliente(String usuario, String contrasena, String CIF, String nombreEmpresa,
            String direcconFacturacion, String correoElectronico, String targetaBancaria) {
        Cliente cli = new Cliente(usuario, contrasena, CIF, nombreEmpresa, direcconFacturacion, correoElectronico,
                targetaBancaria);
        this.Empresa.addCliente(cli); // ==================================//
        return cli;
    }

    public void anadirProductoPedido(Pedido ped, int num, float pesoTot, float largo, float alto, float profundo,
            String nombre, int nInt) {
        Producto p = new Normal(num, pesoTot, largo, alto, profundo, nombre, ped.getCodPost(), ped.getPrioridad(),
                nInt, ped.getFecha());
        ped.anadirProducto(p);
        Empresa.addProducto(p);
    }

    public void anadirProductoPedido(Pedido ped, int num, float pesoTot, float largo, float ancho, float profundo,
            String nombre, int nInt, Boolean liquido, TIPOCOMIDA tipo) {
        Producto p = new Alimentario(num, pesoTot, largo, ancho, profundo, nombre, ped.getCodPost(),
                ped.getPrioridad(), nInt, liquido, tipo, ped.getFecha());
        ped.anadirProducto(p);
        Empresa.addProducto(p);
    }

    public void anadirProductoPedido(Pedido ped, int num, float pesoTot, float largo, float alto, float profundo,
            String nombre, int nInt, Boolean asegurado) {
        Producto p = new Fragil(num, pesoTot, largo, alto, profundo, nombre, ped.getCodPost(), ped.getPrioridad(),
                nInt, asegurado, ped.getFecha());
        ped.anadirProducto(p);
        Empresa.addProducto(p);
    }

    public Pedido CrearPedido(Cliente cliente, int id, Date date, String codPos, PRIORIDAD pr) {
        if (this.getEmpresa().getCPs().contains(codPos) == true) {
            Pedido ped = new Pedido(id, date, codPos, pr);
            this.Empresa.addPedido(ped);
            cliente.addPedido(ped);
            return ped;
        }
        return null;

    }

    public void generarPaquetes(ArrayList<Producto> productos) {
        if (productos.size() == 0) {
            return;
        } else {
            Collections.sort(productos);
            Producto primero = productos.get(0);
            Paquete paq = primero.nuevoPaquete(this.getEmpresa().getConfig());
        }
    }

    public void empaquetar() {
        ArrayList<Producto> prods = this.getEmpresa().getProductos();
        Integer i;

        for (String cp : this.getEmpresa().getCPs()) {
            ArrayList<Producto> mismoCP = new ArrayList<Producto>();
            i = prods.size() - 1;
            while (i >= 0) {
                // Producto con mismo cp y que no esté ya empaquetado
                if (prods.get(i).getCodPost().equals(cp) && prods.get(i - 1).getEmpaquetado() == false) {
                    mismoCP.add(prods.get(i - 1));
                }
                i--;
            }
            generarPaquetes(mismoCP);
        }
    }
}