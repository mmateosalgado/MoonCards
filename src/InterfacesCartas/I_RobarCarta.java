package InterfacesCartas;
import Excepciones.ManoLlenaExcepcion;
import model.Jugador;

public interface I_RobarCarta {

    void robarCarta(Jugador objetivo) throws ManoLlenaExcepcion;
}
