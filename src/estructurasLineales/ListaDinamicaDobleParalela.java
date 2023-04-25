package estructurasLineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.auxiliares.Nodo;
import estructurasLineales.auxiliares.NodoDoble;
import utils.commons.Comparador;

public class ListaDinamicaDobleParalela {

    protected NodoDoble inicio;
    protected NodoDoble fin;
    protected NodoDoble nodoActual;
    protected int numNodo;

    public ListaDinamicaDobleParalela(){
        inicio = null;
        fin = null;
        numNodo = 0;
    }

    public NodoDoble getInicio() {
        return inicio;
    }

    public void setInicio(NodoDoble inicio) {
        this.inicio = inicio;
    }

    public NodoDoble getFin() {
        return fin;
    }

    public void setFin(NodoDoble fin) {
        this.fin = fin;
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

    public boolean vacia() {
        return inicio==null;
    }
    public int agregar(Object info){
        NodoDoble nuevoNodo = new NodoDoble(info);
        if(nuevoNodo!=null){
            numNodo++;
            if(vacia()){
                inicio = nuevoNodo;
            } else {
                if(numNodo % 2 != 0){
                    NodoDoble anterior = fin.getApuntadorAIzquierda();
                    anterior.setApuntadorADerecha(nuevoNodo);
                } else {
                    nuevoNodo.setApuntadorAIzquierda(fin);
                    fin.setApuntadorAIzquierda(nuevoNodo);
                }
            }
            fin = nuevoNodo;
            return 1;
        }
        return -1;
    }

    public void imprimir(){
        inicializarIterador();
        int contador = 0;
        while(nodoActual != null){
            contador++;
            if(contador % 2 != 0){
                SalidaPorDefecto.terminal(nodoActual.getInfo() + " -> ");
                nodoActual = nodoActual.getApuntadorAIzquierda();
            } else {
                SalidaPorDefecto.terminal(nodoActual.getInfo() + " -> ");
                nodoActual = nodoActual.getApuntadorAIzquierda();
                nodoActual = nodoActual.getApuntadorADerecha();
            }
        }
        SalidaPorDefecto.terminal(null);
    }

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

    public void vaciar(){
        inicio = null;
        fin = null;
        numNodo = 0;
    }
    public void inicializarIterador(){
        nodoActual = inicio;
    }
}
