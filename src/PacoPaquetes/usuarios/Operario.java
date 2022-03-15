package PacoPaquetes.usuarios;

public class Operario extends UsuarioRegistrado{
    
    public Operario(String usuario, String contrasena){
        super(usuario,contrasena);
    }
    
    public Repartidor altaRepartidor(String usuario, String contraseña ,String telefono){
        Repartidor r = new Repartidor(usuario, contraseña, telefono);
        return r;

        
    }

}