package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import registros.empresas.EmpleadoDinamico;
import registros.empresas.EmpresaDinamica;

public class PruebaEmpresaDinamica {
    public static void main(String[] args) {
        EmpresaDinamica empresa2 = new EmpresaDinamica("Patito SA");

        ListaDinamica comisiones1 = new ListaDinamica();
        comisiones1.agregar(450.3);
        comisiones1.agregar(849.3);
        comisiones1.agregar(389.5);
        comisiones1.agregar(689.4);
        EmpleadoDinamico empleado1 = new EmpleadoDinamico(101, "Juan", 30, comisiones1);

        ListaDinamica comisiones2 = new ListaDinamica();
        comisiones2.agregar(890.2);
        comisiones2.agregar(634.2);
        comisiones2.agregar(555.1);
        EmpleadoDinamico empleado2 = new EmpleadoDinamico(115, "Roberto", 28, comisiones2);

        empresa2.agregarEmpleado(empleado1);
        empresa2.agregarEmpleado(empleado2);

        empresa2.imprimirDatosEmpresa();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("----------------------------------------");
        SalidaPorDefecto.terminal("\n");
        empresa2.imprimirDatosEmpresaDetalle();

        SalidaPorDefecto.terminal("El promedio de comisiones de Juan es: " + empresa2.obtenerPromedioEmpleado(empleado1));

    }
}
