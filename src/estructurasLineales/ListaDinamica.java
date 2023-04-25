package estructurasLineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.auxiliares.Nodo;
import estructurasNoLineales.Matriz2;
import utils.commons.Comparador;
import utils.commons.TipoTabla;

/**
 * Esta clase contiene los métodos para una Lista Dinámica.
 * @author Aratt
 * @version 1.0
 */
public class ListaDinamica implements Lista{
    protected Nodo primero;
    protected Nodo ultimo;
    protected Nodo nodoActual;

    /**
     * Crea una lista dinámica.
     */
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

    /**
     * Obtiene el objeto en el índice indicado.
     * @param indice Índice en el cual se buscará el valor.
     * @return Regresa el objeto del índice indicado.
     */
    public Object obtener(int indice){
        int cadaIndice = 0;
        inicializarIterador();
        while (nodoActual != null){
            if(cadaIndice == indice){
                return nodoActual;
            }
            cadaIndice++;
            nodoActual = nodoActual.getApuntadorOtroNodo();
        }
        return null;

    }

    /**
     * Agrega información al principio de la lista.
     * @param info Información por agregar.
     * @return Regresa 1 si se agregó o -1 si no se agregó.
     */
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
        PilaDinamica pila = new PilaDinamica();
        inicializarIterador();
        while (nodoActual != null){
            pila.poner(nodoActual.getInfo());
            nodoActual = nodoActual.getApuntadorOtroNodo();
        }
        SalidaPorDefecto.terminal("null");
        while (!pila.vacia()){
            SalidaPorDefecto.terminal(" <- " + pila.quitar());
        }
    }

    /**
     * Este método itera el arreglo hasta encontrar el parámetro info.
     *
     * @param info Es el valor que se buscara en el arreglo.
     * @return Regresa la <b>posición</b> del valor que se buscara o <b>-1</b> en caso de que no se encuentre.
     */
    @Override
    public Object buscar(Object info) {
        inicializarIterador();
        while (nodoActual != null && !(info.toString().equalsIgnoreCase(nodoActual.getInfo().toString()))){
            nodoActual = nodoActual.getApuntadorOtroNodo();
        }
        if (nodoActual != null){
            return nodoActual.getInfo();
        }
        return null;
    }

    /**
     * Elimina el objeto de la lista en el índice que se indica.
     * @param indice Índice por borrar.
     * @return Regresa el valor que se borrará.
     */
    public Object eliminar(int indice){
        ListaEstatica listaDeNodos;
        int cadaIndice = 0;
        inicializarIterador();
        Object respaldo = null;
        while (nodoActual != null){
            if(cadaIndice == indice){
                respaldo = nodoActual;
                Object info = nodoActual;
                listaDeNodos = buscarAnterior(info);
                Nodo anterior = (Nodo) listaDeNodos.obtener(0);
                nodoActual = nodoActual.getApuntadorOtroNodo();
                anterior.setApuntadorOtroNodo(nodoActual);
            }
            cadaIndice++;
            nodoActual = nodoActual.getApuntadorOtroNodo();
        }
        return respaldo;
    }

    /**
     * Este método elimina del arreglo el parámetro info.
     *
     * @param info Es el valor que se eliminara del arreglo.
     * @return Regresa el objeto que se eliminó.
     */
    @Override
    public Object eliminarObjeto(Object info) {
        if(!vacia()){
            Nodo nodoAnterior = (Nodo)buscarAnterior(info).obtener(0);
            Nodo nodoBuscado = (Nodo)buscarAnterior(info).obtener(1);
            if(nodoBuscado == null){
                return null;
            } else {
                Object respaldo = nodoBuscado.getInfo();
                if(primero == ultimo){
                    primero = null;
                    ultimo = null;
                } else if(nodoBuscado == primero){
                    primero = primero.getApuntadorOtroNodo();
                } else if(nodoBuscado == ultimo){
                    nodoAnterior.setApuntadorOtroNodo(null);
                    ultimo = nodoAnterior;
                } else {
                    nodoAnterior.setApuntadorOtroNodo(nodoBuscado.getApuntadorOtroNodo());
                }
                return respaldo;
            }
        }
        return null;
    }

    /**
     * Indica si la lista actual es igual a la lista que mandamos como parámetro.
     * @param lista2 Lista que verificaremos si es igual a la actual.
     * @return Regresa <b>true</b> si son iguales o <b>false</b> si no lo son.
     */
    @Override
    public boolean esIgual(Object lista2) {
        if(lista2 instanceof ListaDinamica){
            if(contarValores() == ((ListaDinamica) lista2).contarValores()){
                inicializarIterador();
                ((ListaDinamica) lista2).inicializarIterador();
                Nodo otroNodoActual = ((ListaDinamica) lista2).nodoActual;
                while (nodoActual != null){
                    if((int)Comparador.comparar(nodoActual, otroNodoActual) == 0){
                        nodoActual = nodoActual.getApuntadorOtroNodo();
                        otroNodoActual = otroNodoActual.getApuntadorOtroNodo();
                    } else {
                        return false;
                    }
                }
                return true;
            } else{
                return false;
            }
        } else if( lista2 instanceof ListaEstatica){
            if(contarValores() == ((ListaEstatica) lista2).getTope()+1){
                int cadaIndice = 0;
                inicializarIterador();
                while (nodoActual != null){
                    if((int)Comparador.comparar(nodoActual, ((ListaEstatica) lista2).obtener(cadaIndice)) == 0){
                        nodoActual = nodoActual.getApuntadorOtroNodo();
                        cadaIndice++;
                    } else {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * Cuenta los valores que existe en la lista.
     * @return Regresa el valor de números que existe en la lista.
     */
    public int contarValores(){
        int contador = 0;
        inicializarIterador();
        while (nodoActual != null){
            contador++;
            nodoActual = nodoActual.getApuntadorOtroNodo();
        }
        return contador;
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
        int veces = 0;
        inicializarIterador();
        while (nodoActual != null && veces < numVeces){
            if((int) Comparador.comparar(nodoActual.getInfo(), infoViejo) == 0){
                nodoActual.setInfo(infoNuevo);
                veces++;
            }
            nodoActual = nodoActual.getApuntadorOtroNodo();
        }
        return true;
    }

    /**
     * Cambia la información en la posición que se indique.
     * @param indice Posición en la que se debe de cambiar la info.
     * @param info Información por cambiar.
     * @return Regresa <b>true</b> si se cambió o <b>false</b> si no se cambio nada.
     */
    public boolean cambiar(int indice, Object info){
        int cadaIndice = 0;
        inicializarIterador();
        while (nodoActual != null){
            if(cadaIndice == indice){
                nodoActual.setInfo(info);
                return true;
            }
            cadaIndice++;
            nodoActual = nodoActual.getApuntadorOtroNodo();
        }
        return false;
    }

    /**
     * Busca dentro de un arreglo los elementos dados por info.
     * @param info Es el valor que se buscara en la lista actual.
     * @return Regresa una lista con las posiciones en las que se encuentra la información que estamos buscando.
     */
    @Override
    public ListaEstatica buscarValores(Object info) {
        ListaEstatica lista = new ListaEstatica(contarValores());
        int cadaValor = 0;
        inicializarIterador();
        while (nodoActual != null){
            if((int) Comparador.comparar(info, nodoActual.getInfo()) == 0){
                lista.agregar(cadaValor);
            }
            nodoActual = nodoActual.getApuntadorOtroNodo();
            cadaValor++;
        }
        return lista;
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

    /**
     * Elimina el objeto que se encuentre en inicio.
     * @return Regresa el objeto eliminado.
     */
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
        primero = null;
        ultimo = null;
        nodoActual = null;
    }

    /**
     * Añade la lista 2 a la lista actual al final de esta.
     *
     * @param listaDatos Es la lista de la cual añadiremos a la lista actual.
     * @return Regresa <b>true</b> si se añadió la lista o <b>false</b> si no se añadió.
     */
    @Override
    public boolean agregarLista(Object listaDatos) {
        if(listaDatos instanceof ListaEstatica lista2){
            for(int cadaIndice = 0; cadaIndice <= lista2.getTope(); cadaIndice++){
                agregar(lista2.obtener(cadaIndice));
            }
            return true;
        } else if(listaDatos instanceof ListaDinamica lista2){
            lista2.inicializarIterador();
            while (lista2.nodoActual != null){
                agregar(lista2.nodoActual.getInfo());
                lista2.nodoActual = lista2.nodoActual.getApuntadorOtroNodo();
            }
            return true;
        }
        return false;
    }

    /**
     * Invierte el orden de los elementos de la lista actual.
     */
    @Override
    public void invertir() {
        ListaDinamica auxiliar = (ListaDinamica) clonar();
        vaciar();
        while (auxiliar.primero != null){
            agregar(auxiliar.eliminar());
        }
    }

    /**
     * Cuenta los elementos que hagan sean iguales a la información proporcionada.
     *
     * @param info Es el elemento que queremos contar dentro del arreglo.
     * @return Regresa el número de veces que se repite la información proporcionada.
     */
    @Override
    public int contar(Object info) {
        int contador = 0;
        inicializarIterador();
        while (nodoActual != null){
            if(nodoActual.getInfo() == info){
                contador++;
            }
            nodoActual = nodoActual.getApuntadorOtroNodo();
        }
        return contador;
    }

    /**
     * Eliminar todos los elementos de la lista dos que se encuentren en la lista actual.
     *
     * @param lista2 Es la lista de la que se borraran los elementos que se encuentren en la lista actual.
     */
    @Override
    public void eliminarLista(Object lista2) {
        if (lista2 instanceof ListaDinamica) {
            ListaDinamica listaDinamica = (ListaDinamica) lista2;
            listaDinamica.inicializarIterador();
            while (listaDinamica.nodoActual != null) {
                eliminarObjeto(listaDinamica.nodoActual.getInfo());
                listaDinamica.nodoActual = listaDinamica.nodoActual.getApuntadorOtroNodo();
            }
        } else if (lista2 instanceof ListaEstatica) {
            for (int cadaPos = 0; cadaPos <= ((ListaEstatica) lista2).getTope(); cadaPos++) {
                eliminarObjeto(((ListaEstatica) lista2).obtener(cadaPos));
            }
        }
    }

    /**
     * Rellena todos los espacios dados por cantidad con el valor de información.
     *
     * @param info     Es el valor que insertaremos en los espacios.
     * @param cantidad Es la cantidad de espacios que insertaremos la nueva información.
     */
    @Override
    public void rellenar(Object info, int cantidad) {
        for(int cadaCantidad = 0; cadaCantidad < cantidad; cadaCantidad++){
            agregar(info);
        }
    }

    /**
     * Clona la lista actual de manera exacta.
     *
     * @return Regresa una copia exacta de la lista actual.
     */
    @Override
    public Lista clonar() {
        ListaDinamica lista = new ListaDinamica();
        inicializarIterador();
        while(nodoActual != null){
            lista.agregar(nodoActual.getInfo());
            nodoActual = nodoActual.getApuntadorOtroNodo();
        }
        return lista;
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
        ListaDinamica lista = new ListaDinamica();
        inicializarIterador();
        int cadaPos = 0;
        while (nodoActual != null && cadaPos < indiceInicial){
            nodoActual = nodoActual.getApuntadorOtroNodo();
            cadaPos++;
        }
        while (nodoActual != null && cadaPos <= indiceFinal){
            lista.agregar(nodoActual.getInfo());
            nodoActual = nodoActual.getApuntadorOtroNodo();
            cadaPos++;
        }
        return lista;
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
        ListaEstatica lista = new ListaEstatica(listaIndices.getMAXIMO());
        for(int cadaIndice = 0; cadaIndice <= listaIndices.getTope(); cadaIndice++){
            inicializarIterador();
            int indice = 0;
            while(nodoActual != null){
                if((int) Comparador.comparar(listaIndices.obtener(cadaIndice), indice) == 0){
                    lista.agregar(obtener(indice));
                }
                indice++;
                nodoActual = nodoActual.getApuntadorOtroNodo();
            }
        }
        return lista;
    }

    /**
     * Obtiene la información del último nodo.
     * @return Regresa la información del último nodo.
     */
    @Override
    public Object verUltimo() {
        return ultimo.getInfo();
    }

    /**
     * Inicializa el nodo actual para poder hacer ciclos.
     */
    public void inicializarIterador(){
        nodoActual = primero;
    }

    /**
     * Ayuda a saber si hay algún nodo.
     * @return Regresa true si hay nodo o false si no lo hay.
     */
    public boolean hayNodo(){
        return nodoActual != null;
    }

    /**
     * Obtiene el nodo.
     * @return Regresa el nodo.
     */
    public Object obtenerNodo(){
        if(hayNodo()){
            Object respaldo = nodoActual.getInfo();
            nodoActual = nodoActual.getApuntadorOtroNodo();
            return respaldo;
        }
        return null;
    }

    /**
     * Busca el nodo anterior al nodo que se quiere buscar.
     * @param info Información que se quiere buscar en el nodo.
     * @return Regresa una lista con el nodo anterior y el nodo con la información que se busca.
     */
    public ListaEstatica buscarAnterior(Object info){
        ListaEstatica lista = new ListaEstatica(2);
        Nodo nodoAnterior = primero;
        Nodo nodoBuscar = primero;
        while (nodoBuscar != null && !(info.toString().equalsIgnoreCase(nodoBuscar.getInfo().toString()))){
            nodoAnterior = nodoBuscar;
            nodoBuscar = nodoBuscar.getApuntadorOtroNodo();
        }
        if (nodoBuscar != null){
            lista.agregar(nodoAnterior);
            lista.agregar(nodoBuscar);
        } else {
            lista.agregar(null);
            lista.agregar(null);
        }
        return lista;
    }

    /**
     * Convierte la lista dinámica en una estática y regresa la lista estática.
     * @return Son los valores de la lista actual pero en una lista estática.
     */
    public ListaEstatica aListaEstatica(){
        inicializarIterador();
        ListaEstatica lista = new ListaEstatica(1);
        int contador = 0;
        while (nodoActual != null){
            contador++;
            lista.redimensionar(contador);
            lista.agregar(nodoActual.getInfo());
            nodoActual = nodoActual.getApuntadorOtroNodo();
        }
        return lista;
    }

    /**
     * Convierte la lista dinámica en una estática y borra los valores que estén en la lista parámetro.
     * @param elementosADescartar Lista con elementos a descartar.
     * @return Regresa la lista estática.
     */
    public ListaEstatica aListaEstatica(ListaEstatica elementosADescartar){
        ListaEstatica valores = aListaEstatica();
        valores.eliminarLista(elementosADescartar);
        return valores;
    }

    /**
     * Crea una matriz bidimensional con los valores que tiene la lista actual y los demás espacios los rellena con null.
     * @param filas Número de filas de la matriz.
     * @param columnas Número de columnas de la matriz.
     * @return Regresa la matriz con los valores de la lista actual.
     */
    public Matriz2 aMatriz2(int filas, int columnas){
        Matriz2 matriz = new Matriz2(filas, columnas, null);
        int cadaCol = 0;
        int cadaFila = 0;
        inicializarIterador();
        while (nodoActual != null){
            if(cadaFila == filas){
                cadaFila = 0;
                cadaCol++;
                matriz.cambiar(cadaFila, cadaCol, nodoActual.getInfo());
            } else {
                matriz.cambiar(cadaFila, cadaCol, nodoActual.getInfo());
            }
            nodoActual = nodoActual.getApuntadorOtroNodo();
            cadaFila++;
        }
        return matriz;
    }

    /**
     * Agrega los elementos de matriz bidimensional a la lista.
     * @param tabla Es la matriz bidimensional la cual se agregará a la lista.
     * @param tipoTabla Tipo de tabla de como se agregará a la lista.
     * @return Regresa true si se agregaron o false si no se agregaron.
     */
    public boolean agregarMatriz2D(Matriz2 tabla, TipoTabla tipoTabla){
        if (tipoTabla==TipoTabla.COLUMNA){
            for (int cadaColumna=0;cadaColumna<tabla.getColumnas();cadaColumna++){
                for (int cadaRenglon=0;cadaRenglon<tabla.getRenglones();cadaRenglon++){
                    agregar(tabla.obtener(cadaRenglon,cadaColumna));
                }
            }
            return true;
        }else if(tipoTabla==TipoTabla.RENGLON){
            for (int cadaRenglon=0;cadaRenglon<tabla.getRenglones();cadaRenglon++){
                for (int cadaColumna=0;cadaColumna<tabla.getRenglones();cadaColumna++){
                    agregar(tabla.obtener(cadaRenglon,cadaColumna));
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Redimensiona la lista, si es un valor menor, dejará los valores de la lista hasta que
     * lleguen a máximo, si es un valor mayor, agregará la lista los valores que faltan con null.
     * @param maximo Valor con el cual se redimensionará la lista.
     */
    public void redimensionar(int maximo){
        if(contarValores() < maximo){
            int cuantosNull = maximo - contarValores();
            for(int cadaValor = 0; cadaValor < cuantosNull; cadaValor++){
                agregar(null);
            }
        } else if(contarValores() > maximo){
            int cuantosBorrar = contarValores() - maximo;
            for(int cadaValor = 0; cadaValor < cuantosBorrar; cadaValor++){
                eliminar();
            }
        }
    }

    public void imprimirRecursivo(){
        imprimirRecursivo(primero);
    }

    private void imprimirRecursivo(Nodo cadaNodo){
        SalidaPorDefecto.terminal(cadaNodo.getInfo() + " -> ");
        if(cadaNodo != null){
            imprimirRecursivo(cadaNodo.getApuntadorOtroNodo());
        }
    }

}
