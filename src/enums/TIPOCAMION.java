package enums;
public enum TIPOCAMION{
    ESTANDAR, ESPECIALES, REFRIGERADO;

    public TIPOCAMION getTipo(String str){
        TIPOCAMION[] allTipos = TIPOCAMION.values();
        for(TIPOCAMION t : allTipos){
            if(t.name().equals(str)){
                return t;
            }
        }
        return null;
    }
}