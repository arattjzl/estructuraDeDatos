package registros.competenciasAtleticas;

public class EventoCompetencia {

    protected String lugar;
    protected String nombre;

    public EventoCompetencia(String nombre, String lugar) {
        this.nombre = nombre;
        this.lugar = lugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
