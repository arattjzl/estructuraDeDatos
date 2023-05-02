package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasNoLineales.ArbolBinario;
import estructurasNoLineales.ArbolExArit;

public class PruebaABExArit {
    public static void main(String[] args) {
        ArbolExArit arbol = new ArbolExArit();

        arbol.crearArbol();
        SalidaPorDefecto.terminal("La altura del arbol es " + arbol.alturaArbol() + "\n");
        SalidaPorDefecto.terminal("\n\n\n\n\n\n\n\n\n\n\n\n");
        arbol.nivelSeEncuentra("promedio");
        arbol.nivelSeEncuentra("resta");
        arbol.nivelSeEncuentra("/");
        SalidaPorDefecto.terminal("\n\n\n\n\n\n\n\n\n\n\n\n");
        SalidaPorDefecto.terminal("En el nivel 3 hay " + arbol.elementosNivel(3) + " elementos\n");
        SalidaPorDefecto.terminal("En el nivel 4 hay " + arbol.elementosNivel(4) + " elementos");
        SalidaPorDefecto.terminal("\n\n\n\n\n\n\n\n\n\n\n\n");
        arbol.queNodoEs("promedio");
        arbol.queNodoEs("resta");
        arbol.queNodoEs("/");
        SalidaPorDefecto.terminal("\n\n\n\n\n\n\n\n\n\n\n\n");
        SalidaPorDefecto.terminal("La informacion /: \n");
        arbol.tieneHermano("/");
        SalidaPorDefecto.terminal("La informacion resta: \n");
        arbol.tieneHermano("resta");
        SalidaPorDefecto.terminal("La informacion ^: \n");
        arbol.tieneHermano("^");
    }
}
