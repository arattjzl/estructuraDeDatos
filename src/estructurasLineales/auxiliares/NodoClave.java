package estructurasLineales.auxiliares;

/**
 * Clase que contiene los métodos para la creación y obtención del nodo clave y sus atributos.
 * @author Aratt
 * @version 1.0
 */
public class NodoClave {

    protected Object clave;
    protected Object valor;
    protected NodoClave ligaDer;

    public NodoClave(Object clave, Object valor){
        this.clave = clave;
        this.valor = valor;
    }

    /**
     * Obtiene la clave del nodo.
     * @return Regresa la clave del nodo.
     */
    public Object getClave() {
        return clave;
    }

    /**
     * Sirve para poner la clave al nodo.
     * @param clave Es la clave que tendrá el nodo.
     */
    public void setClave(Object clave) {
        this.clave = clave;
    }

    /**
     * Obtiene la información del nodo.
     * @return Regresa la información del nodo.
     */
    public Object getValor() {
        return valor;
    }

    /**
     * Sirve para poner la información del nodo.
     * @param valor Es la información del nodo.
     */
    public void setValor(Object valor) {
        this.valor = valor;
    }

    /**
     * Obtiene el nodo al que está conectado.
     * @return Regresa el nodo al que se encuentra ligado.
     */
    public NodoClave getLigaDer() {
        return ligaDer;
    }

    /**
     * Sirve para poner la liga al siguiente nodo.
     * @param ligaDer Es el nodo al que está ligado.
     */
    public void setLigaDer(NodoClave ligaDer) {
        this.ligaDer = ligaDer;
    }
}
