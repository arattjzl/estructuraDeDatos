package registros.constructora;

import estructurasLineales.ListaDinamica;

import java.time.LocalDate;

public class Obra {
    public String construccion;
    public String descripcion;
    public String localizacion;
    public double presupuesto;
    public ListaDinamica trabajadores;
    public LocalDate fecha;
    public String estadoObra;
    public Trabajador encargado;

    public Obra(String construccion, String localizacion,
                double presupuesto, ListaDinamica trabajadores, LocalDate fecha,
                String estadoObra, Trabajador encargado, String descripcion){
        this.construccion = construccion;
        this.localizacion = localizacion;
        this.presupuesto = presupuesto;
        this.trabajadores = trabajadores;
        this.fecha = fecha;
        this.estadoObra = estadoObra;
        this.encargado = encargado;
        this.descripcion = descripcion;
    }

    public Obra(String construccion, String localizacion,
                double presupuesto, LocalDate fecha,
                String estadoObra, Trabajador encargado, String descripcion){
        this.construccion = construccion;
        this.localizacion = localizacion;
        this.presupuesto = presupuesto;
        trabajadores = new ListaDinamica();
        this.fecha = fecha;
        this.estadoObra = estadoObra;
        this.encargado = encargado;
        this.descripcion = descripcion;
    }

    public Obra(){
        trabajadores = new ListaDinamica();
    }

    public String getConstruccion() {
        return construccion;
    }

    public void setConstruccion(String construccion) {
        this.construccion = construccion;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public ListaDinamica getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(ListaDinamica trabajadores) {
        this.trabajadores = trabajadores;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstadoObra() {
        return estadoObra;
    }

    public void setEstadoObra(String estadoObra) {
        this.estadoObra = estadoObra;
    }

    public Trabajador getEncargado() {
        return encargado;
    }

    public void setEncargado(Trabajador encargado) {
        this.encargado = encargado;
    }

    public void agregarTrabajador(Trabajador trabajador){
        trabajadores.agregar(trabajador);
    }
    @Override
    public String toString() {
        return "Obra{" +
                "construccion='" + construccion + '\n' +
                ", descripcion='" + descripcion + '\n' +
                ", localizacion='" + localizacion + '\n' +
                ", presupuesto=" + presupuesto + '\n' +
                ", fecha=" + fecha + '\n' +
                ", estadoObra='" + estadoObra + '\n' +
                ", encargado=" + encargado + '\n'+
                '}';
    }
}
