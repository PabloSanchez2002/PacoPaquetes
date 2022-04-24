package pacopaquetes;

import java.util.Arrays;
import java.util.List;

import es.uam.eps.padsof.invoices.IInvoiceInfo;
import es.uam.eps.padsof.invoices.IProductInfo;
import es.uam.eps.padsof.invoices.InvoiceSystem;
import es.uam.eps.padsof.invoices.NonExistentFileException;
import es.uam.eps.padsof.invoices.UnsupportedImageTypeException;

class Product implements IProductInfo {	// Just an example implementation 
	public String getDescription() { return "Glass sculpture"; }
	public double getPrice() { return 10.80; }
	public String getPriceDetails() { return "2 units, 40 cts/unit, 2*5 eur (fragile+insurance)"; }
}

class Invoice implements IInvoiceInfo { // Just an example implementation 
	public String getClientCif() { return "ES-00877893X"; }
	public String getCompanyName() { return "This is the company name"; }
	public String getCompanyLogo () { return "./resources/logo.jpg"; } // jpg, gif and png formats are supported	
	public double getDiscount() { return 0; }
	public double getUrgent() { return 5.0; }
	public String getOrderDate() { return "March 2nd 2022"; }
	public String getOrderIdentifier() { return "INV000213"; }
	public double getPrice() { return 15.80; }
	public List<IProductInfo> getProducts() { return Arrays.asList( new Product () );	}
}

public class Facturas {
	public static void main(String[] args) throws NonExistentFileException, UnsupportedImageTypeException {
		InvoiceSystem.createInvoice( 
				new Invoice (),			    
				"./tmp/" // Output folder
			  );    
	}
}