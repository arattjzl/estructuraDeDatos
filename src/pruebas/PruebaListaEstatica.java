package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;

public class PruebaListaEstatica {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(5);
        ListaEstatica lista2 = new ListaEstatica(5);


        lista.agregar("Zacatecas");
        lista.agregar("Tokio");
        lista.agregar("Barcelona");
        lista.agregar("Shanghai");
        lista.agregar("Ontario");
        lista.imprimir();


        lista2.agregar("Barcelona");
        lista2.agregar("Shanghai");
        lista2.agregar("Ontario");

        lista.eliminarLista(lista2);
        SalidaPorDefecto.terminal("\n");
        lista.imprimir();
    }
}
