package PacoPaquetes.usuarios;

public class Cliente extends UsuarioRegistrado{

    private String CIF;
    private String nombreEmpresa;
    private String direcconFacturacion;
    private String correoElectronico;
    private String targetaBancaria;

    public Cliente(String usuario, String contraseña, String CIF, String nombreEmpresa, String direcconFacturacion, String correoElectronico, String targetaBancaria){
        super(usuario,contraseña);
        this.CIF=CIF;
        this.nombreEmpresa=nombreEmpresa;
        this.direcconFacturacion=direcconFacturacion;
        this.correoElectronico=correoElectronico;
        this.targetaBancaria=targetaBancaria;
    }

    //================SETS===============//
    public void setNombreEmpresa(String nombre){
        this.nombreEmpresa=nombre;
    }

    public void setDirecconFacturacion(String direccion){
        this.direcconFacturacion=direccion;
    }

    public void setCorreoElectronico(String correo){
        this.correoElectronico=correo;
    }

    public void setTargetaBancaria(String tarjeta){
        this.targetaBancaria=tarjeta;
    }

    //================GETS===============//
    public String getCIF(){
        return this.CIF;
    }

    public String getNombreEmpresa(){
        return this.nombreEmpresa;
    }

    public String getDirecconFacturacion(){
        return this.direcconFacturacion;
    }

    public String getCorreoElectronico(){
        return this.correoElectronico;
    }

    public String getTargetaBancaria(){
        return this.targetaBancaria;
    }
    
    //========================================
    public void editarDatos(String nombre, String direccion, String correo, String tarjeta){
        if(nombre!=null && nombre.isEmpty()==false){
            setNombreEmpresa(nombre);
        }
        if(direccion!=null && direccion.isEmpty()==false){
            setDirecconFacturacion(direccion);
        }
        if(correo!=null && correo.isEmpty()==false){
            setCorreoElectronico(correo);
        }
        if(tarjeta!=null && tarjeta.isEmpty()==false){
            setTargetaBancaria(tarjeta);
        }
    }
    
}
