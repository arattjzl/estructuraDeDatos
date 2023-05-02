package estructurasNoLineales;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import estructurasLineales.ListaDinamicaClave;
import estructurasLineales.auxiliares.NodoClave;
import estructurasLineales.auxiliares.NodoDoble;
import utils.commons.Comparador;
import utils.matematicas.ExpresionesMatematicas;

public class ArbolBinario {
    protected NodoDoble raiz;

    public ArbolBinario(){
        raiz = null;
    }

    /**
     * Crea el árbol pidiendo desde la raíz hasta las hojas.
     * @return Regresa true si se pudo crear o false si no.
     */
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

    /**
     * Crea el árbol pidiendo desde la raíz hasta las hojas.
     * @param subraiz Es la subraíz en la que se encuentra el árbol.
     */
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

    /**
     * Corrimiento en orden.
     */
    public void innorden(){
        innorden(raiz);
    }

    /**
     * Corrimiento en orden.
     */
    protected void innorden(NodoDoble subraiz){
        if (subraiz != null){
            innorden(subraiz.getApuntadorAIzquierda());
            SalidaPorDefecto.terminal(subraiz.getInfo() + " ");
            innorden(subraiz.getApuntadorADerecha());
        }
    }

    /**
     * Corrimiento en preorden.
     */
    public void preorden(){
        preorden(raiz);
    }

    /**
     * Corrimiento en preorden.
     */
    protected void preorden(NodoDoble subraiz){
        if (subraiz != null){
            SalidaPorDefecto.terminal(subraiz.getInfo() + " ");
            preorden(subraiz.getApuntadorAIzquierda());
            preorden(subraiz.getApuntadorADerecha());
        }
    }

    /**
     * Corrimiento en postorden.
     */
    public void posorden(){
        posorden(raiz);
    }

    /**
     * Corrimiento en postorden.
     */
    protected void posorden(NodoDoble subraiz){
        if (subraiz != null){
            posorden(subraiz.getApuntadorAIzquierda());
            posorden(subraiz.getApuntadorADerecha());
            SalidaPorDefecto.terminal(subraiz.getInfo() + " ");
        }
    }
}
