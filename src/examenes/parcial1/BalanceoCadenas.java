package examenes.parcial1;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasLineales.PilaEstatica;

/**
 * Esta clase tiene los metodos para saber si una cadena se encuentra balanceada o no
 * @author Aratt
 * @version 1.0
 */
public class BalanceoCadenas {

    /**
     * Atributos para poder cambiar el color de la cadena en la línea de comandos.
     */
    public static final String rojo = "\u001B[31m";
    public static final String resetear = "\u001B[0m";

    /**
     * Se encarga de balancear una línea de código.
     * @param cadena Es la línea completa de código que está por balancearse.
     * @param lineaCodigo Es el número de línea en la que se encuentra.
     */
    public static void balancearCadena(String cadena, int lineaCodigo){
        PilaEstatica pila = new PilaEstatica(cadena.length());
        ListaEstatica lista = new ListaEstatica(cadena.length());
        for(int cadaCaracter = 0; cadaCaracter < cadena.length(); cadaCaracter++){
            char caracterCadena = cadena.charAt(cadaCaracter);
            lista.agregar(caracterCadena);
        }
        int posicionIndiceLista = 0;
        while (posicionIndiceLista <= lista.getTope()){
            char nuevoCaracter = (char)lista.obtener(posicionIndiceLista);
            if(nuevoCaracter == '(' || nuevoCaracter == '[' || nuevoCaracter == '{'){
                pila.poner(nuevoCaracter);
            } else if(nuevoCaracter == ')' || nuevoCaracter == ']' || nuevoCaracter == '}'){
                sacarParesPila(pila, nuevoCaracter);
            }
            posicionIndiceLista++;
        }
        if (!pila.vacia() || posicionIndiceLista != cadena.length()) {
            while (!pila.vacia()){
                char nuevoCaracter = (char) pila.quitar();
                int espacios = (int) lista.buscar(nuevoCaracter);
                SalidaPorDefecto.terminal(cadena + "\n");
                for(int cadaEspacio = 0; cadaEspacio < espacios; cadaEspacio++){
                    SalidaPorDefecto.terminal(" ");
                }
                if(nuevoCaracter == '('){
                    SalidaPorDefecto.terminal(rojo + "^ Falta un ')' en la linea " + lineaCodigo + "\n" + resetear);
                } else if(nuevoCaracter == ')'){
                    SalidaPorDefecto.terminal(rojo + "^ Falta un '(' en la linea " + lineaCodigo + "\n" + resetear);
                } else if(nuevoCaracter == '['){
                    SalidaPorDefecto.terminal(rojo + "^ Falta un ']' en la linea " + lineaCodigo + "\n" + resetear);
                } else if(nuevoCaracter == ']') {
                    SalidaPorDefecto.terminal(rojo + "^ Falta un '[' en la linea " + lineaCodigo + "\n" + resetear);
                } else if(nuevoCaracter == '{') {
                    SalidaPorDefecto.terminal(rojo + "^ Falta un '}' en la linea " + lineaCodigo + "\n" + resetear);
                } else if(nuevoCaracter == '}') {
                    SalidaPorDefecto.terminal(rojo + "^ Falta un '{' en la linea " + lineaCodigo + "\n" + resetear);
                } else {
                    SalidaPorDefecto.terminal(rojo + "^ Valor de variable no valido" + resetear);
                }
            }
        }
    }

    /**
     * Se encarga de encontrar los pares en la pila.
     * @param pila La pila en la cual tratará de encontrar los pares.
     * @param caracter Caracter del cual encontrará su par.
     */
    public static void sacarParesPila(PilaEstatica pila, char caracter){
        pila.poner(caracter);
        String nueva = "";
        while(!pila.vacia()){
            char nuevoCaracter = (char)pila.quitar();
            if(nuevoCaracter != caracter){
                nueva = nuevoCaracter + nueva;
            }
        }
        for(int cadaChar = 0; cadaChar < nueva.length(); cadaChar++){
            pila.poner(nueva.charAt(cadaChar));
        }
    }

    /**
     * Este método balancea un archivo.
     * @param archivo Es la ruta de acceso al archivo que se quiere balancear.
     */
    public static void balancearArchivo(String archivo){
        ListaEstatica listaLineasArchivo = ArchivoTexto.leer(archivo);
        if(listaLineasArchivo != null){
            for(int cadaLineaArchivo = 0; cadaLineaArchivo <= listaLineasArchivo.getTope(); cadaLineaArchivo++){
                String lineaActual = (String) listaLineasArchivo.obtener(cadaLineaArchivo);
                balancearCadena(lineaActual, cadaLineaArchivo+1);
            }
        } else {
            SalidaPorDefecto.terminal(rojo + "No se puede leer el archivo");
        }
    }
}
