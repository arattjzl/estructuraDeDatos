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
    protected ListaDinamicaClave operandos;
    protected ListaDinamica operadores;
    protected NodoDoble raizSinVar;

    public ArbolBinario(){
        raiz = null;
        operadores = new ListaDinamica();
        operandos = new ListaDinamicaClave();
        raizSinVar = null;
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

    protected void innorden(NodoDoble subraiz){
        if (subraiz != null){
            innorden(subraiz.getApuntadorAIzquierda());
            SalidaPorDefecto.terminal(subraiz.getInfo() + " ");
            innorden(subraiz.getApuntadorADerecha());
        }
    }

    public void preorden(){
        preorden(raiz);
    }

    protected void preorden(NodoDoble subraiz){
        if (subraiz != null){
            SalidaPorDefecto.terminal(subraiz.getInfo() + " ");
            preorden(subraiz.getApuntadorAIzquierda());
            preorden(subraiz.getApuntadorADerecha());
        }
    }

    public void posorden(){
        posorden(raiz);
    }

    protected void posorden(NodoDoble subraiz){
        if (subraiz != null){
            posorden(subraiz.getApuntadorAIzquierda());
            posorden(subraiz.getApuntadorADerecha());
            SalidaPorDefecto.terminal(subraiz.getInfo() + " ");
        }
    }

    public void aListas(){
        aListas(raiz);
        operandos.imprimir();
        SalidaPorDefecto.terminal("\n");
        operadores.imprimir();
    }

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

    public void alturaArbol(){
        SalidaPorDefecto.terminal(alturaArbol(raiz) + "");
    }

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

    public void nivelSeEncuentra(Object info){
        nivelSeEncuentra(raiz, info, 1);
    }

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

    public void elementosNivel(int nivel){
        SalidaPorDefecto.terminal(elementosNivel(nivel,1,raiz) + "");
    }

    protected int elementosNivel(int nivel, int nivelActual, NodoDoble actual){
        if(nivelActual != nivel && actual != null){
            return elementosNivel(nivel, nivelActual+1, actual.getApuntadorAIzquierda()) + elementosNivel(nivel, nivelActual+1, actual.getApuntadorADerecha());
        } else if(nivelActual == nivel && actual == null){
            return 0;
        } else {
            return 1;
        }
    }

    public void queNodoEs(Object info){
        queNodoEs(raiz, null, info);
    }

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

    public void tieneHermano(Object info){
        tieneHermano(raiz, null, info);
    }

    protected void tieneHermano(NodoDoble actual, NodoDoble anterior, Object info){
        if(actual != null){
            if((int) Comparador.comparar(info, actual.getInfo()) == 0){
                if(anterior.getApuntadorAIzquierda() != null && anterior.getApuntadorADerecha() != null){
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
