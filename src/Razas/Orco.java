package Razas;

import InterfacesCartas.I_AumentarAtaque;
import InterfacesCartas.I_SumarVida;
import model.Jugador;
import model.Personaje;

import javax.swing.*;

public class Orco extends Personaje implements I_AumentarAtaque {

    private int danioAdicional;///Si es especial roba Vida

    //--------------------------------------Constructor--------------------------------------

    public Orco(String nombre, boolean isRara, int costoEnergia, int danoInflige, int cantidadDeVida, boolean rangoGlobal, ImageIcon imagen, String descripcion, int danioAdicional) {
        super(nombre, isRara, costoEnergia, danoInflige, cantidadDeVida, rangoGlobal, imagen, descripcion);
        this.danioAdicional = danioAdicional;
    }


    //--------------------------------------GETTERS--------------------------------------

    public int getDanioAdicional () {
        return danioAdicional;
    }
    public String getTipoCarta() {
        return getClass().getName();
    }

    ///--------------------------------------Interfaces que implementa-------------------------------------
    @Override
    public void aumentarAtaque(Jugador objetivo , int id) {

            for(int i=0;i<3;i++)
            {
                if(objetivo.getTablero ().getPersonajeEnPosicion (i)!=null)
                {
                    objetivo.getTablero ().getPersonajeEnPosicion (i).setDanoInflige ( objetivo.getTablero ().getPersonajeEnPosicion ( i ).getDanoInflige () + danioAdicional);
                    objetivo.getTablero().getPersonajeEnPosicion(i).actualizarValoresCarta();
                }
            }

    }
    @Override
    public void activarEfecto(Jugador jugadorEjecutor, Jugador jugadorRival, int id) {

            aumentarAtaque(jugadorEjecutor,0);

    }

    ///--------------------------------------To String-------------------------------------
    @Override
    public String toString() {
        return "Orco{" +
                "danioAdicional=" + danioAdicional +
                "} " + super.toString();
    }
}
