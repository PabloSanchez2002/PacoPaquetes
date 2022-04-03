package pacopaquetes.usuarios;

import java.util.ArrayList;
import pacopaquetes.envios.*;

public class Cliente extends UsuarioRegistrado {

    private String CIF;
    private String nombreEmpresa;
    private String direcconFacturacion;
    private String correoElectronico;
    private String targetaBancaria;
    private ArrayList<Pedido> pedidos;
    private ArrayList<Lote> lotes;

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
    public void setNombreEmpresa(String nombre) {
        this.nombreEmpresa = nombre;
    }

    public void setDirecconFacturacion(String direccion) {
        this.direcconFacturacion = direccion;
    }

    public void setCorreoElectronico(String correo) {
        this.correoElectronico = correo;
    }

    public void setTargetaBancaria(String tarjeta) {
        this.targetaBancaria = tarjeta;
    }

    // ================GETS===============//
    public String getCIF() {
        return this.CIF;
    }

    public String getNombreEmpresa() {
        return this.nombreEmpresa;
    }

    public String getDirecconFacturacion() {
        return this.direcconFacturacion;
    }

    public String getCorreoElectronico() {
        return this.correoElectronico;
    }

    public String getTargetaBancaria() {
        return this.targetaBancaria;
    }

    public ArrayList<Pedido> getPedidos() {
        return this.pedidos;
    }

    public ArrayList<Lote> getLotes() {
        return this.lotes;
    }

    public void addPedido(Pedido ped) {
        this.pedidos.add(ped);
    }

    public void addLote(Lote lote) {
        this.lotes.add(lote);
    }
}
