package estructurasLineales;

/**
 * Esta clase contiene los métodos de la Cola Dinámica.
 * @author Aratt
 * @version 1.0
 */

public class ColaDinamica implements Lote{

    protected ListaDinamica cola;

    /**
     * Crea una cola dinámica.
     */
    public ColaDinamica(){
        cola = new ListaDinamica();
    }

    @Override
    public boolean lleno() {
        return false;
    }

    @Override
    public boolean vacia() {
        return cola.vacia();
    }

    @Override
    public boolean poner(Object info) {
        return cola.agregar(info) > 0;
    }

    @Override
    public Object quitar() {
        return cola.eliminarInicio();
    }

    @Override
    public void imprimir() {
        cola.imprimir();
    }

    @Override
    public Object verTope() {
        return cola.verUltimo();
    }
}
