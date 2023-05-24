package utils.commons;



import estructurasLineales.ListaEstatica;

public class Separador {

    public static ListaEstatica separar(String cadena, String separador){
        int tamanio = 1;
        ListaEstatica lista = new ListaEstatica(tamanio);
        String cadaCadena = "";
        cadena = cadena + separador;
        for(int cadaIndex = 0; cadaIndex < cadena.length(); cadaIndex++){
            if(String.valueOf(cadena.charAt(cadaIndex)).equals(separador)){
                lista.redimensionar(tamanio++);
                lista.agregar(cadaCadena);
                cadaCadena = "";
            } else {
                cadaCadena += cadena.charAt(cadaIndex);
            }
        }
        return lista;
    }
}
