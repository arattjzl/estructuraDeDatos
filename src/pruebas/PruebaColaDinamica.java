package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ColaDinamica;

public class PruebaColaDinamica {
    public static void main(String[] args) {
        ColaDinamica cola = new ColaDinamica();

        cola.poner("hola");
        cola.poner("como");
        cola.poner("estas");
        cola.poner("?");

        cola.imprimir();
        SalidaPorDefecto.terminal("\n" + cola.verTope());
    }
}
