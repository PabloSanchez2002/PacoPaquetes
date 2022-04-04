/**
 * 
 * Esta clase es de los clientes sin registrar
 *
 * @author Pablo Sanchez, Mikel Riskez y Alberto Vicente
 *
 */
package pacopaquetes.usuarios;

public class ClienteSinRegistrar extends UsuarioSinRegistrar {
    /**
     * Crea un cliente sin registrar
     */
    public ClienteSinRegistrar() {
    }

    /**
     * Genera un cliente normal (funciona como un log-in)
     * 
     * @param usuario             nombre de usuario
     * @param contrasena          contraseña
     * @param CIF                 CIF
     * @param nombreEmpresa       Nombre de la empresa
     * @param direcconFacturacion Direccion
     * @param correoElectronico   Correo
     * @param targetaBancaria     Tarjeta
     * @return
     */
    public Cliente nuevoCliente(String usuario, String contrasena, String CIF, String nombreEmpresa,
            String direcconFacturacion, String correoElectronico, String targetaBancaria) {
        Cliente c = new Cliente(usuario, contrasena, CIF, nombreEmpresa, direcconFacturacion, correoElectronico,
                targetaBancaria);
        return c;
    }
}
