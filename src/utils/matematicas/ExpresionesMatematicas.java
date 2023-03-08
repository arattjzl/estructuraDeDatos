package utils.matematicas;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasLineales.PilaEstatica;

public class ExpresionesMatematicas {
    
    public static String infijaAPostfija(String infija){
        infija = tokenizador(infija);
        SalidaPorDefecto.terminal(infija);
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
                while (!pila.vacia() && (char)pila.verTope() != '(' && prioridadOperadores((char)pila.verTope()) >= prioridadOperadores(token)) {
                    postfija += pila.quitar();
                }
                pila.poner(token);
            }
        }
        while (!pila.vacia()) {
            postfija += pila.quitar();
        }
        return postfija;
    }
    
    public static String infijaAPrefija(String infija){
        infija = tokenizador(infija);
        SalidaPorDefecto.terminal(infija);
        PilaEstatica pila = new PilaEstatica(infija.length());
        String postfija = "";
        for (int cadaToken = infija.length() - 1; cadaToken >= 0; cadaToken--) {
            char token = infija.charAt(cadaToken);
            if (esOperando("" + token)) {
                postfija = token + postfija ;
            }
            else if (token == ')') {
                pila.poner(token);
            }
            else if (token == '(') {
                while (!pila.vacia() && (char)pila.verTope() != ')') {
                    postfija = pila.quitar() + postfija;
                }
                pila.quitar();
            }
            else {
                while (!pila.vacia() && (char)pila.verTope() != '(' && prioridadOperadores((char)pila.verTope()) > prioridadOperadores(token)) {
                    postfija = pila.quitar() + postfija;
                }
                pila.poner(token);
            }
        }
        while (!pila.vacia()) {
            postfija = pila.quitar() + postfija;
        }
        SalidaPorDefecto.terminal("\n" + postfija + "\n");
        return postfija;
    }
    
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
                    Double resultadoParcial = operacion(Double.parseDouble(operando1), Double.parseDouble(operando2), token);
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

    public static Double evaluarPrefija(String prefija){
        PilaEstatica pila = new PilaEstatica(prefija.length());
        // 1. Tokenizar izq-der
        for(int cadaToken = prefija.length()-1; cadaToken >= 0; cadaToken--) {
            char token = prefija.charAt(cadaToken);
            // 2. Si es operando, meter a pila
            if(esOperando("" + token)){
                if(!pila.poner("" + token)){
                    return null;
                }
            } else {
                // 3. Si es operador, saca dos operaciones (el primero es op2)
                String operando1 = (String) pila.quitar();
                String operando2 = (String) pila.quitar();

                if(operando2 == null || operando1 == null){
                    return null;
                } else {
                    Double resultadoParcial = operacion(Double.parseDouble(operando1), Double.parseDouble(operando2), token);
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

    private static int prioridadOperadores(char operador) {
        if(operador == '+' || operador == '-'){
            return 1;
        } else if(operador == '*' || operador == '/'){
            return 2;
        } else if(operador == '^'){
            return 3;
        } else return -1;
    }

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
