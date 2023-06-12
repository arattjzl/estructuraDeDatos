package estructurasLineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.auxiliares.Nodo;
import utils.commons.Comparador;
import utils.commons.TipoCopia;

public class Conjunto {
    private ListaDinamica conjunto;

    public Conjunto(){
        conjunto = new ListaDinamica();
    }
    public Conjunto(ListaDinamica conjuntoNuevo){
        conjunto = new ListaDinamica();
        conjunto.agregarLista(conjuntoNuevo);
    }

    public ListaDinamica getConjunto() {
        return conjunto;
    }

    public void union(Conjunto otroConjunto){
        int total = otroConjunto.getConjunto().contarValores();
        union(otroConjunto,0, total);
    }

    private void union(Conjunto otroConjunto, int indice, int total){
        if(indice<total){
            Object cadaValor = otroConjunto.getConjunto().obtener(indice);
            conjunto.agregarSinRepetir(cadaValor);
            union(otroConjunto, indice+1, total);
        }
    }

    public void union(ListaEstatica lista){
        int total = lista.getMAXIMO();
        union(lista, 0, total);
    }

    private void union(ListaEstatica lista, int indice, int total){
        if(indice<total){
            Object cadaValor = lista.obtener(indice);
            conjunto.agregarSinRepetir(cadaValor);
            union(lista, indice+1, total);
        }
    }

    public void union(ListaDinamica listaDinamica){
        int total = listaDinamica.contarValores();
        union(listaDinamica, 0, total);
    }

    private void union(ListaDinamica listaDinamica, int indice, int total){
        if(indice<total){
            Object cadaValor = listaDinamica.obtener(indice);
            conjunto.agregarSinRepetir(cadaValor);
            union(listaDinamica, indice+1, total);
        }
    }

    public ListaDinamica interseccion(Conjunto conjuntoNevo){
        ListaDinamica intersec = new ListaDinamica();
        int total = conjuntoNevo.getConjunto().contarValores();
        return interseccion(conjuntoNevo, intersec, 0, total);
    }

    private ListaDinamica interseccion(Conjunto conjuntoNevo, ListaDinamica intersec, int indice, int total){
        if(indice<total){
            Object cadaValor = conjuntoNevo.getConjunto().obtener(indice);
            if(conjunto.buscar(cadaValor) != null){
                intersec.agregar(cadaValor);
            }
            return interseccion(conjuntoNevo, intersec, indice+1, total);
        }
        return intersec;
    }

    public ListaDinamica interseccion(ListaEstatica listaEstatica){
        ListaDinamica intersec = new ListaDinamica();
        int total = listaEstatica.getMAXIMO();
        return interseccion(listaEstatica, intersec, 0, total);
    }

    private ListaDinamica interseccion(ListaEstatica lista, ListaDinamica intersec, int indice, int total){
        if(indice<total){
            Object cadaValor = lista.obtener(indice);
            if(conjunto.buscar(cadaValor) != null){
                intersec.agregar(cadaValor);
            }
            return interseccion(lista, intersec, indice+1, total);
        }
        return intersec;
    }

    public ListaDinamica interseccion(ListaDinamica lista){
        ListaDinamica intersec = new ListaDinamica();
        int total = lista.contarValores();
        return interseccion(lista, intersec, 0, total);
    }

    private ListaDinamica interseccion(ListaDinamica lista, ListaDinamica intersec, int indice, int total){
        if(indice<total){
            Object cadaValor = lista.obtener(indice);
            if(conjunto.buscar(cadaValor) != null){
                intersec.agregar(cadaValor);
            }
            return interseccion(lista, intersec, indice+1, total);
        }
        return intersec;
    }

    public boolean esMiembro(Object info){
        return esMiembro(info, 0, conjunto.contarValores());
    }

    private boolean esMiembro(Object info, int indice, int total){
        if(indice<total){
            Object cadaValor = conjunto.obtener(indice);
            if((int) Comparador.comparar(info, cadaValor) == 0){
                return true;
            } else {
                return esMiembro(info,indice+1, total);
            }
        }
        return false;
    }

    public Object min(){
        Object minimo = conjunto.obtener(0);
        return min(minimo, 1, conjunto.contarValores());
    }

    private Object min(Object minimo, int indice, int total){
        if(indice<total){
            Object cadaValor = conjunto.obtener(indice);
            if((int) Comparador.comparar(cadaValor, minimo) < 0){
                minimo = cadaValor;
            }
            return min(minimo, indice+1, total);
        }
        return minimo;
    }

    public Object max(){
        Object max = conjunto.obtener(0);
        return max(max, 1, conjunto.contarValores());
    }

    private Object max(Object maximo, int indice, int total){
        if(indice<total){
            Object cadaValor = conjunto.obtener(indice);
            if((int) Comparador.comparar(cadaValor, maximo) > 0){
                maximo = cadaValor;
            }
            return max(maximo, indice+1, total);
        }
        return maximo;
    }

    public int insertar(Object info){
        return conjunto.agregar(info);
    }

    public Object suprime(Object info){
        return conjunto.eliminarObjeto(info);
    }

    public void diferencia(Conjunto otroConjunto){
        int total = otroConjunto.getConjunto().contarValores();
        diferencia(otroConjunto, 0, total);
    }

    private void diferencia(Conjunto otroConjunto, int indice, int total){
        if(indice<total){
            Object cadaValor = otroConjunto.conjunto.obtener(indice);
            conjunto.eliminarObjeto(cadaValor);
            diferencia(otroConjunto,indice+1,total);
        }
    }

    public void diferencia(ListaEstatica estatica){
        int total = estatica.getMAXIMO();
        diferencia(estatica, 0, total);
    }

    private void diferencia(ListaEstatica estatica, int indice, int total){
        if(indice<total){
            Object cadaValor = estatica.obtener(indice);
            conjunto.eliminarObjeto(cadaValor);
            diferencia(estatica,indice+1,total);
        }
    }

    public void diferencia(ListaDinamica dinamica){
        int total = dinamica.contarValores();
        diferencia(dinamica, 0, total);
    }

    private void diferencia(ListaDinamica dinamica, int indice, int total){
        if(indice<total){
            Object cadaValor = dinamica.obtener(indice);
            conjunto.eliminarObjeto(cadaValor);
            diferencia(dinamica,indice+1,total);
        }
    }

    public void imprimir(){
        int total = conjunto.contarValores();
        imprimir(0,total);
        SalidaPorDefecto.terminal(null);
    }

    private void imprimir(int indice, int total){
        if(indice<total){
            Object cadaValor = conjunto.obtener(indice);
            SalidaPorDefecto.terminal(cadaValor+" -> ");
            imprimir(indice+1, total);
        }
    }

    public void vaciar(){
        conjunto = new ListaDinamica();
    }

    public void sustituir(Object anterior, Object nuevo){
        int total = conjunto.contarValores();
        sustituir(anterior,nuevo,0,total);
    }

    public void copiar(int inicio, int fin, TipoCopia copia, Conjunto otroConjunto){
        int total = conjunto.contarValores();
        ListaDinamica nuevaLista = new ListaDinamica();
        ListaDinamica lista = nuevaLista(inicio,fin,0,total, nuevaLista);
        if(copia == TipoCopia.PRINCIPIO){
            agregarInicio(lista, lista.contarValores()-1, 0,otroConjunto);
        } else if(copia == TipoCopia.FINAL){
            agregarFinal(lista, 0, lista.contarValores(),otroConjunto);
        }
    }

    private ListaDinamica nuevaLista(int inicio, int fin, int indice, int total, ListaDinamica listaNueva){
        if(indice<total){
            if(indice>= inicio && indice<=fin){
                Object cadaValor = conjunto.obtener(indice);
                listaNueva.agregar(cadaValor);
            }
            return nuevaLista(inicio,fin,indice+1,total,listaNueva);
        }
        return listaNueva;
    }

    private void agregarInicio(ListaDinamica lista, int indice,int total, Conjunto otroConjunto){
        if(indice>=total){
            otroConjunto.getConjunto().agregarPrincipioSinrepetir(lista.obtener(indice));
            agregarInicio(lista,indice-1,total,otroConjunto);
        }
    }

    private void agregarFinal(ListaDinamica lista, int indice, int total, Conjunto otroConjunto){
        if(indice<total){
            otroConjunto.getConjunto().agregarSinRepetir(lista.obtener(indice));
            agregarFinal(lista,indice+1,total,otroConjunto);
        }
    }

    public void eliminar(int inicio, int fin){
        int total = conjunto.contarValores();
        ListaDinamica nuevaLista = new ListaDinamica();
        conjunto = eliminar(inicio,fin,0,total, nuevaLista);
    }

    private ListaDinamica eliminar(int inicio, int fin, int indice, int total, ListaDinamica lista){
        if(indice<total){
            if(indice<inicio || indice>fin){
                lista.agregar(conjunto.obtener(indice));
            }
            return eliminar(inicio,fin,indice+1,total,lista);
        }
        return lista;
    }

    private void sustituir(Object anterior, Object nuevo, int indice, int total){
        if(indice<total){
            Object cadaValor = conjunto.obtener(indice);
            if((int) Comparador.comparar(cadaValor, anterior) == 0){
                conjunto.cambiar(indice, nuevo);
            }
            sustituir(anterior,nuevo,indice+1,total);
        }
    }
}
