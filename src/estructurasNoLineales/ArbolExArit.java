package estructurasNoLineales;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import estructurasLineales.ListaDinamicaClave;
import estructurasLineales.PilaEstatica;
import estructurasLineales.auxiliares.NodoDoble;
import utils.commons.Comparador;
import utils.matematicas.ExpresionesMatematicas;

/**
 * Clase que contiene los métodos para la creación de un árbol con expresiones aritméticas.
 * @author Aratt
 * @version 1.0
 */

public class ArbolExArit extends ArbolBinario{
    protected ListaDinamicaClave operandos;
    protected ListaDinamica operadores;
    protected NodoDoble raizSinVar;

    public ArbolExArit(){
        super();
        operadores = new ListaDinamica();
        operandos = new ListaDinamicaClave();
        raizSinVar = null;
    }

    public void crearArbolInfija(String infija){

    }

    /**
     * Crea una cadena a un árbol postfija.
     * @param postfija Cadena con la expresión aritmética.
     * @return Regresa true si se pudo crear o false si no.
     */
    public boolean crearArbolPostfija(String postfija){
        PilaEstatica pila = new PilaEstatica(postfija.length());
        for(int posToken = 0; posToken < postfija.length(); posToken++){
            char token = postfija.charAt(posToken);
            if(ExpresionesMatematicas.esOperando(token + "")){
                NodoDoble nuevoNodo = new NodoDoble(token);
                if(nuevoNodo != null){
                    pila.poner(nuevoNodo);
                } else {
                    return false;
                }
            } else {
                NodoDoble nuevoNodo = new NodoDoble(token);
                NodoDoble operando2 = (NodoDoble) pila.quitar();
                NodoDoble operando1 = (NodoDoble) pila.quitar();

                if(nuevoNodo != null && operando1 != null && operando2 != null){
                    nuevoNodo.setApuntadorAIzquierda(operando1);
                    nuevoNodo.setApuntadorADerecha(operando2);
                    pila.poner(nuevoNodo);
                } else {
                    return false;
                }
            }
        }
        NodoDoble nodoRaiz = (NodoDoble) pila.quitar();
        if (nodoRaiz != null){
            raiz = nodoRaiz;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Crea una cadena a un árbol prefijo.
     * @param prefija Cadena con la expresión aritmética.
     * @return Regresa true si se pudo crear o false si no.
     */
    public boolean crearArbolPrefija(String prefija){
        PilaEstatica pila = new PilaEstatica(prefija.length());
        for(int posToken = prefija.length() - 1; posToken >= 0; posToken--){
            char token = prefija.charAt(posToken);
            if(ExpresionesMatematicas.esOperando(token + "")){
                NodoDoble nuevoNodo = new NodoDoble(token);
                if(nuevoNodo != null){
                    pila.poner(nuevoNodo);
                } else {
                    return false;
                }
            } else {
                NodoDoble nuevoNodo = new NodoDoble(token);
                NodoDoble operando1 = (NodoDoble) pila.quitar();
                NodoDoble operando2 = (NodoDoble) pila.quitar();

                if(nuevoNodo != null && operando1 != null && operando2 != null){
                    nuevoNodo.setApuntadorAIzquierda(operando1);
                    nuevoNodo.setApuntadorADerecha(operando2);
                    pila.poner(nuevoNodo);
                } else {
                    return false;
                }
            }
        }
        NodoDoble nodoRaiz = (NodoDoble) pila.quitar();
        if (nodoRaiz != null){
            raiz = nodoRaiz;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Con el árbol ya creado pasa los operandos a una lista y los operadores a otra.
     */
    public void aListas(){
        aListas(raiz);
        operandos.imprimir();
        SalidaPorDefecto.terminal("\n");
        operadores.imprimir();
    }

    /**
     * Con el árbol ya creado pasa los operandos a una lista y los operadores a otra.
     */
    private void aListas(NodoDoble subraiz){
        if (subraiz != null){
            aListas(subraiz.getApuntadorAIzquierda());
            if(ExpresionesMatematicas.esOperando(subraiz.getInfo() + "")){
                if(ExpresionesMatematicas.esNumerico(subraiz.getInfo() + "")){
                    operandos.agregar(subraiz.getInfo(), subraiz.getInfo());
                } else {
                    SalidaPorDefecto.terminal("\n¿Que valor tiene " + subraiz.getInfo() + "?\n");
                    double valor = EntradaPorDefecto.consolaDouble();
                    operandos.agregar(subraiz.getInfo(), valor);
                }
            } else {
                operadores.agregar(subraiz.getInfo());
            }
            aListas(subraiz.getApuntadorADerecha());
        }
    }

    /**
     * Cambia el árbol con variables a su valor numérico.
     */
    public void arbolSinVar(){
        raizSinVar = raiz;
        SalidaPorDefecto.terminal("\nRecorridos del arbol\nPreorden:\n");
        preorden(raiz);
        SalidaPorDefecto.terminal("\nInnorden:\n");
        innorden(raiz);
        SalidaPorDefecto.terminal("\nPostorden:\n");
        posorden(raiz);
        arbolSinVar(raizSinVar);
        SalidaPorDefecto.terminal("\n\nRecorridos del arbol sin variables\nPreorden:\n");
        preorden(raizSinVar);
        SalidaPorDefecto.terminal("\nInnorden:\n");
        innorden(raizSinVar);
        SalidaPorDefecto.terminal("\nPostorden:\n");
        posorden(raizSinVar);
    }

    /**
     * Cambia el árbol con variables a su valor numérico.
     */
    protected void arbolSinVar(NodoDoble actual){
        if (actual != null){
            arbolSinVar(actual.getApuntadorAIzquierda());
            Object info = actual.getInfo();
            if(!ExpresionesMatematicas.esNumerico(info + "") && ExpresionesMatematicas.esOperando(info + "")){
                Object var = operandos.buscar(info);
                actual.setInfo(var);
            }
            arbolSinVar(actual.getApuntadorADerecha());
        }
    }

    /**
     * Obtiene la altura del árbol.
     * @return Regresa la altura del árbol.
     */
    public int alturaArbol(){
        return alturaArbol(raiz);
    }

    /**
     * Obtiene la altura del árbol.
     * @param actual Es la subraíz en la se encuentra.
     * @return Regresa la altura del árbol.
     */
    protected int alturaArbol(NodoDoble actual){
        if(actual != null){
            int alturaIzq = alturaArbol(actual.getApuntadorAIzquierda());
            int alturaDer = alturaArbol(actual.getApuntadorADerecha());
            if(alturaIzq > alturaDer){
                return alturaIzq + 1;
            } else {
                return alturaDer + 1;
            }
        } else {
            return 0;
        }
    }

    /**
     * Obtiene el nivel en el que se encuentra la información indicada.
     * @param info Info que se buscará.
     */
    public void nivelSeEncuentra(Object info){
        nivelSeEncuentra(raiz, info, 1);
    }

    /**
     * Obtiene el nivel en el que se encuentra la información indicada.
     * @param actual Es el nodo actual en el que se encuentra.
     * @param info Info que se buscará.
     * @param nivel Es el nivel en el que se encuentra.
     */
    protected void nivelSeEncuentra(NodoDoble actual, Object info, int nivel){
        if(actual != null){
            if((int) Comparador.comparar(info, actual.getInfo()) == 0){
                SalidaPorDefecto.terminal("La informacion " + info + " se encuentra en el nivel " + nivel + "\n");
            } else {
                nivelSeEncuentra(actual.getApuntadorAIzquierda(), info, nivel+1);
                nivelSeEncuentra(actual.getApuntadorADerecha(), info, nivel+1);
            }
        }
    }

    /**
     * Obtiene los elementos que hay en el nivel indicado.
     * @param nivel Es el nivel a buscar.
     */
    public int elementosNivel(int nivel){
        return elementosNivel(nivel,1,raiz);
    }

    /**
     * Obtiene los elementos que hay en el nivel indicado.
     * @param nivel Es el nivel a buscar.
     * @param nivelActual Es el nivel en el que se encuentra.
     * @param actual Es el nodo actual en el que se encuentra.
     * @return
     */
    protected int elementosNivel(int nivel, int nivelActual, NodoDoble actual){
        if(nivelActual != nivel && actual != null){
            return elementosNivel(nivel, nivelActual+1, actual.getApuntadorAIzquierda())
                    + elementosNivel(nivel, nivelActual+1, actual.getApuntadorADerecha());
        } else if(nivelActual == nivel && actual == null){
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Obtiene la información del nodo que se indica.
     * @param info Información por buscar.
     */
    public void queNodoEs(Object info){
        queNodoEs(raiz, null, info);
    }

    /**
     * Obtiene la información del nodo que se indica.
     * @param actual Es el nodo actual.
     * @param anterior Es el nodo padre.
     * @param info Información por buscar.
     */
    protected void queNodoEs(NodoDoble actual, NodoDoble anterior, Object info){
        if(actual != null){
            if((int) Comparador.comparar(info, actual.getInfo()) == 0){
                if(actual == raiz){
                    SalidaPorDefecto.terminal("El nodo con info " + info +" es nodo raiz" + "\n");
                } else if(actual.getApuntadorAIzquierda() != null || anterior.getApuntadorADerecha() != null){
                    SalidaPorDefecto.terminal("El nodo con info " + info +" es nodo intermedio y su padre es " + anterior.getInfo() + "\n");
                } else {
                    SalidaPorDefecto.terminal("El nodo con info " + info +" es hoja y su padre es " + anterior.getInfo() + "\n");
                }
            } else {
                queNodoEs(actual.getApuntadorAIzquierda(), actual, info);
                queNodoEs(actual.getApuntadorADerecha(), actual, info);
            }
        }
    }

    /**
     * Obtiene la información si hay la información tiene un nodo hermano.
     * @param info Información por buscar.
     */
    public void tieneHermano(Object info){
        tieneHermano(raiz, null, info);
    }

    /**
     * Obtiene la información si hay la información tiene un nodo hermano.
     * @param actual Es el nodo actual.
     * @param anterior Es el nodo padre.
     * @param info Información por buscar.
     */
    protected void tieneHermano(NodoDoble actual, NodoDoble anterior, Object info){
        if(actual != null){
            if((int) Comparador.comparar(info, actual.getInfo()) == 0){
                if(anterior == null){
                    SalidaPorDefecto.terminal("Esta en la raiz\n");
                } else if(anterior.getApuntadorAIzquierda() != null && anterior.getApuntadorADerecha() != null){
                    SalidaPorDefecto.terminal("Si tiene hermano\n");
                } else {
                    SalidaPorDefecto.terminal("No tiene hermano\n");
                }
            } else {
                tieneHermano(actual.getApuntadorAIzquierda(), actual, info);
                tieneHermano(actual.getApuntadorADerecha(), actual, info);
            }
        }
    }
}
