package tests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import org.junit.Test;

import enums.*;
import pacopaquetes.*;
import pacopaquetes.envios.productos.*;
import pacopaquetes.usuarios.*;

public class ProductoTest {
        // Test Producto/Alimentario/Normal/Fragil/.java
        @Test
        public void test() throws IOException {
                Operario op = new Operario("oper1", "oper123");
                PacoPaquetes pp = new PacoPaquetes(op);
                ModifiableDate dat = new ModifiableDate();

                // Test Producto Normal//

                Producto nor = new Normal(30, 40, 12, 8, 4, "Silla", "12345", PRIORIDAD.NORMAL,
                                pp.getConfig().getReintentos(), dat);

                assertEquals(30, nor.getNumUnidades());
                assertEquals(40, nor.getPesoTotal(), 0);
                assertEquals(12, nor.getAlto(), 0);
                assertEquals(8, nor.getAncho(), 0);
                assertEquals(4, nor.getProfundo(), 0);
                assertEquals("Silla", nor.getNombre());
                assertEquals("12345", nor.getCodPost());
                assertEquals(PRIORIDAD.NORMAL, nor.getPrioridad());
                assertEquals(pp.getConfig().getReintentos(), nor.getNIntentos());
                assertEquals(dat, nor.getFecha());
                assertEquals(ESTADO.EN_ALMACEN, nor.getEstado());
                assertEquals(false, nor.getEmpaquetado());
                assertEquals(1, nor.getId());
                assertEquals(18, nor.getPrecio(), 0);

                ModifiableDate.setToday();

                nor.setAlto(10);
                nor.setAncho(3);
                nor.setCodPost("67890");
                nor.setEmpaquetado(true);
                nor.setEstado(ESTADO.EN_REPARTO);
                nor.setFecha(dat);
                nor.setId(50);
                nor.setNintentos(32);
                nor.setNombre("Mesa");
                nor.setNumUnidades(60);
                nor.setPesoTotal(70);
                nor.setPrioridad(PRIORIDAD.URGENTE);
                nor.setProfundo(14);

                assertEquals(60, nor.getNumUnidades());
                assertEquals(70, nor.getPesoTotal(), 0);
                assertEquals(10, nor.getAlto(), 0);
                assertEquals(3, nor.getAncho(), 0);
                assertEquals(14, nor.getProfundo(), 0);
                assertEquals("Mesa", nor.getNombre());
                assertEquals("67890", nor.getCodPost());
                assertEquals(PRIORIDAD.URGENTE, nor.getPrioridad());
                assertEquals(32, nor.getNIntentos());
                assertEquals(dat, nor.getFecha());
                assertEquals(ESTADO.EN_REPARTO, nor.getEstado());
                assertEquals(true, nor.getEmpaquetado());
                assertEquals(50, nor.getId());
                assertEquals(36, nor.getPrecio(), 0);

                // Test Producto Fragil//

                Fragil fra = new Fragil(50, 10, 30, 50, 41, "Jarron", "3456", PRIORIDAD.NORMAL,
                                pp.getConfig().getReintentos(), false, dat);
                assertEquals(false, fra.getAsegurado());
                assertEquals(120, fra.getPrecio(), 0);

                fra.setAsegurado(true);

                assertEquals(true, fra.getAsegurado());
                assertEquals(270, fra.getPrecio(), 0);

                // Test Producto Alimentario//

                Alimentario alim = new Alimentario(70, 12, 4, 2, 1, "Manzana", "1234", PRIORIDAD.NORMAL,
                                pp.getConfig().getReintentos(), false, TIPOCOMIDA.NORMAL, dat);

                assertEquals(TIPOCOMIDA.NORMAL, alim.getTipo());
                assertEquals(false, alim.getLiquido());
                assertEquals(448, alim.getPrecio(), 0);

                alim.setLiquido(true);
                alim.setTipo(TIPOCOMIDA.CONGELADA);

                assertEquals(TIPOCOMIDA.CONGELADA, alim.getTipo());
                assertEquals(true, alim.getLiquido());
        }
}
