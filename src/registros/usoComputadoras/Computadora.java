package registros.usoComputadoras;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import utils.commons.Comparador;

public class Computadora {
    protected int numComputadora;
    protected int CCperteneciente;
    protected int ram;
    protected int tamanioDiscoDuro;
    protected String procesador;
    protected String marca;
    protected ListaDinamica appsInstaladas;
    protected ListaDinamica usuarioQueUtilizaron;

    public Computadora(int numComputadora, int CCperteneciente, int ram, int tamanioDiscoDuro, String procesador, String  marca, ListaDinamica appsInstaladas){
        this.numComputadora = numComputadora;
        this.CCperteneciente = CCperteneciente;
        this.ram = ram;
        this.tamanioDiscoDuro = tamanioDiscoDuro;
        this.procesador = procesador;
        this.marca = marca;
        this.appsInstaladas = appsInstaladas;
        usuarioQueUtilizaron = new ListaDinamica();
    }

    public Computadora(int numComputadora, int CCperteneciente, int ram, int tamanioDiscoDuro, String procesador, String  marca){
        this.numComputadora = numComputadora;
        this.CCperteneciente = CCperteneciente;
        this.ram = ram;
        this.tamanioDiscoDuro = tamanioDiscoDuro;
        this.procesador = procesador;
        this.marca = marca;
        appsInstaladas = new ListaDinamica();
        usuarioQueUtilizaron = new ListaDinamica();
    }

    public int getNumComputadora() {
        return numComputadora;
    }

    public void setNumComputadora(int numComputadora) {
        this.numComputadora = numComputadora;
    }

    public int getCCperteneciente() {
        return CCperteneciente;
    }

    public void setCCperteneciente(int CCperteneciente) {
        this.CCperteneciente = CCperteneciente;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getTamanioDiscoDuro() {
        return tamanioDiscoDuro;
    }

    public void setTamanioDiscoDuro(int tamanioDiscoDuro) {
        this.tamanioDiscoDuro = tamanioDiscoDuro;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public ListaDinamica getAppsInstaladas() {
        return appsInstaladas;
    }

    public void setAppsInstaladas(ListaDinamica appsInstaladas) {
        this.appsInstaladas = appsInstaladas;
    }

    public ListaDinamica getUsuarioQueUtilizaron() {
        return usuarioQueUtilizaron;
    }

    public void setUsuarioQueUtilizaron(ListaDinamica usuarioQueUtilizaron) {
        this.usuarioQueUtilizaron = usuarioQueUtilizaron;
    }

    /**
     * Imprime los datos de la computadora.
     */
    public void imprimirDatosComputadora(){
        SalidaPorDefecto.terminal("Numero de computadora: " + numComputadora +
                ", Centro Computo perteneciente: " + CCperteneciente +
                ", RAM: " + ram +
                ", Diso Duro: " + tamanioDiscoDuro +
                ", Procesador: " + procesador +
                ", Marca: " + marca);
        SalidaPorDefecto.terminal(", Con las apliaciones: ");
        getUsuarioQueUtilizaron().inicializarIterador();
        while (getUsuarioQueUtilizaron().hayNodo()){
            App cadaApp = (App) getAppsInstaladas().obtenerNodo();
            SalidaPorDefecto.terminal(cadaApp.getNombre() + " ");
        }
    }

    /**
     * Agrega una aplicación a la computadora.
     * @param app Es la aplicación que se agregará a la computadora.
     * @return Regresa <b>true</b> si se agregó la aplicación o <b>false</b> si no.
     */
    public boolean agregarApp(App app){
        return appsInstaladas.agregar(app) >= 0;
    }

    /**
     * Elimina la aplicación de una computadora.
     * @param app Es la aplicación que se eliminará.
     * @return
     */
    public Object eliminarApp(App app){
//        appsInstaladas.inicializarIterador();
//        while (appsInstaladas.hayNodo()){
//            String nombre = ((App) appsInstaladas.obtenerNodo()).getNombre();
//            App app = (App) appsInstaladas.obtenerNodo();
//            if((int) Comparador.comparar(nombre, nombreApp) == 0){
//                appsInstaladas.eliminarObjeto(app);
//                return true;
//            }
//        }
//        return null;
        return getUsuarioQueUtilizaron().eliminarObjeto(app);
    }

    /**
     * Regresa un booleano dependiendo si la computadora tiene la app indicada.
     * @param app La app que se quiere verificar si se encuentra instalada.
     * @return Regresa true si se encuentra instalada y false si no.
     */
    public boolean tieneApp(String app){
        getUsuarioQueUtilizaron().inicializarIterador();
        while (getUsuarioQueUtilizaron().hayNodo()){
            String queAppEs = ((App) getUsuarioQueUtilizaron().obtenerNodo()).getNombre();
            if((int) Comparador.comparar(app, queAppEs) == 0){
                return true;
            }
        }
        return false;
    }

    /**
     * Se agrega el uso de la computadora con el usuario y los datos de a que hora empezó y a que hora termino.
     * @param usoComputadora Es el uso que se le dio a la computadora, con información como el usuario,
     *                       fechas de inicio y fin y apps utilizadas.
     * @return Regresa la información de las veces que se utilizó la computadora.
     */
    public boolean iniciarUsoComputadora(UsoComputadora usoComputadora){
        return getUsuarioQueUtilizaron().agregar(usoComputadora) >= 0;
    }

    /**
     * Imprime los usuarios que utilizaron las computadoras.
     */
    public ListaDinamica imprimirUsuariosUtilizaronComputadora(){
        ListaDinamica usuarios = new ListaDinamica();
        getUsuarioQueUtilizaron().inicializarIterador();
        while (getUsuarioQueUtilizaron().hayNodo()){
            String nombre = ((UsoComputadora) getUsuarioQueUtilizaron().obtenerNodo()).getUsuario().getNombre();
            usuarios.agregar(nombre);
        }
        return usuarios;
    }
}
