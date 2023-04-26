package estructurasLineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.auxiliares.Nodo;
import estructurasLineales.auxiliares.NodoDoble;
import utils.commons.Comparador;

/**
 * Clase para el TDA Lista dinámica doble paralela.
 * @author Aratt
 * @version 1.0
 */

public class ListaDinamicaDobleParalela {

    protected NodoDoble inicio;
    protected NodoDoble finArriba;
    protected NodoDoble finAbajo;
    protected NodoDoble nodoActual;
    protected int numNodo;

    public ListaDinamicaDobleParalela(){
        inicio = null;
        finArriba = null;
        finAbajo = null;
        numNodo = 0;
    }

    public NodoDoble getInicio() {
        return inicio;
    }

    public void setInicio(NodoDoble inicio) {
        this.inicio = inicio;
    }

    public NodoDoble getFinArriba() {
        return finArriba;
    }

    public void setFinArriba(NodoDoble finArriba) {
        this.finArriba = finArriba;
    }

    public NodoDoble getFinAbajo() {
        return finAbajo;
    }

    public void setFinAbajo(NodoDoble finAbajo) {
        this.finAbajo = finAbajo;
    }

    public NodoDoble getNodoActual() {
        return nodoActual;
    }

    public void setNodoActual(NodoDoble nodoActual) {
        this.nodoActual = nodoActual;
    }

    public int getNumNodo() {
        return numNodo;
    }

    public void setNumNodo(int numNodo) {
        this.numNodo = numNodo;
    }

    /**
     * Checa si la lista está vacía.
     * @return Regresa true si está vacía o false si no.
     */
    public boolean vacia() {
        return inicio==null;
    }

    /**
     * Agrega valores a la lista.
     * @param info Información por agregar.
     * @return Regresa 1 si se agregó o -1 si no se agregó.
     */
    public int agregar(Object info){
        NodoDoble nuevoNodo = new NodoDoble(info);
        if(nuevoNodo != null){
            numNodo++;
            if(vacia()){
                inicio = nuevoNodo;
                finArriba = nuevoNodo;
            } else {
                if(numNodo % 2 != 0){
                    finArriba.setApuntadorADerecha(nuevoNodo);
                    finArriba = nuevoNodo;
                } else {
                    if(numNodo == 2){
                        finAbajo = nuevoNodo;
                    } else {
                        finAbajo.setApuntadorADerecha(nuevoNodo);
                    }
                    nuevoNodo.setApuntadorAIzquierda(finArriba);
                    finArriba.setApuntadorAIzquierda(nuevoNodo);
                    finAbajo = nuevoNodo;
                }
            }
            return 1;
        }
        return -1;
    }

    /**
     * Imprime la lista.
     */
    public void imprimir(){
        inicializarIterador();
        while(nodoActual != null){
            SalidaPorDefecto.terminal(nodoActual.getInfo() + " -> ");
            nodoActual = nodoActual.getApuntadorADerecha();
        }
        SalidaPorDefecto.terminal(null + "\n");
        inicializarIterador();
        nodoActual = nodoActual.getApuntadorAIzquierda();
        while(nodoActual != null){
            SalidaPorDefecto.terminal(nodoActual.getInfo() + " -> ");
            nodoActual = nodoActual.getApuntadorADerecha();
        }
        SalidaPorDefecto.terminal(null + "\n");
    }

    /**
     * Elimina un valor de la lista.
     * @param info Información por eliminar.
     * @return Regresa la información que se eliminó.
     */
    public Object eliminar(Object info){
        ListaDinamica listaAuxiliar = new ListaDinamica();
        Object respaldo = null;
        inicializarIterador();
        int contador = 0;
        while(nodoActual != null){
            contador++;
            if(contador % 2 != 0){
                if((int) Comparador.comparar(info, nodoActual.getInfo()) != 0){
                    listaAuxiliar.agregar(nodoActual.getInfo());
                } else {
                    respaldo = nodoActual.getInfo();
                }
                nodoActual = nodoActual.getApuntadorAIzquierda();
            } else {
                if((int) Comparador.comparar(info, nodoActual.getInfo()) != 0){
                    listaAuxiliar.agregar(nodoActual.getInfo());
                } else {
                    respaldo = nodoActual.getInfo();
                }
                nodoActual = nodoActual.getApuntadorAIzquierda();
                nodoActual = nodoActual.getApuntadorADerecha();
            }
        }
        vaciar();
        listaAuxiliar.inicializarIterador();
        while(listaAuxiliar.hayNodo()){
            Object cadaInfo = listaAuxiliar.obtenerNodo();
            agregar(cadaInfo);
        }
        return respaldo;
    }

    /**
     * Elimina el último valor de la lista.
     * @return Regresa el la información que se eliminó.
     */
    public Object eliminarUltimo(){
        NodoDoble anterior = (NodoDoble) buscarAnteriorArriba(finArriba.getInfo()).obtener(0);
        Object respaldo = null;
        if(finArriba.getApuntadorAIzquierda() == null){
            respaldo = finArriba.getInfo();
            anterior.setApuntadorADerecha(null);
        } else {
            respaldo = finAbajo.getInfo();
            NodoDoble anteriorAbajo = ((NodoDoble) buscarAnteriorArriba(finArriba.getInfo()).obtener(0)).getApuntadorAIzquierda();
            anteriorAbajo.setApuntadorADerecha(null);
            finArriba.setApuntadorAIzquierda(null);
        }
        return respaldo;
    }

    /**
     * Regresa el nodo anterior del que se indica.
     * @param info Información con la cual buscará el nodo anterior.
     * @return Regresa una lista con el nodo anterior al que se busca y el nodo que se busca.
     */
    public ListaEstatica buscarAnteriorArriba(Object info){
        ListaEstatica lista = new ListaEstatica(2);
        NodoDoble nodoAnterior = inicio;
        NodoDoble nodoBuscar = inicio;
        while (nodoBuscar != null && !(info.toString().equalsIgnoreCase(nodoBuscar.getInfo().toString()))){
            nodoAnterior = nodoBuscar;
            nodoBuscar = nodoBuscar.getApuntadorADerecha();
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
     * Busca la información que indiquemos.
     * @param info Información por buscar.
     * @return Regresa la información si se encontró o null si no.
     */
    public Object buscar(Object info){
        inicializarIterador();
        int contador = 0;
        while(nodoActual != null){
            contador++;
            if(contador % 2 != 0){
                if((int) Comparador.comparar(info, nodoActual.getInfo()) == 0){
                    return info;
                }
                nodoActual = nodoActual.getApuntadorAIzquierda();
            } else {
                if((int) Comparador.comparar(info, nodoActual.getInfo()) == 0){
                    return info;
                }
                nodoActual = nodoActual.getApuntadorAIzquierda();
                nodoActual = nodoActual.getApuntadorADerecha();
            }
        }
        return null;
    }

    /**
     * Vacía la lista.
     */
    public void vaciar(){
        inicio = null;
        finArriba = null;
        finAbajo = null;
        numNodo = 0;
    }

    /**
     * Inicializa el iterador para poder recorrer la lista.
     */
    public void inicializarIterador(){
        nodoActual = inicio;
    }
}
