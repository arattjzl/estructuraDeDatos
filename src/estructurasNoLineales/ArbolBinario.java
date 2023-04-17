package estructurasNoLineales;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import estructurasLineales.auxiliares.NodoDoble;

public class ArbolBinario {
    protected NodoDoble raiz;

    public ArbolBinario(){
        raiz = null;
    }

    public boolean crearArbol(){
        SalidaPorDefecto.terminal("Dame la raiz: ");
        String info = EntradaPorDefecto.consolaCadenas();
        NodoDoble nuevoNodo = new NodoDoble(info);
        if (nuevoNodo != null){
            raiz = nuevoNodo;
            return crearArbol(raiz);
        } else {
            return false;
        }
    }

    private boolean crearArbol(NodoDoble subraiz){
        SalidaPorDefecto.terminal("El nodo " + subraiz.getInfo() + " tiene hijo izquierdo? [S/N] ");
        String respuesta = EntradaPorDefecto.consolaCadenas();
        if (respuesta.equalsIgnoreCase("s")){
            SalidaPorDefecto.terminal("Dame su contenido: ");
            String infoIzq = EntradaPorDefecto.consolaCadenas();
            NodoDoble nuevoNodoIzq = new NodoDoble(infoIzq);
            if(nuevoNodoIzq != null){
                subraiz.setApuntadorAIzquierda(nuevoNodoIzq);
                return crearArbol(nuevoNodoIzq);
            } else {
                return false;
            }
        }
    }
}
