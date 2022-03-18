package pacopaquetes.usuarios;

public class ClienteSinRegistrar {
    
    public ClienteSinRegistrar(){}

    public Cliente nuevoCliente(String usuario, String contrasena, String CIF, String nombreEmpresa, String direcconFacturacion, String correoElectronico, String targetaBancaria){
        Cliente c = new Cliente(usuario, contrasena, CIF, nombreEmpresa, direcconFacturacion, correoElectronico, targetaBancaria);
        return c;
    }
}
