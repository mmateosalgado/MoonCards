package Razas;

import InterfacesCartas.I_AumentarAtaque;
import InterfacesCartas.I_SumarVida;
import model.Jugador;
import model.Personaje;

import javax.swing.*;

public class Humano extends Personaje implements I_AumentarAtaque, I_SumarVida {

    private int danioAdicional;
    private int sumarVida;

    //--------------------------------------Constructor Para guardar en el archivo--------------------------------------
    ///--------------------------------------Sumar Vida siempre va a ser 2 (la usa en caso de ser rara)--------------------------------------
    public Humano(String nombre, boolean isRara, int costoEnergia, int danoInflige, int cantidadDeVida, boolean rangoGlobal, ImageIcon imagen, String descripcion, int danioAdicional) {
        super(nombre, isRara, costoEnergia, danoInflige, cantidadDeVida, rangoGlobal, imagen, descripcion);
        this.danioAdicional = danioAdicional;
        this.sumarVida = 2;
    }

    //--------------------------------------GETTERS--------------------------------------

    public int getDanioAdicional () {
        return danioAdicional;
    }

    public int getSumarVida () {
        return sumarVida;
    }

    public String getTipoCarta() {
        return getClass().getName();
    }

    ///--------------------------------------Interfaces que implementa--------------------------------------
    @Override
    public void aumentarAtaque(Jugador objetivo , int id) {
        if(isRara ()) {
            for (int i = 0; i < 3; i++) {
                if(objetivo.getTablero().getPersonajeEnPosicion(i) != null)
                {
                    objetivo.getTablero().getPersonajeEnPosicion(i).setDanoInflige(objetivo.getTablero().getPersonajeEnPosicion(i).getDanoInflige() + danioAdicional);

                }
            }
        }else{
            System.out.println("VALOR DE ID: "+ id);
            objetivo.getTablero().getPersonajeEnPosicion(id - 1).setDanoInflige(objetivo.getTablero().getPersonajeEnPosicion(id - 1).getDanoInflige() + danioAdicional);
          //  objetivo.getTablero().getPersonajeEnPosicion(id-1).actualizarValoresCarta();
        }
        }

    @Override
    public void sumarVida(Jugador caster, int id) {
        if(isRara ())
        {
        for (int i = 0; i < 3; i++) {
            if(caster.getTablero().getPersonajeEnPosicion(i) != null)
            {
                caster.getTablero().getPersonajeEnPosicion(i).setCantidadDeVida(caster.getTablero().getPersonajeEnPosicion(i).getCantidadDeVida() + sumarVida);
            }
        }
            caster.getTablero().getPosHeroe().setCantVida(caster.getTablero().getPosHeroe().getCantVida() + sumarVida);
        }
    }


    @Override
    public void activarEfecto(Jugador jugadorEjecutor, Jugador jugadorRival, int id) {

        if(isRara())
        {
            aumentarAtaque(jugadorEjecutor,0);
            sumarVida(jugadorEjecutor,0);
        }
        else
        {
            aumentarAtaque(jugadorEjecutor,id);
        }
    }

    //--------------------------------------To String--------------------------------------
    @Override
    public String toString() {
        return "Humano{" +
                "danioAdicional=" + danioAdicional +
                ", sumarVida=" + sumarVida +
                "} " + super.toString();
    }
}
