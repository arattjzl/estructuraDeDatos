package registros.probabilidad;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.Lista;
import estructurasLineales.ListaDinamica;
import estructurasLineales.ListaEstatica;
import estructurasLineales.auxiliares.Nodo;
import estructurasNoLineales.GrafoEstatico;
import estructurasNoLineales.auxiliares.Vertice;
import registros.commons.VariableEstadistica;
import utils.commons.Comparador;
import utils.commons.Separador;

public class EscenarioProbabilidad {
    protected GrafoEstatico grafo;

    public EscenarioProbabilidad(int numNodos){
        grafo = new GrafoEstatico(numNodos);
    }

    public boolean agregarVertice(Object info, Object nomPro, double probabilidad){
        ListaDinamica sublisa = obetenerPrimerValorVertice(info);
        VariableEstadistica nuevaVariable = new VariableEstadistica(nomPro, probabilidad);
        if(sublisa.vacia()){
            ListaDinamica lista = new ListaDinamica();
            lista.agregar(info);
            lista.agregar(nuevaVariable);
            return grafo.agregarVertice(lista);
        } else {
            sublisa.agregar(nuevaVariable);
            return true;
        }
    }

    public boolean agregarArista(Object origen, Object destino){
        return grafo.agregarArista(origen, destino);
    }

    private ListaDinamica obetenerPrimerValorVertice(Object info){
        ListaEstatica vertices = grafo.getVertices();
        ListaDinamica lista = new ListaDinamica();
        if(!vertices.vacia()) {
            for (int cadaNodo = 0; cadaNodo <= vertices.getTope(); cadaNodo++) {
                Vertice vertice = (Vertice) vertices.obtener(cadaNodo);
                ListaDinamica sublista = (ListaDinamica) vertice.getInfo();
                if ((int) Comparador.comparar(sublista.getPrimero().getInfo(), info) == 0) {
                    return sublista;
                }
            }
        }
        return lista;
    }

    public void imprimir(){
        ListaEstatica vertices = grafo.getVertices();
        for(int cadaVertice = 0; cadaVertice <= vertices.getTope(); cadaVertice++){
            Vertice vertice = (Vertice) vertices.obtener(cadaVertice);
            ListaDinamica sublista = (ListaDinamica) vertice.getInfo();
            sublista.imprimir();
            SalidaPorDefecto.terminal("\n");
        }
    }

    public void probabilidad(String cadena){
        ListaEstatica cadenaSeparada = Separador.separar(cadena, "|");
        cadenaSeparada.imprimir();
        ListaEstatica vertices = grafo.getVertices();
        for(int cadaVertice = 0; cadaVertice <= vertices.getTope(); cadaVertice++){
            Vertice vertice = (Vertice) vertices.obtener(cadaVertice);
            ListaDinamica sublista = (ListaDinamica) vertice.getInfo();
            if(sublista.getPrimero().getInfo().equals(cadenaSeparada.obtener(0))){
                if(cadenaSeparada.getMAXIMO() == 2){
                    sublista.inicializarIterador();
                    sublista.obtenerNodo();
                    while(sublista.hayNodo()){
                        VariableEstadistica variable = (VariableEstadistica) (sublista.obtenerNodo());
                        String nombre = (String) variable.getInfo();
                        ListaEstatica subnombre = Separador.separar(nombre, "-");
                        if(subnombre.obtener(1).equals(cadenaSeparada.obtener(1))){
                            SalidaPorDefecto.terminal(subnombre.obtener(0) + " tiene de porcentaje de probabilidad: " + variable.getProbabilidad()*100 + "%" + "\n");
                        }
                    }
                } else {
                    sublista.inicializarIterador();
                    sublista.obtenerNodo();
                    while(sublista.hayNodo()){
                        VariableEstadistica variable = (VariableEstadistica) (sublista.obtenerNodo());
                        String nombre = (String) variable.getInfo();
                        SalidaPorDefecto.terminal(nombre + " tiene de porcentaje de probabilidad: " + variable.getProbabilidad()*100 + "%" + "\n");
                    }
                }
            }
        }
    }
}