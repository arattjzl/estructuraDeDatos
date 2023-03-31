package registros.usoComputadoras;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import estructurasLineales.auxiliares.Nodo;
import utils.commons.Comparador;

public class ControlCentroComputo {
    protected ListaDinamica listaComputadoras;

    public ControlCentroComputo(){
        listaComputadoras = new ListaDinamica();
    }

    /**
     * Agrega computadoras al centro de control de computadoras.
     * @param computadora Es un objeto de tipo computadora con sus atributos.
     * @return Regresa verdadero si se agrego o falso si no.
     */
    public boolean agregarComputadora(Computadora computadora){
        int agregado = listaComputadoras.agregar(computadora);
        return agregado > 0;
    }

    /**
     * Imprime los detalles de todas las computadoras.
     */
    public void imprimirDetallesComputadoras(){
        listaComputadoras.inicializarIterador();
        while (listaComputadoras.hayNodo()){
            ((Computadora)listaComputadoras.obtenerNodo()).imprimirDatosComputadora();
            SalidaPorDefecto.terminal("\n");
        }
    }

    /**
     * Imprime los detalles de la computadora que coincida con el número de computadora pasado como atributo.
     * @param numComputadora Es el número de la computadora.
     */
    public void imprimirCaracteristicaComputadora(int numComputadora){
        listaComputadoras.inicializarIterador();
        while(listaComputadoras.hayNodo()){
            Computadora computadora = ((Computadora) listaComputadoras.obtenerNodo());
            if((int) Comparador.comparar(numComputadora, computadora.numComputadora) == 0){
                computadora.imprimirDatosComputadora();
            }
        }
    }

    /**
     * Agrega una aplicación a la computadora que se indique con el número de computadora.
     * @param numComputadora Es la computadora que se agregará la app.
     * @param app Es la app por agregar.
     * @return Regresa verdadero si se agrego o falso si no.
     */
    public boolean agregarAppsAComputadora(int numComputadora, App app){
        listaComputadoras.inicializarIterador();
        while (listaComputadoras.hayNodo()){
            Computadora computadora = ((Computadora) listaComputadoras.obtenerNodo());
            if((int) Comparador.comparar(numComputadora, computadora.numComputadora) == 0
                    && (int) Comparador.comparar(computadora.getRam(), app.getRamMinimaCorrerse()) >= 0){
                computadora.agregarApp(app);
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina una aplicación a la computadora que se indique con el número de computadora.
     * @param numComputadora Es la computadora de la que se eliminará la app.
     * @param app Es la app por eliminar.
     * @return Regresa verdadero si se eliminó o falso si no.
     */
    public boolean eliminarAppAComputadora(int numComputadora, App app){
        listaComputadoras.inicializarIterador();
        while (listaComputadoras.hayNodo()){
            Computadora computadora = ((Computadora) listaComputadoras.obtenerNodo());
            if((int) Comparador.comparar(numComputadora, computadora.numComputadora) == 0
                    && (int) Comparador.comparar(computadora.getRam(), app.getRamMinimaCorrerse()) >= 0){
                computadora.eliminarApp(app);
                return true;
            }
        }
        return false;
    }

    /**
     * Da de alta una computadora con todos sus componentes y con sus aplicaciones ya instaladas.
     * @param computadora Es la computadora que se dará de alta.
     * @return Regresa verdadero si se dio de alta o falso si no.
     */
    public boolean darAltaComputadora(Computadora computadora){
        return listaComputadoras.agregar(computadora) >= 0;
    }

    /**
     * Da de baja la computadora que se indique.
     * @param computadora Computadora por dar de baja.
     * @return Regresa el objeto que se dio de baja o null si no se dio de baja nada.
     */
    public Object darBajaComputadora(Computadora computadora){
        return listaComputadoras.eliminarObjeto(computadora);
    }

    /**
     * Genera una lista con las computadoras que tiene la app Chrome instalada.
     * @return Regresa la lista de las computadoras que tiene Chrome instalado.
     */
    public ListaDinamica computadorasConChrome(){
        ListaDinamica computadorasChrome = new ListaDinamica();
        listaComputadoras.inicializarIterador();
        while (listaComputadoras.hayNodo()){
            Computadora computadora = (Computadora) listaComputadoras.obtenerNodo();
            if(computadora.tieneApp("Chrome")){
                computadorasChrome.agregar(computadora);
            }
        }
        return computadorasChrome;
    }

    /**
     * Genera una lista con las computadoras que pueden correr la app.
     * @param app App que se quiere ver que computadora si la corre.
     * @return Regresa la lista de las computadoras que si corren la app.
     */
    public ListaDinamica computadorasQuePuedenCorrerApp(App app){
        ListaDinamica computadorasCorrenApp = new ListaDinamica();
        listaComputadoras.inicializarIterador();
        while (listaComputadoras.hayNodo()){
            Computadora computadora = (Computadora) listaComputadoras.obtenerNodo();
            if((int) Comparador.comparar(computadora.getRam() ,app.getRamMinimaCorrerse()) >= 0){
                computadorasCorrenApp.agregar(computadora);
            }
        }
        return computadorasCorrenApp;
    }
}
