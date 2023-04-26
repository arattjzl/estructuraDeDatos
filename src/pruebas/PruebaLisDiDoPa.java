package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamicaDobleParalela;

public class PruebaLisDiDoPa {
    public static void main(String[] args) {
        ListaDinamicaDobleParalela lista = new ListaDinamicaDobleParalela();

        SalidaPorDefecto.terminal(lista.agregar("a") + "");
        SalidaPorDefecto.terminal(lista.agregar("g") + "");
        SalidaPorDefecto.terminal(lista.agregar("b") + "");
        SalidaPorDefecto.terminal(lista.agregar("r") + "");
        SalidaPorDefecto.terminal(lista.agregar("c") + "");
        SalidaPorDefecto.terminal(lista.agregar("z") + "\n");

        lista.imprimir();
        SalidaPorDefecto.terminal("\n");
        lista.eliminar("r");
        lista.imprimir();
    }
}
