package enums;

/**
 * Enumerado de los tipos de estados de un paquete o producto
 */
public enum ESTADO {
    EN_ALMACEN, EN_REPARTO, ENTREGADO;

    @Override
    public String toString(){
        if(this.equals(ENTREGADO)){
            return "Entregado";
        }else if(this.equals(EN_ALMACEN)){
            return "En almacén";
        }else{
            return "En reparto";
        }
    }
}