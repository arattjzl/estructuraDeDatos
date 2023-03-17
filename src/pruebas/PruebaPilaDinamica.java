package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.PilaDinamica;

public class PruebaPilaDinamica {
    public static void main(String[] args) {
        PilaDinamica pila = new PilaDinamica();

        pila.poner("hola");
        pila.poner("como");
        pila.poner("estas");
        pila.poner("?");

        pila.imprimir();

    }
}
