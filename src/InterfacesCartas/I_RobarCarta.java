package InterfacesCartas;
import Excepciones.ManoLlenaExcepcion;
import model.Jugador;

public interface I_RobarCarta {

    void RobarCarta(Jugador objetivo) throws ManoLlenaExcepcion;
}
