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
            crearArbol(raiz);
            return true;
        } else {
            return false;
        }
    }

    protected void crearArbol(NodoDoble subraiz){
        SalidaPorDefecto.terminal("¿ El nodo " + subraiz.getInfo() + " tiene hijo izquierdo ?  \n");
        String respuestaIzq = entradasalida.EntradaPorDefecto.consolaCadenas();
        if (respuestaIzq.equalsIgnoreCase("si")) {
            SalidaPorDefecto.terminal("Dame el contenido del hijo izquierdo de " + subraiz.getInfo() + "\n");
            String info = entradasalida.EntradaPorDefecto.consolaCadenas();
            NodoDoble nuevoNodoIzq = new NodoDoble(info);
            if (nuevoNodoIzq != null) {
                subraiz.setApuntadorAIzquierda(nuevoNodoIzq);
                crearArbol(nuevoNodoIzq);
            }
        }
        SalidaPorDefecto.terminal("¿ El nodo " + subraiz.getInfo() + " tiene hijo derecho ?  \n");
        String respuestaDer = entradasalida.EntradaPorDefecto.consolaCadenas();
        if (respuestaDer.equalsIgnoreCase("si")) {
            SalidaPorDefecto.terminal("Dame el contenido del hijo derecho de " + subraiz.getInfo() + "\n");
            String info = entradasalida.EntradaPorDefecto.consolaCadenas();
            NodoDoble nuevoNodoDer = new NodoDoble(info);
            if (nuevoNodoDer != null) {
                subraiz.setApuntadorADerecha(nuevoNodoDer);
                crearArbol(nuevoNodoDer);
            }
        }
    }

    public void innorden(){
        innorden(raiz);
    }

    private void innorden(NodoDoble subraiz){
        if (subraiz != null){
            innorden(subraiz.getApuntadorAIzquierda());
            SalidaPorDefecto.terminal(subraiz.getInfo() + " ");
            innorden(subraiz.getApuntadorADerecha());
        }
    }

    public void preorden(){
        preorden(raiz);
    }

    private void preorden(NodoDoble subraiz){
        if (subraiz != null){
            SalidaPorDefecto.terminal(subraiz.getInfo() + " ");
            preorden(subraiz.getApuntadorAIzquierda());
            preorden(subraiz.getApuntadorADerecha());
        }
    }

    public void posorden(){
        posorden(raiz);
    }

    private void posorden(NodoDoble subraiz){
        if (subraiz != null){
            posorden(subraiz.getApuntadorAIzquierda());
            posorden(subraiz.getApuntadorADerecha());
            SalidaPorDefecto.terminal(subraiz.getInfo() + " ");
        }
    }
}
