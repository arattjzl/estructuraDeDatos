package utils.matematicas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import estructurasLineales.auxiliares.Nodo;
import utils.commons.Comparador;

/**
 * Clase para polinomios.
 * @author Aratt
 * @version 1.0
 */
public class Polinomio {
    protected ListaDinamica polinomio;
    protected String poli;

    public Polinomio(String poli) {
        this.poli = poli;
        polinomio = new ListaDinamica();
        separar(poli);
    }

    /**
     * Separa el polinomio en monomios y los mete a la lista dinámica.
     * @param poli Es el polinomio.
     */
    public void separar(String poli){
        poli = quitar(poli);
        int exp = Integer.parseInt(String.valueOf(poli.charAt(0)));
        separar(poli, exp);
        polinomio.agregar("1");
    }

    /**
     * Separa el polinomio en monomios y los mete a la lista dinámica.
     * @param poli Es el polinomio.
     * @param exp Es el exponente el que va.
     */
    private void separar(String poli, int exp){
        if(poli.length() > 0){
            int valor = Integer.parseInt(String.valueOf(poli.charAt(0)));
            if(exp == valor){
                String porAgr = "x" + exp;
                if(exp == 1){
                    polinomio.agregar("x");
                } else {
                    polinomio.agregar(porAgr);
                }
                poli = poli.substring(1);
                separar(poli, exp-1);
            } else {
                polinomio.agregar("");
                separar(poli, exp-1);
            }
        }
    }

    /**
     * Del string polinomio, elimina todos los valores de operaciones y de "x".
     * @param poli Es el polinomio.
     * @return Regresa la string de polinomio sin esos valores.
     */
    public String quitar(String poli){
        return quitar(poli, 0);
    }

    /**
     * Del string polinomio, elimina todos los valores de operaciones y de "x".
     * @param poli Es el polinomio.
     * @param pos Posición del arreglo.
     * @return Regresa la string de polinomio sin esos valores.
     */
    private String quitar(String poli, int pos){
        String car = String.valueOf(poli.charAt(pos));
        if(pos < poli.length()-1){
            if(car.equals("+") || car.equals("-") || car.equals("*") || car.equals("/") || car.equals("x")){
                return quitar(poli, pos+1);
            } else {
                return car + quitar(poli, pos+1);
            }
        } else {
            return poli.charAt(poli.length()-1) + "";
        }
    }

    /**
     * Imprime la lista.
     */
    public void imprimir(){
        imprimirRecursivo(polinomio.getPrimero());
    }

    /**
     * Imprime la lista.
     * @param cadaNodo Nodo en el que se encuentra.
     */
    private void imprimirRecursivo(Nodo cadaNodo){
        if(cadaNodo != null){
            SalidaPorDefecto.terminal(cadaNodo.getInfo() + " -> ");
            imprimirRecursivo(cadaNodo.getApuntadorOtroNodo());
        } else {
            SalidaPorDefecto.terminal(null);
        }
    }

    /**
     * Convierte la lista a binario.
     * @return Regresa el valor binario.
     */
    public String aBinario(){
        return aBinario(polinomio.getPrimero());
    }

    /**
     * Convierte la lista a binario.
     * @param nodo Nodo en el que se encuentra.
     * @return egresa el valor binario.
     */
    private String aBinario(Nodo nodo){
        if(nodo != null && nodo.getInfo() != ""){
            return 1 + aBinario(nodo.getApuntadorOtroNodo());
        } else if(nodo != null && nodo.getInfo() == ""){
            return 0 + aBinario(nodo.getApuntadorOtroNodo());
        } else {
            return "";
        }
    }

    /**
     * Busca el valor que se indique.
     * @param info Es el valor por buscar.
     * @return Regresa el valor si se encontró o null si no.
     */
    public Object buscarRecursivo(Object info){
        return buscarRecursivo(info, polinomio.getPrimero());
    }

    /**
     * Busca el valor que se indique.
     * @param info Es el valor por buscar.
     * @param nodo Es el nodo en el que se encuentra.
     * @return Regresa el valor si se encontró o null si no.
     */
    private Object buscarRecursivo(Object info, Nodo nodo){
        if(nodo != null){
            if((int) Comparador.comparar(info, nodo.getInfo()) == 0){
                return info;
            } else {
                return buscarRecursivo(info, nodo.getApuntadorOtroNodo());
            }
        }
        return null;
    }
}
