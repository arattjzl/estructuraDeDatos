package estructurasLineales;

import estructurasLineales.auxiliares.Nodo;
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

    @Override
    public int agregar(Object info){
        Nodo nuevoNodo = new Nodo(info);
        if(nuevoNodo != null){
            if(vacia()){
                primero = nuevoNodo;
                ultimo = nuevoNodo;
            } else {
                if(tipoOrden == TipoOrden.INC){
                    inicializarIterador();
                    Nodo nodoAnterior = null;
                    while(nodoActual != null && (int)Comparador.comparar(info, nodoActual.getInfo()) > 0){
                        nodoAnterior = nodoActual;
                        nodoActual = nodoActual.getApuntadorOtroNodo();
                    }
                    if(nodoAnterior == null){
                        nuevoNodo.setApuntadorOtroNodo(primero);
                        primero = nuevoNodo;
                    } else {
                        nuevoNodo.setApuntadorOtroNodo(nodoActual);
                        nodoAnterior.setApuntadorOtroNodo(nuevoNodo);
                    }
                    return 1;
                } else if(tipoOrden == TipoOrden.DEC) {
                    inicializarIterador();
                    Nodo nodoAnterior = null;
                    while(nodoActual != null && (int)Comparador.comparar(info, nodoActual.getInfo()) < 0){
                        nodoAnterior = nodoActual;
                        nodoActual = nodoActual.getApuntadorOtroNodo();
                    }
                    if(nodoAnterior == null){
                        nuevoNodo.setApuntadorOtroNodo(primero);
                        primero = nuevoNodo;
                    } else {
                        nuevoNodo.setApuntadorOtroNodo(nodoActual);
                        nodoAnterior.setApuntadorOtroNodo(nuevoNodo);
                    }
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }

    @Override
    public Object buscar(Object info){
        return super.buscar(info);
    }

    @Override
    public boolean esIgual(Object lista2){
        return false;
    }

    @Override
    public boolean cambiar(Object infoViejo, Object infoNuevo, int numVeces){
        return false;
    }

    @Override
    public ListaEstatica buscarValores(Object info){
        ListaEstatica lista = new ListaEstatica(1);
        return lista;
    }

    @Override
    public Lista subLista(int indiceInicial, int indiceFinal){
        ListaEstatica lista = new ListaEstatica(1);
        return lista;
    }

    @Override
    public ListaEstatica subLista(ListaEstaticaNumerica listaIndices){
        ListaEstatica lista = new ListaEstatica(listaIndices.getMAXIMO());
        return lista;
    }

    @Override
    public int agregarPrincipio(Object info){
        return agregar(info);
    }
}
