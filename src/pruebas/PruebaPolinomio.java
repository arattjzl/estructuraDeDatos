package pruebas;

import entradasalida.SalidaPorDefecto;
import utils.matematicas.Polinomio;

public class PruebaPolinomio {
    public static void main(String[] args) {
        Polinomio polinomio = new Polinomio("x5+x3+x-1");

        polinomio.imprimir();
        SalidaPorDefecto.terminal("\n" + polinomio.aBinario());
        SalidaPorDefecto.terminal("\n" + polinomio.buscarRecursivo("x2"));
    }
}
