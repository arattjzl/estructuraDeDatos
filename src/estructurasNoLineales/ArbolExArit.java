package estructurasNoLineales;

import estructurasLineales.PilaEstatica;
import estructurasLineales.auxiliares.NodoDoble;
import utils.matematicas.ExpresionesMatematicas;

public class ArbolExArit extends ArbolBinario{

    public void crearArbolInfija(String infija){

    }

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
}
