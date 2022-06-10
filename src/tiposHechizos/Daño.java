package tiposHechizos;

import InterfacesCartas.I_HacerDanio;
import model.Hechizo;
import model.Jugador;
import model.Personaje;

public class Daño extends Hechizo implements I_HacerDanio {

    private int cantDañoInflige;

    //Constructor--------------------------------------

    public Daño (String nombre , boolean isRara , int costoEnergia , int danoInflige , int cantDañoInflige) {
        super ( nombre , isRara , costoEnergia , danoInflige );
        cantDañoInflige = cantDañoInflige;
    }

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

    }
}
