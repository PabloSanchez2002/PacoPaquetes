/**
 * 
 * Esta clase es de los planes de reparto
 *
 * @author Pablo Sanchez, Mikel Risquez y Alberto Vicente
 *
 */
package pacopaquetes.envios;

import java.util.ArrayList;

import enums.ESTADO;
import enums.TIPOCOMIDA;
import enums.TIPOPAQUETE;
import pacopaquetes.Camion;

public class PlanDeReparto {
    private static int count = 0;
    /**
     * Id
     */
    private int id;
    /**
     * Camion asignado
     */
    private Camion camion;
    /**
     * Peso del camion (inicial a 0 ya que no hay carga)
     */
    private int pesoCamion;
    /**
     * Paquetes en ese plan de reparto
     */
    private ArrayList<Paquete> paquetes;
    /**
     * Numero maximo de codigos postales
     */
    private int maxCPs;

    /**
     * Lista de codigos postales
     */
    private ArrayList<String> CPs;

    /**
     * Genera objeto de PlanReparto
     */
    public PlanDeReparto() {
        count++;
        this.id = count;
        this.pesoCamion = 0;
        this.paquetes = new ArrayList<Paquete>();
        this.CPs = new  ArrayList<String>();
    }

    // ================SETS===============//
    /**
     * Asigna un camion
     * 
     * @param camion
     */
    public void setCamion(Camion camion) {
        this.camion = camion;
    }

    /**
     * Anade un paquete al plan
     * 
     * @param paquete
     */
    public void addPaquete(Paquete paquete) {
        this.pesoCamion += paquete.getPesoTotal();
        this.paquetes.add(paquete);
    }

    public void setMaxCPS(int cp){
        this.maxCPs = cp;
    }

    // ================GETS===============//
    /**
     * Devuelve el Id del plan
     * 
     * @return int
     */
    public int getId() {
        return this.id;
    }

    /**
     * Devuelve el camion del plan
     * 
     * @return Camion
     */
    public Camion getCamion() {
        return this.camion;
    }

    /**
     * Devuelve el peso de carga
     * 
     * @return int
     */
    public int getPesoCamion() {
        return this.pesoCamion;
    }

    /**
     * Devuelve el maximo de codigos postales
     * 
     * @return int
     */
    public int getMaxCPS(){
        return this.maxCPs;
    }

    /**
     * DLista de codigos postales
     * 
     * @return ArrayList<String>
     */
    public ArrayList<String> getCPS(){
        return this.CPs;
    }
    
    /**
     * Devuelve el array de paquetes del plan
     * 
     * @return ArrayList<Paquete>
     */
    public ArrayList<Paquete> getPaquetes() {
        return this.paquetes;
    }

    public Boolean aceptaCP(String cp){
        if(this.CPs.contains(cp)){
            return true;
        }
        else if(this.CPs.size() < this.maxCPs){
                return true; 
        }
        else{
            return false;
        }
    }
    

    /**
     * Anade paquetes al plan de reparto
     * 
     * @param paquetes
     */
    public void repartoMasivo(ArrayList<Paquete> paquetes) {

        for (Paquete paq : paquetes) {
            if(aceptaCP(paq.getCP()) == true || (this.pesoCamion + paq.getPesoTotal()) >= this.getCamion().getPesoMax()){
                TIPOPAQUETE tipo = this.getPaquetes().get(0).getTipo();
                TIPOCOMIDA comida = this.getPaquetes().get(0).getTipocomida();
                TIPOPAQUETE tipopaq = paq.getTipo();

                if (tipo == TIPOPAQUETE.NORMAL) {
                    if (tipopaq.equals(TIPOPAQUETE.NORMAL)) {
                        paq.setEntregado(ESTADO.EN_REPARTO);
                        this.addPaquete(paq);
                        paquetes.remove(paq);
                    }
                } else if (tipo == TIPOPAQUETE.FRAGIL) {
                    if (tipopaq.equals(TIPOPAQUETE.FRAGIL)) {
                        paq.setEntregado(ESTADO.EN_REPARTO);
                        this.addPaquete(paq);
                        paquetes.remove(paq);
                    }
                } else if (tipo == TIPOPAQUETE.COMIDA) {
                    if (tipopaq == TIPOPAQUETE.COMIDA) {
                        if (paq.getTipocomida() == TIPOCOMIDA.CONGELADA
                                && comida == TIPOCOMIDA.CONGELADA) {
                            paq.setEntregado(ESTADO.EN_REPARTO);
                            this.addPaquete(paq);
                            paquetes.remove(paq);
                        } else {
                            paq.setEntregado(ESTADO.EN_REPARTO);
                            this.addPaquete(paq);
                            paquetes.remove(paq);
                        }
                    }
                }
            }
        }
    }
}