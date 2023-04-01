package registros.usoComputadoras;

/**
 * Clase con los métodos para usuario.
 * @author Aratt
 * @version 1.0
 */

public class Usuario {

    protected String nombre;

    public Usuario(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
