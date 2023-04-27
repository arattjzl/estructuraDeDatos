package estructurasNoLineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.auxiliares.NodoDoble;
import utils.commons.Comparador;

/**
 * Clase que contiene los métodos para la creación y manipulación de un Árbol Binario de Búsqueda.
 * @author Aratt
 * @version 1.0
 */
public class ArbolBinarioBusqueda extends ArbolBinario{

    /**
     * Se crea un árbol desde la raíz hasta las hojas.
     * @param subraiz Es la raíz en la que iniciará el árbol.
     */
    @Override
    protected void crearArbol(NodoDoble subraiz) {
        SalidaPorDefecto.terminal("¿El nodo " + subraiz.getInfo() + " tiene hijo izquierdo?  \n");
        String respuestaIzq = entradasalida.EntradaPorDefecto.consolaCadenas();
        if (respuestaIzq.equalsIgnoreCase("si")) {
            SalidaPorDefecto.terminal("Dame el contenido del hijo izquierdo de " + subraiz.getInfo() + "\n");
            String info = entradasalida.EntradaPorDefecto.consolaCadenas();
            NodoDoble nuevoNodoIzq = new NodoDoble(info);
            if (nuevoNodoIzq != null && (int) Comparador.comparar(info, subraiz.getInfo().toString()) < 0) {
                subraiz.setApuntadorAIzquierda(nuevoNodoIzq);
                crearArbol(nuevoNodoIzq);
            }
        }
        SalidaPorDefecto.terminal("¿El nodo " + subraiz.getInfo() + " tiene hijo derecho?  \n");
        String respuestaDer = entradasalida.EntradaPorDefecto.consolaCadenas();
        if (respuestaDer.equalsIgnoreCase("si")) {
            SalidaPorDefecto.terminal("Dame el contenido del hijo derecho de " + subraiz.getInfo() + "\n");
            String info = entradasalida.EntradaPorDefecto.consolaCadenas();
            NodoDoble nuevoNodoDer = new NodoDoble(info);
            if (nuevoNodoDer != null && (int) Comparador.comparar(info, subraiz.getInfo()) > 0) {
                subraiz.setApuntadorADerecha(nuevoNodoDer);
                crearArbol(nuevoNodoDer);
            }
        }
    }

    /**
     * Agregará nodos al árbol, aún cuando no exista un árbol.
     * @param info Información que se agregará al árbol.
     * @return Regresa true si se pudo agregar y false si no.
     */
    public boolean agregar(Object info){
        if(raiz == null){
            NodoDoble nuevoNodo = new NodoDoble(info);
            if(nuevoNodo != null){
                raiz = nuevoNodo;
                return true;
            } else {
                return false;
            }
        } else {
            return agregar(raiz, info);
        }
    }

    /**
     * Agregará nodos al árbol, aún cuando no exista árbol.
     * @param subraiz Sub raíz en la que se encuentran del árbol.
     * @param info Información que se agregará.
     * @return Regresa true si se pudo agregar y false si no.
     */
    private boolean agregar(NodoDoble subraiz, Object info){
        if((int) Comparador.comparar(info, subraiz.getInfo()) < 0){
            if(subraiz.getApuntadorAIzquierda() != null){
                return agregar(subraiz.getApuntadorAIzquierda(), info);
            } else {
                NodoDoble nuevoNodo = new NodoDoble(info);
                if(nuevoNodo != null){
                    subraiz.setApuntadorAIzquierda(nuevoNodo);
                    return true;
                } else {
                    return false;
                }
            }
        } else if((int) Comparador.comparar(info, subraiz.getInfo()) > 0){
            if(subraiz.getApuntadorADerecha() != null){
                return agregar(subraiz.getApuntadorADerecha(), info);
            } else {
                NodoDoble nuevoNodo = new NodoDoble(info);
                if(nuevoNodo != null){
                    subraiz.setApuntadorADerecha(nuevoNodo);
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    /**
     * Busca el objeto en el árbol.
     * @param info Información por buscar.
     * @return Regresa el objeto si se encontró en el árbol y null si no.
     */
    public Object buscar(Object info){
        return buscar(raiz, info);
    }

    /**
     * Busca el objeto en el árbol.
     * @param subraiz Sub raíz del árbol en la que se encuentra.
     * @param info Información por buscar.
     * @return Regresa el objeto si se encontró y null si no.
     */
    private Object buscar(NodoDoble subraiz, Object info){
        if(subraiz != null){
            if((int) Comparador.comparar(info, subraiz.getInfo()) < 0){
                return buscar(subraiz.getApuntadorAIzquierda(), info);
            } else if((int) Comparador.comparar(info, subraiz.getInfo()) > 0){
                return buscar(subraiz.getApuntadorADerecha(), info);
            } else {
                return subraiz.getInfo();
            }
        } else {
            return null;
        }
    }

    /**
     * Elimina la información indicada del árbol.
     * @param info Información por eliminar.
     * @return Regresa la información si se eliminó o null si no.
     */
    public Object eliminar(Object info){
        return eliminar(raiz, null, info);
    }

    /**
     * Elimina la información indicada del árbol.
     * @param subraiz Es el nodo actual en el cual nos encontramos.
     * @param anterior Es el nodo anterior del padre, o sea, el nodo abuelo.
     * @param info Información por eliminar.
     * @return Regresa la información si se eliminó o null si no.
     */
    private Object eliminar(NodoDoble subraiz, NodoDoble anterior, Object info){
        if(subraiz != null){
            if((int) Comparador.comparar(info, subraiz.getInfo()) < 0){
                return eliminar(subraiz.getApuntadorAIzquierda(), subraiz, info);
            } else {
                if((int) Comparador.comparar(info, subraiz.getInfo()) > 0){
                    return eliminar(subraiz.getApuntadorADerecha(), subraiz, info);
                } else {
                    if(subraiz.getApuntadorAIzquierda() != null
                            && subraiz.getApuntadorADerecha() != null){
                        NodoDoble auxiliar = subraiz.getApuntadorAIzquierda();
                        NodoDoble nuevoAux = null;
                        boolean bool = false;
                        while(auxiliar.getApuntadorADerecha() != null){
                            nuevoAux = auxiliar;
                            auxiliar = auxiliar.getApuntadorADerecha();
                            bool = true;
                        }
                        subraiz.setInfo(auxiliar.getInfo());
                        if(bool == true){
                            auxiliar.setApuntadorADerecha(auxiliar.getApuntadorAIzquierda());
                        } else {
                            subraiz.setApuntadorAIzquierda(auxiliar.getApuntadorAIzquierda());
                        }
                    } else {
                        NodoDoble otroNodo = subraiz;
                        if(otroNodo.getApuntadorADerecha() == null){
                            if(otroNodo.getApuntadorAIzquierda() != null){
                                otroNodo = subraiz.getApuntadorAIzquierda();
                                if(anterior != null){
                                    if((int) Comparador.comparar(info, anterior.getInfo()) < 0){
                                        anterior.setApuntadorAIzquierda(otroNodo);
                                    } else {
                                        anterior.setApuntadorADerecha(otroNodo);
                                    }
                                } else {
                                    raiz = otroNodo;
                                }
                            } else {
                                if(anterior == null){
                                    raiz = null;
                                } else {
                                    if((int) Comparador.comparar(info, anterior.getInfo()) < 0){
                                        anterior.setApuntadorAIzquierda(null);
                                    } else {
                                        anterior.setApuntadorADerecha(null);
                                    }
                                }
                            }
                        } else {
                            if(otroNodo.getApuntadorAIzquierda() == null){
                                otroNodo = subraiz.getApuntadorADerecha();
                                if(anterior != null){
                                    if((int) Comparador.comparar(info, anterior.getInfo()) < 0){
                                        anterior.setApuntadorAIzquierda(otroNodo);
                                    } else {
                                        anterior.setApuntadorADerecha(otroNodo);
                                    }
                                } else {
                                    raiz = otroNodo;
                                }
                            }
                        }
                    }
                }
            }
        } else {
            return null;
        }
        return null;
    }
}
