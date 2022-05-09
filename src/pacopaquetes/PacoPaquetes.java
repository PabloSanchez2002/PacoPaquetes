/**
 * 
 * Esta clase es de PacoPaquetes
 *
 * @author Pablo Sanchez, Mikel Risquez y Alberto Vicente
 *
 */
package pacopaquetes;

import pacopaquetes.usuarios.*;
import pacopaquetes.envios.*;
import pacopaquetes.envios.productos.*;
import java.io.Serializable;

import java.util.ArrayList;

public class PacoPaquetes implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Operario que maneja la empresa
     */
    private Operario oper;
    /**
     * Array de repartidores
     */
    private ArrayList<Repartidor> repartidores;
    /**
     * Array de clientes
     */
    private ArrayList<Cliente> clientes;
    /**
     * Array de camiones en la flota de la empresa
     */
    private ArrayList<Camion> camiones;
    /**
     * Array de productos
     */
    private ArrayList<Producto> productos;
    /**
     * Lista de paquetes de la empresa
     */
    private ArrayList<Paquete> paquetes;
    /**
     * Lista de pedidos de la empresa
     */
    private ArrayList<Pedido> pedidos;
    /**
     * Lista de planes de reparto de la empresa
     */
    private ArrayList<PlanDeReparto> repartos;
    /**
     * Lista de codigos postales de la empresa
     */
    private ArrayList<String> CP;
    /**
     * Configuracion de la empresa
     */
    private Configuracion config;

    /**
     * Constructor de la empresa devuelve la empresa
     * 
     * @param oper operario de la empresa
     */
    public PacoPaquetes(Operario oper) {
        this.oper = oper;
        this.repartidores = new ArrayList<Repartidor>();
        this.clientes = new ArrayList<Cliente>();
        this.camiones = new ArrayList<Camion>();
        this.productos = new ArrayList<Producto>();
        this.pedidos = new ArrayList<Pedido>();
        this.paquetes = new ArrayList<Paquete>();
        this.CP = new ArrayList<String>();
        this.repartos = new ArrayList<PlanDeReparto>();
        this.config = new Configuracion();
        asignarOper();
    }

    /**
     * Asigna al operario la empresa
     */
    public void asignarOper() {
        this.oper.setEmpresa(this);
    }

    // =========================GETS==========================\\
    /**
     * Devuelve el operario de la empresa
     *
     * @return Operario operario
     */
    public Operario getOperario() {
        return this.oper;
    }

    public int findUsuario(String nombre, String contrasena) {
        if (this.oper.getUsuario().equals(nombre) && this.oper.getContrasena().equals(contrasena)) {
            return 0;
        } else {
            Cliente c = this.findClienteByName(nombre);
            Repartidor r = this.findRepByName(nombre);

            if (c != null && c.getUsuario().equals(nombre) && c.getContrasena().equals(contrasena) ) {
                return 1;
            }
            if (r != null && r.getUsuario().equals(nombre) && r.getContrasena().equals(contrasena)) {
                return 2;
            }
            return -1;
        }
    }

    /**
     * Devuelve la lista de repartidores de la empresa
     *
     * @return ArrayList<Repartidor> lista de repartidores
     */
    public ArrayList<Repartidor> getRepartidores() {
        return this.repartidores;
    }

    /**
     * Devuelve la lista de clientes de la empresa
     *
     * @return ArrayList<Cliente> lista de clientes
     */
    public ArrayList<Cliente> getClientes(){
        return this.clientes;
    }

    /**
     * Devuelve la configuracion de la empresa
     *
     * @return Configuracion conf de la empresa
     */
    public Configuracion getConfig() {
        return this.config;
    }

    /**
     * Devuelve la lista de camiones de la empresa
     *
     * @return ArrayList<Camion> lista de camiones
     */
    public ArrayList<Camion> getCamiones() {
        return this.camiones;
    }

    /**
     * Devuelve la lista de productos del almacen
     *
     * @return ArrayList<Producto> lista de productos
     */
    public ArrayList<Producto> getProductos() {
        return this.productos;
    }

    /**
     * Devuelve la lista de codigos postales
     *
     * @return ArrayList<String> lista de codigos postales
     */
    public ArrayList<String> getCPs() {
        return this.CP;
    }

    /**
     * Devuelve la lista de pedidos de la empresa
     *
     * @return ArrayList<Pedido> lista de pedidos
     */
    public ArrayList<Pedido> getPedidos() {
        return this.pedidos;
    }

    /**
     * Devuelve la lista de paquetes de la empresa
     *
     * @return ArrayList<Paquete> lista de paquetes
     */
    public ArrayList<Paquete> getPaquetes() {
        return this.paquetes;
    }

    /**
     * Devuelve la lista de planes de reparto de la empresa
     *
     * @return ArrayList<PlanDeReparto> lista de planes de reparto
     */
    public ArrayList<PlanDeReparto> getPlanDeRepartos() {
        return this.repartos;
    }

    // =========================ADDS Y REMOVES==========================\\
    /**
     * Anade un repartidor a la empresa
     * 
     * @param rep repartidor
     */
    public void addRepartidor(Repartidor rep) {
        if (this.findRepByName(rep.getUsuario()) != null)
            return;
        this.repartidores.add(rep);
    }

    /**
     * Elimina un repartidor de la empresa
     * 
     * @param rep repartidor
     */
    public void rmRepartidor(Repartidor rep) {
        this.repartidores.remove(rep);
    }

    /**
     * Anade un cliente a la empresa
     * 
     * @param cli cliente
     */
    public void addCliente(Cliente cli) {
        if (this.findClienteByName(cli.getUsuario()) != null)
            return;
        this.clientes.add(cli);
    }

    /**
     * Anade un pedido a la empresa
     * 
     * @param ped pedido
     */
    public void addPedido(Pedido ped) {
        if (this.findPedidoById(ped.getId()) != null)
            return;
        this.pedidos.add(ped);
    }

    /**
     * Elimina un pedido de la empresa
     * 
     * @param ped pedido
     */
    public void rmPedido(Pedido ped) {
        this.pedidos.remove(ped);
    }

    /**
     * Anade un camion a la empresa
     * 
     * @param cam camion
     */
    public void addCamion(Camion cam) {
        if (this.findCamionByMatr(cam.getMatricula()) != null)
            return;
        this.camiones.add(cam);
    }

    /**
     * Elimina un camion de la empresa
     * 
     * @param cam camion
     */
    public void rmCamion(Camion cam) {
        this.camiones.remove(cam);
    }

    /**
     * Anade un producto a la empresa
     * 
     * @param pro producto
     */
    public void addProducto(Producto pro) {
        if (this.findProductoById(pro.getId()) == null) {
            this.productos.add(pro);
        }
    }

    /**
     * Anade un paquete a la empresa
     * 
     * @param pac paquete
     */
    public void addPaquete(Paquete pac) {
        if (this.findPaqueteById(pac.getId()) == null) {
            this.paquetes.add(pac);
        }
    }

    /**
     * Anade un codigo postal a la empresa
     * 
     * @param cp codigo postal
     */
    public void addCP(String cp) {
        if (this.CP.contains(cp) != true) {
            this.CP.add(cp);
        }
    }

    /**
     * Elimina un producto de la empresa
     * 
     * @param pro producto
     */
    public void rmPedido(Producto pro) {
        this.productos.remove(pro);
    }

    /**
     * Anade un plan de reparto a la empresa
     * 
     * @param plan plan de reparto
     */
    public void addPlanDeReparto(PlanDeReparto plan) {
        this.repartos.add(plan);
    }

    /**
     * Encuentra un repartidor con un nombre de usuario dado
     * 
     * @param name nombre
     * @return Repartidor
     */
    // =========================FINDS==========================\\
    public Repartidor findRepByName(String name) {
        for (Repartidor rep : this.repartidores)
            if (rep.getUsuario().equals(name))
                return rep;
        return null;
    }

    /**
     * Encuentra un camion con una matricula dada
     * 
     * @param matricula
     * @return Camion
     */
    public Camion findCamionByMatr(String matricula) {
        for (Camion cam : this.camiones)
            if (cam.getMatricula().equals(matricula))
                return cam;
        return null;
    }

    /**
     * Encuentra un pedido con una id dada
     * 
     * @param id id
     * @return Pedido
     */
    public Pedido findPedidoById(int id) {
        for (Pedido ped : this.pedidos)
            if (ped.getId() == id)
                return ped;
        return null;
    }

    /**
     * Encuentra un producto con una id dada
     * 
     * @param id id
     * @return Producto
     */
    public Producto findProductoById(int id) {
        for (Producto pro : this.productos)
            if (pro.getId() == id)
                return pro;
        return null;
    }

    /**
     * Encuentra un paquete con la id dada
     * 
     * @param id id
     * @return Paquete
     */
    public Paquete findPaqueteById(int id) {
        for (Paquete pac : this.paquetes)
            if (pac.getId() == id)
                return pac;
        return null;
    }

    /**
     * Encuentra un cliente con un nombre de usuario dado
     * 
     * @param name nombre
     * @return Cliente
     */
    public Cliente findClienteByName(String name) {
        for (Cliente cli : this.clientes)
            if (cli.getUsuario().equals(name))
                return cli;
        return null;
    }
}