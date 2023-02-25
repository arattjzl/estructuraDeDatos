package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import registros.empresas.Empleado;
import registros.empresas.Empresa;

public class PruebaEmpresa {
    public static void main(String[] args) {
        //Empresa empresa = new Empresa("Patito SA", 5);

        ListaEstatica comisiones1 = new ListaEstatica(4);
        comisiones1.agregar(450.3);
        comisiones1.agregar(849.3);
        comisiones1.agregar(389.5);
        comisiones1.agregar(689.4);
        Empleado empleado1 = new Empleado(101, "Juan", 30, comisiones1);

        ListaEstatica comisiones2 = new ListaEstatica(3);
        comisiones2.agregar(890.2);
        comisiones2.agregar(634.2);
        comisiones2.agregar(555.1);
        Empleado empleado2 = new Empleado(115, "Roberto", 28, comisiones2);

        //empresa.agregarEmpleado(empleado1);
        //empresa.agregarEmpleado(empleado2);

        //empresa.imprimirDatosEmpresa();
        //SalidaPorDefecto.terminal("\n");
        //empresa.imprimirDatosEmpresaDetalle();
        SalidaPorDefecto.terminal(empleado2.obtenerPromedio() + "");

        //SalidaPorDefecto.terminal("El promedio de comisiones de Juan es: " + empresa.obtenerPromedioEmpleado(empleado1));
    }
}
