package tiposHechizos;

import InterfacesCartas.I_HacerDanio;
import model.Hechizo;
import model.Jugador;

import javax.swing.*;

public class Danio extends Hechizo implements I_HacerDanio {

    private int cantDañoInflige;

    //--------------------------------------Constructor Para Guardar en el Archivo--------------------------------------

    public Danio(String nombre, boolean isRara, int costoEnergia, ImageIcon imagem, String descrip, int cantDañoInflige) {
        super(nombre, isRara, costoEnergia, 0, imagem, descrip);
        this.cantDañoInflige = cantDañoInflige;
    }

    ///--------------------------------------GETTERS--------------------------------------

    public int getCantDanioInflige () {
        return cantDañoInflige;
    }

    public String getTipoCarta() {
        return getClass().getName();
    }

    ///--------------------------------------Interfaces que implementa--------------------------------------
    @Override
    public void infligeDanio (Jugador objetivo , int id) {

        if ( isRara () ) {
            for (int i = 0; i < 3; i++) {
                if ( objetivo.getTablero ().getPersonajeEnPosicion ( i ) != null ) {
                    objetivo.getTablero ().getPersonajeEnPosicion ( i ).setCantidadDeVida ( objetivo.getTablero ().getPersonajeEnPosicion ( i ).getCantidadDeVida () - cantDañoInflige );
                }
            }
            objetivo.getTablero ().getPosHeroe ().setCantVida ( objetivo.getTablero ().getPosHeroe ().getCantVida () - cantDañoInflige );
        } else {// id-1 es la posicion en el arreglo (por ej si un personaje tiene id =2, su pos en el arreglo es 1)

            if(id == 0)
            {
                objetivo.getTablero ().getPosHeroe ().setCantVida ( objetivo.getTablero ().getPosHeroe ().getCantVida () -cantDañoInflige );
            }
            else
            {
                objetivo.getTablero ().getPersonajeEnPosicion ( id-1 ).setCantidadDeVida (objetivo.getTablero ().getPersonajeEnPosicion ( id-1 ).getCantidadDeVida () -cantDañoInflige);
            }
        }
    }


    @Override
    public void activarEfecto(Jugador jugadorEjecutor, Jugador jugadorRival, int id) {
       infligeDanio (jugadorRival,id);

    }
    ///--------------------------------------To String--------------------------------------

    @Override
    public String toString() {
        return "Danio{" +
                "cantDañoInflige=" + cantDañoInflige +
                "} " + super.toString();
    }
}
