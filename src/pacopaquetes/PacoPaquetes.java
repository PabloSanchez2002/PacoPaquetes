package pacopaquetes;

import pacopaquetes.usuarios.*;
import pacopaquetes.envios.Pedido;
import pacopaquetes.envios.productos.*;

import java.util.ArrayList;

public class PacoPaquetes {
    private Operario oper;
    private ArrayList<Repartidor> repartidores;
    private ArrayList<Cliente> clientes;
    private ArrayList<Camion> camiones;
    private ArrayList<Producto> productos;
    private ArrayList<Pedido> pedidos;
    private Configuracion config;
    
    public PacoPaquetes( Operario oper){
        this.oper = oper;
        this.repartidores = new ArrayList<Repartidor>();
        this.clientes = new ArrayList<Cliente>();
        this.camiones = new ArrayList<Camion>();
        this.productos = new ArrayList<Producto>();
        this.pedidos = new ArrayList<Pedido>();
        this.config = new Configuracion();
        asignarOper();
    }

    public void asignarOper(){
        this.oper.setEmpresa(this);
    }

    //=========================GETS==========================\\
    public Operario getOperario(){
        return this.oper;
    }

    public Configuracion getConfig(){
        return this.config;
    }

    //=========================ADDS Y REMOVES==========================\\
    public void addRepartidor(Repartidor rep){
        if(this.findRepByName(rep.getUsuario())!= null) return;
        this.repartidores.add(rep);
    }
    public void rmRepartidor(Repartidor rep){
        this.repartidores.remove(rep);
    }

    public void addCliente(Cliente cli){
        if(this.findClienteByName(cli.getUsuario())!= null) return;
        this.clientes.add(cli);
    }

    public void addPedido(Pedido ped){
        if(this.findPedidoById(ped.getId())!=null) return;
        this.pedidos.add(ped);
    }
    public void rmPedido(Pedido ped){
        this.pedidos.remove(ped);
    }

    public void addCamion(Camion cam){
        if(this.findCamionByMatr(cam.getMatricula())!=null) return;
        this.camiones.add(cam);
    }
    public void rmCamion(Camion cam){
        this.camiones.remove(cam);
    }

    //=========================FINDS==========================\\
    public Repartidor findRepByName(String name){
        for(Repartidor rep:this.repartidores)
            if(rep.getUsuario()==name) return rep;
        return null;
    }

    public Camion findCamionByMatr(String matricula){
        for(Camion cam:this.camiones)
            if(cam.getMatricula()==matricula) return cam;
        return null;
    }

    public Pedido findPedidoById(int id){
        for(Pedido ped:this.pedidos)
            if(ped.getId()==id) return ped;
        return null;
    }

    public Producto findProductoById(int id){
        for(Producto pro:this.productos)
            if(pro.getId()==id) return pro;
        return null;
    }

    public Cliente findClienteByName(String name){
        for(Cliente cli:this.clientes)
            if(cli.getUsuario()==name) return cli;
        return null;
    }
}