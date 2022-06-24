package Excepciones;

import java.util.NoSuchElementException;

public class DatoNoEcontradoExcepcion extends NoSuchElementException {
    public DatoNoEcontradoExcepcion(String message) {
        super(message);
    }
}
