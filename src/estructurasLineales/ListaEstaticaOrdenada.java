package estructurasLineales;

import utils.commons.Comparador;
import utils.commons.TipoOrden;

/**
 * Es la clase que contiene los métodos para realizar listas estáticas ordenadas
 * @author Aratt
 * @version 1.0
 */
public class ListaEstaticaOrdenada extends ListaEstatica{
    protected TipoOrden orden;
    public ListaEstaticaOrdenada(int tamanio, TipoOrden orden) {
        super(tamanio);
        this.orden = orden;
    }

    public TipoOrden getOrden() {
        return orden;
    }

    public void setOrden(TipoOrden orden) {
        this.orden = orden;
    }

    @Override
    public int agregar(Object info){
        if(!llena()){
            int posicion = (int) buscar(info);
            if(posicion<0){
                tope++;
                posicion = posicion*-1;
                posicion--;
                for(int movs = tope; movs > posicion; movs--){
                    informacion[movs] = informacion[movs-1];
                }
                informacion[posicion] = info;
                return posicion;
            }
            return -1;
        }
        return -1;
    }

    @Override
    public Object buscar(Object info){
        int posicion = 0;
        if(orden == TipoOrden.INC){
            while (posicion <= tope && (int)(Comparador.comparar(info, informacion[posicion])) > 0){
                posicion++;
            }
            //si no esta en la lista
            if(posicion>tope || (int)(Comparador.comparar(info, informacion[posicion])) < 0){
                return (posicion+1)*-1;
            }
            //si esta en la lista
            return posicion+1;
        }
        if(orden == TipoOrden.DEC){
            while (posicion <= tope && (int)(Comparador.comparar(informacion[posicion], info)) > 0){
                posicion++;
            }
            //si no esta en la lista
            if(posicion>tope || (int)(Comparador.comparar(informacion[posicion], info)) < 0){
                return (posicion+1)*-1;
            }
            //si esta en la lista
            return posicion+1;
        }
        return null;
    }

    @Override
    public boolean cambiar(Object valorViejo, Object valorNuevo, int numOcurrencias){
        if((int)buscar(valorViejo) > 0){
            eliminarObjeto(valorViejo);
            agregar(valorNuevo);
            return true;
        }
        return false;
    }


    @Override
    public boolean cambiar(int indice, Object info){
        if(indice <= tope){
            eliminar(indice);
            agregar(info);
            return true;
        }
        return false;
    }

    @Override
    public boolean agregarLista(Object lista2){
        if(lista2 instanceof ListaEstaticaOrdenada){
            for(int indice = 0; indice <= getMAXIMO()-1; indice++){
                agregar(((ListaEstaticaOrdenada) lista2).obtener(indice));
            }
            return true;
        }
        return false;
    }

    @Override
    public Object eliminarObjeto(Object info) {
        int posicion = (Integer)buscar(info);
        if(posicion>=0){ // si esta
            posicion--;
            Object respado = informacion[posicion];
            tope--;
            for(int movs = posicion; movs <= tope; movs++){
                informacion[movs] = informacion[movs+1];
            }
            return respado;
        }else { // no esta
            return null;
        }
    }
    @Override
    public void invertir(){
        ListaEstaticaOrdenada listaAuxiliar = new ListaEstaticaOrdenada(getMAXIMO(), TipoOrden.DEC);
        for(int indice = 0; indice < getMAXIMO(); indice++){
            listaAuxiliar.agregar(obtener(indice));
        }
        vaciar();
        if(getOrden() == TipoOrden.INC){
            setOrden(TipoOrden.DEC);
            for(int indice = 0; indice < getMAXIMO(); indice++){
                agregar(listaAuxiliar.obtener(indice));
            }
        } else if(getOrden() == TipoOrden.DEC){
            setOrden(TipoOrden.INC);
            for(int indice = 0; indice < getMAXIMO(); indice++){
                agregar(listaAuxiliar.obtener(indice));
            }
        }
    }

    /**
     * Desordena el arreglo
     * @return regresa la lista con el arreglo desordenado
    */
    public Lista arregloDesordenado(){
        ListaEstatica nuevaLista = new ListaEstatica(getMAXIMO());
        for(int indice = 0; indice <= getTope(); indice=indice+2){
            nuevaLista.agregar(obtener(indice));
        }
        for(int indice = 1; indice <= getTope(); indice=indice+2){
            nuevaLista.agregar(obtener(indice));
        }
        return nuevaLista;
    }

    /**
     * Indica si la lista2 (que es otro arreglo ordenado) es una sublista o subconjunto
     * de la lista actual.
     * @param lista2 Es la lista a comparar
     * @return Regresa true si es una sublista
    */
    public boolean esSublista(Lista lista2){
        if(lista2 instanceof ListaEstaticaOrdenada){
            Object objetoInicial = ((ListaEstaticaOrdenada) lista2).obtener(0);
            int posicion = (int)buscar(objetoInicial)-1;
            for(int indice = 0; indice < ((ListaEstaticaOrdenada) lista2).getTope();indice++){
                if((int)Comparador.comparar(obtener(posicion), ((ListaEstaticaOrdenada) lista2).obtener(indice)) != 0){
                    return false;
                }
                posicion++;
            }
            return true;
        }
        return false;
    }

    /**
     * Debe cambiar los elementos de primera lista que se encuentren en la lista
     * actual con los elementos de la segunda lista. Cada elemento de lista2 coincide en
     * posición con su nuevo valor a cambiar en la segunda lista.
     * @param lista2 Es la lista con índices a buscar
     * @param lista2Nueva son los objetos que tiene que insertar
     * @return regresa true si si cambia la lista
     */
    public boolean cambiarLista(Lista lista2, Lista lista2Nueva){
        if(lista2 instanceof ListaEstatica && lista2Nueva instanceof ListaEstatica){
            for(int indice = 0; indice < ((ListaEstatica) lista2).getMAXIMO(); indice++){
                if((int)Comparador.comparar(((ListaEstatica) lista2).obtener(indice), obtener((int)buscar(((ListaEstatica) lista2).obtener(indice))-1)) == 0){
                    cambiar(obtener((int)buscar(((ListaEstatica) lista2).obtener(indice))-1), ((ListaEstatica) lista2Nueva).obtener(indice), 1 );
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Retiene los objetos de lista 2 que estén en la lista principal y son los que deja en la lista principal
     * @param lista2 es la lista con los objetos a retener
     * @return regresa true si si tiene objetos iguales
     */
    public boolean retenerLista(Lista lista2){
        if(lista2 instanceof ListaEstatica){
            for(int indice = 0; indice < ((ListaEstatica) lista2).MAXIMO; indice++){
                if((int)Comparador.comparar(((ListaEstatica) lista2).obtener(indice), obtener((int)buscar(((ListaEstatica) lista2).obtener(indice))-1)) == 0){
                    eliminar((int)buscar(((ListaEstatica) lista2).obtener(indice)));
                }
            }
        }
        return false;
    }
}