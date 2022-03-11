package PacoPaquetes.usuarios;
public abstract class  UsuarioRegistrado extends UsuarioSinRegistrar{
    private String usuario;
    private String contraseña;  

    public UsuarioRegistrado(String usuario, String contraseña){
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    //================SETS===============//
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }

    //================GETS===============//
    public String getUsuario(){
        return this.usuario; 
    }

    public String getContraseña(){
        return this.contraseña; 
    }

    
}
