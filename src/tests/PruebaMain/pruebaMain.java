package tests.PruebaMain;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import enums.*;
import pacopaquetes.*;
import pacopaquetes.envios.*;
import pacopaquetes.envios.productos.Fragil;
import pacopaquetes.envios.productos.Producto;
import pacopaquetes.usuarios.*;

public class pruebaMain {

        public static void main(String[] args) throws IOException {
                Operario op = new Operario("oper1", "oper123");
                PacoPaquetes pp = new PacoPaquetes(op);
                Repartidor rp = op.altaRepartidor("Juan", "juan123", "123123123");
                // lee camiones y CPs
                op.getEmpresa().addCP("12345");
                op.cargarCP("files/codigos.txt");
                op.altaCamionesDesdeArchivo("files/camiones.txt");

                /* Aqui debe ir el test de LeerTest pero por alguna razon no funciona */

                // Crea cliente e inicia pedido
                Cliente pepe = op.nuevoCliente("jose", "123pepe", "231238", "MANZANAS SA", "Calle joakin 14",
                                "josepepe@mail",
                                "425685222556");

                ModifiableDate date = new ModifiableDate();
                // Pedido no valido, cp no registrado en la empresa
                Pedido ped0 = op.CrearPedido(pepe, date, "10101", PRIORIDAD.URGENTE);
                assertEquals(null, ped0);

                // Pedido con CP valido
                Pedido ped = op.CrearPedido(pepe, date, "12345", PRIORIDAD.URGENTE);

                // producto normal
                op.anadirProductoPedido(ped, 2, 9, 3, 50, 30, "Altavoz",
                                pp.getConfig().getReintentos());

                // producto fragil
                op.anadirProductoPedido(ped, 20, 10, 3, 50, 34, "Cristal",
                                pp.getConfig().getReintentos(), true);

                // producto alimenticio normal
                op.anadirProductoPedido(ped, 90, 30, 3, 50, 34, "Manzana",
                                pp.getConfig().getReintentos(), false, TIPOCOMIDA.NULL);

                // producto alimenticio congelado
                op.anadirProductoPedido(ped, 5, 20, 23, 10, 20, "Atun congelado",
                                pp.getConfig().getReintentos(), false, TIPOCOMIDA.CONGELADA);

                // fragil
                op.anadirProductoPedido(ped, 50, 1, 3, 5, 41, "Jarron", pp.getConfig().getReintentos(), false);

                // producto alimenticio congelado
                op.anadirProductoPedido(ped, 3, 2, 1, 8, 23, "Pulpo congelado", pp.getConfig().getReintentos(),
                                false, TIPOCOMIDA.CONGELADA);
                // Producto dim especiales
                op.anadirProductoPedido(ped, 3, 2, 100, 800, 23, "Mesa billar", pp.getConfig().getReintentos());

                // Anadimos un lote al cliente
                Lote lot = op.CrearLote(pepe, date, "12345", PRIORIDAD.URGENTE, TIPOPAQUETE.FRAGIL, TIPOCOMIDA.NULL);
                // lot.addProduct(new Fragil(4, 6, 4, 5, 6, "Figura porcelana", "12345",
                // PRIORIDAD.URGENTE, 4, true,date));
                WriterReader wr = new WriterReader();
                wr.guardarPP("pp.txt", pp);

                PacoPaquetes pp2 = wr.cargarPP("pp.txt");

                op.empaquetar();
                ArrayList<Paquete> paq = pp.getPaquetes();

                op.generarPlanesReparto(paq);
                ArrayList<PlanDeReparto> plan = new ArrayList<PlanDeReparto>();

        }
}
