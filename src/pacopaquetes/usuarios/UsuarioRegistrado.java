package pacopaquetes.usuarios;

import java.io.Serializable;

public abstract class UsuarioRegistrado extends UsuarioSinRegistrar implements Serializable {
    private static final long serialVersionUID = 1L;
    private String usuario;
    private String contrasena;

    public UsuarioRegistrado(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    // ================SETS===============//
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // ================GETS===============//
    public String getUsuario() {
        return this.usuario;
    }

    public String getContrasena() {
        return this.contrasena;
    }

}
