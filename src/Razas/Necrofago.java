package Razas;

import Excepciones.ManoLlenaExcepcion;
import Excepciones.MazoVacioExcepcion;
import InterfacesCartas.I_HacerDanio;
import InterfacesCartas.I_RobarCarta;
import model.Jugador;
import model.Personaje;

import javax.swing.*;

public class Necrofago extends Personaje implements I_RobarCarta, I_HacerDanio {

    private int cantDanioInflige;
    private int cantCartasRobadas;

    //Constructor--------------------------------------

    public Necrofago (String nombre , boolean isRara , int costoEnergia , int danoInflige , int cantidadDeVida , int infligeDanio, int cantCartasRobadas, boolean esGlobal) {
        super ( nombre , isRara , costoEnergia , danoInflige , cantidadDeVida, esGlobal);
        this.cantDanioInflige = infligeDanio;
        this.cantCartasRobadas = cantCartasRobadas;
    }

    //Getters--------------------
    public int getCantCartasRobadas() {
        return cantCartasRobadas;
    }

    public int getcantDañoInflige () {
        return cantDanioInflige;
    }

    @Override
    public void robarCarta (Jugador jugador) {

        for(int i=0;i<cantCartasRobadas && i!=99;i++)
        {
            try {
                jugador.getManoActual().robarCarta(jugador);
            }catch (ManoLlenaExcepcion  e){
                JOptionPane.showMessageDialog(null,e.getMessage());
                i=99;
            }
        }
    }

    @Override
    public void infligeDanio (Jugador objetivo , int id) {
        // id-1 es la posicion en el arreglo (por ej si un personaje tiene id =2, su pos en el arreglo es 1)
            objetivo.getTablero ().getPersonajeEnPosicion ( id-1 ).setCantidadDeVida (objetivo.getTablero ().getPersonajeEnPosicion ( id-1).getCantidadDeVida () - cantDanioInflige);
    }
    public String getTipoCarta() {
        return getClass().getName();
    }

    @Override
    public void activarEfecto(Jugador jugadorEjecutor, Jugador jugadorRival, int id) {

        if(isRara() && jugadorRival.getTablero().getPosiciones()[id-1] != null) { //aca controlamos que si el necrofago va a devolver el ataque al atacante, este siga vivo (no vamos a atacar a alguien que ya sacamos del tablero)
            infligeDanio(jugadorRival, id);
        }
            robarCarta(jugadorEjecutor);
    }
}
