package repasoDePOO.interfaces;


import repasoDePOO.implementaciones.Piloto;

public interface IAvion {
    public void setTipoAvion(String tipoAvion);
    public String getTipoAvion();
    public void setMatricula(String matricula);
    public String getMatricula();
    public void setFabricante(String fabricante);
    public String getFabricante();
    public void setModelo(String modelo);
    public String getModelo();
    public void setCapacidad(int capacidad);
    public int getCapacidada();
    public void setAutonomia(String autonomia);
    public String getAutonomia();
}
