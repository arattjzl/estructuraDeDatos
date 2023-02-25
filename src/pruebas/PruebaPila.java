package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.PilaEstatica;
public class PruebaPila {
    public static void main(String[] args) {
        PilaEstatica pila = new PilaEstatica(5);
        pila.poner("a");
        pila.poner("r");
        pila.poner("t");
        pila.poner("y");
        pila.poner("u");
        pila.imprimir();
        SalidaPorDefecto.terminal("Eliminar; "+ pila.quitar()+"\n");
        pila.imprimir();
        SalidaPorDefecto.terminal("Tope; "+ pila.verTope()+"\n");
        }
}
    