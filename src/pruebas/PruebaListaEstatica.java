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

        lista2.agregar("Tokio");
        lista2.agregar("Tokio");
        lista2.agregar("Rio de Janeiro");
        lista2.agregar("Buenos Aires");
        lista2.agregar("Zacatecas");


        lista.imprimirOI();
        System.out.println("\n");
        lista.invertir();
        lista.imprimirOI();

    }
}
