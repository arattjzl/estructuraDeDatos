package registros.probabilidad;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamicaClave;
import estructurasLineales.ListaEstatica;
import estructurasNoLineales.GrafoEstatico;
import estructurasNoLineales.auxiliares.Vertice;
import registros.commons.AtributosMOM;
import utils.commons.Comparador;
import utils.commons.Separador;


/**
 * @author aratt
 * @author diego
 * @version 1.0
 */
public class ModeloOcultoMarkov {
    protected GrafoEstatico grafo;

    public ModeloOcultoMarkov(int numEstados){
        grafo = new GrafoEstatico(numEstados);
    }

    /**
     * Agrega un estado al MOM.
     * @param estado Nombre del estado.
     * @param probabilidadInicial Probabilidad inicial de este estado.
     * @return Regresa true si se agregó o false si no.
     */
    public boolean agregarEstado(Object estado, double probabilidadInicial){
        AtributosMOM atributos = new AtributosMOM();
        atributos.setEstado(estado.toString());
        atributos.setProbabilidadInicio(probabilidadInicial);
        return grafo.agregarVertice(atributos);
    }

    /**
     * Agrega una probabilidad de emisión.
     * @param estado Nombre del estado.
     * @param clave Nombre de la observación.
     * @param probabilidad Probabilidad de la observación.
     * @return Regresa true si se agregó o false si no.
     */
    public boolean agregarProbabilidadEmision(Object estado, Object clave, double probabilidad){
        for(int cadaVertice = 0; cadaVertice<grafo.getVertices().cantidad(); cadaVertice++){
            Vertice vertice = (Vertice)grafo.getVertices().obtener(cadaVertice);
            AtributosMOM atributo = (AtributosMOM)vertice.getInfo();
            if(estado.toString().equalsIgnoreCase(atributo.getEstado())){
                ListaDinamicaClave lista = atributo.getProbabilidadEmision();
                  return lista.agregar(clave, probabilidad);
            }
        }
        return false;
    }

    /**
     * Agrega una probabilidad de transición entre el estado origen y el destino y su probabilidad.
     * @param estadoOrigen Estado origen.
     * @param estadoDestino Estado destino.
     * @param probabilidad Probabilidad del cambio.
     * @return Regresa true si se agregó o false si no.
     */
    public boolean agregarProbabilidadTransicion(Object estadoOrigen, Object estadoDestino, double probabilidad){
        return grafo.agregarArista(estadoOrigen, estadoDestino, probabilidad);
    }

    /**
     * Imprime el grafo con toda su inforamción.
     */
    public void imprimir(){
        ListaEstatica lista = grafo.getVertices();
        for(int cadaIndice = 0; cadaIndice <= lista.getTope(); cadaIndice++){
            Vertice cadaVertice = (Vertice) lista.obtener(cadaIndice);
            AtributosMOM cadaAtributo = (AtributosMOM) cadaVertice.getInfo();
            SalidaPorDefecto.terminal(cadaAtributo.getEstado() + "\nProbabilidad de inicio: " + cadaAtributo.getProbabilidadInicio() + "\nProbabilidad de emision: ");
            cadaAtributo.getProbabilidadEmision().imprimir();
            SalidaPorDefecto.terminal("\n\n");
        }
        SalidaPorDefecto.terminal("\n\n");
        grafo.getAristas().imprimirPorColumna();
    }

    /**
     * Regresa el estado inicial del estado que se indique.
     * @param estado Estado.
     * @return Regresa la probabilidad inicial del estado indicado.
     */
    public double inicioEstado(String estado){
        ListaEstatica lista = grafo.getVertices();
        for(int cadaIndice = 0; cadaIndice <= lista.getTope(); cadaIndice++){
            Vertice vertice = (Vertice) lista.obtener(cadaIndice);
            AtributosMOM atributos = (AtributosMOM) vertice.getInfo();
            if((int) Comparador.comparar(estado, atributos.getEstado()) == 0){
                return atributos.getProbabilidadInicio();
            }
        }
        return 0.0;
    }

    /**
     * Obtiene la probabilidad de que se realice una actividad dado el estado y la observación.
     * @param estado Estado.
     * @param observacion Observación.
     * @return Regresa la probabilidad de que se realice.
     */
    public double probabilidadDeRealizarActividad(String estado, String observacion){
        ListaEstatica lista = grafo.getVertices();
        for(int cadaIndice = 0; cadaIndice <= lista.getTope(); cadaIndice++){
            Vertice vertice = (Vertice) lista.obtener(cadaIndice);
            AtributosMOM atributos = (AtributosMOM) vertice.getInfo();
            if((int) Comparador.comparar(estado, atributos.getEstado()) == 0){
                ListaDinamicaClave observaciones = atributos.getProbabilidadEmision();
                return (double) observaciones.buscar(observacion);
            }
        }
        return 0.0;
    }

    /**
     * Obtiene la probabilidad de que se pase de cierto estado a otro estado dado por la transición.
     * @param estado Estado inicial.
     * @param estadoTras Estado de transición.
     * @return Regresa la probabilidad de este suceso.
     */
    public double probabilidadCiertoEstado(String estado, String estadoTras){
        ListaEstatica lista = grafo.getVertices();
        int indiceEstado = (int) lista.buscar(estado);
        int indiceEstadoTrans = (int) lista.buscar(estadoTras);
        return (double) grafo.getAristas().obtener(indiceEstado, indiceEstadoTrans);
    }

    /**
     * Obtiene la probabilidad de una secuencia de estados.
     * @param secuencia Secuencia de estados.
     * @return Regresa la probabilidad de este suceso.
     */
    public double pobabilidadDeSecuenciaDeEstados(String secuencia){
        ListaEstatica listaSecuencias = Separador.separar(secuencia, ",");
        ListaEstatica listaVertices = grafo.getVertices();
        double probabilidad = 1;
        for(int cadaSecuencia = 1; cadaSecuencia <= listaSecuencias.getTope(); cadaSecuencia++){
            int indiceEstado = (int) listaVertices.buscar(listaSecuencias.obtener(cadaSecuencia-1));
            int indiceEstadoTrans = (int) listaVertices.buscar(listaSecuencias.obtener(cadaSecuencia));
            double nuevaProb = (double) grafo.getAristas().obtener(indiceEstado, indiceEstadoTrans);
            probabilidad *= nuevaProb;
        }
        return probabilidad;
    }
}