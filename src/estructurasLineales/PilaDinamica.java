package estructurasLineales;

/**
 * Esta clase contiene los métodos de la Pila Dinámica.
 * @author Aratt
 * @version 1.0
 */
public class PilaDinamica implements Lote{

    protected ListaDinamica pila;

    /**
     * Crea una pila dinámica.
     */
    public PilaDinamica(){
        pila = new ListaDinamica();
    }

    @Override
    public boolean lleno() {
        return false;
    }

    @Override
    public boolean vacia() {
        return pila.vacia();
    }

    @Override
    public boolean poner(Object info) {
        return pila.agregar(info) > 0;
    }

    @Override
    public Object quitar() {
        return pila.eliminar();
    }

    @Override
    public void imprimir() {
        pila.imprimir();
    }

    @Override
    public Object verTope() {
        return pila.verUltimo();
    }
}
