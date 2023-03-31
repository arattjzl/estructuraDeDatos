package registros.usoComputadoras;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import utils.commons.Comparador;


public class ControlCentroComputo {
    protected ListaDinamica listaComputadoras;
    protected ListaDinamica todosUsuarios;

    public ControlCentroComputo(){
        listaComputadoras = new ListaDinamica();
        todosUsuarios = new ListaDinamica();
    }

    public ListaDinamica getListaComputadoras() {
        return listaComputadoras;
    }

    public void setListaComputadoras(ListaDinamica listaComputadoras) {
        this.listaComputadoras = listaComputadoras;
    }

    public ListaDinamica getTodosUsuarios() {
        return todosUsuarios;
    }

    public void setTodosUsuarios(ListaDinamica todosUsuarios) {
        this.todosUsuarios = todosUsuarios;
    }

    /**
     * Agrega computadoras al centro de control de computadoras.
     * @param computadora Es un objeto de tipo computadora con sus atributos.
     * @return Regresa verdadero si se agrego o falso si no.
     */
    public boolean agregarComputadora(Computadora computadora){
        int agregado = getListaComputadoras().agregar(computadora);
        return agregado > 0;
    }

    /**
     * Imprime los detalles de todas las computadoras.
     */
    public void imprimirDetallesComputadoras(){
        getListaComputadoras().inicializarIterador();
        while (getListaComputadoras().hayNodo()){
            Computadora cadaComputadora = ((Computadora) getListaComputadoras().obtenerNodo());
            cadaComputadora.imprimirDatosComputadora();
            SalidaPorDefecto.terminal("\n");
        }
    }

    /**
     * Imprime los detalles de la computadora que coincida con el número de computadora pasado como atributo.
     * @param numComputadora Es el número de la computadora.
     */
    public void imprimirCaracteristicaComputadora(int numComputadora){
        getListaComputadoras().inicializarIterador();
        while(getListaComputadoras().hayNodo()){
            Computadora cadaComputadora = ((Computadora) getListaComputadoras().obtenerNodo());
            if((int) Comparador.comparar(numComputadora, cadaComputadora.getNumComputadora()) == 0){
                cadaComputadora.imprimirDatosComputadora();
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
        getListaComputadoras().inicializarIterador();
        while (getListaComputadoras().hayNodo()){
            Computadora cadaComputadora = ((Computadora) getListaComputadoras().obtenerNodo());
            if((int) Comparador.comparar(numComputadora, cadaComputadora.getNumComputadora()) == 0
                    && (int) Comparador.comparar(cadaComputadora.getRam(), app.getRamMinimaCorrerse()) >= 0){
                cadaComputadora.agregarApp(app);
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
        getListaComputadoras().inicializarIterador();
        while (getListaComputadoras().hayNodo()){
            Computadora cadaComputadora = ((Computadora) getListaComputadoras().obtenerNodo());
            if((int) Comparador.comparar(numComputadora, cadaComputadora.getNumComputadora()) == 0){
                cadaComputadora.eliminarApp(app);
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
        return getListaComputadoras().agregar(computadora) >= 0;
    }

    /**
     * Da de baja la computadora que se indique.
     * @param computadora Computadora por dar de baja.
     * @return Regresa el objeto que se dio de baja o null si no se dio de baja nada.
     */
    public Object darBajaComputadora(Computadora computadora){
        return getListaComputadoras().eliminarObjeto(computadora);
    }

    /**
     * Genera una lista con las computadoras que tiene la app Chrome instalada.
     * @return Regresa la lista de las computadoras que tiene Chrome instalado.
     */
    public ListaDinamica computadorasConChrome(){
        ListaDinamica computadorasChrome = new ListaDinamica();
        getListaComputadoras().inicializarIterador();
        while (getListaComputadoras().hayNodo()){
            Computadora cadaComputadora = (Computadora) getListaComputadoras().obtenerNodo();
            if(cadaComputadora.tieneApp("Chrome")){
                computadorasChrome.agregar(cadaComputadora);
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
        getListaComputadoras().inicializarIterador();
        while (getListaComputadoras().hayNodo()){
            Computadora cadaComputadora = (Computadora) getListaComputadoras().obtenerNodo();
            if((int) Comparador.comparar(cadaComputadora.getRam() ,app.getRamMinimaCorrerse()) >= 0){
                computadorasCorrenApp.agregar(cadaComputadora);
            }
        }
        return computadorasCorrenApp;
    }

    /**
     * Imprime los usuarios que han utilizado cierta computadora.
     * @param numComputadora Es la computadora de la que se quieren sacar los usuarios que la utilizaron.
     */
    public void imprimirUsuariosComputadora(int numComputadora){
        getListaComputadoras().inicializarIterador();
        while (getListaComputadoras().hayNodo()){
            Computadora cadaComputadora = (Computadora) getListaComputadoras().obtenerNodo();
            if((int) Comparador.comparar(cadaComputadora.getNumComputadora(), numComputadora) == 0){
                cadaComputadora.imprimirUsuariosUtilizaronComputadora().imprimir();
            }
        }
    }

    /**
     * Imprime los detalles del uso de la computadora para un usuario dado y una computadora dada.
     * @param nombreUsuario Es el usuario que queremos obtener los detalles de uso.
     * @param numComputadora Es la computadora que queremos obtener los detalles de uso.
     */
    public void imprimirDetallesUsuarioComputadora(String nombreUsuario, int numComputadora){
        SalidaPorDefecto.terminal("Detalles de uso de la computadora con número de computadora " + numComputadora + " para el usuario " + nombreUsuario + "\n");
        getListaComputadoras().inicializarIterador();
        while (getListaComputadoras().hayNodo()){
            Computadora cadaComputadora = ((Computadora) getListaComputadoras().obtenerNodo());
            if((int) Comparador.comparar(cadaComputadora.getNumComputadora(), numComputadora) == 0){
                cadaComputadora.getUsuarioQueUtilizaron().inicializarIterador();
                while (cadaComputadora.getUsuarioQueUtilizaron().hayNodo()){
                    UsoComputadora usoComputadora = ((UsoComputadora) cadaComputadora.getUsuarioQueUtilizaron().obtenerNodo());
                    if((int) Comparador.comparar(usoComputadora.getUsuario().getNombre(), nombreUsuario) == 0){
                        usoComputadora.imprimirDatos();
                        SalidaPorDefecto.terminal(" La computadora se encuentra en el CC: " + cadaComputadora.getCCperteneciente() + "\n");
                    }
                }
            }
        }
    }

    /**
     * Imprime las aplicaciones utilizadas por un usuario dado en una fecha específica.
     * @param nombreUsuario Es el usuario que se quiere ver las aplicaciones utilizadas.
     * @param fecha Es la fecha en la que queremos ver las aplicaciones utilizadas.
     */
    public void imprimirAppsUtilizadasPorUsuarioEnFecha(String nombreUsuario, String fecha){
        SalidaPorDefecto.terminal("Apps abiertas por usuario " + nombreUsuario + " en la fecha " + fecha + "\n");
        getListaComputadoras().inicializarIterador();
        while (getListaComputadoras().hayNodo()){
            Computadora cadaComputadora = ((Computadora) getListaComputadoras().obtenerNodo());
            cadaComputadora.getUsuarioQueUtilizaron().inicializarIterador();
            while (cadaComputadora.getUsuarioQueUtilizaron().hayNodo()){
                UsoComputadora usoComputadora = ((UsoComputadora) cadaComputadora.getUsuarioQueUtilizaron().obtenerNodo());
                if((int) Comparador.comparar(usoComputadora.getUsuario().getNombre(), nombreUsuario) == 0 && (int) Comparador.comparar(usoComputadora.getFechaInicio(), fecha) == 0){
                    usoComputadora.imprimirAppsUtilizadas();
                }
            }
        }
    }

    /**
     * Imprime los usuarios que no hacen uso de los centros de cómputo.
     */
    public void imprimirUsuariosSinUsoCC(){
        ListaDinamica usuariosSinUtilizarCC = (ListaDinamica) getTodosUsuarios().clonar();
        getListaComputadoras().inicializarIterador();
        while (getListaComputadoras().hayNodo()){
            Computadora cadaComputadora = ((Computadora) getListaComputadoras().obtenerNodo());
            cadaComputadora.getUsuarioQueUtilizaron().inicializarIterador();
            while (cadaComputadora.getUsuarioQueUtilizaron().hayNodo()){
                UsoComputadora usoComputadora = ((UsoComputadora) cadaComputadora.getUsuarioQueUtilizaron().obtenerNodo());
                Usuario cadaUsuarioSiUtilizado = usoComputadora.getUsuario();
                usuariosSinUtilizarCC.eliminarObjeto(cadaUsuarioSiUtilizado);
            }
        }
        usuariosSinUtilizarCC.inicializarIterador();
        SalidaPorDefecto.terminal("Usuarios que no han utilizado ningún centro de cómputo: ");
        while (usuariosSinUtilizarCC.hayNodo()){
            String cadaUsuarioSinUtilizarCC = ((Usuario) usuariosSinUtilizarCC.obtenerNodo()).getNombre();
            SalidaPorDefecto.terminal(cadaUsuarioSinUtilizarCC + " ");
        }
    }
}
