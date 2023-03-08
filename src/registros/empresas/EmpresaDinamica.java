package registros.empresas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import estructurasLineales.ListaEstatica;
import registros.empresas.EmpleadoDinamico;

/**
 * @version1.0
 * @autor:Clase ED
 */
public class EmpresaDinamica {
    protected String nombre;
    protected ListaDinamica empleados;

    public EmpresaDinamica(String nombre) {
        this.nombre = nombre;
        this.empleados = new ListaDinamica();
    }

    public boolean agregarEmpleado(EmpleadoDinamico objetoEmpleado) {
        Object retornoEmpleado = empleados.buscar(objetoEmpleado);
        if (retornoEmpleado == null) {
            int retornoPosicionE = empleados.agregar(objetoEmpleado);
            if (retornoPosicionE >= 0) {
                return true;
            } else {
                return false;
            }
        }else{
            return false;}
    }

    public void imprimirDatosEmpresa(){
        SalidaPorDefecto.terminal("Los datos de la empresa " + nombre + " son: \n");
        empleados.imprimir();
    }
    public void imprimirDatosEmpresaDetalle() {
        SalidaPorDefecto.terminal("Los datos de la empresa " + nombre + " son:" + "\n");
        empleados.inicializarIterador();
        while(empleados.hayNodo()){
            SalidaPorDefecto.terminal(".");
            //Recorrer todos los empleados para sacar todos sus datos
            EmpleadoDinamico empleadoTemporal = (EmpleadoDinamico) empleados.obtenerNodo();
            SalidaPorDefecto.terminal(empleadoTemporal.getNombre()+
                    "("+empleadoTemporal.numeroEmpleado+") \n");
            SalidaPorDefecto.terminal("Sus comisiones son: \n");
            empleadoTemporal.getComicionesanio().imprimir();
            //para que el siguiente empleado este separado
            SalidaPorDefecto.terminal("\n");
        }
    }
    public Double obtenerPromedioEmpleado(EmpleadoDinamico objetoEmpleado){
        Object empleadoEncontrado = empleados.buscar(objetoEmpleado);
        if(empleadoEncontrado==null){
            return null;
        }else {
            return ((EmpleadoDinamico)empleadoEncontrado).obtenerPromedio();
        }
    }
}