package tests;

import java.io.IOException;
import java.util.ArrayList;

import pacopaquetes.PacoPaquetes;
import pacopaquetes.usuarios.Operario;
import pacopaquetes.*;


public class mainleer {

    public static void main(String args[]) throws IOException {
        Operario op = new Operario("oper1", "oper123");
        PacoPaquetes pp = new PacoPaquetes(op);
        op.cargarCP("files/codigos.txt");
        op.altaCamionesDesdeArchivo("files/camiones.txt");

        ArrayList<Camion> cam = pp.getCamiones();
        ArrayList<String> cp = pp.getCPs();
        //================
        System.out.println(cam.size() + " " +cp.size());
    }
}
