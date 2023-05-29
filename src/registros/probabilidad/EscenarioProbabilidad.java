package registros.probabilidad;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import estructurasLineales.ListaEstatica;
import estructurasNoLineales.GrafoEstatico;
import estructurasNoLineales.auxiliares.Vertice;
import registros.commons.VariableEstadistica;
import utils.commons.Comparador;
import utils.commons.Separador;

/**
 * @author aratt
 * @author diego
 * @version 1.0
 */
public class EscenarioProbabilidad {
    /**
     * Es la estructura de datos utilizada para almacenar las variables(Es un GrafoEstático)
     */
    protected GrafoEstatico grafo;

    /**
     * Crea un escenario de probabilidad.
     * @param numNodos Número de nodos que tendrá el grafo.
     */
    public EscenarioProbabilidad(int numNodos){
        grafo = new GrafoEstatico(numNodos);
    }

    /**
     * Agrega un vértice información al grafo y si ya se encuentra dentro, agrega además una probabilidad la cual corresponde
     * al atributo nomPro.
     * @param info Nombre del vértice que se agregará.
     * @param nomPro Nombre de la probabilidad que se agregará.
     * @param probabilidad Nombre de la probabilidad que corresponde al nombre.
     * @return Regresa true si se agregó al grafo o false si no.
     */
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

    /**
     * Agrega aristas al entre el vértice.
     * @param origen Origen de la arista.
     * @param destino Destino de la arista.
     * @return Regresa true si se agregó la arista o false si no.
     */
    public boolean agregarArista(Object origen, Object destino){
        return grafo.agregarArista(origen, destino);
    }

    /**
     * Obtiene la sublista de probabilidades de vértice que se ingrese.
     * @param info Nombre del vértice.
     * @return Regresa la sublista del vértice ingresado.
     */
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

    /**
     * Imprime el nombre de todos los vértices del grafo.
     */
    public void imprimirPrimeros(){
        ListaEstatica vertices = grafo.getVertices();
        for(int cadaVertice = 0; cadaVertice <= vertices.getTope(); cadaVertice++){
            Vertice vertice = (Vertice) vertices.obtener(cadaVertice);
            ListaDinamica sublista = (ListaDinamica) vertice.getInfo();
            SalidaPorDefecto.terminal(sublista.getPrimero()+"\n");
        }
    }

    /**
     * Imprime la sublista del vértice ingresado.
     * @param cadena Nombre del vértice.
     */
    public void imprimirSublista(String cadena){
        ListaEstatica vertices = grafo.getVertices();
        for(int cadaVertice = 0; cadaVertice <= vertices.getTope(); cadaVertice++){
            Vertice vertice = (Vertice) vertices.obtener(cadaVertice);
            ListaDinamica sublista = (ListaDinamica) vertice.getInfo();
            if(sublista.getPrimero().getInfo().equals(cadena)){
                sublista.imprimir();
            }
        }
    }

    /**
     * Este método saca la probabilidad de una de las variables especifica y despues la imprime
     * @param cadena Es la cadena de la probabilidad a buscar
     */
    public void probabilidad(String cadena){
        ListaEstatica cadenaSeparada = Separador.separar(cadena, "|");
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

    /**
     * Busca la probabilidad de un variable que este dentro del grafo
     * @param probabilidad Es la cadena de la probabilidad a buscar
     * @return Regresa el valor de la probabilidad
     */
    private double buscarProbabilidad(String probabilidad){
        ListaEstatica cadenaSeparada = Separador.separar(probabilidad, "|");
        ListaEstatica vertices = grafo.getVertices();
        for(int cadaVertice = 0; cadaVertice <= vertices.getTope(); cadaVertice++){
            Vertice vertice = (Vertice) vertices.obtener(cadaVertice);
            ListaDinamica sublista = (ListaDinamica) vertice.getInfo();
            if(sublista.getPrimero().getInfo().equals(cadenaSeparada.obtener(0))){
                sublista.inicializarIterador();
                sublista.obtenerNodo();
                while(sublista.hayNodo()){
                    VariableEstadistica cadaVariable = (VariableEstadistica) sublista.obtenerNodo();
                    if(cadenaSeparada.obtener(1).equals(cadaVariable.getInfo())){
                        return cadaVariable.getProbabilidad();
                    }
                }
            }
        }
        return 0;
    }

    /**
     * Este método calcula la probabilidad conjunta de varias variables en el grafo
     * @param probabilidad Es la cadena de la probabilidad conjunta
     */
    public void probabilidadConjunta(String probabilidad){
        ListaEstatica nodos = Separador.separar(probabilidad, "*");
        ListaDinamica probabilidades = new ListaDinamica();
        for(int cadaNodo = 0; cadaNodo <= nodos.getTope(); cadaNodo++){
            probabilidades.agregar(buscarProbabilidad((String) nodos.obtener(cadaNodo)));
        }
        double probabilidadConjunta = 1;
        probabilidades.inicializarIterador();
        while(probabilidades.hayNodo()){
            double cadaProb = (double) probabilidades.obtenerNodo();
            probabilidadConjunta *= cadaProb;
        }
        SalidaPorDefecto.terminal("La probabildad conjunta es de: "+ probabilidadConjunta*100 + "%");
    }
}