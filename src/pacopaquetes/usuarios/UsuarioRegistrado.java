/**
 * 
 * Esta clase es del usuario registrado
 *
 * @author Pablo Sanchez, Mikel Risquez y Alberto Vicente
 *
 */
package pacopaquetes.usuarios;

import java.io.Serializable;

public abstract class UsuarioRegistrado extends UsuarioSinRegistrar implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Nombre de usuario
     */
    private String usuario;
    /**
     * Contraseña
     */
    private String contrasena;

    /**
     * Constructor del usuario registrado
     * 
     * @param usuario    Nombre de usuario
     * @param contrasena Contraseña
     */
    public UsuarioRegistrado(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    /**
     * Cambia el usuario al dado por parametro
     *
     * @param usuario usuario a cambiar
     * 
     */
    // ================SETS===============//
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Cambia la contraseña
     * 
     * @param contrasena nueva contraseña
     */

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // ================GETS===============//
    /*
     * Devuelve el usuario
     * 
     * @return String
     */
    public String getUsuario() {
        return this.usuario;
    }

    /**
     * Devuelve la contraseña
     * 
     * @return String
     */
    public String getContrasena() {
        return this.contrasena;
    }

}
