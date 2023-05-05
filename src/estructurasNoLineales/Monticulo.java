package estructurasNoLineales;

import estructurasLineales.ColaDinamica;
import estructurasLineales.ListaDinamica;
import estructurasLineales.auxiliares.NodoDoble;
import utils.commons.Comparador;
import utils.commons.TipoOrden;

/**
 * Clase con métodos para el TDA Montículo.
 * @author Aratt
 * @version 1.0
 */
public class Monticulo extends ArbolBinario{

    protected TipoOrden tipoOrden;

    /**
     * Crea un montículo con el tipo de orden indicado.
     * @param tipoOrden Tipo de orden que tendrá el montículo.
     */
    public Monticulo(TipoOrden tipoOrden){
        super();
        this.tipoOrden = tipoOrden;
    }

    /**
     * Agrega el valor a la lista indicado al montículo.
     * @param info Información por agregar.
     * @return Regresa true si se agregó o false si no.
     */
    public boolean agregar(Object info){
        NodoDoble nuevoNodo = new NodoDoble(info);
        if(nuevoNodo != null){
            if(raiz == null){
                raiz = nuevoNodo;
            } else {
                agregar(nuevoNodo);
                if(tipoOrden == TipoOrden.INC){
                    buscarLugarInc(raiz, null);
                } else if(tipoOrden == TipoOrden.DEC){
                    buscarLugarDec(raiz, null);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Agrega el nodo indicado al final del montículo.
     * @param nodoNuevo Es el nodo que se agregará al montículo.
     */
    private void agregar(NodoDoble nodoNuevo){
        ColaDinamica cola = new ColaDinamica();
        cola.poner(raiz);
        while (!cola.vacia()){
            NodoDoble nodoSacado = (NodoDoble) cola.quitar();
            if(nodoSacado.getApuntadorAIzquierda() != null && nodoSacado.getApuntadorADerecha() != null){
                cola.poner(nodoSacado.getApuntadorAIzquierda());
                cola.poner(nodoSacado.getApuntadorADerecha());
            } else if(nodoSacado.getApuntadorAIzquierda() != null && nodoSacado.getApuntadorADerecha() == null){
                nodoSacado.setApuntadorADerecha(nodoNuevo);
                break;
            } else {
                nodoSacado.setApuntadorAIzquierda(nodoNuevo);
                break;
            }
        }
    }

    /**
     * Busca el lugar que le toca a cada nodo en el montículo de manera incremental.
     * @param actual Es el nodo en el que se encuentra.
     * @param padre Es el nodo padre del actual.
     */
    private void buscarLugarInc(NodoDoble actual, NodoDoble padre){
        if(actual != null) {
            if(actual != raiz){
                if((int) Comparador.comparar(actual.getInfo(), padre.getInfo()) > 0){
                    if(padre == raiz){
                        if(padre.getApuntadorADerecha() == actual) {
                            cambioDer(actual, padre);
                        } else if(padre.getApuntadorAIzquierda() == actual) {
                            cambioIzq(actual, padre);
                        }
                        raiz = actual;
                    } else {
                        NodoDoble abuelo = obtenerPadre(padre);
                        if(padre.getApuntadorADerecha() == actual){
                            cambioDer(actual, padre);
                            if(abuelo.getApuntadorADerecha() == padre){
                                abuelo.setApuntadorADerecha(actual);
                            } else if(abuelo.getApuntadorAIzquierda() == padre){
                                abuelo.setApuntadorAIzquierda(actual);
                            }
                        } else if(padre.getApuntadorAIzquierda() == actual){
                            cambioIzq(actual, padre);
                            if(abuelo.getApuntadorADerecha() == padre){
                                abuelo.setApuntadorADerecha(actual);
                            } else if(abuelo.getApuntadorAIzquierda() == padre){
                                abuelo.setApuntadorAIzquierda(actual);
                            }
                        }
                    }
                }
            }
            buscarLugarInc(actual.getApuntadorAIzquierda(), actual);
            buscarLugarInc(actual.getApuntadorADerecha(), actual);
        }
    }

    /**
     * Realiza el cambio de nodo al si es hijo derecho del padre.
     * @param actual Nodo actual que se cambiará.
     * @param padre Nodo padre del actual.
     */
    private void cambioDer(NodoDoble actual, NodoDoble padre){
        NodoDoble auxizq = padre.getApuntadorAIzquierda();
        padre.setApuntadorADerecha(actual.getApuntadorADerecha());
        padre.setApuntadorAIzquierda(actual.getApuntadorAIzquierda());
        actual.setApuntadorAIzquierda(auxizq);
        actual.setApuntadorADerecha(padre);
    }

    /**
     * Realiza el cambio de nodo al si es hijo izquierdo del padre.
     * @param actual Nodo actual que se cambiará.
     * @param padre Nodo padre del actual.
     */
    private void cambioIzq(NodoDoble actual, NodoDoble padre){
        NodoDoble auxDer = padre.getApuntadorADerecha();
        padre.setApuntadorADerecha(actual.getApuntadorADerecha());
        padre.setApuntadorAIzquierda(actual.getApuntadorAIzquierda());
        actual.setApuntadorAIzquierda(padre);
        actual.setApuntadorADerecha(auxDer);
    }

    /**
     * Busca el lugar que le toca a cada nodo en el montículo de manera decremental.
     * @param actual Es el nodo en el que se encuentra.
     * @param padre Es el nodo padre del actual.
     */
    private void buscarLugarDec(NodoDoble actual, NodoDoble padre){
        if(actual != null) {
            if(actual != raiz){
                if((int) Comparador.comparar(padre.getInfo(), actual.getInfo()) > 0){
                    if(padre == raiz){
                        if(padre.getApuntadorADerecha() == actual) {
                            cambioDer(actual, padre);
                        } else if(padre.getApuntadorAIzquierda() == actual) {
                            cambioIzq(actual, padre);
                        }
                        raiz = actual;
                    } else {
                        NodoDoble abuelo = obtenerPadre(padre);
                        if(padre.getApuntadorADerecha() == actual){
                            cambioDer(actual, padre);
                            if(abuelo.getApuntadorADerecha() == padre){
                                abuelo.setApuntadorADerecha(actual);
                            } else if(abuelo.getApuntadorAIzquierda() == padre){
                                abuelo.setApuntadorAIzquierda(actual);
                            }
                        } else if(padre.getApuntadorAIzquierda() == actual){
                            cambioIzq(actual, padre);
                            if(abuelo.getApuntadorADerecha() == padre){
                                abuelo.setApuntadorADerecha(actual);
                            } else if(abuelo.getApuntadorAIzquierda() == padre){
                                abuelo.setApuntadorAIzquierda(actual);
                            }
                        }
                    }
                }
            }
            buscarLugarDec(actual.getApuntadorAIzquierda(), actual);
            buscarLugarDec(actual.getApuntadorADerecha(), actual);
        }
    }

    /**
     * Obtiene el nodo padre del nodo que se indique.
     * @param buscando Es el nodo del cual se quiere encontrar el padre.
     * @return Regresa el nodo padre si tiene o null si no tiene.
     */
    public NodoDoble obtenerPadre(NodoDoble buscando){
        ColaDinamica cola = new ColaDinamica();
        NodoDoble padre = null;
        cola.poner(raiz);
        while(!cola.vacia()){
            NodoDoble quitado = (NodoDoble) cola.quitar();
            if(quitado.getApuntadorAIzquierda() != null){
                cola.poner(quitado.getApuntadorAIzquierda());
            }
            if(quitado.getApuntadorADerecha() != null){
                cola.poner(quitado.getApuntadorADerecha());
            }
            if((quitado.getApuntadorAIzquierda() != null
                    && (int) Comparador.comparar(buscando, quitado.getApuntadorAIzquierda()) == 0 )||
                    (quitado.getApuntadorADerecha() != null
                            && (int) Comparador.comparar(buscando, quitado.getApuntadorADerecha()) == 0)){
                padre = quitado;
            }
        }
        return padre;
    }

    /**
     * Realiza la eliminación de la raíz y re-acomoda el montículo.
     */
    public void eliminar(){
        NodoDoble ultimoNodo = obtenerUltimoNodo();
        NodoDoble padreUltimo = obtenerPadre(ultimoNodo);
        if(padreUltimo.getApuntadorAIzquierda() == ultimoNodo){
            padreUltimo.setApuntadorAIzquierda(null);
        } else if(padreUltimo.getApuntadorADerecha() == ultimoNodo){
            padreUltimo.setApuntadorADerecha(null);
        }
        ultimoNodo.setApuntadorADerecha(raiz.getApuntadorADerecha());
        ultimoNodo.setApuntadorAIzquierda(raiz.getApuntadorAIzquierda());
        raiz = ultimoNodo;
        if(tipoOrden == TipoOrden.INC){
            buscarLugarInc(raiz, null);
        } else if(tipoOrden == TipoOrden.DEC){
            buscarLugarDec(raiz, null);
        }
    }

    /**
     * Obtiene el último nodo del árbol.
     * @return Regresa el último nodo del árbol
     */
    private NodoDoble obtenerUltimoNodo(){
        ColaDinamica cola = new ColaDinamica();
        cola.poner(raiz);
        ListaDinamica lista = new ListaDinamica();
        while (!cola.vacia()){
            NodoDoble nodoSacado = (NodoDoble) cola.quitar();
            lista.agregar(nodoSacado);
            if(nodoSacado.getApuntadorAIzquierda() != null){
                cola.poner(nodoSacado.getApuntadorAIzquierda());
            }
            if(nodoSacado.getApuntadorADerecha() != null){
                cola.poner(nodoSacado.getApuntadorADerecha());
            }
        }
        return (NodoDoble) lista.verUltimo();
    }
}
