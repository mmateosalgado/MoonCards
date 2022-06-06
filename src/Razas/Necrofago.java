package Razas;

import InterfacesCartas.I_Danio;
import InterfacesCartas.I_RobarCarta;
import model.Jugador;
import model.Personaje;

public class Necrofago extends Personaje implements I_RobarCarta, I_Danio {

    private int infligeDanio;
    private int cantCartasRobadas;

    public Necrofago (String nombre , boolean isRara , int costoEnergia , int danoInflige , int cantidadDeVida , int infligeDanio, int cantCartasRobadas) {
        super ( nombre , isRara , costoEnergia , danoInflige , cantidadDeVida );
        this.infligeDanio = infligeDanio;
        this.cantCartasRobadas = cantCartasRobadas;
    }

    public int getCantCartasRobadas() {
        return cantCartasRobadas;
    }

    public int getInfligeDanio () {
        return infligeDanio;
    }

    @Override
    public void RobarCarta (Jugador jugador) {
    }

    @Override
    public void infligeDanio (Personaje objetivo , int danio) {
        objetivo.setCantidadDeVida ( objetivo.getCantidadDeVida () -infligeDanio);
    }



}
