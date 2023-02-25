package utils.commons;

public class Comparador {

    public static Object comparar(Object objeto1, Object objeto2) {
        if (objeto1 instanceof Number && objeto2 instanceof Number) {
            if(((Number) objeto1).doubleValue() > ((Number) objeto2).doubleValue()) {
                return 1;
            } else if (((Number) objeto1).doubleValue() < ((Number) objeto2).doubleValue()){
                return -1;
            } else {
                return 0;
            }
        } else {
            return (objeto1.toString()).compareToIgnoreCase(objeto2.toString());
        }
    }
}
