package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;

public class PruebaListaEstatica {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(5);

       lista.agregar(1);
       lista.agregar(2);
       lista.agregar(3);

       lista.rellenar(0,9);
       SalidaPorDefecto.terminal("\n");
       lista.imprimir();
    }
}
