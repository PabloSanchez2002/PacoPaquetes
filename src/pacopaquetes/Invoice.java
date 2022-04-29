package pacopaquetes;

import java.util.*;

import enums.PRIORIDAD;
import es.uam.eps.padsof.invoices.IInvoiceInfo;
import es.uam.eps.padsof.invoices.IProductInfo;
import pacopaquetes.envios.Pedido;
import pacopaquetes.usuarios.Cliente;

public class Invoice implements IInvoiceInfo {
    private String getClientCif;
    private String getCompanyName;
    private String getCompanyLogo;
    private double getDiscount;
    private PRIORIDAD getUrgent;
    private ModifiableDate getOrderDate;
    private int getOrderIdentifier;
    private double getPrice;
    private List<IProductInfo> getProducts;

    public Invoice(Pedido ped, Cliente cli, double discount) {
        this.getClientCif = cli.getCIF();
        this.getCompanyName = "Paco Paquetes";
        this.getCompanyLogo = "./resources/logo.png";
        this.getDiscount = discount;
        this.getUrgent = ped.getPrioridad();
        this.getOrderDate = ped.getFecha();
        this.getOrderIdentifier = ped.getId();
        this.getPrice = ped.getPrecio(discount);
        this.getProducts = ped.getProductosIProductInfo();
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
        return 100 * this.getDiscount;
    }

    @Override
    public String getOrderDate() {
        return ModifiableDate.getModifiableDate().toString();
    }

    @Override
    public String getOrderIdentifier() {
        return "" + getOrderIdentifier;
    }

    @Override
    public double getPrice() {
        return this.getPrice;
    }

    @Override
    public double getUrgent() {
        if (this.getUrgent == PRIORIDAD.URGENTE)
            return 5.0;
        else {
            return 0;
        }
    }

    @Override
    public List<IProductInfo> getProducts() {
        return this.getProducts;
    }

    @Override
    public String getCompanyLogo() {
        return this.getCompanyLogo;
    }
}
