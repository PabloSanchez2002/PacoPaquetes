/**
 * 
 * Esta clase es del operario
 *
 * @author Pablo Sanchez, Mikel Riskez y Alberto Vicente
 *
 */
package pacopaquetes.usuarios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import enums.*;
import pacopaquetes.*;
import pacopaquetes.envios.*;
import pacopaquetes.envios.productos.*;

public class Operario extends UsuarioRegistrado {

    /**
     * Empresa sobre la que tiene control
     */
    private PacoPaquetes Empresa;

    /**
     * Contructor de Operario, devulve el objecto Operario
     * 
     * @param usuario    usurio del operario
     * @param contrasena Contrasena del operario
     */
    public Operario(String usuario, String contrasena) {
        super(usuario, contrasena);
    }

    // ===============SETS===============//
    /**
     * Anade la empresa del operario
     * 
     * @param PPaquetes empresa
     */
    public void setEmpresa(PacoPaquetes PPaquetes) {
        this.Empresa = PPaquetes;
    }

    // ===============GETS===============//
    /**
     * Devuelve la empresa del operario
     * 
     * @return PacoPaquetes
     */
    public PacoPaquetes getEmpresa() {
        return this.Empresa;
    }

    /**
     * Da de alta un rapartidor
     * 
     * @param usuario    nombre de usuario
     * @param contrasena contrasena
     * @param telefono   telefono de contacto
     * @return Repartidor
     */
    public Repartidor altaRepartidor(String usuario, String contrasena, String telefono) {
        Repartidor rep = new Repartidor(usuario, contrasena, telefono);
        this.Empresa.addRepartidor(rep);
        return rep;
    }

    /**
     * Da de baja un repartidor
     * 
     * @param rep Repartidor a dar de baja
     */
    public void bajaRepartidor(Repartidor rep) {
        this.Empresa.rmRepartidor(rep);
    }

    /**
     * Da de alta un camion
     * 
     * @param matricula matricula
     * @param pesoMax   peso maximo
     * @param tipo      tipo de camion
     * @return Camion
     */
    public Camion altaCamion(String matricula, int pesoMax, TIPOCAMION tipo) {
        Camion cam = new Camion(matricula, pesoMax, tipo);
        this.Empresa.addCamion(cam);
        return cam;
    }

    /**
     * Anade camiones a la flota de camiones
     * 
     * @param filename nombre del archivo
     * @throws IOException en caso de no encontrar el archivo
     */
    public void altaCamionesDesdeArchivo(String filename) throws IOException {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File(filename);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            int matricula;
            String strCamion = br.readLine();
            while (strCamion != null) {
                String[] camion = strCamion.split(":");
                matricula = Integer.parseInt(camion[1]);

                this.altaCamion(camion[0], matricula, TIPOCAMION.ESTANDAR.getTipo(camion[2]));
                strCamion = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /**
     * Carga las direcciones postales desde un archivo
     * 
     * @param filename nombre del archivo
     */
    public void cargarCP(String filename) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File(filename);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                this.Empresa.addCP(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /**
     * Da de baja un camion
     * 
     * @param cam a dar de baja
     */
    public void bajaCamion(Camion cam) {
        this.Empresa.rmCamion(cam);
    }

    /**
     * Crea un nuevo cliente en la empresa
     * 
     * @param usuario             nombre de usuario
     * @param contrasena          cotrasena
     * @param CIF                 CIF
     * @param nombreEmpresa       nombre de la empresa
     * @param direcconFacturacion direccion
     * @param correoElectronico   correo
     * @param targetaBancaria     tarjeta
     * @return Cliente
     */
    public Cliente nuevoCliente(String usuario, String contrasena, String CIF, String nombreEmpresa,
            String direcconFacturacion, String correoElectronico, String targetaBancaria) {
        Cliente cli = new Cliente(usuario, contrasena, CIF, nombreEmpresa, direcconFacturacion, correoElectronico,
                targetaBancaria);
        this.Empresa.addCliente(cli); // ==================================//
        return cli;
    }

    /**
     * Compara el volumen de el producto con el maximo permitido
     * 
     * @param prod
     * @return boolean
     */
    public boolean MaxVolum(Producto prod) {
        if (prod.getAlto() * prod.getAncho() * prod.getProfundo() > this.Empresa.getConfig().getMaxVolume())
            return true;
        else
            return false;
    }

    /**
     * Anade un producto normal a un pedido
     * 
     * @param ped      pedido
     * @param num      numero de productos
     * @param pesoTot  peso total
     * @param alto     alto
     * @param ancho    ancho
     * @param profundo profundo
     * @param nombre   nombre del producto
     * @param nInt     numeor de intentos
     */
    public void anadirProductoPedido(Pedido ped, int num, float pesoTot, float alto, float ancho, float profundo,
            String nombre, int nInt) {
        Producto p = new Normal(num, pesoTot, alto, ancho, profundo, nombre, ped.getCodPost(), ped.getPrioridad(),
                nInt, ped.getFecha());
        p.setDimEspecial(this.MaxVolum(p));
        ped.anadirProducto(p);
        Empresa.addProducto(p);
    }

    /**
     * Anade un producto alimentario a un pedido
     * 
     * @param ped      pedido
     * @param num      numero de productos
     * @param pesoTot  peso total
     * @param alto     alto
     * @param ancho    ancho
     * @param profundo profundo
     * @param nombre   nombre del producto
     * @param nInt     numeor de intentos
     * @param liquido  si es liquido o no
     * @param tipo     tipo de comida
     */
    public void anadirProductoPedido(Pedido ped, int num, float pesoTot, float alto, float ancho, float profundo,
            String nombre, int nInt, Boolean liquido, TIPOCOMIDA tipo) {
        Producto p = new Alimentario(num, pesoTot, alto, ancho, profundo, nombre, ped.getCodPost(),
                ped.getPrioridad(), nInt, liquido, tipo, ped.getFecha());
        p.setDimEspecial(this.MaxVolum(p));
        ped.anadirProducto(p);
        Empresa.addProducto(p);
    }

    /**
     * Anade un producto fragil a un pedido
     * 
     * @param ped       pedido
     * @param num       numero de productos
     * @param pesoTot   peso total
     * @param alto      alto
     * @param ancho     ancho
     * @param profundo  profundo
     * @param nombre    nombre del producto
     * @param nInt      numeor de intentos
     * @param asegurado si esta asegurado
     */
    public void anadirProductoPedido(Pedido ped, int num, float pesoTot, float alto, float ancho, float profundo,
            String nombre, int nInt, Boolean asegurado) {
        Producto p = new Fragil(num, pesoTot, alto, ancho, profundo, nombre, ped.getCodPost(), ped.getPrioridad(),
                nInt, asegurado, ped.getFecha());
        p.setDimEspecial(this.MaxVolum(p));
        ped.anadirProducto(p);
        Empresa.addProducto(p);
    }

    /**
     * Crea un pedido para un cliente
     * 
     * @param cliente cliente que hce el pedido
     * @param date    fecha
     * @param codPos  direccion
     * @param pr      prioridad
     * @return
     */
    public Pedido CrearPedido(Cliente cliente, ModifiableDate date, String codPos, PRIORIDAD pr) {
        if (this.getEmpresa().getCPs().contains(codPos) == true) {
            Pedido ped = new Pedido(date, codPos, pr);
            this.Empresa.addPedido(ped);
            cliente.addPedido(ped);
            return ped;
        }
        return null;
    }

    /**
     * Crea un lote
     * 
     * @param cliente cliente
     * @param date    fecha
     * @param codPos  codigo postal
     * @param pr      prioridad
     * @param tp      tipo paquete
     * @param tc      tipo comida
     * @return Lote
     */
    public Lote CrearLote(Cliente cliente, ModifiableDate date, String codPos, PRIORIDAD pr, TIPOPAQUETE tp,
            TIPOCOMIDA tc) {
        if (this.getEmpresa().getCPs().contains(codPos) == true) {
            Lote lot = new Lote(pr, tp, tc, this.getEmpresa().getConfig().getmaxPesoPaqNormal(),
                    this.getEmpresa().getConfig().getReintentos(), date);
            this.Empresa.addPaquete(lot);
            cliente.addLote(lot);
            return lot;
        }
        return null;

    }

    /**
     * Devuelve un array de productos que no han sido empaquetados
     * 
     * @param prods productos a comprobar
     * @return ArrayList<Producto> array de productos sin empaquetar
     */
    public ArrayList<Producto> listaSinEmpaquetar(ArrayList<Producto> prods) {
        ArrayList<Producto> unpacked = new ArrayList<Producto>();
        for (Producto p : prods) {
            if (p.getEmpaquetado() == false) {
                unpacked.add(p);
            }
        }
        return unpacked;
    }

    /**
     * Obtine el primer producto de un array
     * 
     * @param prods array de productos
     * @return Producto primer producto
     */
    public Producto primerProd(ArrayList<Producto> prods) {
        for (Producto p : prods) {
            if (p.getEmpaquetado() == false) {
                return p;
            }
        }
        return null;
    }

    /**
     * Genera paquetes en los que anade productos
     * 
     * @param productos productos a anadir
     */
    public void generarPaquetes(ArrayList<Producto> productos) {
        Collections.sort(productos);

        while (productos.isEmpty() == false) {
            productos = this.listaSinEmpaquetar(productos);
            Producto primero = this.primerProd(productos);
            Paquete paq = primero.nuevoPaquete(this.getEmpresa().getConfig());
            productos.remove(primero);
            this.getEmpresa().addPaquete(paq);
            paq.empaquetadoMasivo(productos);
        }
    }

    /**
     * Funcion para empaquetar los productos de la empresa
     */

    public void empaquetar() {
        ArrayList<Producto> prods;

        for (String cp : this.getEmpresa().getCPs()) {
            prods = this.listaSinEmpaquetar(this.getEmpresa().getProductos());
            ArrayList<Producto> mismoCP = new ArrayList<Producto>();
            for (Producto p : prods) {
                if (p.getCodPost().equals(cp)) {
                    mismoCP.add(p);
                }
            }
            generarPaquetes(mismoCP);
        }
    }

    /**
     * Encuentra los paquetes sin repartir de un arrray dado
     *
     * @param paquetes array de paquetes a comprobar
     * @return ArrayList<Paquete> array de paquetes sin repartir
     */
    public ArrayList<Paquete> PaquetesSinRepartir(ArrayList<Paquete> paquetes) {
        ArrayList<Paquete> storage = new ArrayList<Paquete>();
        for (Paquete p : paquetes) {
            if (p.getEntregado() == ESTADO.EN_ALMACEN) {
                storage.add(p);
            }
        }
        return storage;
    }

    /**
     * Retorna el primer paquete del array de paquetes
     * 
     * @param paq array de paquetes
     * @return Paquete primer paquete
     */
    public Paquete primerPaq(ArrayList<Paquete> paq) {
        for (Paquete p : paq) {
            if (p.getEntregado() == ESTADO.EN_ALMACEN) {
                return p;
            }
        }
        return null;
    }

    /**
     * Comprueba los camiones sin cargar que pueden ser usados para el reparto
     * 
     * @param camiones camiones a comprobar
     * @return ArrayList<Camion> sin cargar y funcionales
     */
    public ArrayList<Camion> camionesSinCargar(ArrayList<Camion> camiones) {
        ArrayList<Camion> descargados = new ArrayList<Camion>();

        for (Camion c : camiones) {
            if (c.getCargado() == false || c.getAveriado() == false) {
                descargados.add(c);
            }
        }

        return descargados;
    }

    /**
     * Genera todos los planes de reparto a partir de los paquetes a repartir
     * 
     * @param paquetes paquetes a repartir
     */
    public void generarPlanesReparto(ArrayList<Paquete> paquetes) {
        Collections.sort(paquetes);
        while (paquetes.isEmpty() == false) {
            paquetes = this.PaquetesSinRepartir(paquetes);
            ArrayList<Camion> camiones = camionesSinCargar(this.Empresa.getCamiones());
            Paquete primero = this.primerPaq(paquetes);
            PlanDeReparto rep = primero.nuevoPlanDeReparto(camiones,this.getEmpresa().getConfig().getMaxCodPostales()); 
            if (rep != null) {
                paquetes.remove(primero);
                this.getEmpresa().addPlanDeReparto(rep);
                rep.repartoMasivo(paquetes);
                rep.getCamion().setCargado(true);
            } else {
                paquetes.remove(primero);
            }
        }
    }

    /**
     * Asigna un plan de reparto a un repartidor
     * 
     * @param rep        plan de reparto
     * @param repartidor repartidor
     */
    public void asignarRepartidor(PlanDeReparto rep, Repartidor repartidor) {
        if (repartidor.consultarPlanReparto() == null) {
            repartidor.setPlanReparto(rep);
        }
    }

    /**
     * Simula un reparto de todos los planes de la empresa
     * 
     * @param reparto indica si se han repartido o si no
     */
    public void simularReparto(Boolean reparto) {
        for (PlanDeReparto plan : this.Empresa.getPlanDeRepartos()) {
            for (Paquete paquetes : plan.getPaquetes()) {
                if (reparto == true) {
                    paquetes.setEntregado(ESTADO.ENTREGADO);
                    for (Producto prods : paquetes.getProductos()) {
                        prods.setEstado(ESTADO.ENTREGADO);
                    }
                } else if (reparto == false) {
                    paquetes.setNintentos(paquetes.getNIntentos() - 1);
                    paquetes.setEntregado(ESTADO.EN_ALMACEN);
                    for (Producto prods : paquetes.getProductos()) {
                        prods.setNintentos(prods.getNIntentos() - 1);
                        prods.setEstado(ESTADO.EN_ALMACEN);
                    }
                }
            }
        }
    }

}