package PacoPaquetes.usuarios;

public class ClienteSinRegistrar {
    
    public ClienteSinRegistrar(){}

    public Cliente nuevoCliente(String usuario, String contraseña, String CIF, String nombreEmpresa, String direcconFacturacion, String correoElectronico, String targetaBancaria){
        Cliente c = new Cliente(usuario, contraseña, CIF, nombreEmpresa, direcconFacturacion, correoElectronico, targetaBancaria);
        return c;
    }
}
