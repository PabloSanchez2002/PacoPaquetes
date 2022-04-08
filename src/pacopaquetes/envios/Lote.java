/**
 * 
 * Esta clase es de lotes
 *
 * @author Pablo Sanchez, Mikel Riskez y Alberto Vicente
 *
 */
package pacopaquetes.envios;

import enums.PRIORIDAD;
import enums.TIPOCOMIDA;
import enums.TIPOPAQUETE;
import pacopaquetes.ModifiableDate;

public class Lote extends Paquete {
    private static final long serialVersionUID = 1L;

    /**
     * Crea un nuevo lote
     * 
     * @param prio    prioridad
     * @param tipo    tipo de lote
     * @param comida  tipo de comida si lo es
     * @param maxPeso peso maximo por lote
     * @param nint    numero de intentos de reparto
     * @param fecha   fecha de creación del lote
     */
    public Lote(PRIORIDAD prio, TIPOPAQUETE tipo, TIPOCOMIDA comida, int maxPeso, int nint, ModifiableDate fecha, String CP) {
        super(prio, tipo, comida, maxPeso, nint, fecha, CP);
    }
}