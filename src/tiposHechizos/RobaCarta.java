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
        super ( nombre , isRara , costoEnergia , danoInflige );
        this.cantCartasRobadas = cantCartasRobadas;
    }

    public int getCantCartasRobadas () {
        return cantCartasRobadas;
    }

    public void setCantCartasRobadas (int cantCartasRobadas) {
        this.cantCartasRobadas = cantCartasRobadas;
    }

    @Override
    public void RobarCarta (Jugador objetivo) {//TODO . COMO APLICAR MAZO VACIO ACA????? -->, MazoVacioExcepcion

        for(int i=0;i<cantCartasRobadas;i++)
        {
            try {
                objetivo.getManoActual ().RobarCarta (objetivo);
            } catch (ManoLlenaExcepcion e) {
                e.printStackTrace();
            }
        }
    }
}
