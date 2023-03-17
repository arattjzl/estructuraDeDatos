package estructurasLineales;

/**
 * Esta clase contiene los métodos que son de Lote.
 * @author Aratt
 * @version 1.0
 */
public interface Lote {

    /**
     * Verifica si el TDA esta lleno o no.
     * @return Regresa true si esta lleno o false si no lo está.
     */
    public boolean lleno();

    /**
     * Verifica si el TDA esta vacía o no.
     * @return Regresa true si esta vacía o false si no lo está.
     */
    public boolean vacia();

    /**
     * Agrega la información al TDA.
     * @param info Es la información que se agregará.
     * @return Regresa true si se pudo agregar o false si no.
     */
    public boolean poner(Object info);

    /**
     * Elimina el valor del TDA.
     * @return Regresa el valor que se quitó del TDA.
     */
    public Object quitar();

    /**
     * Imprime el TDA.
     */
    public void imprimir();

    /**
     * Obtiene el valor del último objeto en el TDA.
     * @return Regresa el valor.
     */
    public Object verTope();

}