package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import estructurasLineales.ListaEstatica;
import estructurasLineales.ListaEstaticaNumerica;

public class PruebaListaDinamica {
    public static void main(String[] args) {
        ListaDinamica lista = new ListaDinamica();
        ListaEstaticaNumerica listaNum = new ListaEstaticaNumerica(4);

        listaNum.agregar(1);
        listaNum.agregar(3);
        listaNum.agregar(0);

        lista.agregar("a");
        lista.agregar("b");
        lista.agregar("z");
        lista.agregar("h");
        lista.agregar("i");
        lista.agregar("r");
        lista.agregar("z");

        lista.imprimir();
        SalidaPorDefecto.terminal("\n");
        lista.subLista(listaNum).imprimir();
    }
}
