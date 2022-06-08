package Razas;

import InterfacesCartas.I_HacerDanio;
import InterfacesCartas.I_RobarCarta;
import model.Jugador;
import model.Personaje;

public class Necrofago extends Personaje implements I_RobarCarta, I_HacerDanio {

    private int cantDañoInflige;
    private int cantCartasRobadas;

    //Constructor--------------------------------------

    public Necrofago (String nombre , boolean isRara , int costoEnergia , int danoInflige , int cantidadDeVida , int infligeDanio, int cantCartasRobadas) {
        super ( nombre , isRara , costoEnergia , danoInflige , cantidadDeVida );
        this.cantDañoInflige = infligeDanio;
        this.cantCartasRobadas = cantCartasRobadas;
    }

    //Getters--------------------
    public int getCantCartasRobadas() {
        return cantCartasRobadas;
    }

    public int getcantDañoInflige () {
        return cantDañoInflige;
    }

    @Override
    public void RobarCarta (Jugador jugador) {
        for(int i=0;i<cantCartasRobadas;i++)
        {
            jugador.getManoActual ().RobarCarta (jugador);
        }
    }

    @Override
    public void infligeDanio (Jugador objetivo , int id) {
        if(isRara ())// id-1 es la posicion en el arreglo (por ej si un personaje tiene id =2, su pos en el arreglo es 1)
        {
            objetivo.getTablero ().getPersonajeEnPosicion ( id-1 ).setCantidadDeVida (objetivo.getTablero ().getPersonajeEnPosicion ( id-1).getCantidadDeVida () - cantDañoInflige);
        }
    }

}
