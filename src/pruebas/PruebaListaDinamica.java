package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import estructurasLineales.ListaEstatica;
import estructurasLineales.ListaEstaticaNumerica;
import estructurasNoLineales.Matriz2;
import utils.commons.TipoTabla;

public class PruebaListaDinamica {
    public static void main(String[] args) {
        ListaDinamica lista = new ListaDinamica();

        lista.agregar("a");
        lista.agregar("b");
        lista.agregar("z");
        lista.agregar("o");
        lista.agregar("p");
        lista.agregar("r");
        lista.agregar("q");


        lista.imprimir();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("\n");
        lista.subLista(1, 4).imprimir();
    }
}
