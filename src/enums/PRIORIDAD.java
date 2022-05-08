package enums;

/**
 * Enumerado de prioridad de entrega
 */
public enum PRIORIDAD {
    NORMAL, URGENTE;

    
    @Override
    public String toString(){
        if(this.equals(PRIORIDAD.URGENTE)){
            return "Urgente";
        }
        else{
            return "Normal";
        }
    }
}
