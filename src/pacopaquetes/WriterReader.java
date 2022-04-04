/**
 * 
 * Esta clase es del WriterReader
 *
 * @author Pablo Sanchez, Mikel Riskez y Alberto Vicente
 *
 */
package pacopaquetes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WriterReader {
	public WriterReader() {
	}

	/**
	 * Guarda el objeto paco paquetes en el fichero que se le pase por parametro
	 * 
	 * @param file fichero donde lo guarda
	 * @param pp   objeto que guarda en el ficherp
	 */
	public void guardarPP(String file, PacoPaquetes pp) {

		try {
			FileOutputStream f = new FileOutputStream(new File(file));
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			o.writeObject(pp);

			o.close();
			f.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error initializing stream");
		}

	}

	/**
	 * Carga el objeto paco paquetes desde el fichero que se le pase por parametro
	 * 
	 * @param file fichero desde donde lo carga
	 * @return PacoPaquetes objeto leido
	 */
	public PacoPaquetes cargarPP(String file) {
		PacoPaquetes pp = null;
		try {
			FileInputStream fi = new FileInputStream(new File(file));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read object
			pp = (PacoPaquetes) oi.readObject();

			oi.close();
			fi.close();

			return pp;

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return pp;
	}

}