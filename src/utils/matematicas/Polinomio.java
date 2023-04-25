package utils.matematicas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import estructurasLineales.auxiliares.Nodo;

public class Polinomio {
    protected ListaDinamica polinomio;

    public Polinomio(String poli) {
        polinomio = new ListaDinamica();
        separar(poli);
    }

    public void separar(String poli){
        String cadaValor = "";
        for(int cadaPos = 0; cadaPos < poli.length(); cadaPos++){
            String cadaChar = String.valueOf(poli.charAt(cadaPos));
            if(cadaChar.equals("+") || cadaChar.equals("-")){
                polinomio.agregar(cadaValor);
                cadaValor = "";
            } else {
                cadaValor = cadaValor + cadaChar;
            }
        }
    }

    public void imprimir(){
        polinomio.imprimirRecursivo();
    }
}
