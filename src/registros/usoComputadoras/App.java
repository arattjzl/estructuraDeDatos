package registros.usoComputadoras;

public class App {
    protected String nombre;
    protected char logo;
    protected String autores;
    protected String version;
    protected int ramMinimaCorrerse;

    public App(String nombre, char logo, String autores, String version, int ramMinimaCorrerse){
        this.nombre = nombre;
        this.logo = logo;
        this.autores = autores;
        this.version = version;
        this.ramMinimaCorrerse = ramMinimaCorrerse;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getLogo() {
        return logo;
    }

    public void setLogo(char logo) {
        this.logo = logo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getRamMinimaCorrerse() {
        return ramMinimaCorrerse;
    }

    public void setRamMinimaCorrerse(int ramMinimaCorrerse) {
        this.ramMinimaCorrerse = ramMinimaCorrerse;
    }
}
