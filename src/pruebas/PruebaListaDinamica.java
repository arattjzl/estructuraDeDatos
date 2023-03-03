package pruebas;

import estructurasLineales.ListaDinamica;

public class PruebaListaDinamica {
    public static void main(String[] args) {
        ListaDinamica lista = new ListaDinamica();

        lista.agregar("a");
        lista.agregar("b");
        lista.agregar("z");
        lista.agregarPrincipio("s");

        lista.imprimir();
    }
}
