package pacopaquetes.GUI.Paneles.Operario;

import pacopaquetes.*;
import pacopaquetes.usuarios.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class pantOper {

    private Operario op;

    public pantOper(PacoPaquetes pp, Operario op){
        this.op=op;
        this.op.setEmpresa(pp);
    }


}
