package utils.matematicas;

import estructurasLineales.PilaEstatica;

public class ExpresionesMatematicas {
    
    public static String infijaAPostfija(String infija){
        return "";
    }
    
    public static String infijaAPrefija(String infija){
        return "";
    }
    
    public static Double evaluarPostfija(String postfija){
        PilaEstatica pila = new PilaEstatica(postfija.length());
        // 1. Tokenizar izq-der
        for(int cadaToken = 0; cadaToken < postfija.length(); cadaToken++) {
            char token = postfija.charAt(cadaToken);
            // 2. Si es operando, meter a pila
            if(esOperando("" + token)){
                if(pila.poner("" + token)){
                    return null;
                }
            } else {
                // 3. Si es operador, saca dos operaciones (el primero es op2)
                String operando2 = (String) pila.quitar();
                String operando1 = (String) pila.quitar();

                if(operando2 == null || operando1 == null){
                    return null;
                } else {
                    Double resultadoParcial = operacicon(Double.parseDouble(operando1), Double.parseDouble(operando2), token);
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
            // Aplicar operaciones con ellos
            // Meter el resultado en la pila
        }
        // 4. El resultado final esta en la pila
        return null;
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
        }
        return true;
    }

    public static Double operacicon(double operando1, double operando2, char operador){
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
            return Math.pow(operando2, operando1);
        } else if (operador=='%') {
            return operando1%operando2;
        }
        return null;
    }
}
