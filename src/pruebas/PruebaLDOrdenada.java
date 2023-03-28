package pruebas;

import estructurasLineales.ListaDinamicaOrdenada;
import utils.commons.TipoOrden;

public class PruebaLDOrdenada {
    public static void main(String[] args) {
        ListaDinamicaOrdenada lista = new ListaDinamicaOrdenada(TipoOrden.DEC);
        lista.agregar(8);
        lista.agregar(9);
        lista.agregar(5);
        lista.agregar(1);
        lista.imprimir();
    }
}
