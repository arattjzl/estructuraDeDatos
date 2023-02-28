package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ColaEstatica;

public class PruebaColaEstatica {
    public static void main(String[] args) {
        ColaEstatica cola = new ColaEstatica(5);

        cola.poner("a");
        cola.poner("b");
        cola.poner("c");
        cola.poner("d");
        cola.poner("e");
        cola.poner("f");
        cola.imprimir();

        SalidaPorDefecto.terminal("\neliminando: " + cola.quitar() + "\n");
        SalidaPorDefecto.terminal("eliminando: " + cola.quitar() + "\n");

        cola.imprimir();
        cola.poner("z");
        SalidaPorDefecto.terminal("\n");
        cola.imprimir();
    }
}
