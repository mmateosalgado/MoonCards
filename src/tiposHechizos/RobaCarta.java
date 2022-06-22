package tiposHechizos;

import Excepciones.ManoLlenaExcepcion;
import Excepciones.MazoVacioExcepcion;
import InterfacesCartas.I_RobarCarta;
import model.Hechizo;
import model.Jugador;

public class RobaCarta extends Hechizo implements I_RobarCarta {
private int cantCartasRobadas;

    //Constructor--------------------------------------

    public RobaCarta (String nombre , boolean isRara , int costoEnergia , int danoInflige , int cantCartasRobadas) {
        super ( nombre , isRara , costoEnergia , 0 );
        this.cantCartasRobadas = cantCartasRobadas;
    }

    public int getCantCartasRobadas () {
        return cantCartasRobadas;
    }

    public void setCantCartasRobadas (int cantCartasRobadas) {
        this.cantCartasRobadas = cantCartasRobadas;
    }

    @Override
    public void robarCarta (Jugador objetivo) {//TODO . COMO APLICAR MAZO VACIO ACA????? -->, MazoVacioExcepcion

        for(int i=0;i<cantCartasRobadas;i++)
        {
            try {
                objetivo.getManoActual ().robarCarta (objetivo);
            } catch (ManoLlenaExcepcion e) {
                e.printStackTrace();
            }
        }
    }
    public String getTipoCarta() {
        return getClass().getSimpleName();
    }

    @Override
    public void activarEfecto(Jugador jugadorEjecutor, Jugador jugadorRival, int id) {

        robarCarta(jugadorEjecutor);

    }
}
