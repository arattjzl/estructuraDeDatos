package estructurasNoLineales;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import estructurasLineales.*;
import estructurasLineales.auxiliares.NodoDoble;

/**
 * Clase con métodos para el TDA árbol binario.
 * @author Aratt
 * @version 1.0
 */
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

    /**
     * Corrimiento en postorden sin recursividad.
     */
    public void postordenSinRecursion(){
        PilaDinamica pila = new PilaDinamica();
        ListaDinamica lista = new ListaDinamica();
        pila.poner(raiz);

        while (!pila.vacia()){
            NodoDoble nodoSacado = (NodoDoble) pila.quitar();

            lista.agregar(nodoSacado.getInfo());
            if(nodoSacado.getApuntadorAIzquierda() != null){
                pila.poner(nodoSacado.getApuntadorAIzquierda());
            }
            if(nodoSacado.getApuntadorADerecha() != null){
                pila.poner(nodoSacado.getApuntadorADerecha());
            }
        }
        lista.invertir();
        String cadena = "";
        lista.inicializarIterador();
        while (lista.hayNodo()){
            cadena += lista.obtenerNodo() + " ";
        }
        SalidaPorDefecto.terminal(cadena);
    }

    /**
     * Recorre el árbol por niveles, y de izquierda a derecha utilizando colas.
     */
    public void recorridoAmplitud(){
        // 1. Se agrega la raíz a una “cola” de nodos por visitar
        ColaDinamica cola = new ColaDinamica();
        cola.poner(raiz);

        // 2. Mientras que la cola no esté vacía, se saca el primer elemento
        // de la cola continuamos con el paso 3; pero si la cola esté vacía,
        // entonces nos vamos al paso 5.
        while (!cola.vacia()){
            NodoDoble nodoSacado = (NodoDoble) cola.quitar();

            // 3. Se imprime el nodo procesado actualmente y se agregan todos
            // los hijos del nodo a la cola de nodos pendientes por procesar.
            SalidaPorDefecto.terminal(nodoSacado.getInfo() + " ");
            if(nodoSacado.getApuntadorAIzquierda() != null){
                cola.poner(nodoSacado.getApuntadorAIzquierda());
            }
            if(nodoSacado.getApuntadorADerecha() != null){
                cola.poner(nodoSacado.getApuntadorADerecha());
            }
        }
    }

    /**
     * Recorre el árbol por niveles, y de izquierda a derecha utilizando pilas.
     */
    public void recorridoAmplitudPila(){
        // 1. Se agrega la raíz a una “pila” de nodos por visitar
        PilaDinamica pila = new PilaDinamica();
        pila.poner(raiz);

        // 2. Mientras que la cola no esté vacía, se saca el primer
        // elemento de la cola continuamos con el paso 3; pero si la
        // pila esté vacía, entonces nos vamos al paso 5.
        while (!pila.vacia()){
            NodoDoble nodoSacado = (NodoDoble) pila.quitar();

            // 3. Se imprime el nodo procesado actualmente y se agregan todos
            // los hijos del nodo a la pila de nodos pendientes por procesar.
            SalidaPorDefecto.terminal(nodoSacado.getInfo() + " ");
            if(nodoSacado.getApuntadorAIzquierda() != null){
                pila.poner(nodoSacado.getApuntadorAIzquierda());
            }
            if(nodoSacado.getApuntadorADerecha() != null){
                pila.poner(nodoSacado.getApuntadorADerecha());
            }
        }
    }
}
