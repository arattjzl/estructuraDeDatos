package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;

public class PruebaListaDinamica {
    public static void main(String[] args) {
        ListaDinamica lista = new ListaDinamica();

        lista.agregar("a");
        lista.agregar("b");
        lista.agregar("z");
        lista.agregarPrincipio("s");

        lista.imprimir();
        lista.eliminar();
        SalidaPorDefecto.terminal("\n");
        lista.imprimir();
        lista.eliminarInicio();
        SalidaPorDefecto.terminal("\n");
        lista.imprimir();
    }
}
