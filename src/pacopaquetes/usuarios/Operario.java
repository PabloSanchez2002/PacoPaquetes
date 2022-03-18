package pacopaquetes.usuarios;

import enums.TIPOCAMION;
import pacopaquetes.*;

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

    public void bajaCamion(Camion cam){
        this.Empresa.rmCamion(cam);
    }

    public Cliente nuevoCliente(String usuario, String contrasena, String CIF, String nombreEmpresa, String direcconFacturacion, String correoElectronico, String targetaBancaria ){
        Cliente cli = new Cliente(usuario,contrasena,CIF,nombreEmpresa,direcconFacturacion,correoElectronico,targetaBancaria);
        this.Empresa.addCliente(cli);
        return cli;
    }

}