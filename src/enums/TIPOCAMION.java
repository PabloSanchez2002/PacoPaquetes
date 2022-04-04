package enums;

/**
 * Enumerado de tipo de camion
 */
public enum TIPOCAMION {
    ESTANDAR, ESPECIALES, REFRIGERADO;

    /**
     * Retorna el tipo de camion segun la String que se pase por argumento
     * 
     * @param str tipo de camion
     * @return enumerado coincidente
     */
    public TIPOCAMION getTipo(String str) {
        TIPOCAMION[] allTipos = TIPOCAMION.values();
        for (TIPOCAMION t : allTipos) {
            if (t.name().equals(str)) {
                return t;
            }
        }
        return null;
    }
}