package pacopaquetes.envios;

import java.util.ArrayList;

import enums.TIPOPAQUETE;
import pacopaquetes.Camion;

public class PlanDeReparto {
    private static int count = 0;
    private int id;
    private Camion camion;
    private ArrayList<Paquete> paquetes;

    public PlanDeReparto() {
        count++;
        this.id = count;
        this.paquetes = new ArrayList<Paquete>();
    }

    // ================SETS===============//
    public void setRepartidor(Camion camion) {
        this.camion = camion;
    }

    public void addPaquete(Paquete paquete) {
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
            if (paq.getTipo().equals(this.getPaquetes().get(0).getTipo())) {
                if (paq.getTipo() == TIPOPAQUETE.COMIDA
                        && paq.getTipocomida().equals(this.getPaquetes().get(0).getTipocomida())) {
                    this.addPaquete(paq);
                    paquetes.remove(paq);
                } else {
                    this.addPaquete(paq);
                    paquetes.remove(paq);
                }
            }
        }
    }
}