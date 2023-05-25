package metodosDeOrdenamiento;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import utils.commons.Comparador;

public class PancakeSort {

    private static int indiceMayor(ListaEstatica lista){
        int indiceMayor = 0;
        for(int cadaIndice = 0; cadaIndice <= lista.getTope(); cadaIndice++){
            if((int) Comparador.comparar(lista.obtener(cadaIndice), lista.obtener(indiceMayor)) > 0){
                indiceMayor = cadaIndice;
            }
        }
        return indiceMayor;
    }

    private static void cambio(ListaEstatica lista, int indiceMayor){
        for(int cadaIndice = 0; cadaIndice < indiceMayor; cadaIndice++){
            Object temporal = lista.obtener(cadaIndice);
            lista.cambiar(cadaIndice,lista.obtener(indiceMayor));
            lista.cambiar(indiceMayor, temporal);
            indiceMayor --;
        }
    }

    public static void sort(ListaEstatica lista){
        for(int tamanio = lista.getTope(); tamanio >= 1; tamanio--){
            int indiceMayor = indiceMayor(lista);
            if(indiceMayor != tamanio-1){
                cambio(lista, indiceMayor);
                cambio(lista, tamanio-1);
            }
        }
    }

    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(7);
        lista.agregar(23);
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(11);
        lista.agregar(12);
        lista.agregar(6);
        lista.agregar(7);

        lista.imprimir();
        SalidaPorDefecto.terminal("\n");
        sort(lista);
        lista.imprimir();
    }
}
