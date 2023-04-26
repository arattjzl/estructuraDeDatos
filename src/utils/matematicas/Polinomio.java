package utils.matematicas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import estructurasLineales.auxiliares.Nodo;
import utils.commons.Comparador;

public class Polinomio {
    protected ListaDinamica polinomio;
    protected String poli;

    public Polinomio(String poli) {
        this.poli = poli;
        polinomio = new ListaDinamica();
        separar(poli);
    }

    public void separar(String poli){
        poli = quitar(poli);
        int exp = Integer.parseInt(String.valueOf(poli.charAt(0)));
        separar(poli, exp);
        polinomio.agregar("1");
    }

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

    public String quitar(String poli){
        return quitar(poli, 0);
    }

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

    public void imprimir(){
        imprimirRecursivo(polinomio.getPrimero());
    }

    private void imprimirRecursivo(Nodo cadaNodo){
        if(cadaNodo != null){
            SalidaPorDefecto.terminal(cadaNodo.getInfo() + " -> ");
            imprimirRecursivo(cadaNodo.getApuntadorOtroNodo());
        } else {
            SalidaPorDefecto.terminal(null);
        }
    }

    public String aBinario(){
        return aBinario(polinomio.getPrimero());
    }

    private String aBinario(Nodo nodo){
        if(nodo != null && nodo.getInfo() != ""){
            return 1 + aBinario(nodo.getApuntadorOtroNodo());
        } else if(nodo != null && nodo.getInfo() == ""){
            return 0 + aBinario(nodo.getApuntadorOtroNodo());
        } else {
            return "";
        }
    }

    public Object buscarRecursivo(Object info){
        return buscarRecursivo(info, polinomio.getPrimero());
    }

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
