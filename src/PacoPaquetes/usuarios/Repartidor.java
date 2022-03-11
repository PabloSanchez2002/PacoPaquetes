package PacoPaquetes.usuarios;

import PacoPaquetes.envios.PlanDeReparto;

public class Repartidor extends UsuarioRegistrado{
    
    private String telefono;
    private PlanDeReparto planReparto;   

    public Repartidor(String usuario, String contraseña, String telefono){
        super(usuario, contraseña);
        this.telefono = telefono;
    }

    //===============SETS===============//
    public void setPlanReparto(PlanDeReparto plan){
        this.planReparto = plan;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    
    //===============GETS===============//
    public String getTelefono(){
        return this.telefono;
    }

    public PlanDeReparto consultarPlanReparto(){
        return this.planReparto;
    }

    


}