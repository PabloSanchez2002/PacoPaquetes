package pacopaquetes.envios;

import java.util.ArrayList;

import enums.ESTADO;
import enums.TIPOCOMIDA;
import enums.TIPOPAQUETE;
import pacopaquetes.Camion;

public class PlanDeReparto {
    private static int count = 0;
    private int id;
    private Camion camion;
    private int pesoCamion;
    private ArrayList<Paquete> paquetes;

    public PlanDeReparto() {
        count++;
        this.id = count;
        this.pesoCamion = 0;
        this.paquetes = new ArrayList<Paquete>();
    }

    // ================SETS===============//
    public void setCamion(Camion camion) {
        this.camion = camion;
    }

    public void addPaquete(Paquete paquete) {
        this.pesoCamion += paquete.getPesoTotal();
        if (this.pesoCamion > this.getCamion().getPesoMax())
            return;
        this.paquetes.add(paquete);
    }

    // ================GETS===============//

    public int getId() {
        return this.id;
    }

    public Camion getCamion() {
        return this.camion;
    }

    public ArrayList<Paquete> getPaquetes() {
        return this.paquetes;
    }

    public void repartoMasivo(ArrayList<Paquete> paquetes) {

        for (Paquete paq : paquetes) {
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