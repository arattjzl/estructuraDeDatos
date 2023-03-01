package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasNoLineales.Matriz2Numerica;

public class PruebaMatriz2Numerica {
    public static void main(String[] args) {
        Matriz2Numerica matriz = new Matriz2Numerica(2,2);

        matriz.cambiar(0,1, 1);
        matriz.cambiar(0,0, 1);
        matriz.cambiar(1,1, 1);
        matriz.cambiar(1,0, 1);

        matriz.imprimirPorColumna();
        matriz.potencia(2);
        SalidaPorDefecto.terminal("\n");
        matriz.imprimirPorColumna();
    }
}
