package pruebas;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import utils.matematicas.ExpresionesMatematicas;

public class PruebaPilaEM {
    public static void main(String[] args) {
        SalidaPorDefecto.terminal("Ingrese la expresion: \n");
        String infija = EntradaPorDefecto.consolaCadenas();
        SalidaPorDefecto.terminal("Evaluando expresión prefija: \n");
        SalidaPorDefecto.terminal(ExpresionesMatematicas.evaluarPrefija(ExpresionesMatematicas.infijaAPrefija(infija)) + "");

    }
}
