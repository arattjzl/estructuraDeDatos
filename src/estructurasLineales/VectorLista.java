package estructurasLineales;

/**
 * Esta clase contiene los métodos de una TDA lista estática.
 * @version 1.0
 * @author Aratt Juarez
 */
public interface VectorLista extends Lista{
    /**
     * Este método regresa si la lista está llena.
     * @return Regresa <b>true</b> si la lista esta llena o <b>false</b> si no esta llena.
     */
    public boolean llena();

    /**
     * Este método regresa un entero que es el máximo del arreglo.
     * @return Regresa el número máximo del arreglo.
     */
    public int maximo();

    /**
     * Este método regresa la cantidad de elementos que hay en el arreglo.
     * @return Regresa el número de la cantidad de la lista.
     */
    public int cantidad();

    /**
     * Regresa el objeto en la posición del índice.
     * @param indice Es el valor que queremos regresar
     * @return Regresa el objeto que se encuentra en la posición que buscamos.
     */
    public Object obtener(int indice);

    /**
     * Modifica el elemento en la posición índice y pone la información en ese índice.
     * @param indice Es el valor en el cual queremos cambiar la información.
     * @param info Es la información que queremos insertar.
     * @return Regresa <b>true</b> si se pudo cambiar y <b>false</b> si no se pudo cambiar.
     */
    public boolean cambiar(int indice, Object info);

    /**
     * Modifica el elemento de la posición índice por el contenido de infos
     * @param indicesBusqueda Las posiciones en las que se insertaran nueva información.
     * @param infosNuevos Son los datos que insertaremos en la lista actual.
     * @return Regresará <b>true</b> si es que se pudo realizar el cambio y <b>false</b> si no se pudo y dirá si fue por las dimensiones o por índices inválidos.
     */
    public boolean cambiarListaEstatica(ListaEstatica indicesBusqueda, ListaEstatica infosNuevos);

    /**
     * Elimina el elemento del arreglo en una posición dada.
     * @param indice Es la posición la cual se quiere eliminar.
     * @return Regresa el objeto eliminado.
     */
    public Object eliminar(int indice);

    /**
     * Redimensionará el tamaño del arreglo.
     * @param maximo Es el número máximo al que cambiaremos el arreglo
     * @return Regresa si se realizo el redimensionamiento.
     */
    public boolean redimensionar(int maximo);

}
