package utils.matematicas;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasLineales.PilaEstatica;

/**
 * Esta clase contiene métodos para poder utilizar expresiones aritméticas.
 * @author Aratt
 * @version 1.0
 */
public class ExpresionesMatematicas {

    /**
     * Convierte una expresión infija a una postfija.
     * @param infija Es la expresión infija.
     * @return Regresa la expresión de manera postfija.
     */
    public static String infijaAPostfija(String infija){
        infija = tokenizador(infija);
        SalidaPorDefecto.terminal(infija + "\n");
        PilaEstatica pila = new PilaEstatica(infija.length());
        String postfija = "";
        for (int cadaToken = 0; cadaToken < infija.length(); cadaToken++) {
            char token = infija.charAt(cadaToken);
            if (esOperando("" + token)) {
                postfija += token;
            }
            else if (token == '(') {
                pila.poner(token);
            }
            else if (token == ')') {
                while (!pila.vacia() && (char)pila.verTope() != '(') {
                    postfija += pila.quitar();
                }
                pila.quitar();
            }
            else {
                while (!pila.vacia() && (char)pila.verTope() != '('
                        && prioridadOperadores((char)pila.verTope()) >= prioridadOperadores(token)) {
                    postfija += pila.quitar();
                }
                pila.poner(token);
            }
        }
        while (!pila.vacia()) {
            postfija += pila.quitar();
        }
        SalidaPorDefecto.terminal("\n" + postfija + "\n");
        return postfija;
    }

    /**
     * Convierte una expresión infija a una prefija.
     * @param infija Expresión infija.
     * @return Regresa la expresión de manera prefija.
     */
    public static String infijaAPrefija(String infija){
        infija = tokenizador(infija);
        SalidaPorDefecto.terminal(infija + "\n");
        PilaEstatica pila = new PilaEstatica(infija.length());
        String prefija = "";
        for (int cadaToken = infija.length() - 1; cadaToken >= 0; cadaToken--) {
            char token = infija.charAt(cadaToken);
            if (esOperando("" + token)) {
                prefija = token + prefija ;
            }
            else if (token == ')') {
                pila.poner(token);
            }
            else if (token == '(') {
                while (!pila.vacia() && (char)pila.verTope() != ')') {
                    prefija = pila.quitar() + prefija;
                }
                pila.quitar();
            }
            else {
                while (!pila.vacia() && (char)pila.verTope() != '('
                        && prioridadOperadores((char)pila.verTope()) > prioridadOperadores(token)) {
                    prefija = pila.quitar() + prefija;
                }
                pila.poner(token);
            }
        }
        while (!pila.vacia()) {
            prefija = pila.quitar() + prefija;
        }
        SalidaPorDefecto.terminal("\n" + prefija + "\n");
        return prefija;
    }

    /**
     * Evalúa la expresión postfija.
     * @param postfija Es una expresión postfija.
     * @return Regresa el valor de la expresión.
     */
    public static Double evaluarPostfija(String postfija){
        PilaEstatica pila = new PilaEstatica(postfija.length());
        // 1. Tokenizar izq-der
        for(int cadaToken = 0; cadaToken < postfija.length(); cadaToken++) {
            char token = postfija.charAt(cadaToken);
            // 2. Si es operando, meter a pila
            if(esOperando("" + token)){
                if(!pila.poner("" + token)){
                    return null;
                }
            } else {
                // 3. Si es operador, saca dos operaciones (el primero es op2)
                String operando2 = (String) pila.quitar();
                String operando1 = (String) pila.quitar();

                if(operando2 == null || operando1 == null){
                    return null;
                } else {
                    Double resultadoParcial = operacion(Double.parseDouble(operando1),
                            Double.parseDouble(operando2), token);
                    if (resultadoParcial == null) {
                        return null;
                    } else {
                        boolean resultadoPila = pila.poner("" + resultadoParcial);
                        if(!resultadoPila){
                            return null;
                        }
                    }
                }
            }
        }
        // Aplicar operaciones con ellos
        // Meter el resultado en la pila
        String resultado = (String) pila.quitar();
        if(resultado!=null){
            return Double.parseDouble(resultado);
        }
        return null;
        // 4. El resultado final esta en la pila
    }

    /**
     * Efectúa la evaluación del una expresión prefija.
     * @param prefija Es la expresión prefija.
     * @return Regresa el valor de la expresión.
     */
    public static Double evaluarPrefija (String prefija){
        PilaEstatica pila = new PilaEstatica(prefija.length());
        for (int cadaToken = prefija.length() -1; cadaToken >= 0; cadaToken--){
            //1. Tokenizar der-izq
            char token = prefija.charAt(cadaToken);
            //2. Si es opernado, meter a la pila
            if (esOperando("" + token)){
                boolean resultadoPila = pila.poner("" + token);
                if (!resultadoPila){
                    return null;
                }
            } else { //es operador
                //3. Si es operador, sacar 2 operandos
                // (el primero es op1)
                String operando1 = (String) pila.quitar();
                String operando2 = (String) pila.quitar();

                if (operando1 == null || operando2 == null){
                    return null;
                } else {
                    //Aplicar la operacion con ellos
                    Double resultadoParcial = operacion(Double.parseDouble(operando1), Double.parseDouble(operando2), token);
                    //Meter el resultado en la pila
                    if (resultadoParcial == null){
                        return null;
                    } else {
                        boolean resultadoPila = pila.poner("" + resultadoParcial);
                        if (!resultadoPila){
                            return null;
                        }
                    }
                }
            }
        }
        //4. el resultado final esta en la pila.
        String resultadoFinal = (String)pila.quitar();
        if (resultadoFinal != null) {
            return Double.parseDouble(resultadoFinal);
        } else {
            return null;
        }
    }

    /**
     * Verifica si el token es un operando.
     * @param token Token a verificar.
     * @return  Regresa <b>true</b> si es un operando y <b>false</b> si no lo es.
     */
    public static boolean esOperando(String token){
        if(token.equalsIgnoreCase("+")){
            return false;
        } else if(token.equalsIgnoreCase("-")){
            return false;
        } else if(token.equalsIgnoreCase("/")){
            return false;
        } else if(token.equalsIgnoreCase("*")){
            return false;
        } else if(token.equalsIgnoreCase("^")){
            return false;
        } else if(token.equalsIgnoreCase("%")){
            return false;
        } else if(token.equalsIgnoreCase("(")){
            return false;
        } else if(token.equalsIgnoreCase(")")){
            return false;
        } else if(token.equalsIgnoreCase("[")){
            return false;
        } else if(token.equalsIgnoreCase("]")){
            return false;
        }
        return true;
    }

    /**
     * Verifica si el token es un valor numérico.
     * @param token Token a verificar.
     * @return Regresa <b>true</b> si no es número o <b>false</b> si lo es.
     */
    public static boolean noEsNumero(String token){
        if(token.equalsIgnoreCase("1")){
            return false;
        } else if(token.equalsIgnoreCase("2")){
            return false;
        } else if(token.equalsIgnoreCase("3")){
            return false;
        } else if(token.equalsIgnoreCase("4")){
            return false;
        } else if(token.equalsIgnoreCase("5")){
            return false;
        } else if(token.equalsIgnoreCase("6")){
            return false;
        } else if(token.equalsIgnoreCase("7")){
            return false;
        } else if(token.equalsIgnoreCase("8")){
            return false;
        } else if(token.equalsIgnoreCase("9")){
            return false;
        } else if(token.equalsIgnoreCase("0")){
            return false;
        }
        return true;
    }

    /**
     * Efectua la operación entre los dos operandos y el operador.
     * @param operando1 Primer operando.
     * @param operando2 Segundo operando.
     * @param operador Es operación que se realizará.
     * @return Regresa el valor de la operación.
     */
    public static Double operacion(double operando1, double operando2, char operador){
        if(operador=='+'){
            return operando1 + operando2;
        } else if (operador=='-') {
            return operando1 - operando2;
        } else if (operador=='/') {
            if(operando2==0){
                return null;
            }
            return operando1/operando2;
        } else if(operador=='*'){
            return operando1*operando2;
        } else if(operador=='^'){
            return Math.pow(operando1, operando2);
        } else if (operador=='%') {
            return operando1%operando2;
        }
        return null;
    }

    /**
     * Nos dice que prioridad tiene el operador.
     * @param operador Es el operador del cual queremos saber su prioridad.
     * @return Regresa el valor de la prioridad, entre más bajo el entero, menos prioridad.
     */
    private static int prioridadOperadores(char operador) {
        if(operador == '+' || operador == '-'){
            return 1;
        } else if(operador == '*' || operador == '/'){
            return 2;
        } else if(operador == '^'){
            return 3;
        } else return -1;
    }

    /**
     * Realiza la tokenización de la función que le pases como parámetro.
     * @param infija Función matemática a tokenizar.
     * @return Regresa la función lista para convertirla a una expresión postfija o prefija.
     */
    public static String tokenizador(String infija){
        ListaEstatica lista = new ListaEstatica(infija.length());
        int cadaToken = 0;
        while(cadaToken < infija.length()){
            String nuevaVariable = "";
            if(!noEsNumero(infija.charAt(cadaToken) + "")) {
                lista.agregar(infija.charAt(cadaToken));
            } else if(!esOperando(infija.charAt(cadaToken) + "")){
                lista.agregar(infija.charAt(cadaToken));
            } else if(esOperando(infija.charAt(cadaToken) + "") && infija.charAt(cadaToken) != ' '){
                while(esOperando(infija.charAt(cadaToken) + "")) {
                    nuevaVariable += infija.charAt(cadaToken);
                    cadaToken++;
                }
                SalidaPorDefecto.terminal("Que valor tiene la variable " + nuevaVariable + "\n");
                nuevaVariable = EntradaPorDefecto.consolaCadenas();
                lista.agregar(nuevaVariable);
                lista.agregar(infija.charAt(cadaToken));
            }
            cadaToken++;
        }
        String nuevaInfija = "";
        for(int nuevoToken = 0; nuevoToken <= lista.getTope(); nuevoToken++){
            nuevaInfija += lista.obtener(nuevoToken);
        }
        return nuevaInfija;
    }
}
