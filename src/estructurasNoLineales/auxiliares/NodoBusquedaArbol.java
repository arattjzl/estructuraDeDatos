package estructurasNoLineales.auxiliares;

/**
 * Nodo utilizado para guardar el índice y dirección de una base de datos.
 * @author Aratt
 * @version 1.0
 */
public class NodoBusquedaArbol {
    public Object indice;
    public long direccion;

    public NodoBusquedaArbol(Object indice, long direccion) {
        this.indice = indice;
        this.direccion = direccion;
    }

    public Object getIndice() {
        return indice;
    }

    public void setIndice(Object indice) {
        this.indice = indice;
    }

    public long getDireccion() {
        return direccion;
    }

    public void setDireccion(long direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return " [ " + indice + " - " + direccion + " ] ";
    }
}
