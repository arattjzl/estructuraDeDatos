package estructurasLineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.auxiliares.NodoDoble;

public class ListaDinamicaDoble implements Lista{

    protected NodoDoble primero;
    protected NodoDoble ultimo;

    public ListaDinamicaDoble(){
        primero = null;
        ultimo = null;
    }
    @Override
    public boolean vacia() {
        return primero==null;
    }

    @Override
    public int agregar(Object info) {
        NodoDoble nodoNuevo = new NodoDoble(info);
        if(nodoNuevo!=null){
            if(vacia()){
                primero = nodoNuevo;
                ultimo = nodoNuevo;
            } else {
                ultimo.setApuntadorADerecha(nodoNuevo);
                nodoNuevo.setApuntadorAIzquierda(ultimo);
                ultimo = nodoNuevo;
            }
            return 1;
        }
        return -1;
    }

    @Override
    public void imprimir() {
        NodoDoble auxiliar = primero;
        if(!vacia()){
            SalidaPorDefecto.terminal("null <- " );
            while (auxiliar.getApuntadorADerecha() != null){
                SalidaPorDefecto.terminal(auxiliar.getInfo() + " <-> ");
                auxiliar = auxiliar.getApuntadorADerecha();
            }
            SalidaPorDefecto.terminal(auxiliar.getInfo() + " -> ");
        }
        SalidaPorDefecto.terminal(null);
    }

    @Override
    public void imprimirOI() {

    }

    @Override
    public Object buscar(Object info) {
        return null;
    }

    @Override
    public Object eliminarObjeto(Object info) {
        return null;
    }

    @Override
    public boolean esIgual(Object lista2) {
        return false;
    }

    @Override
    public boolean cambiar(Object infoViejo, Object infoNuevo, int numVeces) {
        return false;
    }

    @Override
    public ListaEstatica buscarValores(Object info) {
        return null;
    }

    @Override
    public Object eliminar() {
        if(!vacia()){
            Object respaldo = ultimo.getInfo();
            if(primero==ultimo){
                primero = null;
                ultimo = null;
            } else {
                ultimo = ultimo.getApuntadorAIzquierda();
                ultimo.setApuntadorADerecha(null);
            }
            return respaldo;
        }
        return null;
    }

    @Override
    public void vaciar() {

    }

    @Override
    public boolean agregarLista(Object lista2) {
        return false;
    }

    @Override
    public void invertir() {

    }

    @Override
    public int contar(Object info) {
        return 0;
    }

    @Override
    public void eliminarLista(Object lista2) {

    }

    @Override
    public void rellenar(Object info, int cantidad) {

    }

    @Override
    public Lista clonar() {
        return null;
    }

    @Override
    public Lista subLista(int indiceInicial, int indiceFinal) {
        return null;
    }

    @Override
    public ListaEstatica subLista(ListaEstaticaNumerica listaIndices) {
        return null;
    }

    @Override
    public Object verUltimo() {
        return null;
    }

    @Override
    public boolean recibeBuffer(Object[] info) {
        return false;
    }

    @Override
    public Object eliminarInicio() {
        return null;
    }
}
