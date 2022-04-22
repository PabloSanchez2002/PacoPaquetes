/**
 * 
 * Esta clase es del repartidor
 *
 * @author Pablo Sanchez, Mikel Risquez y Alberto Vicente
 *
 */
package pacopaquetes.usuarios;

import pacopaquetes.envios.PlanDeReparto;

public class Repartidor extends UsuarioRegistrado {
    /**
     * Telefono de contacto
     */
    private String telefono;
    /**
     * PLan de reparto asociado
     */
    private PlanDeReparto planReparto;

    /**
     * Constructor de Repartidor
     *
     * @param usuario    usuario del repartidor
     * @param contrasena contrasena del repartidor
     * @param telefono   telefono
     */
    public Repartidor(String usuario, String contrasena, String telefono) {
        super(usuario, contrasena);
        this.telefono = telefono;
        this.planReparto = null;
    }

    // ===============SETS===============//
    /**
     * Establece un plan de reparto
     *
     * @param plan plan de reparto
     */
    public void setPlanReparto(PlanDeReparto plan) {
        this.planReparto = plan;
    }

    /**
     * Establece el telefono
     *
     * @param telefono telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // ===============GETS===============//
    /**
     * Devuelve el telefono del repartidor
     *
     * @return String telefono
     */
    public String getTelefono() {
        return this.telefono;
    }

    /**
     * Devuelve el plan de reparto
     *
     * @return PlanDeReparto Plan de reparto
     */
    public PlanDeReparto consultarPlanReparto() {
        return this.planReparto;
    }

    /**
     * Marca un camion como averiado
     */
    public void setCamionAveriado() {
        if (this.planReparto.getCamion() == null) {
            return;
        }
        this.planReparto.getCamion().setAveriado(true);
    }

}