package Razas;

import InterfacesCartas.I_Congelar;
import InterfacesCartas.I_SumarVida;
import model.Jugador;
import model.Personaje;

import javax.swing.*;

public class Golem extends Personaje implements I_Congelar, I_SumarVida {

    private int sumarVida;
    private int cantTurnosCongela;

    //--------------------------------------Constructor para guardar en el Archivo--------------------------------------
    ///--------------------------------------cantTurnosCongela siempre va a ser 4 (la usa en caso de ser rara)--------------------------------------
    public Golem(String nombre, boolean isRara, int costoEnergia, int danoInflige, int cantidadDeVida, boolean rangoGlobal, ImageIcon imagen, String descripcion, int sumarVida) {
        super(nombre, isRara, costoEnergia, danoInflige, cantidadDeVida, rangoGlobal, imagen, descripcion);
        this.sumarVida = sumarVida;
        this.cantTurnosCongela = 4;
    }

    //--------------------------------------GETTERS--------------------------------------
    public int getSumarVida () {
        return sumarVida;
    }

    public int getCantTurnosCongela () {
        return cantTurnosCongela;
    }

    @Override
    public String getTipoCarta() {
        return getClass().getSimpleName();
    }

    //--------------------------------------Interfaces que implementa--------------------------------------
    @Override
    public void congelar (Jugador objetivo , int id)  {
        ///Id - 1  porque es una posicion menos en el arreglo
        if(!objetivo.getTablero ().isVacio ())
        {
            objetivo.getTablero ().getPersonajeEnPosicion ( id-1 ).setTurnosCongelado (objetivo.getTablero ().getPersonajeEnPosicion ( id-1 ).getTurnosCongelado () + cantTurnosCongela);
        }
    }
    @Override
    public void sumarVida(Jugador caster, int id) {
        ///Si es rara Cura a todos
        if (isRara()) {
            for (int i = 0; i < 3; i++) {
                if(caster.getTablero().getPersonajeEnPosicion(i) != null)
                {
                    caster.getTablero().getPersonajeEnPosicion(i).setCantidadDeVida(caster.getTablero().getPersonajeEnPosicion(i).getCantidadDeVida() + sumarVida);
                }
            }
            caster.getTablero().getPosHeroe().setCantVida(caster.getTablero().getPosHeroe().getCantVida() + sumarVida);
        } else {

            if(id == 0)
            {
                caster.getTablero().getPosHeroe().setCantVida(caster.getTablero().getPosHeroe().getCantVida() + sumarVida);

            }
            else // id-1 es la posicion en el arreglo (por ej si un personaje tiene id =2, su pos en el arreglo es 1)
            {
                caster.getTablero().getPersonajeEnPosicion(id-1).setCantidadDeVida(caster.getTablero().getPersonajeEnPosicion(id-1).getCantidadDeVida() + sumarVida);
            }
        }
    }

    @Override
    public void activarEfecto(Jugador jugadorEjecutor, Jugador jugadorRival, int id) {

        if(isRara())
        {
            sumarVida(jugadorEjecutor,0);
            congelar(jugadorRival,id);
        }
        else{
            sumarVida(jugadorEjecutor,id);
        }

    }

    //--------------------------------------TO String--------------------------------------
    @Override
    public String toString() {
        return "Golem{" +
                "sumarVida=" + sumarVida +
                ", cantTurnosCongela=" + cantTurnosCongela +
                "} " + super.toString();
    }
}
