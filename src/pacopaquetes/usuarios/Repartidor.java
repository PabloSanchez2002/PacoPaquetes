package pacopaquetes.usuarios;

import pacopaquetes.envios.PlanDeReparto;

public class Repartidor extends UsuarioRegistrado{
    
    private String telefono;
    private PlanDeReparto planReparto;

    public Repartidor(String usuario, String contrasena, String telefono){
        super(usuario, contrasena);
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

    public void setCamionAveriado(){
        this.planReparto.getCamion().setAveriado(true);
    }


}