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

    private void intercambio(){
        
    }
}
