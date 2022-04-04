/**
 * 
 * Esta clase es del cliente
 *
 * @author Pablo Sanchez, Mikel Riskez y Alberto Vicente
 *
 */
package pacopaquetes.usuarios;

import java.util.ArrayList;
import pacopaquetes.envios.*;

public class Cliente extends UsuarioRegistrado {

    /**
     * CIF de la empresa
     */
    private String CIF;
    /**
     * nombre de la empresa
     */
    private String nombreEmpresa;
    /**
     * direccion de faturacion
     */
    private String direcconFacturacion;
    /**
     * correo electronico
     */
    private String correoElectronico;
    /**
     * tarjeta bancaria
     */
    private String targetaBancaria;
    /**
     * Array de pedidos del cliente
     */
    private ArrayList<Pedido> pedidos;
    /**
     * Array de lotes
     */
    private ArrayList<Lote> lotes;

    /**
     * Crea objeto tipo cliente
     * 
     * @param usuario             nombre de usuario
     * @param contrasena          contraseña
     * @param CIF                 CIF
     * @param nombreEmpresa       Nombre de la empresa
     * @param direcconFacturacion direccion de facturacion
     * @param correoElectronico   correo electronico
     * @param targetaBancaria     tarjeta bancaria
     */
    public Cliente(String usuario, String contrasena, String CIF, String nombreEmpresa, String direcconFacturacion,
            String correoElectronico, String targetaBancaria) {
        super(usuario, contrasena);
        this.CIF = CIF;
        this.nombreEmpresa = nombreEmpresa;
        this.direcconFacturacion = direcconFacturacion;
        this.correoElectronico = correoElectronico;
        this.targetaBancaria = targetaBancaria;
        this.pedidos = new ArrayList<Pedido>();
        this.lotes = new ArrayList<Lote>();
    }

    // ================SETS===============//
    /**
     * Asigna nuevo nombre
     * 
     * @param nombre nombre
     */
    public void setNombreEmpresa(String nombre) {
        this.nombreEmpresa = nombre;
    }

    /**
     * Asigna nueva direccion
     * 
     * @param direccion
     */
    public void setDirecconFacturacion(String direccion) {
        this.direcconFacturacion = direccion;
    }

    /**
     * Asigna nuevo correo
     * 
     * @param correo
     */
    public void setCorreoElectronico(String correo) {
        this.correoElectronico = correo;
    }

    /**
     * Asigna nueva tarjeta
     * 
     * @param tarjeta
     */
    public void setTargetaBancaria(String tarjeta) {
        this.targetaBancaria = tarjeta;
    }

    // ================GETS===============//

    /**
     * Devuelve el CIF
     * 
     * @return String
     */
    public String getCIF() {
        return this.CIF;
    }

    /**
     * Devuelve el nombre de la empresa
     * 
     * @return String
     */
    public String getNombreEmpresa() {
        return this.nombreEmpresa;
    }

    /**
     * Devuelve la direccion
     * 
     * @return String
     */
    public String getDirecconFacturacion() {
        return this.direcconFacturacion;
    }

    /**
     * Devuelve el correo electronico
     * 
     * @return String
     */
    public String getCorreoElectronico() {
        return this.correoElectronico;
    }

    /**
     * Devuelve la trajeta bancaria
     * 
     * @return String
     */
    public String getTargetaBancaria() {
        return this.targetaBancaria;
    }

    /**
     * Devuelve el Arraylist de pedidos
     * 
     * @return ArrayList<Pedido>
     */
    public ArrayList<Pedido> getPedidos() {
        return this.pedidos;
    }

    /**
     * Devuelve el Arraylist de lotes
     * 
     * @return ArrayList<Lote>
     */
    public ArrayList<Lote> getLotes() {
        return this.lotes;
    }

    /**
     * Añade un pedido al array
     * 
     * @param ped
     */
    public void addPedido(Pedido ped) {
        this.pedidos.add(ped);
    }

    /**
     * Añade un lote al array
     * 
     * @param lote
     */
    public void addLote(Lote lote) {
        this.lotes.add(lote);
    }
}
