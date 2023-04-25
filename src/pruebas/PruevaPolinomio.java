package pruebas;

import utils.matematicas.Polinomio;

public class PruevaPolinomio {
    public static void main(String[] args) {
        Polinomio polinomio = new Polinomio("x5+x3+x-1");

        polinomio.imprimir();
    }
}
