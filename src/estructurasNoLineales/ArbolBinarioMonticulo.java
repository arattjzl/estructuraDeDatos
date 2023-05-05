package estructurasNoLineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ColaDinamica;
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

    private void buscarLugarInc(NodoDoble actual, NodoDoble padre){
        if(actual != null){
            buscarLugarInc(actual.getApuntadorADerecha(),actual);
            buscarLugarInc(actual.getApuntadorAIzquierda(),actual);
            if(actual != raiz){
                if((int) Comparador.comparar(actual.getInfo(), padre.getInfo()) > 0){
                    if(padre == raiz){
                        if(padre.getApuntadorADerecha() == actual) {
                            NodoDoble auxizq = padre.getApuntadorAIzquierda();
                            padre.setApuntadorADerecha(actual.getApuntadorADerecha());
                            padre.setApuntadorAIzquierda(actual.getApuntadorAIzquierda());
                            actual.setApuntadorAIzquierda(auxizq);
                            actual.setApuntadorADerecha(padre);
                        } else if(padre.getApuntadorAIzquierda() == actual) {
                            NodoDoble auxDer = padre.getApuntadorADerecha();
                            padre.setApuntadorADerecha(actual.getApuntadorADerecha());
                            padre.setApuntadorAIzquierda(actual.getApuntadorAIzquierda());
                            actual.setApuntadorAIzquierda(padre);
                            actual.setApuntadorADerecha(auxDer);
                        }
                        raiz = actual;
                    } else if(obtenerPadre(padre) != null){
                        NodoDoble abuelo = obtenerPadre(padre);
                        if(padre.getApuntadorADerecha() == actual){
                            NodoDoble auxizq = padre.getApuntadorAIzquierda();
                            padre.setApuntadorADerecha(actual.getApuntadorADerecha());
                            padre.setApuntadorAIzquierda(actual.getApuntadorAIzquierda());
                            actual.setApuntadorAIzquierda(auxizq);
                            actual.setApuntadorADerecha(padre);
                            if(abuelo.getApuntadorADerecha() == padre){
                                abuelo.setApuntadorADerecha(actual);
                            } else if(abuelo.getApuntadorAIzquierda() == padre){
                                abuelo.setApuntadorAIzquierda(actual);
                            }
                        } else if(padre.getApuntadorAIzquierda() == actual){
                            NodoDoble auxDer = padre.getApuntadorADerecha();
                            padre.setApuntadorADerecha(actual.getApuntadorADerecha());
                            padre.setApuntadorAIzquierda(actual.getApuntadorAIzquierda());
                            actual.setApuntadorAIzquierda(padre);
                            actual.setApuntadorADerecha(auxDer);
                            if(abuelo.getApuntadorADerecha() == padre){
                                abuelo.setApuntadorADerecha(actual);
                            } else if(abuelo.getApuntadorAIzquierda() == padre){
                                abuelo.setApuntadorAIzquierda(actual);
                            }
                        }
                    }
                }
            }
        }
    }

    private void buscarLugarDec(NodoDoble actual, NodoDoble padre){
        if(actual != null){
            buscarLugarInc(actual.getApuntadorADerecha(),actual);
            buscarLugarInc(actual.getApuntadorAIzquierda(),actual);
            if(actual != raiz){
                if((int) Comparador.comparar(actual.getInfo(), padre.getInfo()) < 0){
                    if(padre == raiz){
                        if(padre.getApuntadorADerecha() == actual) {
                            NodoDoble auxizq = padre.getApuntadorAIzquierda();
                            padre.setApuntadorADerecha(actual.getApuntadorADerecha());
                            padre.setApuntadorAIzquierda(actual.getApuntadorAIzquierda());
                            actual.setApuntadorAIzquierda(auxizq);
                            actual.setApuntadorADerecha(padre);
                        } else if(padre.getApuntadorAIzquierda() == actual) {
                            NodoDoble auxDer = padre.getApuntadorADerecha();
                            padre.setApuntadorADerecha(actual.getApuntadorADerecha());
                            padre.setApuntadorAIzquierda(actual.getApuntadorAIzquierda());
                            actual.setApuntadorAIzquierda(padre);
                            actual.setApuntadorADerecha(auxDer);
                        }
                        raiz = actual;
                    } else if(obtenerPadre(padre) != null){
                        NodoDoble abuelo = obtenerPadre(padre);
                        if(padre.getApuntadorADerecha() == actual){
                            NodoDoble auxizq = padre.getApuntadorAIzquierda();
                            padre.setApuntadorADerecha(actual.getApuntadorADerecha());
                            padre.setApuntadorAIzquierda(actual.getApuntadorAIzquierda());
                            actual.setApuntadorAIzquierda(auxizq);
                            actual.setApuntadorADerecha(padre);
                            if(abuelo.getApuntadorADerecha() == padre){
                                abuelo.setApuntadorADerecha(actual);
                            } else if(abuelo.getApuntadorAIzquierda() == padre){
                                abuelo.setApuntadorAIzquierda(actual);
                            }
                        } else if(padre.getApuntadorAIzquierda() == actual){
                            NodoDoble auxDer = padre.getApuntadorADerecha();
                            padre.setApuntadorADerecha(actual.getApuntadorADerecha());
                            padre.setApuntadorAIzquierda(actual.getApuntadorAIzquierda());
                            actual.setApuntadorAIzquierda(padre);
                            actual.setApuntadorADerecha(auxDer);
                            if(abuelo.getApuntadorADerecha() == padre){
                                abuelo.setApuntadorADerecha(actual);
                            } else if(abuelo.getApuntadorAIzquierda() == padre){
                                abuelo.setApuntadorAIzquierda(actual);
                            }
                        }
                    }
                }
            }
        }
    }

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
            if((quitado.getApuntadorAIzquierda() != null && (int) Comparador.comparar(buscando, quitado.getApuntadorAIzquierda()) == 0 )||
                    (quitado.getApuntadorADerecha() != null && (int) Comparador.comparar(buscando, quitado.getApuntadorADerecha()) == 0)){
                padre = quitado;
            }
        }
        return padre;
    }
}
