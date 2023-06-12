package registros.constructora;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;

public class Sucursal {
    public int numSucursal;
    public String estado;
    public ListaDinamica obras;

    public Sucursal(int numSucursal, String estado){
        this.numSucursal = numSucursal;
        this.estado = estado;
        obras = new ListaDinamica();
    }

    public int getNumSucursal() {
        return numSucursal;
    }

    public void setNumSucursal(int numSucursal) {
        this.numSucursal = numSucursal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ListaDinamica getObras() {
        return obras;
    }

    public void setObras(ListaDinamica obras) {
        this.obras = obras;
    }

    public void agregarObra(Obra obra){
        obras.agregar(obra);
    }

    public void imprimirObras(){
        obras.inicializarIterador();
        while(obras.hayNodo()){
            Object cadaobra = obras.obtenerNodo();
            SalidaPorDefecto.terminal(cadaobra + "\n\n-------\n\n");
        }
    }
    @Override
    public String toString() {
        return "Num sucursal: " + numSucursal + " Estado: " + estado + "\n";
    }
}
