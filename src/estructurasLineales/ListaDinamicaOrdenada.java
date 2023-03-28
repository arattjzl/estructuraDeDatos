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
    public boolean vacia() {
        return primero == null;
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
                    while(nodoActual.getApuntadorOtroNodo()!=null && (int)Comparador.comparar(info, nodoActual.getInfo())>0){
                        nodoActual = nodoActual.getApuntadorOtroNodo();
                    }
                    if(nodoActual == primero){
                        if((int) Comparador.comparar(info, nodoActual.getInfo()) > 0){
                            primero.setApuntadorOtroNodo(nuevoNodo);
                        } else if((int) Comparador.comparar(info, nodoActual.getInfo()) < 0){
                            nuevoNodo.setApuntadorOtroNodo(primero);
                            primero = nuevoNodo;
                        }
                    } else if(nodoActual != ultimo){
                        Nodo nodoAnterior = (Nodo)buscarAnterior(info).obtener(0);
                        Nodo nodoBuscado = (Nodo)buscarAnterior(info).obtener(1);
                        nodoAnterior.setApuntadorOtroNodo(nuevoNodo);
                        nuevoNodo.setApuntadorOtroNodo(nodoBuscado);
                    } else {
                        ultimo.setApuntadorOtroNodo(nuevoNodo);
                        ultimo = nuevoNodo;
                    }
                    return 1;
                } else if(tipoOrden == TipoOrden.DEC) {
                    inicializarIterador();
                    while (nodoActual.getApuntadorOtroNodo() != null && (int) Comparador.comparar(info, nodoActual.getInfo()) < 0) {
                        nodoActual = nodoActual.getApuntadorOtroNodo();
                    }
                    if (nodoActual == primero) {
                        if ((int) Comparador.comparar(info, nodoActual.getInfo()) < 0) {
                            primero.setApuntadorOtroNodo(nuevoNodo);
                        } else if ((int) Comparador.comparar(info, nodoActual.getInfo()) > 0) {
                            nuevoNodo.setApuntadorOtroNodo(primero);
                            primero = nuevoNodo;
                        }
                    } else if (nodoActual != ultimo) {
                        Nodo nodoAnterior = (Nodo) buscarAnterior(info).obtener(0);
                        Nodo nodoBuscado = (Nodo) buscarAnterior(info).obtener(1);
                        nodoAnterior.setApuntadorOtroNodo(nuevoNodo);
                        nuevoNodo.setApuntadorOtroNodo(nodoBuscado);
                    } else {
                        ultimo.setApuntadorOtroNodo(nuevoNodo);
                        ultimo = nuevoNodo;
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
    public void imprimir(){
        super.imprimir();
    }

    @Override
    public void imprimirOI(){
        super.imprimirOI();
    }

    @Override
    public Object buscar(Object info){
        return super.buscar(info);
    }

    @Override
    public Object eliminarObjeto(Object info){
        return null;
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
    public Object eliminar(){
        return super.eliminar();
    }

    @Override
    public void vaciar(){
        super.vaciar();
    }

    @Override
    public boolean agregarLista(Object lista2){
        if(lista2 instanceof ListaEstatica){
            for(int cadaIndice = 0; cadaIndice <= ((ListaEstatica) lista2).getTope(); cadaIndice++){
                agregar(((ListaEstatica) lista2).obtener(cadaIndice));
            }
            return true;
        } else if(lista2 instanceof ListaDinamica){
            inicializarIterador();
            while(nodoActual != null){
                agregar(nodoActual.getInfo());
                nodoActual = nodoActual.getApuntadorOtroNodo();
            }
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void invertir(){
        super.invertir();
    }

    @Override
    public int contar(Object info){
        return 1;
    }

    @Override
    public void eliminarLista(Object lista2){

    }

    @Override
    public void rellenar(Object info, int cantidad){

    }

    @Override
    public Lista clonar(){
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
    public Object verUltimo(){
        return super.verUltimo()    ;
    }

    @Override
    public Object eliminarInicio(){
        return super.eliminarInicio();
    }

    @Override
    public int agregarPrincipio(Object info){
        return agregar(info);
    }
}
