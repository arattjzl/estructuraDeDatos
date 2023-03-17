package estructurasLineales.auxiliares;

/**
 * Esta clase contiene los métodos del Nodo.
 * @author Aratt
 * @version 1.0
 */
public class Nodo {
    protected Object info;
    protected Nodo apuntadorOtroNodo;

    /**
     * Crea un nodo con información.
     * @param info Es la información que contedrá el nodo.
     */
    public Nodo(Object info){
        this.info = info;
        apuntadorOtroNodo = null;
    }

    /**
     * Crea un nodo sin información.
     */
    public Nodo(){
        info = null;
        apuntadorOtroNodo = null;
    }

    /**
     * Regresa la información del nodo.
     * @return Regresa la información del nodo.
     */
    public Object getInfo() {
        return info;
    }

    /**
     * Cambia la información del nodo.
     * @param info Es la nueva información del nodo.
     */
    public void setInfo(Object info) {
        this.info = info;
    }

    /**
     * Regresa el nodo al que apunta.
     * @return Regresa el nodo al que apunta.
     */
    public Nodo getApuntadorOtroNodo() {
        return apuntadorOtroNodo;
    }

    /**
     * Cambia el apuntador a otro nodo.
     * @param apuntadorOtroNodo Es el nuevo nodo a donde apuntará.
     */
    public void setApuntadorOtroNodo(Nodo apuntadorOtroNodo) {
        this.apuntadorOtroNodo = apuntadorOtroNodo;
    }

    @Override
    public String toString() {
        return info.toString();
    }
}
