package model;

import InterfacesCartas.I_RobarCarta;

import java.util.ArrayList;

public class Mano implements I_RobarCarta {
    private ArrayList <Carta> mano;
    private int validos;

    public Mano() {
        this.mano = new ArrayList<>();
        this.validos = 0;
    }

    @Override
    public void RobarCarta (Jugador jugador) {
        if(validos<10)
        {
            mano.add(jugador.getMazoJugador().sacarCartaRandom());
            validos++;
        }
        else
        {
            //se descarta la carta
        }
    }


}
