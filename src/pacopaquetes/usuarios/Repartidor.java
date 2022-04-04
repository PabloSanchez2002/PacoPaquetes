package pacopaquetes.usuarios;

import pacopaquetes.envios.PlanDeReparto;

public class Repartidor extends UsuarioRegistrado {

    private String telefono;
    private PlanDeReparto planReparto;

    public Repartidor(String usuario, String contrasena, String telefono) {
        super(usuario, contrasena);
        this.telefono = telefono;
        this.planReparto = null;
    }

    // ===============SETS===============//
    public void setPlanReparto(PlanDeReparto plan) {
        this.planReparto = plan;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // ===============GETS===============//
    public String getTelefono() {
        return this.telefono;
    }

    public PlanDeReparto consultarPlanReparto() {
        return this.planReparto;
    }

    public void setCamionAveriado() {
        if (this.planReparto.getCamion() == null) {
            return;
        }
        this.planReparto.getCamion().setAveriado(true);
    }

}