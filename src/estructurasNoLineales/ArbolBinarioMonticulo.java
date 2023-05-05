package estructurasNoLineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ColaDinamica;
import estructurasLineales.ColaEstatica;
import estructurasLineales.ListaEstatica;
import estructurasLineales.auxiliares.NodoDoble;
import utils.commons.Comparador;
import utils.commons.TipoOrden;

public class ArbolBinarioMonticulo extends ArbolBinario{

    protected TipoOrden tipoOrden;

    public ArbolBinarioMonticulo(TipoOrden tipoOrden){
        super();
        this.tipoOrden = tipoOrden;
    }

    public boolean agregar(Object info){
        NodoDoble nuevoNodo = new NodoDoble(info);
        if(nuevoNodo != null){
            if(raiz == null){
                raiz = nuevoNodo;
            } else {
                if(tipoOrden == TipoOrden.INC){
                    agregarInc(nuevoNodo);
                    buscarLugarInc(nuevoNodo, raiz);
                } else {
                    agregarDec(nuevoNodo);
                }

            }
            return true;
        } else {
            return false;
        }
    }

    private void agregarInc(NodoDoble nodoNuevo){
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

    private void agregarDec(NodoDoble nodoNuevo){
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

    private void buscarLugarInc(NodoDoble actual, NodoDoble padre){
        if(actual != null){
            buscarLugarInc(actual.getApuntadorADerecha(),actual);
            buscarLugarInc(actual.getApuntadorAIzquierda(),actual);
            if((int) Comparador.comparar(actual.getInfo(), padre.getInfo()) > 0){
                if(padre == raiz){
                    if(padre.getApuntadorADerecha() == actual) {
                        NodoDoble auxDer = padre.getApuntadorADerecha();
                        padre.setApuntadorADerecha(actual.getApuntadorADerecha());
                        padre.setApuntadorAIzquierda(actual.getApuntadorAIzquierda());
                        actual.setApuntadorAIzquierda(padre.getApuntadorAIzquierda());
                        actual.setApuntadorADerecha(auxDer);
                    } else if(padre.getApuntadorAIzquierda() == actual) {
                        NodoDoble auxizq = padre.getApuntadorAIzquierda();
                        padre.setApuntadorADerecha(actual.getApuntadorADerecha());
                        padre.setApuntadorAIzquierda(actual.getApuntadorAIzquierda());
                        actual.setApuntadorAIzquierda(auxizq);
                        actual.setApuntadorADerecha(actual.getApuntadorADerecha());
                    }
                } else {
                    NodoDoble abuelo = obtenerPadre(padre);
                    if(padre.getApuntadorADerecha() == actual){
                        NodoDoble auxDer = padre.getApuntadorADerecha();
                        padre.setApuntadorADerecha(actual.getApuntadorADerecha());
                        padre.setApuntadorAIzquierda(actual.getApuntadorAIzquierda());
                        actual.setApuntadorAIzquierda(padre.getApuntadorAIzquierda());
                        actual.setApuntadorADerecha(auxDer);
                        if(abuelo.getApuntadorADerecha() != null && abuelo.getApuntadorADerecha() == padre){
                            abuelo.setApuntadorADerecha(actual);
                        } else if(abuelo.getApuntadorAIzquierda() != null && abuelo.getApuntadorAIzquierda() == padre){
                            abuelo.setApuntadorAIzquierda(actual);
                        }
                    } else if(padre.getApuntadorAIzquierda() == actual){
                        NodoDoble auxizq = padre.getApuntadorAIzquierda();
                        padre.setApuntadorADerecha(actual.getApuntadorADerecha());
                        padre.setApuntadorAIzquierda(actual.getApuntadorAIzquierda());
                        actual.setApuntadorAIzquierda(auxizq);
                        actual.setApuntadorADerecha(actual.getApuntadorADerecha());
                        if(abuelo.getApuntadorADerecha() != null && abuelo.getApuntadorADerecha() == padre){
                            abuelo.setApuntadorADerecha(actual);
                        } else if(abuelo.getApuntadorAIzquierda() != null && abuelo.getApuntadorAIzquierda() == padre){
                            abuelo.setApuntadorAIzquierda(actual);
                        }
                    }
                }
            }
        }
    }

    private NodoDoble obtenerPadre(NodoDoble buscando){
        ColaDinamica cola = new ColaDinamica();
        cola.poner(raiz);
        while(!cola.vacia()){
            NodoDoble quitado = (NodoDoble) cola.quitar();
            if(quitado.getApuntadorAIzquierda() == buscando || quitado.getApuntadorADerecha() == buscando){
                return quitado;
            }
            if(quitado.getApuntadorAIzquierda() != null){
                cola.poner(quitado.getApuntadorAIzquierda());
            }
            if(quitado.getApuntadorADerecha() != null){
                cola.poner(quitado.getApuntadorADerecha());
            }
        }
        return null;
    }
}
