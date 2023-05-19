package pruebas;

import entradasalida.SalidaPorDefecto;
import registros.probabilidad.EscenarioProbabilidad;

public class PruebaEscenarioProbabilidad {
    public static void main(String[] args) {
        EscenarioProbabilidad escenario = new EscenarioProbabilidad(8);
        escenario.agregarVertice("C", "MC", 0.72);
        escenario.agregarVertice("C", "PC", 0.28);

        escenario.agregarVertice("IL", "MI", 0.63);
        escenario.agregarVertice("IL", "PI", 0.37);

        escenario.agregarVertice("EP", "BEP-MC", 0.39);
        escenario.agregarVertice("EP", "MEP-MC", 0.61);
        escenario.agregarVertice("EP", "BEP-PC", 0.75);
        escenario.agregarVertice("EP", "MEP-PC", 0.25);

        escenario.agregarVertice("CI", "BCI-BEP", 0.80);
        escenario.agregarVertice("CI", "MCI-BEP", 0.20);
        escenario.agregarVertice("CI", "BCI-MEP", 0.24);
        escenario.agregarVertice("CI", "MCI-MEP", 0.76);

        escenario.agregarVertice("E", "BE-MC,BEP", 0.43);
        escenario.agregarVertice("E", "ME-MC,BEP", 0.57);
        escenario.agregarVertice("E", "BE-PC,BEP", 0.86);
        escenario.agregarVertice("E", "ME-PC,BEP", 0.14);
        escenario.agregarVertice("E", "BE-MC,MEP", 0.17);
        escenario.agregarVertice("E", "ME-MC,MEP", 0.83);
        escenario.agregarVertice("E", "BE-PC,MEP", 0.54);
        escenario.agregarVertice("E", "ME-PC,MEP", 0.46);

        escenario.agregarVertice("DTI", "BDTI-BE,BCI", 0.82);
        escenario.agregarVertice("DTI", "MDTI-BE,BCI", 0.18);
        escenario.agregarVertice("DTI", "BDTI-BE,MCI", 0.54);
        escenario.agregarVertice("DTI", "MDTI-BE,MCI", 0.46);
        escenario.agregarVertice("DTI", "BDTI-ME,BCI", 0.61);
        escenario.agregarVertice("DTI", "MDTI-ME,BCI", 0.39);
        escenario.agregarVertice("DTI", "BDTI-ME,MCI", 0.20);
        escenario.agregarVertice("DTI", "MDTI-ME,MCI", 0.80);

        escenario.agregarVertice("CE", "BCE-BCI,MIL", 0.90);
        escenario.agregarVertice("CE", "MCE-BCI,MIL", 0.10);
        escenario.agregarVertice("CE", "BCE-BCI,PIL", 0.64);
        escenario.agregarVertice("CE", "MCE-BCI,PIL", 0.36);
        escenario.agregarVertice("CE", "BCE-MCI,MIL", 0.68);
        escenario.agregarVertice("CE", "MCE-MCI,MIL", 0.32);
        escenario.agregarVertice("CE", "BCE-MCI,PIL", 0.25);
        escenario.agregarVertice("CE", "MCE-MCI,PIL", 0.75);

        escenario.agregarVertice("PM", "SPM-BDTI,BCE", 0.83);
        escenario.agregarVertice("PM", "NSPM-BDTI,BCE", 0.17);
        escenario.agregarVertice("PM", "SPM-BDTI,MCE", 0.63);
        escenario.agregarVertice("PM", "NSPM-BDTI,MCE", 0.37);
        escenario.agregarVertice("PM", "SPM-MDTI,BCE", 0.57);
        escenario.agregarVertice("PM", "NSPM-MDTI,BCE", 0.43);
        escenario.agregarVertice("PM", "SPM-MDTI,MCE", 0.13);
        escenario.agregarVertice("PM", "NSPM-MDTI,MCE", 0.87);

        //escenario.imprimir();
        escenario.probabilidad("PM|BDTI,MCE");
        SalidaPorDefecto.terminal("\n");
        escenario.probabilidad("C");

    }
}
