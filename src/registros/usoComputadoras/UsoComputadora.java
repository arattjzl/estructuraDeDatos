package registros.usoComputadoras;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;

/**
 * Clase con los métodos para tener control del uso de computadoras.
 * @author Aratt
 * @version 1.0
 */

public class UsoComputadora {
    protected Usuario usuario;
    protected String fechaInicio;
    protected String horaInicio;
    protected String fechaFin;
    protected String horaFin;
    protected ListaDinamica appsUtilizadas;

    public UsoComputadora(Usuario usuario, String fechaInicio, String horaInicio){
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.horaInicio = horaInicio;
        fechaFin = "";
        horaFin = "";
        appsUtilizadas = new ListaDinamica();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public ListaDinamica getAppsUtilizadas() {
        return appsUtilizadas;
    }

    public void setAppsUtilizadas(ListaDinamica appsUtilizadas) {
        this.appsUtilizadas = appsUtilizadas;
    }

    /**
     * Guarda la fecha en la cual se terminó el uso de la computadora.
     */
    public void terminarUsoComputadora(String horaFin, String fechaFin){
        this.fechaFin = fechaFin;
        this.horaFin = horaFin;
    }

    /**
     * Agrega una aplicación que se haya utilizado en el tiempo que el usuario utilizó la computadora.
     * @param app App utilizada.
     * @return Regresa true si se agregó la app y false si no.
     */
    public boolean agregarAppUtilizada(App app){
        return getAppsUtilizadas().agregar(app) >= 0;
    }

    /**
     * Imprime los datos que el uso.
     */
    public void imprimirDatos(){
        SalidaPorDefecto.terminal("Usuario: " + usuario.getNombre() +
                ", Fecha Inicio: " + fechaInicio +
                ", Hora Inicio: " + horaInicio +
                ", Fecha Fin: " + fechaFin +
                ", Hora Fin: " + horaFin);
    }

    /**
     * Imprime las apps utilizadas.
     */
    public void imprimirAppsUtilizadas(){
        getAppsUtilizadas().inicializarIterador();
        while (getAppsUtilizadas().hayNodo()){
            App cadaApp = (App) getAppsUtilizadas().obtenerNodo();
            SalidaPorDefecto.terminal(cadaApp.getNombre() + " ");
        }
    }
}
