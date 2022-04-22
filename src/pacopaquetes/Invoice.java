package pacopaquetes;

import java.util.List;

import enums.PRIORIDAD;
import es.uam.eps.padsof.invoices.IInvoiceInfo;
import pacopaquetes.envios.Pedido;
import pacopaquetes.envios.productos.Producto;
import pacopaquetes.usuarios.Cliente;

public class Invoice implements IInvoiceInfo{
    private String getClientCif;
	private String getCompanyName;
	private String getCompanyLogo; 
	private double getDiscount;
	private PRIORIDAD getUrgent;
	private ModifiableDate getOrderDate;
	private int getOrderIdentifier;
	private double getPrice;
	private List<Producto> getProducts;
    
    public Invoice(Pedido ped, Cliente cli, double discount){
        this.getClientCif= cli.getCIF();
        this.getCompanyName= "Paco Paquetes";
        this.getCompanyLogo = "./resources/logo.png";
        this.getDiscount = discount;
        this.getUrgent = ped.getPrioridad();
        this.getOrderDate = ped.getFecha();
        this.getOrderIdentifier = ped.getId();
        this.getPrice = ped.getPrecio(discount);
        this.getProducts = ped.getProductos();
    }

    @Override
    public String getClientCif() {
        return this.getClientCif;
    }

    @Override
    public String getCompanyName() {
        return this.getCompanyName;
    }

    @Override
    public double getDiscount() {
        return this.getDiscount;
    }

    @Override
    public String getOrderDate() {
        return this.getOrderDate();
    }

    @Override
    public String getOrderIdentifier() {
        return getOrderIdentifier();
    }

    @Override
    public double getPrice() {
        return this.getPrice;
    }

    @Override
    public double getUrgent() {
        return this.getUrgent();
    }
}
