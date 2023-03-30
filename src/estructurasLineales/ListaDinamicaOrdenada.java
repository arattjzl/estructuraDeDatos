package estructurasLineales;

import estructurasLineales.auxiliares.Nodo;
import estructurasNoLineales.Matriz2;
import utils.commons.Comparador;
import utils.commons.TipoOrden;

/**
 * Esta clase contiene los métodos para el TDA Lista dinámica ordenada.
 * @author Aratt
 * @version 1.0
 */
public class ListaDinamicaOrdenada extends ListaDinamica {
    public TipoOrden tipoOrden;
    public ListaDinamicaOrdenada(TipoOrden tipoOrden){
        super();
        this.tipoOrden = tipoOrden;
    }

    public TipoOrden getTipoOrden() {
        return tipoOrden;
    }

    public void setTipoOrden(TipoOrden tipoOrden) {
        this.tipoOrden = tipoOrden;
    }

    @Override
    public int agregar(Object info){
        Nodo nuevoNodo = new Nodo(info);
        if (nuevoNodo != null) {
            if (vacia()) {
                primero = nuevoNodo;
                ultimo = nuevoNodo;
            } else if(primero == ultimo){
                if(tipoOrden == TipoOrden.INC) {
                    if ((int) Comparador.comparar(info, primero.getInfo())>0) {
                        primero.setApuntadorOtroNodo(nuevoNodo);
                        ultimo = nuevoNodo;
                    }
                    if ((int) Comparador.comparar(info, primero.getInfo())<0) {
                        Nodo respaldo = ultimo;
                        primero = nuevoNodo;
                        nuevoNodo.setApuntadorOtroNodo(respaldo);
                    }
                }
                if(tipoOrden == TipoOrden.DEC) {
                    if ((int) Comparador.comparar(info, primero.getInfo())>0) {
                        Nodo respaldo = ultimo;
                        primero = nuevoNodo;
                        nuevoNodo.setApuntadorOtroNodo(respaldo);
                    }
                    if ((int) Comparador.comparar(info, primero.getInfo())<0) {
                        primero.setApuntadorOtroNodo(nuevoNodo);
                        ultimo = nuevoNodo;
                    }
                }
            }else {
                inicializarIterador();
                if(tipoOrden == TipoOrden.INC){
                    while(nodoActual.getApuntadorOtroNodo()!=null && (int)Comparador.comparar(info, nodoActual.getInfo())>0){
                        nodoActual = nodoActual.getApuntadorOtroNodo();
                    }
                    if((int)Comparador.comparar(info, nodoActual.getInfo())==0){
                        return -1;
                    }
                    if(nodoActual!=ultimo && nodoActual!=primero){
                        ListaEstatica listaDeBusqueda = buscarAnterior(nodoActual.getInfo());
                        Nodo anterior = (Nodo) listaDeBusqueda.obtener(0);
                        Nodo nodoBuscado = (Nodo) listaDeBusqueda.obtener(1);
                        anterior.setApuntadorOtroNodo(nuevoNodo);
                        nuevoNodo.setApuntadorOtroNodo(nodoBuscado);
                    } else if (nodoActual == primero) {
                        nuevoNodo.setApuntadorOtroNodo(nodoActual);
                        primero = nuevoNodo;
                    } else{
                        if((int)Comparador.comparar(nuevoNodo.getInfo(), ultimo.getInfo())<0){
                            ListaEstatica listaDeBusqueda = buscarAnterior(nodoActual.getInfo());
                            Nodo anterior = (Nodo) listaDeBusqueda.obtener(0);
                            Nodo nodoBuscado = (Nodo) listaDeBusqueda.obtener(1);
                            anterior.setApuntadorOtroNodo(nuevoNodo);
                            nuevoNodo.setApuntadorOtroNodo(nodoBuscado);
                            ultimo = nodoBuscado;
                        }else{
                            nodoActual.setApuntadorOtroNodo(nuevoNodo);
                            ultimo = nuevoNodo;
                        }
                    }
                }
                if(tipoOrden == TipoOrden.DEC){
                    while(nodoActual.getApuntadorOtroNodo()!=null && (int)Comparador.comparar(info, nodoActual.getInfo())<0){
                        nodoActual = nodoActual.getApuntadorOtroNodo();
                    }
                    if((int)Comparador.comparar(info, nodoActual.getInfo())==0){
                        return -1;
                    }
                    if(nodoActual!=ultimo && nodoActual!=primero){
                        ListaEstatica listaDeBusqueda = buscarAnterior(nodoActual.getInfo());
                        Nodo anterior = (Nodo) listaDeBusqueda.obtener(0);
                        Nodo nodoBuscado = (Nodo) listaDeBusqueda.obtener(1);
                        anterior.setApuntadorOtroNodo(nuevoNodo);
                        nuevoNodo.setApuntadorOtroNodo(nodoBuscado);
                    } else if (nodoActual == primero) {
                        nuevoNodo.setApuntadorOtroNodo(nodoActual);
                        primero = nuevoNodo;
                    } else{
                        if((int)Comparador.comparar(nuevoNodo.getInfo(), ultimo.getInfo())>0){
                            ListaEstatica listaDeBusqueda = buscarAnterior(nodoActual.getInfo());
                            Nodo anterior = (Nodo) listaDeBusqueda.obtener(0);
                            Nodo nodoBuscado = (Nodo) listaDeBusqueda.obtener(1);
                            anterior.setApuntadorOtroNodo(nuevoNodo);
                            nuevoNodo.setApuntadorOtroNodo(nodoBuscado);
                            ultimo = nodoBuscado;
                        }else{
                            nodoActual.setApuntadorOtroNodo(nuevoNodo);
                            ultimo = nuevoNodo;
                        }
                    }
                }
            }
            return 1;
        } else{
            return -1;
        }
    }

    /**
     * Elimina de la lista actual los valores que se encuentren en la matriz.
     * @param matriz Matriz con valores por eliminar.
     */
    public void eliminarMatriz(Matriz2 matriz){
        for(int cadaReng = 0; cadaReng < matriz.getRenglones(); cadaReng++){
            for(int cadacol = 0; cadacol < matriz.getColumnas(); cadacol++){
                Object info = matriz.obtener(cadaReng, cadacol);
                inicializarIterador();
                while(nodoActual != null){
                    if((int) Comparador.comparar(nodoActual.getInfo(), info)==0){
                        eliminarObjeto(info);
                    }
                    nodoActual = nodoActual.getApuntadorOtroNodo();
                }
            }
        }
    }
    @Override
    public void invertir(){
        if(tipoOrden == TipoOrden.DEC){
            setTipoOrden(TipoOrden.INC);
            super.invertir();

        } else if (tipoOrden == TipoOrden.INC){
            setTipoOrden(TipoOrden.DEC);
            super.invertir();
        }
    }

    @Override
    public boolean cambiar(Object infoViejo, Object infoNuevo, int numVeces){
        eliminarObjeto(infoViejo);
        agregar(infoNuevo);
        return true;
    }

    @Override
    public int agregarPrincipio(Object info){
        return agregar(info);
    }

    /**
     * Agregará al final de la lista, pero igualmente quedará en su espacio designado por el tipo de orden.
     * @param info Información por agreagr.
     * @return Regresa true si se agregaron o false si no se agregaron.
     */
    public int agregarFinal(Object info){
        return agregar(info);
    }

}
