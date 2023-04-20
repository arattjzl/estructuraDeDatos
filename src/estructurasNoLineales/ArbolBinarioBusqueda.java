package estructurasNoLineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.auxiliares.Nodo;
import estructurasLineales.auxiliares.NodoDoble;
import utils.commons.Comparador;

public class ArbolBinarioBusqueda extends ArbolBinario{

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

    public Object buscar(Object info){
        return buscar(raiz, info);
    }

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
}
