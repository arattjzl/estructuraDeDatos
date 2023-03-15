package examenes.parcial1;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;

public class MenuExamen1 {
    public static void main(String[] args) {
        int opcionEscogida;
        do {
            SalidaPorDefecto.terminal("¿Que tipo de balanceo necesitas?\n");
            SalidaPorDefecto.terminal("1) Balanceo de cadena\n");
            SalidaPorDefecto.terminal("2) Balanceo de archivo\n");
            SalidaPorDefecto.terminal("3) Salir\n");
            opcionEscogida = EntradaPorDefecto.consolaDouble().intValue();
            switch (opcionEscogida) {
                case 1:
                    SalidaPorDefecto.terminal("Ingrese la cadena\n");
                    String cadena = EntradaPorDefecto.consolaCadenas();
                    BalanceoCadenas.balancearCadena(cadena, 1);
                    break;
                case 2:
                    SalidaPorDefecto.terminal("Ingrese la ruta del archivo\n");
                    String archivo = EntradaPorDefecto.consolaCadenas();
                    BalanceoCadenas.balancearArchivo(archivo);
                    break;
                default:
                    SalidaPorDefecto.terminal("Opcion no valida\n");
                    break;
            }
        } while (opcionEscogida != 3);
    }
}
