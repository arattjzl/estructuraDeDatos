package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamicaDoble;

public class PruebaListaDinamicaDoble {
    public static void main(String[] args) {
        ListaDinamicaDoble lista = new ListaDinamicaDoble();

        lista.imprimir();
        SalidaPorDefecto.terminal("\n");
        
        lista.agregar("d");
        lista.agregar("s");
        lista.agregar("y");
        lista.agregar("o");

        lista.imprimir();
        lista.eliminar();
        SalidaPorDefecto.terminal("\n");
        lista.imprimir();
    }
}
