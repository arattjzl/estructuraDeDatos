package arreglosUnidimensionales;


import estructurasLineales.ListaEstatica;

public class Campesino implements ICampesino{
    protected String nombre;
    protected ListaEstatica anio1;
    protected ListaEstatica anio2;
    protected ListaEstatica anio3;
    protected ListaEstatica anio4;

    public Campesino(String nombre, ListaEstatica anio1, ListaEstatica anio2, ListaEstatica anio3, ListaEstatica anio4){
        this.nombre = nombre;
        this.anio1 = anio1;
        this.anio2 = anio2;
        this.anio3 = anio3;
        this.anio4 = anio4;
    }

    public Campesino(String nombre){
        this.nombre = nombre;
        anio1 = new ListaEstatica(12);
        anio2 = new ListaEstatica(12);
        anio3 = new ListaEstatica(12);
        anio4 = new ListaEstatica(12);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaEstatica getAnio1() {
        return anio1;
    }

    public void setAnio1(ListaEstatica anio1) {
        this.anio1 = anio1;
    }

    public ListaEstatica getAnio2() {
        return anio2;
    }

    public void setAnio2(ListaEstatica anio2) {
        this.anio2 = anio2;
    }

    public ListaEstatica getAnio3() {
        return anio3;
    }

    public void setAnio3(ListaEstatica anio3) {
        this.anio3 = anio3;
    }

    public ListaEstatica getAnio4() {
        return anio4;
    }

    public void setAnio4(ListaEstatica anio4) {
        this.anio4 = anio4;
    }

    public boolean agregarAnio1(double toneladas){
        int retorno = anio1.agregar(toneladas);
        if(retorno >= 0){
            return true;
        }
        return false;
    }

    @Override
    public double obtenerPromedioAnio(ListaEstatica listaEstatica){
        double promedio = 0;
        if(listaEstatica.cantidad()!=0) {
            for (int cadaMes = 0; cadaMes < listaEstatica.cantidad(); cadaMes++) {
                promedio += (double) listaEstatica.obtener(cadaMes);
            }
            promedio = promedio / listaEstatica.cantidad();
        }
        return promedio;
    }

    @Override
    public int mayoresPromedioAnual(ListaEstatica listaEstatica){
        ListaEstatica mayores = new ListaEstatica(12);
        double promedio = obtenerPromedioAnio(listaEstatica);
        for(int mes = 0; mes <listaEstatica.cantidad(); mes++){
            if(((double) listaEstatica.obtener(mes)) > promedio){
                mayores.agregar(listaEstatica.obtener(mes));
            }
        }
        return mayores.cantidad();
    }

    @Override
    public int elMenor(ListaEstatica listaEstatica){
        double menor = 0;
        for(int indice = 0; indice < listaEstatica.cantidad(); indice++){
            if(menor == 0){
                menor = (double) listaEstatica.obtener(indice);
            }
            if((double) listaEstatica.obtener(indice) < menor){
                menor = (double) listaEstatica.obtener(indice);
            }
        }
        return (int) listaEstatica.buscar(menor)+1;
    }

    @Override
    public ListaEstatica menosToneladas(){
        ListaEstatica menores = new ListaEstatica(4);
        int posMenor1 = elMenor(anio1);
        int posMenor2 = elMenor(anio2);
        int posMenor3 = elMenor(anio3);
        int posMenor4 = elMenor(anio4);
        menores.agregar(posMenor1);
        menores.agregar(posMenor2);
        menores.agregar(posMenor3);
        menores.agregar(posMenor4);
        return menores;
    }

    @Override
    public double toneladasUltimoMes(ListaEstatica listaEstatica){
        return (double) listaEstatica.obtener(listaEstatica.getTope());
    }

    @Override
    public ListaEstatica tonUltMes(){
        ListaEstatica toneladas = new ListaEstatica(4);
        double tonelada1 = toneladasUltimoMes(anio1);
        double tonelada2 = toneladasUltimoMes(anio2);
        double tonelada3 = toneladasUltimoMes(anio3);
        double tonelada4 = toneladasUltimoMes(anio4);
        toneladas.agregar(tonelada1);
        toneladas.agregar(tonelada2);
        toneladas.agregar(tonelada3);
        toneladas.agregar(tonelada4);
        return toneladas;
    }

    @Override
    public double tonTrim(ListaEstatica listaEstatica){
        double total = 0.0;
        for(int mes = 3; mes < 6; mes++){
            total += (double) listaEstatica.obtener(mes);
        }
        return total;
    }

    @Override
    public ListaEstatica tonTrimestresAnios(){
        ListaEstatica toneladas = new ListaEstatica(4);
        double tonelada1 = tonTrim(anio1);
        double tonelada2 = tonTrim(anio2);
        double tonelada3 = tonTrim(anio3);
        double tonelada4 = tonTrim(anio4);
        toneladas.agregar(tonelada1);
        toneladas.agregar(tonelada2);
        toneladas.agregar(tonelada3);
        toneladas.agregar(tonelada4);
        return toneladas;
    }

}
