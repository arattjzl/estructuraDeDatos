package registros.empresas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;

public class Empresa {
    protected String nombre;
    protected ListaEstatica empleados;

    public Empresa(String nombre, int cantidadEmpleado) {
        empleados = new ListaEstatica(cantidadEmpleado);
        this.nombre = nombre;
    }

    public boolean agregarEmpleado(Empleado objetoEmpleado){
        int retornoEmpleado = (Integer)empleados.buscar(objetoEmpleado);
        if(retornoEmpleado == -1){ // se puede agregar
           int retornoPosicionEmpleado = empleados.agregar(objetoEmpleado);
           if(retornoPosicionEmpleado >= 0){
               return true;
           }
           return false;
        }
        return false;
    }

    public void imprimirDatosEmpresa(){
        SalidaPorDefecto.terminal("Los datos de la empresa " + nombre + " son: \n");
        empleados.imprimir();
    }

    public void imprimirDatosEmpresaDetalle(){
        SalidaPorDefecto.terminal("Los datos de la empresa " + nombre + " son: \n");
        // recorre todos los empleados, para sacar sus datos
        for(int cadaEmpleado = 0; cadaEmpleado < empleados.cantidad(); cadaEmpleado++){
            Empleado empleadoTermporal = (Empleado)empleados.obtener(cadaEmpleado);
            SalidaPorDefecto.terminal(empleadoTermporal.getNombre() + "(" + empleadoTermporal.getNumeroEmpleado() + ")\n");
            SalidaPorDefecto.terminal("Sus comisiones son: \n");
            empleadoTermporal.getComisionesAnio().imprimir();
            SalidaPorDefecto.terminal("\n"); // el siguiente empleado saldra separado
        }
    }

    public Double obtenerPromedioEmpleado(Empleado objetoEmpleado){
        int posicionEmpleado = (int)empleados.buscar(objetoEmpleado);
        if(posicionEmpleado==-1){
            return null;
        }else {
            Empleado empleadoTemporal = (Empleado) empleados.obtener(posicionEmpleado);
            return empleadoTemporal.obtenerPromedio();
        }
    }
}
