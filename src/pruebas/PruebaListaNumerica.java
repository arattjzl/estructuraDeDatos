package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasLineales.ListaEstaticaNumerica;

public class PruebaListaNumerica {
    public static void main(String[] args) {
        ListaEstaticaNumerica lista = new ListaEstaticaNumerica(5);
        ListaEstaticaNumerica lista2 = new ListaEstaticaNumerica(5);
        ListaEstaticaNumerica lista3 = new ListaEstaticaNumerica(5);
        ListaEstaticaNumerica lista4 = new ListaEstaticaNumerica(5);
        ListaEstatica lista5 = new ListaEstatica(5);

        lista.agregar(1);
        lista.agregar(-2);
        lista.agregar(4);
        lista.agregar(16);

        lista2.agregar(2);
        lista2.agregar(-4);
        lista2.agregar(8);
        lista2.agregar(32);

        lista.imprimirOI();
        SalidaPorDefecto.terminal("\n");
        lista.invertir();
        lista.imprimirOI();

    }
}
