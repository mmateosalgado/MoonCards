package Excepciones;

import java.util.NoSuchElementException;

public class MazoVacioExcepcion extends NoSuchElementException {
    public MazoVacioExcepcion(String message) {
        super(message);
    }
}
