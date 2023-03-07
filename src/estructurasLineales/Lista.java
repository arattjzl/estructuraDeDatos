package estructurasLineales;

/**
 * Esta clase contiene los métodos de una TDA lista.
 * @version 1.0
 * @author Aratt Juarez
 */
public interface Lista {
    /**
     * Este método regresa un indicador de sí la list está vacía.
     * @return regresa <b>true</b> si está vacía, <b>false</b> en caso contrario
     */
    public boolean vacia();

    /**
     * Este método añade un elemento a la lista.
     * @param info Es el nuevo valor a añadir.
     * @return Regresa la <b>posición</b> en donde se agrega o <b>-1</b> en caso de que se encuentre.
     */
    public int agregar(Object info);

    /**
     * Ese método imprime la lista en orden descendente.
     */
    public void imprimir();

    /**
     * Este método imprime la lista en orden ascendente.
     */
    public void imprimirOI();

    /**
     * Este método itera el arreglo hasta encontrar el parámetro info.
     * @param info Es el valor que se buscara en el arreglo.
     * @return Regresa la <b>posición</b> del valor que se buscara o <b>-1</b> en caso de que no se encuentre.
     */
    public Object buscar(Object info);

    /**
     * Este método elimina del arreglo el parámetro info.
     * @param info Es el valor que se eliminara del arreglo.
     * @return Regresa el objeto que se eliminó.
     */
    public Object eliminarObjeto(Object info);

    /**
     * Indica si la lista actual es igual a la lista que mandamos como parámetro.
     * @param lista2 Lista que verificaremos si es igual a la actual.
     * @return Regresa <b>true</b> si son iguales o <b>false</b> si no lo son.
     */
    public boolean esIgual(Object lista2);

    /**
     * Modifica el elemento viejo por el elemento nuevo buscando y modificando el número de veces que se indique.
     * @param infoViejo Es el elemento viejo que queremos cambiar.
     * @param infoNuevo Es el elemento nuevo que queremos.
     * @param numVeces Número de veces que queremos hacer el cambio.
     * @return Regresa <b>true</b> si se cambió al menos una vez o <b>false</b> si no se cambio nada.
     */
    public boolean cambiar(Object infoViejo, Object infoNuevo, int numVeces);

    /**
     * Busca dentro de un arreglo los elementos dados por info.
     * @param info Es el valor que se buscara en la lista actual.
     * @return Regresa una lista con las posiciones en las que se encuentra la información que estamos buscando.
     */
    public ListaEstatica buscarValores(Object info);

    /**
     * Regresará el objeto que se encuentre en la última posición del arreglo
     * @return Regresa el objeto que está en la última posición del arreglo.
     */
    public Object eliminar();

    /**
     * Vacía el contenido del arreglo
     */
    public void vaciar();

    /**
     * Añade la lista 2 a la lista actual al final de esta.
     * @param lista2 Es la lista de la cual añadiremos a la lista actual.
     * @return Regresa <b>true</b> si se añadió la lista o <b>false</b> si no se añadió.
     */
    public boolean agregarLista(Object lista2);

    /**
     * Invierte el orden de los elementos de la lista actual.
     */
    public void invertir();

    /**
     * Cuenta los elementos que hagan sean iguales a la información proporcionada.
     * @param info Es el elemento que queremos contar dentro del arreglo.
     * @return Regresa el número de veces que se repite la información proporcionada.
     */
    public int contar(Object info);

    /**
     * Eliminar todos los elementos de la lista dos que se encuentren en la lista actual.
     * @param lista2 Es la lista de la que se borraran los elementos que se encuentren en la lista actual.
     */
    public void eliminarLista(Object lista2);

    /**
     * Rellena todos los espacios dados por cantidad con el valor de información.
     * @param info Es el valor que insertaremos en los espacios.
     * @param cantidad Es la cantidad de espacios que insertaremos la nueva información.
     */
    public void rellenar(Object info, int cantidad);

    /**
     * Clona la lista actual de manera exacta.
     * @return  Regresa una copia exacta de la lista actual.
     */
    public Lista clonar();

    /**
     * Regresa una lista con los elementos que van desde el índice inicial hasta el índice final.
     * @param indiceInicial Es el índice en el cual empezara la nueva lista.
     * @param indiceFinal Es el índice en el cual terminara la lista.
     * @return Regresa la lista nueva solo con los objetos que van desde el índice inicial hasta el final.
     */
    public Lista subLista(int indiceInicial, int indiceFinal);

    /**
     * Regresar un arreglo conteniendo los elementos del arreglo
     * actual que se obtienen del arreglo de índices “listaIndices”, el cual contiene las
     * posiciones de los índices de donde se obtendrán los datos a retornar.
     * @param listaIndices Es una lista valores numéricos.
     * @return Regresa una lista con valores de los índices de la lista parámetro.
     */
    public ListaEstatica subLista(ListaEstaticaNumerica listaIndices);

    public Object verUltimo();

    public boolean recibeBuffer(Object[] info);
    public Object eliminarInicio();
}
