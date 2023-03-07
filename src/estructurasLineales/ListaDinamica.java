package estructurasLineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.auxiliares.Nodo;

public class ListaDinamica implements Lista{
    protected Nodo primero;
    protected Nodo ultimo;
    protected Nodo nodoActual;
    public ListaDinamica(){
        primero = null;
        ultimo = null;
        nodoActual = null;
    }

    /**
     * Este método regresa un indicador de sí la list está vacía.
     * @return regresa <b>true</b> si está vacía, <b>false</b> en caso contrario
     */
    @Override
    public boolean vacia() {
        return primero == null;
    }

    /**
     * Este método añade un elemento a la lista.
     *
     * @param info Es el nuevo valor a añadir.
     * @return Regresa la <b>posición</b> en donde se agrega o <b>-1</b> en caso de que se encuentre.
     */
    @Override
    public int agregar(Object info) {
        Nodo nuevoNodo = new Nodo(info);
        if(nuevoNodo != null){
            if(vacia()){
                primero = nuevoNodo;
            } else {
                ultimo.setApuntadorOtroNodo(nuevoNodo);
            }
            ultimo = nuevoNodo;
            return 1;
            }
        return -1;
    }

    public int agregarPrincipio(Object info){
        Nodo nuevoNodo = new Nodo(info);
        if(nuevoNodo != null){
            if(vacia()){
                ultimo = nuevoNodo;
            } else {
                nuevoNodo.setApuntadorOtroNodo(primero);
            }
            primero = nuevoNodo;
            return 1;
        }
        return -1;
    }

    /**
     * Ese método imprime la lista en orden descendente.
     */
    @Override
    public void imprimir() {
        Nodo temporal = primero;
        while(temporal != null){
            SalidaPorDefecto.terminal(temporal.getInfo() + " -> ");
            temporal = temporal.getApuntadorOtroNodo();
        }
        SalidaPorDefecto.terminal("null");
    }

    /**
     * Este método imprime la lista en orden ascendente.
     */
    @Override
    public void imprimirOI() {

    }

    /**
     * Este método itera el arreglo hasta encontrar el parámetro info.
     *
     * @param info Es el valor que se buscara en el arreglo.
     * @return Regresa la <b>posición</b> del valor que se buscara o <b>-1</b> en caso de que no se encuentre.
     */
    @Override
    public Object buscar(Object info) {
        return null;
    }

    /**
     * Este método elimina del arreglo el parámetro info.
     *
     * @param info Es el valor que se eliminara del arreglo.
     * @return Regresa el objeto que se eliminó.
     */
    @Override
    public Object eliminarObjeto(Object info) {
        return null;
    }

    /**
     * Indica si la lista actual es igual a la lista que mandamos como parámetro.
     *
     * @param lista2 Lista que verificaremos si es igual a la actual.
     * @return Regresa <b>true</b> si son iguales o <b>false</b> si no lo son.
     */
    @Override
    public boolean esIgual(Object lista2) {
        return false;
    }

    /**
     * Modifica el elemento viejo por el elemento nuevo buscando y modificando el número de veces que se indique.
     *
     * @param infoViejo Es el elemento viejo que queremos cambiar.
     * @param infoNuevo Es el elemento nuevo que queremos.
     * @param numVeces  Número de veces que queremos hacer el cambio.
     * @return Regresa <b>true</b> si se cambió al menos una vez o <b>false</b> si no se cambio nada.
     */
    @Override
    public boolean cambiar(Object infoViejo, Object infoNuevo, int numVeces) {
        return false;
    }

    /**
     * Busca dentro de un arreglo los elementos dados por info.
     *
     * @param info Es el valor que se buscara en la lista actual.
     * @return Regresa una lista con las posiciones en las que se encuentra la información que estamos buscando.
     */
    @Override
    public ListaEstatica buscarValores(Object info) {
        return null;
    }

    /**
     * Regresará el objeto que se encuentre en la última posición del arreglo
     *
     * @return Regresa el objeto que está en la última posición del arreglo.
     */
    @Override
    public Object eliminar() {
        if(!vacia()){
            Object respaldo = ultimo.getInfo();
            if(primero == ultimo){
                primero = null;
                ultimo = null;
            } else {
                Nodo penultimo = primero;
                while (penultimo.getApuntadorOtroNodo() != ultimo){
                    penultimo = penultimo.getApuntadorOtroNodo();
                }
                penultimo.setApuntadorOtroNodo(null);
                ultimo = penultimo;
            }
            return respaldo;
        }
        return null;
    }

    @Override
    public Object eliminarInicio(){
        if(!vacia()){
            Object respaldo = primero.getInfo();
            if(primero == ultimo){
                primero = null;
                ultimo = null;
            } else {
                primero = primero.getApuntadorOtroNodo();
            }
            return respaldo;
        }
        return null;
    }

    /**
     * Vacía el contenido del arreglo
     */
    @Override
    public void vaciar() {

    }

    /**
     * Añade la lista 2 a la lista actual al final de esta.
     *
     * @param lista2 Es la lista de la cual añadiremos a la lista actual.
     * @return Regresa <b>true</b> si se añadió la lista o <b>false</b> si no se añadió.
     */
    @Override
    public boolean agregarLista(Object lista2) {
        return false;
    }

    /**
     * Invierte el orden de los elementos de la lista actual.
     */
    @Override
    public void invertir() {

    }

    /**
     * Cuenta los elementos que hagan sean iguales a la información proporcionada.
     *
     * @param info Es el elemento que queremos contar dentro del arreglo.
     * @return Regresa el número de veces que se repite la información proporcionada.
     */
    @Override
    public int contar(Object info) {
        return 0;
    }

    /**
     * Eliminar todos los elementos de la lista dos que se encuentren en la lista actual.
     *
     * @param lista2 Es la lista de la que se borraran los elementos que se encuentren en la lista actual.
     */
    @Override
    public void eliminarLista(Object lista2) {

    }

    /**
     * Rellena todos los espacios dados por cantidad con el valor de información.
     *
     * @param info     Es el valor que insertaremos en los espacios.
     * @param cantidad Es la cantidad de espacios que insertaremos la nueva información.
     */
    @Override
    public void rellenar(Object info, int cantidad) {

    }

    /**
     * Clona la lista actual de manera exacta.
     *
     * @return Regresa una copia exacta de la lista actual.
     */
    @Override
    public Lista clonar() {
        return null;
    }

    /**
     * Regresa una lista con los elementos que van desde el índice inicial hasta el índice final.
     *
     * @param indiceInicial Es el índice en el cual empezara la nueva lista.
     * @param indiceFinal   Es el índice en el cual terminara la lista.
     * @return Regresa la lista nueva solo con los objetos que van desde el índice inicial hasta el final.
     */
    @Override
    public Lista subLista(int indiceInicial, int indiceFinal) {
        return null;
    }

    /**
     * Regresar un arreglo conteniendo los elementos del arreglo
     * actual que se obtienen del arreglo de índices “listaIndices”, el cual contiene las
     * posiciones de los índices de donde se obtendrán los datos a retornar.
     *
     * @param listaIndices Es una lista valores numéricos.
     * @return Regresa una lista con valores de los índices de la lista parámetro.
     */
    @Override
    public ListaEstatica subLista(ListaEstaticaNumerica listaIndices) {
        return null;
    }

    @Override
    public Object verUltimo() {
        return null;
    }

    @Override
    public boolean recibeBuffer(Object[] info) {
        return false;
    }

    public void inicializarIterador(){
        nodoActual = primero;
    }

    public boolean hayNodo(){
        return nodoActual == null;
    }

    public Object obtenerNodo(){
        if(hayNodo()){
            Object respaldo = nodoActual.getInfo();
            nodoActual = nodoActual.getApuntadorOtroNodo();
            return respaldo;
        }
        return null;
    }
}
