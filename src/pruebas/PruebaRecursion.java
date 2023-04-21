package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamicaClave;
import utils.PalabraDiccionario;
import utils.matematicas.ExpresionesMatematicas;

public class PruebaRecursion {
    public static void main(String[] args) {
        SalidaPorDefecto.terminal(ExpresionesMatematicas.aBinario(150) + "\n");
        SalidaPorDefecto.terminal(ExpresionesMatematicas.aBinario(999) + "\n");
        SalidaPorDefecto.terminal(ExpresionesMatematicas.aBinario(371) + "\n");
        SalidaPorDefecto.terminal(ExpresionesMatematicas.aBinario(420) + "\n");
    }
}
