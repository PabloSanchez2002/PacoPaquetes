package pacopaquetes.envios;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;

import enums.PRIORIDAD;
import enums.TIPOCOMIDA;
import enums.TIPOPAQUETE;
import pacopaquetes.ModifiableDate;
import pacopaquetes.envios.productos.*;
import pacopaquetes.usuarios.Cliente;

public class Lote extends Paquete {
    private static final long serialVersionUID = 1L;

    public Lote(PRIORIDAD prio, TIPOPAQUETE tipo, TIPOCOMIDA comida, int maxPeso, int nint, ModifiableDate fecha) {
        super(prio, tipo, comida, maxPeso, nint, fecha);
    }
}