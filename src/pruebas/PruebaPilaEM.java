package pruebas;

import entradasalida.SalidaPorDefecto;
import utils.matematicas.ExpresionesMatematicas;

public class PruebaPilaEM {
    public static void main(String[] args) {
        SalidaPorDefecto.terminal("Ejecutando la operacion usando expresiones matematicas" + "\n");
        SalidaPorDefecto.terminal(ExpresionesMatematicas.evaluarPostfija("18+32*42^/-")+ "\n");
        SalidaPorDefecto.terminal(ExpresionesMatematicas.evaluarPrefija("-+18/*32^42") + "");
    }
}
