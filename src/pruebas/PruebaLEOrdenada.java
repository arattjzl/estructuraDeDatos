package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstaticaOrdenada;
import utils.commons.TipoOrden;

public class PruebaLEOrdenada {
    public static void main(String[] args) {
        ListaEstaticaOrdenada lista = new ListaEstaticaOrdenada(5, TipoOrden.INC);
        ListaEstaticaOrdenada lista2 = new ListaEstaticaOrdenada(3, TipoOrden.INC);

        lista.agregar(5);
        lista.agregar(2);
        lista.agregar(3);
        lista.agregar(1);
        lista.agregar(4);

        lista2.agregar(1);
        lista2.agregar(3);
        lista2.agregar(5);


        lista.retenerLista(lista2);
        lista.imprimirOI();
    }
}
