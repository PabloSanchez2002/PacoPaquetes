package pacopaquetes.usuarios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import enums.TIPOCAMION;
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

    public Boolean altaCamionesDesdeArchivo(String archivo) throws IOException {

        FileReader stream = new FileReader(archivo);
        BufferedReader br = new BufferedReader(stream);

        int matricula;
        String strCamion = br.readLine();
        while (strCamion != null) {
            String[] camion = strCamion.split(":");
            matricula = Integer.parseInt(camion[1]);

            this.altaCamion(camion[0], matricula, TIPOCAMION.ESTANDAR.getTipo(camion[2]));
        }
        br.close();
        return true;
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
                Integer cp = Integer.parseInt(linea);
                this.Empresa.addCP(cp);
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
            int id, String nombre, PRIORIDAD PR, TIPOCOMIDA tipo, Boolean liquido) {
        Producto p = new Alimentario(num, pesoTot, largo, alto, profundo, id, nombre, PR, liquido, tipo);
        ped.anadirProducto(p);
        Empresa.addProducto(p);
    }

    public void anadirProductoPedido(Pedido ped, int num, float pesoTot, float largo, float alto, float profundo,
            int id, String nombre, PRIORIDAD PR) {
        Producto p = new Normal(num, pesoTot, largo, alto, profundo, id, nombre, PR);
        ped.anadirProducto(p);
        Empresa.addProducto(p);
    }

    public void anadirProductoPedido(Pedido ped, int num, float pesoTot, float largo, float alto, float profundo,
            int id, String nombre, PRIORIDAD PR, Boolean asegurado) {
        Producto p = new Fragil(num, pesoTot, largo, alto, profundo, id, nombre, PR, asegurado);
        ped.anadirProducto(p);
        Empresa.addProducto(p);
    }

    public Pedido CrearPedido(int id, Date date, int nint, PRIORIDAD pr) {
        Pedido ped = new Pedido(id, date, nint, pr);
        this.Empresa.addPedido(ped);
        return ped;
    }

}