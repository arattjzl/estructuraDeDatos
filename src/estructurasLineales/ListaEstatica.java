package estructurasLineales;

import entradasalida.SalidaPorDefecto;
import utils.commons.Comparador;

/**
 * Esta clase contiene los métodos de la Lista Estática.
 * @author Aratt
 * @version 1.0
 */
public class ListaEstatica implements VectorLista {
    protected int tope;
    protected int MAXIMO;
    protected Object informacion[];


    public ListaEstatica(int tamanio){
        MAXIMO = tamanio;
        informacion = new Object[tamanio];
        tope = -1;
    }

    public Object[] getInformacion() {
        return informacion;
    }

    public int getTope() {
        return tope;
    }

    public void setTope(int tope) {
        this.tope = tope;
    }

    public int getMAXIMO() {
        return MAXIMO;
    }

    public void setMAXIMO(int MAXIMO) {
        this.MAXIMO = MAXIMO;
    }

    public void setInformacion(Object[] informacion) {
        this.informacion = informacion;
    }

    @Override
    public boolean vacia() {
        if(tope == -1){
            return true;
        }
        return false;
    }

    private boolean validarRango(int indice){
        if(indice>=0 && indice<=tope){
            return true;
        }
        return false;
    }

    @Override
    public int agregar(Object info) {
        if(!llena()){
            tope+=1;
            informacion[tope] = info;
            return tope;
        }
        return -1;
    }

    @Override
    public void imprimir() {
        for(int celda=tope; celda >= 0; celda--){
            SalidaPorDefecto.terminal(informacion[celda] + "\n");
        }
    }

    @Override
    public void imprimirOI() {
        for(int celda=0; celda <= tope; celda++){
            SalidaPorDefecto.terminal(informacion[celda] + "\n");
        }
    }

    @Override
    public Object buscar(Object info) {
        int posicion=0;
        while(posicion<=tope && !info.toString().equalsIgnoreCase(informacion[posicion].toString())){
            posicion++;
        }
        if(posicion>tope){
            return -1;
        } else {
            return posicion;
        }
    }

    @Override
    public Object eliminarObjeto(Object info) {
        int posicion = (Integer)buscar(info);
        if(posicion>=0){ // si esta
            Object eliminado = informacion[posicion];
            tope--;
            for(int movs = tope; movs > posicion; movs--){
                informacion[movs] = informacion[movs+1];
            }
            return eliminado;
        }else { // no esta
            return null;
        }
    }

    @Override
    public boolean llena() {
        return tope == MAXIMO - 1;
    }

    @Override
    public int maximo() {
        return MAXIMO;
    }

    @Override
    public int cantidad() {
        return tope+1;
    }

    @Override
    public Object obtener(int indice) {
        if(validarRango(indice)){
            return informacion[indice];
        }
        return null;
    }

    @Override
    public boolean cambiar(int indice, Object info) {
        if(indice <= tope){
            informacion[indice] = info;
            return true;
        }
        return false;
    }

    @Override
    public boolean cambiarListaEstatica(ListaEstatica indicesBusqueda, ListaEstatica infosNuevos) {
        return false;
    }

    @Override
    public Object eliminar(int indice) {
        if(indice>=0 && indice <= tope) { // si esta
            Object eliminado = informacion[indice];
            tope--;
            for (int movs = indice; movs <= tope; movs++) {
                informacion[movs] = informacion[movs + 1];
            }
            return eliminado;
        }
        return null;
    }

    @Override
    public boolean redimensionar(int maximo) {
        ListaEstatica auxiliar = (ListaEstatica) clonar();
        MAXIMO = maximo;
        informacion = new Object[getMAXIMO()];
        for(int cadaIndice = 0; cadaIndice <= getTope(); cadaIndice++){
            informacion[cadaIndice] = auxiliar.obtener(cadaIndice);
        }
        return true;
    }

    public boolean recibeBuffer(Object[] buffer) {
        if(!vacia()) {
            for(int indiceArreglo = 0; indiceArreglo <= getTope(); indiceArreglo++){
                agregar(buffer[indiceArreglo]);
            }
            return true;
        }
        return false;
    }

    @Override
    public Object eliminarInicio() {
        return null;
    }


    @Override
    public boolean esIgual(Object lista2) {
        if(lista2 instanceof ListaEstatica){
           ListaEstatica lista2Estatica = (ListaEstatica) lista2;
            if(this.maximo() == (lista2Estatica.maximo())){
                for(int i = 0; i <= maximo()-1; i++){
                    if(!(informacion[i].toString().equalsIgnoreCase(lista2Estatica.getInformacion()[i].toString()))){
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean cambiar(Object infoViejo, Object infoNuevo, int numVeces) {
        if(numVeces <= tope){
            for(int i = 0; i < numVeces; i++){
                int posicion = (int) buscar(infoViejo);
                informacion[posicion] = infoNuevo;
            }
            return true;
        }
        return false;
    }

    //TODO
    @Override
    public ListaEstatica buscarValores(Object info) {
        int numeroInfo = 0;
        for(int indice = 0; indice <=tope; indice++){
            if(informacion[indice].toString().equalsIgnoreCase(info.toString())){
                numeroInfo++;
            }
        }
        ListaEstatica nuevaLista = new ListaEstatica(numeroInfo);
        for(int indice = 0; indice <=tope; indice++){
            if(informacion[indice].toString().equalsIgnoreCase(info.toString())){
               nuevaLista.agregar(indice);
            }
        }
        return nuevaLista;
    }

    @Override
    public Object eliminar() {
        Object objeto = informacion[getTope()];
        tope--;
        return objeto;
    }

    @Override
    public void vaciar() {
        tope = -1;
    }

    //todo
    @Override
    public boolean agregarLista(Object lista2) {
        if(lista2 instanceof ListaEstatica){
            for(int indice = 0; indice <= getMAXIMO()-1; indice++){
                agregar(((ListaEstatica) lista2).informacion[indice]);
            }
        }
        return false;
    }

    @Override
    public void invertir() {
        ListaEstatica listaAuxiliar = new ListaEstatica(getMAXIMO());
        for(int indice = 0; indice <= getTope(); indice++){
            listaAuxiliar.informacion[getTope()-indice] = informacion[indice];
        }
        for(int indice = 0; indice <= getTope(); indice++){
            informacion[indice] = listaAuxiliar.informacion[indice];
        }
    }

    @Override
    public int contar(Object info) {
        int contador = 0;
        for(int indice = 0; indice <= tope; indice++){
            if(info.toString().equalsIgnoreCase(informacion[indice].toString())){
                contador++;
            }
        }
        return contador;
    }

    @Override
    public void eliminarLista(Object lista2) {
        if (lista2 instanceof ListaEstatica lista2estatica) {
            for(int contador = 0;contador <= lista2estatica.getTope(); contador ++) {
                for (int cadaIndice = 0; cadaIndice <= getTope(); cadaIndice++) {
                    if ((int) Comparador.comparar(lista2estatica.obtener(contador), obtener(cadaIndice)) == 0) {
                        eliminar(cadaIndice);
                    }
                }
            }
        }
    }

    @Override
    public void rellenar(Object info, int cantidad) {
        if(cantidad <= MAXIMO-1){
            for(int indice = tope; indice <= cantidad; indice++){
                agregar(info);
            }
        }
    }

    @Override
    public Lista clonar() {
        ListaEstatica nuevaLista = new ListaEstatica(MAXIMO);
        for(int indice = 0; indice <= getTope(); indice++){
            nuevaLista.agregar(informacion[indice]);
        }
        return nuevaLista;
    }

    @Override
    public Lista subLista(int indiceInicial, int indiceFinal) {
        ListaEstatica nuevaLista = new ListaEstatica(indiceFinal-indiceInicial+1);
        if(indiceInicial <= indiceFinal){
            if(indiceInicial >= 0 && indiceInicial <= maximo()-1){
                if(indiceFinal >= 0 && indiceFinal <= maximo()-1){
                    for(int indice = indiceInicial; indice <= indiceFinal; indice++){
                        nuevaLista.agregar(informacion[indice]);
                    }
                }
            }
        }
        return nuevaLista;
    }

    @Override
    public ListaEstatica subLista(ListaEstaticaNumerica listaIndices) {
        ListaEstatica listaNueva = new ListaEstatica(listaIndices.getTope()+1);
        if(!vacia()){
            for(int indiceLista = 0; indiceLista <= listaIndices.getTope(); indiceLista++){
                if(obtener((int) listaIndices.obtener(indiceLista)) != null){
                    Object objeto = (obtener((int)listaIndices.obtener(indiceLista)));
                    listaNueva.agregar(objeto);
                }
            }
            return listaNueva;
        }
        return listaNueva;
    }

    @Override
    public Object verUltimo() {
        if(!vacia()){
            return informacion[getTope()];
        }
        return null;
    }

    public Object[] leerArreglo(){
        Object[] arregloAuxiliar = new Object[getMAXIMO()];
        for(int indiceArreglo = 0; indiceArreglo <= getTope(); indiceArreglo++){
            arregloAuxiliar[indiceArreglo] = informacion[indiceArreglo];
        }
        return arregloAuxiliar;
    }

}
