package tiposHechizos;

import InterfacesCartas.I_SumarVida;
import model.Hechizo;
import model.Jugador;
import model.Personaje;

import javax.swing.*;

public class Curacion extends Hechizo implements I_SumarVida {
    private int sumarVida;

    //Constructor--------------------------------------

    public Curacion(String nombre, boolean isRara, int costoEnergia, int danoInflige, int sumaVida) {
        super(nombre, isRara, costoEnergia, 0);
        this.sumarVida = sumaVida;
    }

    public Curacion(String nombre, boolean isRara, int costoEnergia,ImageIcon imagem, String descrip, int sumarVida) {
        super(nombre, isRara, costoEnergia, 0, imagem, descrip);
        this.sumarVida = sumarVida;
    }

    public int getSumarVida () {
        return sumarVida;
    }

    @Override
    public void sumarVida(Jugador caster, int id) {
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
    public String getTipoCarta() {
        return getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return "Curacion{" +
                "sumarVida=" + sumarVida +
                "} " + super.toString();
    }

    @Override
    public void activarEfecto(Jugador jugadorEjecutor, Jugador jugadorRival, int id) {
           sumarVida(jugadorEjecutor,id);
    }
}
