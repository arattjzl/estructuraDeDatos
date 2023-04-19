package estructurasLineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.auxiliares.NodoClave;
import estructurasNoLineales.Matriz2;
import utils.commons.Comparador;

public class ListaDinamicaClave {
    public NodoClave primero;
    public NodoClave ultimo;
    public NodoClave nodoActual;

    public ListaDinamicaClave(){
        primero = null;
        ultimo = null;
    }

    /**
     * Este método regresa un indicador de sí la list está vacía.
     * @return regresa <b>true</b> si está vacía, <b>false</b> en caso contrario
     */
    public boolean vacia() {
        return primero == null;
    }

    /**
     * Inserta datos al final de la lista donde se permite que la lista tenga información duplicada,
     * pero no claves duplicadas, si la clave está duplicada, se cambiará la información de la clave anterior
     * con la información nueva.
     * @param clave Es el identificador único.
     * @param info Es la información por agregar.
     * @return Regresa <b>true</b> si se pudo agregar o <b>false</b> si no se pudo.
     */
    public boolean agregar(Object clave, Object info){
        NodoClave nuevoNodo = new NodoClave(clave, info);
        if (nuevoNodo != null){
            if(vacia()){
                primero = nuevoNodo;
            } else {
                Object claveBuscada = buscar(clave);
                if (claveBuscada != null){
                    inicializarIterado();
                    while (hayNodo()){
                        if ((int) Comparador.comparar(clave, nodoActual.getClave()) == 0){
                            nodoActual.setValor(info);
                            return true;
                        } else {
                            nodoActual = nodoActual.getLigaDer();
                        }
                    }
                }
                ultimo.setLigaDer(nuevoNodo);
            }
            ultimo = nuevoNodo;
            return true;
        }
        return false;
    }

    /**
     * Utiliza el campo de clave para borrar el elemento.
     * @param clave Es el campo clave del nodo que se eliminará.
     * @return Regresa el contenido real del campo o null si no se localiza el valor.
     */
    public Object eliminar(Object clave){
        Object buscado = buscar(clave);
        if(buscado != null){
            inicializarIterado();
            while(hayNodo()){
                if((int)Comparador.comparar(clave, nodoActual.getClave()) == 0){
                    Object eliminado = nodoActual.getValor();
                    if(nodoActual == primero){
                        primero = primero.getLigaDer();
                    } else if(nodoActual == ultimo){
                        ultimo = (NodoClave) buscarAnterior(nodoActual.getValor()).obtener(0);
                        ultimo.setLigaDer(null);
                    } else{
                        NodoClave nodoAnterior = (NodoClave) buscarAnterior(nodoActual.getValor()).obtener(0);
                        nodoAnterior.setLigaDer(nodoActual.getLigaDer());
                    }
                    return eliminado;
                }
                nodoActual = nodoActual.getLigaDer();
            }
        }
        return null;
    }

    /**
     * Se usa el campo de valor o info para borrar el elemento
     * @param info Es el valor o info del nodo que se eliminará.
     * @return Regresa el contenido real del campo o null si no se localiza el valor.
     */
    public Object eliminarContenido(Object info){
        Object buscado = buscarObjeto(info);
        if(buscado != null){
            inicializarIterado();
            while(hayNodo()){
                if((int)Comparador.comparar(info, nodoActual.getValor()) == 0){
                    Object eliminado = nodoActual.getValor();
                    if(nodoActual == primero){
                        primero = primero.getLigaDer();
                    } else if(nodoActual == ultimo){
                        ultimo = (NodoClave) buscarAnterior(nodoActual.getValor()).obtener(0);
                        ultimo.setLigaDer(null);
                    } else {
                        NodoClave nodoAnterior = (NodoClave) buscarAnterior(nodoActual.getValor()).obtener(0);
                        nodoAnterior.setLigaDer(nodoActual.getLigaDer());
                    }
                    return eliminado;
                }
                nodoActual = nodoActual.getLigaDer();
            }
        }
        return null;
    }

    /**
     * Busca un elemento ubicado por su clave.
     * @param clave Es el campo clave del nodo que se buscará.
     * @return Regresa el contenido en caso de que se encuentre, null en caso contrario.
     */
    public Object buscar(Object clave){
        inicializarIterado();
        while (hayNodo()){
            if((int) Comparador.comparar(clave, nodoActual.getClave()) == 0){
                return nodoActual.getValor();
            } else {
               nodoActual = nodoActual.getLigaDer();
            }
        }
        return null;
    }

    /**
     * Busca un elemento ubicado por su contenido.
     * @param info Es el valor o info del nodo que se buscará.
     * @return Regresa el contenido en caso de que se encuentre, null en caso contrario.
     */
    public Object buscarObjeto(Object info){
        inicializarIterado();
        while (hayNodo()){
            if((int) Comparador.comparar(info, nodoActual.getValor()) == 0){
                return nodoActual.getValor();
            } else {
                nodoActual = nodoActual.getLigaDer();
            }
        }
        return null;
    }

    /**
     * Substituye un elemento de la lista localizado mediante la clave por el nuevo valor.
     * @param clave Clave a localizar.
     * @param info Info nueva que se cambiará.
     * @return Regresa <b>true</b> si se pudo cambiar o <b>false</b> si no se pudo.
     */
    public boolean cambiar(Object clave, Object info){
        Object buscado = buscar(clave);
        if(buscado != null){
            inicializarIterado();
            while (hayNodo()){
                if((int)Comparador.comparar(clave, nodoActual.getClave()) == 0){
                    nodoActual.setValor(info);
                    return true;
                }
                nodoActual = nodoActual.getLigaDer();
            }
        }
        return false;
    }

    /**
     * Substituye un elemento de la lista localizado mediante el valor por el nuevo contenido.
     * @param infoVieja Es la información vieja que se cambiará.
     * @param infoNueva Es la información nueva que se cambiará.
     * @return Regresa <b>true</b> si se pudo cambiar o <b>false</b> si no se pudo.
     */
    public boolean cambiarValor(Object infoVieja, Object infoNueva){
        Object buscado = buscarObjeto(infoVieja);
        if (buscado != null){
            inicializarIterado();
            while (hayNodo()){
                if((int)Comparador.comparar(infoVieja, nodoActual.getValor()) == 0){
                    nodoActual.setValor(infoNueva);
                    return true;
                }
                nodoActual = nodoActual.getLigaDer();
            }
        }
        return false;
    }

    /**
     * Imprime la lista completa.
     */
    public void imprimir(){
        inicializarIterado();
        while (hayNodo()){
            SalidaPorDefecto.terminal("[ " + nodoActual.getClave() + " ]-[ " + nodoActual.getValor() + " ] -> ");
            nodoActual = nodoActual.getLigaDer();
        }
        SalidaPorDefecto.terminal(null);
    }

    /**
     * Imprime las claves de la lista.
     */
    public void imprimirClaves(){
        inicializarIterado();
        while (hayNodo()){
            SalidaPorDefecto.terminal("[ " + nodoActual.getClave() + " ] -> ");
            nodoActual = nodoActual.getLigaDer();
        }
        SalidaPorDefecto.terminal(null);
    }

    /**
     * Imprime los valores de la lista.
     */
    public void imprimirValores(){
        inicializarIterado();
        while (hayNodo()){
            SalidaPorDefecto.terminal("[ " + nodoActual.getValor() + " ] -> ");
            nodoActual = nodoActual.getLigaDer();
        }
        SalidaPorDefecto.terminal(null);
    }

    /**
     * Regresa la lista actual como una lista que contiene dos arreglos, un arreglo es la lista de claves, y el otro es un arreglo que tiene la lista de contenidos.
     * @return Regresa una lista estática con otras listas, una de claves y otra de valores.
     */
    public ListaEstatica aListasEstaticas(){
        int redimension = 1;
        ListaEstatica listaCompleta = new ListaEstatica(2);
        ListaEstatica listaClaves = new ListaEstatica(redimension);
        ListaEstatica listaValores = new ListaEstatica(redimension);
        inicializarIterado();
        while (hayNodo()){
            listaClaves.agregar(nodoActual.getClave());
            listaValores.agregar(nodoActual.getValor());
            nodoActual = nodoActual.getLigaDer();
            listaCompleta.redimensionar(redimension++);
            listaClaves.redimensionar(redimension++);
            listaValores.redimensionar(redimension++);
        }
        listaCompleta.agregar(listaClaves);
        listaCompleta.agregar(listaValores);
        return listaCompleta;
    }

    /**
     * Regresa la lista actual como una lista que contiene dos listas ligadas, un de estas es de claves, y la otra es de contenidos.
     * @return Regresa una lista dinámica con dos listas ligadas, una de claves y otra de valores.
     */
    public ListaDinamica aListasDinamicas(){
        ListaDinamica listaCompleta = new ListaDinamica();
        ListaDinamica listaClaves = new ListaDinamica();
        ListaDinamica listaValores = new ListaDinamica();
        inicializarIterado();
        while (hayNodo()){
            listaClaves.agregar(nodoActual.getClave());
            listaValores.agregar(nodoActual.getValor());
            nodoActual = nodoActual.getLigaDer();
        }
        listaCompleta.agregar(listaClaves);
        listaCompleta.agregar(listaValores);
        return listaCompleta;
    }

    /**
     * Crea una matriz bidimensional y guarda las calves y valores en ella.
     * @return Regresa la matriz bidimensional.
     */
    public Matriz2 aMatriz2(){
        int conteo = numElementos();
        int cadaReng = 0;
        Matriz2 matriz = new Matriz2(conteo, 2);
        inicializarIterado();
        while (hayNodo()){
            matriz.cambiar(cadaReng, 0, nodoActual.getClave());
            matriz.cambiar(cadaReng, 1, nodoActual.getValor());
            cadaReng++;
            nodoActual = nodoActual.getLigaDer();
        }
        return matriz;
    }

    /**
     * Obtiene el valor de la clave especificada
     * @param clave Es el valor de la clave a obtener.
     * @return Regresa el valor de la info que concuerda con la clave.
     */
    public Object obtener(Object clave){
        inicializarIterado();
        Object temporal = null;
        while (hayNodo()){
            if((int) Comparador.comparar(clave, nodoActual.getClave()) == 0){
                temporal = nodoActual.getValor();
            }
            nodoActual = nodoActual.getLigaDer();
        }
        return temporal;
    }

    /**
     * Vacía la lista.
     */
    public void vaciar(){
        primero = null;
        ultimo = null;
    }

    /**
     * Agrega todos los elementos de la lista pasada como argumento a la lista actual.
     * @param lista Es la lista que contiene otros valores con su clave.
     * @return Regresa <b>true</b> si se agregaron o <b>false</b> si no.
     */
    public boolean agregarLista(ListaDinamicaClave lista){
        if(!lista.vacia()){
            lista.inicializarIterado();
            while (lista.hayNodo()){
                agregar(lista.nodoActual.getClave(), lista.nodoActual.getValor());
                lista.nodoActual = lista.nodoActual.getLigaDer();
            }
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Cuenta el número de nodos que hay en la lista.
     * @return Regresa el tamaño de la lista.
     */
    public int numElementos(){
        int contador = 0;
        inicializarIterado();
        while (hayNodo()){
            contador++;
            nodoActual = nodoActual.getLigaDer();
        }
        return contador;
    }

    /**
     * Agrega todos los elementos del arreglo pasado como argumento, donde hay arreglos paralelos de claves y valores respectivamente.
     * @param arregloClaves Arreglo que contiene las claves.
     * @param arregloValores Arreglo que contiene los valores.
     * @return Regresa <b>true</b> si se agregaron o <b>false</b> si no.
     */
    public boolean agregarListasEstaticas(ListaEstatica arregloClaves, ListaEstatica arregloValores){
        if((int) Comparador.comparar(arregloClaves.getMAXIMO(), arregloValores.getMAXIMO()) == 0){
            if(!arregloClaves.vacia() && !arregloValores.vacia()){
                for(int cadaClaveValor = 0; cadaClaveValor < arregloClaves.getMAXIMO(); cadaClaveValor++){
                    Object clave = arregloClaves.obtener(cadaClaveValor);
                    Object valor = arregloValores.obtener(cadaClaveValor);
                    agregar(clave, valor);
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Agrega todos los elementos de la lista pasada como argumento, donde hay listas paralelas de claves y valores respectivamente.
     * @param listaClaves Lista que contiene las claves.
     * @param listaValores Lista que contiene los valores.
     * @return Regresa <b>true</b> si se agregaron o <b>false</b> si no.
     */
    public boolean agregarListasDinamicas(ListaDinamica listaClaves, ListaDinamica listaValores){
        if((int) Comparador.comparar(listaClaves.contarValores(), listaValores.contarValores()) == 0){
            if(!listaClaves.vacia() && !listaValores.vacia()){
                listaClaves.inicializarIterador();
                listaValores.inicializarIterador();
                while (listaClaves.hayNodo() && listaValores.hayNodo()){
                    Object clave = listaClaves.obtenerNodo();
                    Object valor = listaValores.obtenerNodo();
                    agregar(clave, valor);
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Agrega todos los elementos de la matriz pasada como argumento, donde la primera columna tiene las claves y la segunda columna tiene los valores.
     * @param matriz Es la matriz que tiene las claves y valores.
     * @return Regresa <b>true</b> si se agregaron o <b>false</b> si no.
     */
    public boolean agregarMatriz2(Matriz2 matriz){
        if ((int) Comparador.comparar(matriz.getColumnas(), 2) == 0){
            for(int cadaReng = 0; cadaReng < matriz.getRenglones(); cadaReng++){
                Object clave = matriz.obtener(cadaReng, 0);
                Object valor = matriz.obtener(cadaReng, 1);
                agregar(clave, valor);
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Inicializa el nodo actual para poder hacer ciclos.
     */
    public void inicializarIterado(){
        nodoActual = primero;
    }

    /**
     * Ayuda a saber si hay algún nodo.
     * @return Regresa <b>true</b> si hay nodo o <b>false</b> si no lo hay.
     */
    public boolean hayNodo(){
        return nodoActual != null;
    }

    /**
     * Busca el nodo anterior al nodo que se quiere buscar.
     * @param info Información que se quiere buscar en el nodo.
     * @return Regresa una lista con el nodo anterior y el nodo con la información que se busca.
     */
    public ListaEstatica buscarAnterior(Object info){
        ListaEstatica lista = new ListaEstatica(2);
        NodoClave nodoAnterior = primero;
        NodoClave nodoBuscar = primero;
        while (nodoBuscar != null && !(info.toString().equalsIgnoreCase(nodoBuscar.getValor().toString()))){
            nodoAnterior = nodoBuscar;
            nodoBuscar = nodoBuscar.getLigaDer();
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
}
