package Excepciones;

public class TableroLlenoExcepcion extends ArrayIndexOutOfBoundsException{
    public TableroLlenoExcepcion(String message) {
        super(message);
    }
}
