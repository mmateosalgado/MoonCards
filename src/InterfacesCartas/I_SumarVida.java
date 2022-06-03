package InterfacesCartas;

import Batalla.Tablero;
import model.Jugador;
import model.Personaje;

public interface I_SumarVida {

    //void sumarVida(Personaje objetivo,int sumaVida);
    void sumarVida(Jugador jugador, int id);
}
