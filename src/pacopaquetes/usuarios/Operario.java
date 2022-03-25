package pacopaquetes.usuarios;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import enums.TIPOCAMION;
import javafx.animation.Animation.Status;
import java.util.*;
import enums.*;
import pacopaquetes.*;
import pacopaquetes.envios.*;
import pacopaquetes.envios.productos.*;

public class Operario extends UsuarioRegistrado{
    
    private PacoPaquetes Empresa;

    public Operario(String usuario, String contrasena){
        super(usuario,contrasena);
    }

    //===============SETS===============//
    public void setEmpresa(PacoPaquetes PPaquetes){
        this.Empresa = PPaquetes;
    }

    //===============GETS===============//
    public PacoPaquetes getEmpresa(){
        return this.Empresa;
    }




    public Repartidor altaRepartidor(String usuario, String contrasena ,String telefono){
        Repartidor rep = new Repartidor(usuario, contrasena, telefono);
        this.Empresa.addRepartidor(rep);
        return rep;
    }

    public void bajaRepartidor(Repartidor rep){
        this.Empresa.rmRepartidor(rep);
    }

    public Camion altaCamion(String matricula, int pesoMax, TIPOCAMION tipo){
        Camion cam = new Camion(matricula,pesoMax,tipo);
        this.Empresa.addCamion(cam);
        return cam;
    }

    public Boolean altaCamionesDesdeArchivo(String archivo) throws IOException{
        FileInputStream stream = new FileInputStream(archivo);
        BufferedReader br = new BufferedReader(new InputStreamReader(stream));
       
        int matricula;
        String strCamion = br.readLine();
        while(strCamion != null){
            String[] camion = strCamion.split(":");
            matricula = Integer.parseInt(camion[1]);
            
            this.altaCamion(camion[0], matricula, TIPOCAMION.ESTANDAR.getTipo(camion[2]));
        }
        br.close();
        return true;
    }

    public void bajaCamion(Camion cam){
        this.Empresa.rmCamion(cam);
    }

    public Cliente nuevoCliente(String usuario, String contrasena, String CIF, String nombreEmpresa, String direcconFacturacion, String correoElectronico, String targetaBancaria ){
        Cliente cli = new Cliente(usuario,contrasena,CIF,nombreEmpresa,direcconFacturacion,correoElectronico,targetaBancaria);
        this.Empresa.addCliente(cli); //==================================//
        return cli;
    }

    public void anadirProductoPedido(Pedido ped,int num,float pesoTot, float largo, float alto, float profundo ,ESTADO estado ,int id, String nombre, PRIORIDAD PR,TIPOCOMIDA tipo,Boolean liquido){
        Producto p = new Alimentario(num,pesoTot,largo,alto,profundo,estado,id,nombre,PR,liquido,tipo);
        ped.anadirProducto(p);
        Empresa.addProducto(p);
    }

    public void anadirProductoPedido(Pedido ped,int num,float pesoTot, float largo, float alto, float profundo ,ESTADO estado ,int id, String nombre, PRIORIDAD PR, int modo){
        Producto p = new Normal(num,pesoTot,largo,alto,profundo,estado,id,nombre,PR);
        ped.anadirProducto(p);
        Empresa.addProducto(p);
    }
    public void anadirProductoPedido(Pedido ped,int num,float pesoTot, float largo, float alto, float profundo ,ESTADO estado ,int id, String nombre, PRIORIDAD PR,Boolean asegurado){
        Producto p = new Fragil(num,pesoTot,largo,alto,profundo,estado,id,nombre,PR,asegurado);
        ped.anadirProducto(p);
        Empresa.addProducto(p);
    }



    public Pedido CrearPedido(int id, Date date, int nint, PRIORIDAD pr){
        Pedido ped= new Pedido(id, date, nint, pr);
        this.Empresa.addPedido(ped); 
        return ped;
    }

}