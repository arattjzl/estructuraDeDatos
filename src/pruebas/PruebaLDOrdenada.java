package pruebas;

import estructurasLineales.ListaDinamica;
import estructurasLineales.ListaDinamicaOrdenada;
import estructurasLineales.ListaEstatica;
import utils.commons.TipoOrden;

public class PruebaLDOrdenada {
    public static void main(String[] args) {
        ListaDinamicaOrdenada lista = new ListaDinamicaOrdenada(TipoOrden.DEC);
        ListaDinamica listanueva = new ListaDinamica();
        lista.agregar(1);
        lista.agregar(7);
        lista.agregar(5);
        lista.agregar(3);
        lista.agregar(9);

        listanueva.agregar(1);
        listanueva.agregar(3);

        lista.eliminarLista(listanueva);
        lista.imprimir();
    }
}
